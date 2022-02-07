package com.mindex.challenge.data;

import com.mindex.challenge.dao.EmployeeRepository;
import java.util.List;

public class ReportingStructure {
    private Employee employee;
    private Integer numberOfReports;

    public ReportingStructure(){

    }

    public ReportingStructure(Employee employee, EmployeeRepository employeeRepository){
        this.employee = employee;
        this.setNumberOfReports(employeeRepository);
    }

    public int DirectReportCount(List<Employee> workingList, EmployeeRepository employeeRepository){
        int total = 0;
        if (workingList == null){
            return total;
        } else {
            return recursiveDirectReportCount(total, workingList, employeeRepository);
        }
    }

    public int recursiveDirectReportCount(int total, List<Employee> workingList, EmployeeRepository employeeRepository){

        for (Employee employee:workingList){
            //Work around to accessing Database necessary because of null values of directReports of employees.
            //There is most likely a better way to do this than daisy chaining the EmployeeRepository object through several functions.
            //Revise in the future.
            Employee localEmployee = employeeRepository.findByEmployeeId(employee.getEmployeeId());
            List<Employee> helpingList = localEmployee.getDirectReports();

            if (helpingList != null){
                total += recursiveDirectReportCount(total, helpingList, employeeRepository);
                }
        }
        return total + workingList.size();
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Integer getNumberOfReports() {
        return numberOfReports;
    }

    public void setNumberOfReports(EmployeeRepository employeeRepository) {
        this.numberOfReports = DirectReportCount(this.employee.getDirectReports(), employeeRepository);
    }

    @Override
    public String toString() {
        return "Reporting Structure for: " + this.employee.getFirstName() + ". Their number of Reports is: " + this.numberOfReports;
    }
}
