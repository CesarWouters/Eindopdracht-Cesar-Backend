package com.example.eindopdracht.table;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TableService {

    private final TableRepository tableRepository;


    public void deleteTable(Integer tableNumber) {
        tableRepository.deleteById(tableNumber);
    }

    public TableDto tableToDto(Table table) {
        TableDto tableDto = new TableDto();
        tableDto.setTableNumber(table.getTableNumber());
        tableDto.setCapacity(table.getCapacity());
        return tableDto;
    }

    public TableDto findAllTablesByCapacity(int capacity) {
        Table table = tableRepository.findByCapacity(capacity);
        TableDto tableDto = tableToDto(table);
        return tableDto;
    }
}
