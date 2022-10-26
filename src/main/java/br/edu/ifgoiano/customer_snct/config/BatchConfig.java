package br.edu.ifgoiano.customer_snct.config;

import br.edu.ifgoiano.customer_snct.model.Customer;
import br.edu.ifgoiano.customer_snct.reader.CustomerReader;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class BatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job costumerJob(final Step consumerStep){
        return jobBuilderFactory
                .get("costumerJob")
                .start(consumerStep)
                .build();
    }

    public Step customerSetup(CustomerReader customerReader,
                              CustomerProcessor customerProcessor,
                              CustomerWriter customerWriter){

        return stepBuilderFactory.get("customerSetup")
                .<Customer, Customer>chunk(1)
                .reader(customerReader)
                .processor(customerProcessor)
                .writer(customerWriter)
                .build();
    }

}
