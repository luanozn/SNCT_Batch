package br.edu.ifgoiano.customer_snct.processor;

import br.edu.ifgoiano.customer_snct.model.Customer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CustomerProcessor implements ItemProcessor<Customer, Customer> {

    @Override
    public Customer process(Customer customer){
        customer.setLocalDateTime(LocalDateTime.now());
        return customer;
    }
}
