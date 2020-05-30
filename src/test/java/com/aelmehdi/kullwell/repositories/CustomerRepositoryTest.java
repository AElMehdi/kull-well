package com.aelmehdi.kullwell.repositories;

import com.aelmehdi.kullwell.models.Customer;
import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.testcontainers.containers.PostgreSQLContainer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @ClassRule
    public static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:latest");

    @Test
    void should_save_a_user() {
        Customer savedUser = customerRepository.save(new Customer(1L, "Yassine", "Nissya"));

        assertThat(savedUser.getFirstName()).isEqualTo("Yassine");
    }

    @Test
    void should_get_user_by_id() {
        Customer customer = new Customer(3L, "Bob", "Matt");

        customerRepository.save(customer);

        assertThat(customerRepository.findById(3L).get()).isEqualTo(customer);
    }
}
