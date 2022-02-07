package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.CompensationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompensationServiceImpl implements CompensationService{

    private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Compensation create(Compensation compensation){
        LOG.debug("Creating compensation [{}]", compensation);

        Employee employee = compensation.getEmployee();
        employee.setSalary(compensation.getSalary());
        employee.setEffectiveDate(compensation.getEffectiveDate());
        employeeRepository.save(employee);
        return compensation;
    }

    @Override
    public Compensation read(String id){
        LOG.debug("Creating compensation for id [{}]", id);

        Employee employee = employeeRepository.findByEmployeeId(id);

        if (employee == null){
            throw new RuntimeException("Invalid employeeId for compensation record: " + id);
        }
        return new Compensation(employee);
    }
}
