package com.example.eindopdracht.table;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/table")
public class TableController {

    private final TableService tableService;


    @GetMapping("/{capacity}")
    public ResponseEntity<TableDto> findAllTablesByCapacity(@PathVariable("capacity") int capacity) {
        return ResponseEntity.ok(tableService.findAllTablesByCapacity(capacity));
    }

    @DeleteMapping("/{tableNumber}")
    public ResponseEntity<TableDto> deleteTable(@PathVariable("tableNumber") Integer tableNumber) {
        tableService.deleteTable(tableNumber);
        return ResponseEntity.noContent().build();
    }


}
