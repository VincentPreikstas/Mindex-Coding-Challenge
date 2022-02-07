package com.mindex.challenge.data;

import java.time.LocalDate;

public class Compensation {
    private Employee employee;
    private Integer salary;
    private LocalDate effectiveDate;

    public Compensation() {
    }

    public Compensation(Employee employee){
        this.employee = employee;
        this.salary = employee.getSalary();
        this.effectiveDate = employee.getEffectiveDate();
    }

    public Employee getEmployee() {
        return employee;
    }

    public Integer getSalary() {
        return salary;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}
