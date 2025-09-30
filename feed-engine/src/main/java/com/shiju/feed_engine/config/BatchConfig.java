package com.shiju.feed_engine.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Collections;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Bean
    public ItemReader<String> itemReader() {
        return new FlatFileItemReaderBuilder<String>()
                .name("itemReader")
                .resource(new ClassPathResource("sample-data.txt"))
                .delimited()
                .delimiter(",") // example: change based on your file
                .names("line")  // map to single column
                .fieldSetMapper(fieldSet -> fieldSet.readString("line"))
                .build();
    }

    @Bean
    public ItemProcessor<String, String> itemProcessor() {
        return String::toUpperCase;
    }

    @Bean
    public ItemWriter<String> itemWriter() {
        return items -> items.forEach(item -> System.out.println("Writing item: " + item));
    }

    @Bean
    public Step myStep(JobRepository jobRepository,
                       PlatformTransactionManager transactionManager,
                       ItemReader<String> itemReader,
                       ItemProcessor<String, String> itemProcessor,
                       ItemWriter<String> itemWriter) {

        return new StepBuilder("myStep", jobRepository)
                .<String, String>chunk(10, transactionManager)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();
    }

    @Bean
    public Job myJob(JobRepository jobRepository, Step myStep) {
        return new JobBuilder("myJob", jobRepository)
                .start(myStep)
                .build();
    }
}
