package com.aelmehdi.kullwell.repositories;

import com.aelmehdi.kullwell.models.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
