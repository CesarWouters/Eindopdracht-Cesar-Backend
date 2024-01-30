package com.example.eindopdracht.employee;

import com.example.eindopdracht.exceptions.RecordNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Optional<EmployeeDto> findEmployeeById(Long id) {
Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            EmployeeDto employeeDto = employeeToDto(employee.get());
            return Optional.of(employeeDto);
        }
        else throw new RecordNotFoundException("geen medewerker gevonden");
    }
    public List<EmployeeDto> findAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeListToDtoList(employeeList);
    }

    public List<EmployeeDto> employeeListToDtoList(Collection<Employee> employees) {
        List<EmployeeDto> employeeDtoList = new ArrayList<>();

        for (Employee employee : employees) {
            EmployeeDto employeeDto = employeeToDto(employee);
            employeeDtoList.add(employeeDto);
        }
        return employeeDtoList;
    }


    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        employee.setPassword(employeeDto.getPassword());
        employeeRepository.save(employee);
        return employeeDto;
    }

    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {

        if (employeeRepository.findById(id).isPresent()){

            Employee employee = employeeRepository.findById(id).get();

            Employee employee1 = dtoToEmployee(employeeDto);
            employee1.setId(employee.getId());

            employeeRepository.save(employee1);

            return employeeToDto(employee1);

        } else {

            throw new  RecordNotFoundException("geen medewerker gevonden");

        }
    }
    public void deleteEmployee(Long id) {

        if (employeeRepository.findById(id).isPresent()){
            employeeRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("geen medewerker gevonden");
        }
    }

    public EmployeeDto employeeToDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setPassword(employee.getPassword());
        return employeeDto;
    }

    public Employee dtoToEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        employee.setPassword(employeeDto.getPassword());
        return employee;
    }

}
