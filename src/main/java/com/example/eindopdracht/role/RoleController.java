package com.example.eindopdracht.role;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RoleController {
 private final RoleService service;

    @GetMapping("/roles")
    public List<RoleDto> getRoles() {
        return service.getRoles();
    }

}
