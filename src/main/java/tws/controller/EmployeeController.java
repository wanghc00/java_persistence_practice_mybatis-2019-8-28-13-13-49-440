package tws.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tws.mapper.EmployeeMapper;
import tws.model.Employee;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    
    @Autowired
    private EmployeeMapper employeeMapper;
    
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void insertEmployee(@RequestBody Employee employee) {
        employeeMapper.insertEmployee(employee);
    }
    
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeMapper.selectAllEmployees();
        
    }
    
    @GetMapping("/{id}")
    public Employee getAllEmployees(@PathVariable int id) {
        return employeeMapper.selectEmployee(id);
        
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable int id, @RequestBody Employee employeePara){
        List<Employee> employees = new ArrayList<Employee>();
        employees = employeeMapper.selectAllEmployees();
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employeeMapper.updateEmployee(employeePara, id);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            
        }
        return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable int id){
        List<Employee> employees = new ArrayList<Employee>();
        employees = employeeMapper.selectAllEmployees();
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employeeMapper.deleteEmployeeById(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
    }
    
}
