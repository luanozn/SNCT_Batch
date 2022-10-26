package br.edu.ifgoiano.customer_snct.repository;

import br.edu.ifgoiano.customer_snct.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
