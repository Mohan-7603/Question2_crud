package com.question2.crud.service;

import com.question2.crud.entity.Department;
import com.question2.crud.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department getDepartmentById(String id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public Department updateDepartment(String id, Department updatedDepartment) {
        Department existingDepartment = departmentRepository.findById(id).orElse(null);
        if (existingDepartment != null) {
            existingDepartment.setDepartmentName(updatedDepartment.getDepartmentName());
            return departmentRepository.save(existingDepartment);
        } else {
            return null;
        }
    }

    public void deleteDepartment(String id) {
        departmentRepository.deleteById(id);
    }
}
