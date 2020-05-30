package com.aelmehdi.kullwell;

import com.aelmehdi.kullwell.models.Customer;
import com.aelmehdi.kullwell.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.slf4j.LoggerFactory.getLogger;

@SpringBootApplication
public class KullWellApplication {

    private static final Logger log = getLogger(KullWellApplication.class);
    private static CustomerRepository customerRepository;

    @Autowired
    public KullWellApplication(CustomerRepository customerRepository) {
        KullWellApplication.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(KullWellApplication.class, args);
        Customer savedUser = customerRepository.save(new Customer(1L, "Yassine", "Nissya"));

        log.info("Customer was created successfully" + savedUser);
    }
}
