package com.example.eindopdracht.table;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<Table, Integer> {
    Table findByCapacity(int capacity);
}
