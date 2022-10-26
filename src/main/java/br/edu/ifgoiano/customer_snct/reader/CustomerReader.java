package br.edu.ifgoiano.customer_snct.reader;


import br.edu.ifgoiano.customer_snct.mapper.CustomerMapper;
import br.edu.ifgoiano.customer_snct.model.Customer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.PathResource;
import org.springframework.stereotype.Component;

@Component
public class CustomerReader extends FlatFileItemReader<Customer> {

    public CustomerReader(){
        DefaultLineMapper<Customer> defaultLineMapper = new DefaultLineMapper<>();
        defaultLineMapper.setLineTokenizer(new DelimitedLineTokenizer());
        defaultLineMapper.setFieldSetMapper(new CustomerMapper());
        this.setLineMapper(defaultLineMapper);
        this.setResource(new PathResource("data/customers.dat"));
    }
}
