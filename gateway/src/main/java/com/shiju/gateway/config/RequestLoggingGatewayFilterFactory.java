/**
 * This file is provided without any copyright claims. It is intended for free use, modification,
 * and distribution.
 *
 * @author Shiju S
 * @version 0.0.1
 * @since 2025
 */

package com.shiju.gateway.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SignalType;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class RequestLoggingGatewayFilterFactory extends AbstractGatewayFilterFactory<Object> {

  private static final Logger log = LoggerFactory.getLogger(RequestLoggingGatewayFilterFactory.class);

  public RequestLoggingGatewayFilterFactory() {
    super(Object.class);
  }

  @Override
  public GatewayFilter apply(Object config) {
    return (exchange, chain) -> {
      ServerHttpRequest request = exchange.getRequest();
      log.info("Request method: {}, URI: {}", request.getMethod(), request.getURI());
      log.info("Headers: {}", request.getHeaders());
      AtomicReference<String> bodyRef = new AtomicReference<>("");
      return DataBufferUtils.join(request.getBody())
          .flatMap(dataBuffer -> {
            byte[] bytes = new byte[dataBuffer.readableByteCount()];
            dataBuffer.read(bytes);
            DataBufferUtils.release(dataBuffer);
            String body = new String(bytes, StandardCharsets.UTF_8);
            bodyRef.set(body);
            log.info("Request body: {}", body);
            Flux<DataBuffer> cachedFlux = Flux.defer(() -> {
              DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(bytes);
              return Mono.just(buffer);
            });
            ServerHttpRequest mutatedRequest = new ServerHttpRequestDecorator(request) {
              @Override
              public Flux<DataBuffer> getBody() {
                return cachedFlux;
              }
            };
            ServerWebExchange mutatedExchange = exchange.mutate().request(mutatedRequest).build();
            return chain.filter(mutatedExchange);
          });
    };
  }
}

