package br.edu.ifgoiano.customer_snct.config;

import br.edu.ifgoiano.customer_snct.model.Customer;
import br.edu.ifgoiano.customer_snct.processor.CustomerProcessor;
import br.edu.ifgoiano.customer_snct.reader.CustomerReader;
import br.edu.ifgoiano.customer_snct.writer.CustomerWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class BatchConfig {

    private final JobBuilderFactory jobBuilderFactory;

    private final StepBuilderFactory stepBuilderFactory;

    @Autowired
    public BatchConfig(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory){
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean
    public Job costumerJob(final Step consumerStep){
        return jobBuilderFactory
                .get("costumerJob")
                .start(consumerStep)
                .build();
    }

    @Bean
    public Step customerStep(CustomerReader customerReader,
                              CustomerProcessor customerProcessor,
                              CustomerWriter customerWriter){

        return stepBuilderFactory.get("customerStep")
                .<Customer, Customer>chunk(1)
                .reader(customerReader)
                .processor(customerProcessor)
                .writer(customerWriter)
                .build();
    }

}
