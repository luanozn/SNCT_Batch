package br.edu.ifgoiano.customer_snct.writer;

import br.edu.ifgoiano.customer_snct.model.Customer;
import br.edu.ifgoiano.customer_snct.repository.CustomerRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
public class CustomerWriter implements ItemWriter<Customer> {

    private final CustomerRepository repository;

    @Autowired
    public CustomerWriter(CustomerRepository repository) {
        this.repository = repository;
    }


    @Override
    public void write(List<? extends Customer> list) throws Exception {
        repository.saveAll(list);

        final var customers = repository.findAll();
        System.out.println("/*----------------------------------------------------------------------*/");

        customers.forEach(System.out::println);
    }
}
