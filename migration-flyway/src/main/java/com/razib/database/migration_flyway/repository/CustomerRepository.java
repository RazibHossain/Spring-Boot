package com.razib.database.migration_flyway.repository;


import com.razib.database.migration_flyway.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository
        extends JpaRepository<Customer, Long> {
}