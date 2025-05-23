package com.datastructure.employee;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeIntervewQuestion {
    public static void main(String[] args) {
        /*
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

        //TODO How many male and female employees are there in the organization?
        Map<String, Long> noOfMaleAndFemaleEmployees= employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(noOfMaleAndFemaleEmployees);
        //TODO Print the name of all departments in the organization?
        employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
        //TODO What is the average age of male and female employees?
        Map<String, Double> avgAgeOfMaleAndFemaleEmployees= employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        System.out.println(avgAgeOfMaleAndFemaleEmployees);
        //TODO Get the details of highest paid employee in the organization?
        Optional<Employee> highestPaidEmployeeWrapper= employeeList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
        Employee highestPaidEmployee = highestPaidEmployeeWrapper.get();
        System.out.println("Details Of Highest Paid Employee : ");
        System.out.println("==================================");
        System.out.println("ID : "+highestPaidEmployee.getId());
        System.out.println("Name : "+highestPaidEmployee.getName());
        System.out.println("Age : "+highestPaidEmployee.getAge());
        System.out.println("Gender : "+highestPaidEmployee.getGender());
        System.out.println("Department : "+highestPaidEmployee.getDepartment());
        System.out.println("Year Of Joining : "+highestPaidEmployee.getYearOfJoining());
        System.out.println("Salary : "+highestPaidEmployee.getSalary());

        // TODO Get the names of all employees who have joined after 2015?
        employeeList.stream().filter(e -> e.getYearOfJoining() > 2015).map(Employee::getName)
                .forEach(System.out::println);

        //TODO Count the number of employees in each department?
        Map<String, Long> employeeCountByDepartment= employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        Set<Map.Entry<String, Long>> entrySet = employeeCountByDepartment.entrySet();
        for (Map.Entry<String, Long> entry : entrySet)
        {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }

        //TODO What is the average salary of each department?

        Map<String, Double> avgSalaryOfDepartments=        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        Set<Map.Entry<String, Double>> entrySet1 = avgSalaryOfDepartments.entrySet();
        for (Map.Entry<String, Double> entry : entrySet1)
        {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
        //TODO Get the details of youngest male employee in the product development department?
        Optional<Employee> youngestMaleEmployeeInProductDevelopmentWrapper=
                employeeList.stream()
                        .filter(e -> e.getGender()=="Male" && e.getDepartment()=="Product Development")
                        .min(Comparator.comparingInt(Employee::getAge));

        Employee youngestMaleEmployeeInProductDevelopment = youngestMaleEmployeeInProductDevelopmentWrapper.get();
        System.out.println("Details Of Youngest Male Employee In Product Development");
        System.out.println("----------------------------------------------");
        System.out.println("ID : "+youngestMaleEmployeeInProductDevelopment.getId());
        System.out.println("Name : "+youngestMaleEmployeeInProductDevelopment.getName());
        System.out.println("Age : "+youngestMaleEmployeeInProductDevelopment.getAge());
        System.out.println("Year Of Joinging : "+youngestMaleEmployeeInProductDevelopment.getYearOfJoining());
        System.out.println("Salary : "+youngestMaleEmployeeInProductDevelopment.getSalary());

        //TODO Who has the most working experience in the organization?
        Optional<Employee> seniorMostEmployeeWrapper= employeeList.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();
        Employee seniorMostEmployee = seniorMostEmployeeWrapper.get();
        System.out.println("Senior Most Employee Details :");
        System.out.println("----------------------------");
        System.out.println("ID : "+seniorMostEmployee.getId());
        System.out.println("Name : "+seniorMostEmployee.getName());
        System.out.println("Age : "+seniorMostEmployee.getAge());
        System.out.println("Gender : "+seniorMostEmployee.getGender());
        System.out.println("Age : "+seniorMostEmployee.getDepartment());
        System.out.println("Year Of Joinging : "+seniorMostEmployee.getYearOfJoining());
        System.out.println("Salary : "+seniorMostEmployee.getSalary());
        //TODO How many male and female employees are there in the sales and marketing team?
        Map<String, Long> countMaleFemaleEmployeesInSalesMarketing= employeeList.stream()
                        .filter(e -> e.getDepartment()=="Sales And Marketing")
                        .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(countMaleFemaleEmployeesInSalesMarketing);

        //TODO What is the average salary of male and female employees?
        Map<String, Double> avgSalaryOfMaleAndFemaleEmployees= employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(avgSalaryOfMaleAndFemaleEmployees);

        //TODO List down the names of all employees in each department?

        Map<String, List<Employee>> employeeListByDepartment= employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        Set<Map.Entry<String, List<Employee>>> entrySet2 = employeeListByDepartment.entrySet();
        for (Map.Entry<String, List<Employee>> entry : entrySet2)
        {
            System.out.println("--------------------------------------");
            System.out.println("Employees In "+entry.getKey() + " : ");
            System.out.println("--------------------------------------");
            List<Employee> list = entry.getValue();
            for (Employee e : list)
            {
                System.out.println(e.getName());
            }
        }
        //TODO What is the average salary and total salary of the whole organization?
        DoubleSummaryStatistics employeeSalaryStatistics= employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("Average Salary = "+employeeSalaryStatistics.getAverage());
        System.out.println("Total Salary = "+employeeSalaryStatistics.getSum());

        //TODO Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.

        Map<Boolean, List<Employee>> partitionEmployeesByAge= employeeList.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 25));
        Set<Map.Entry<Boolean, List<Employee>>> entrySet3 = partitionEmployeesByAge.entrySet();
        for (Map.Entry<Boolean, List<Employee>> entry : entrySet3)
        {
            System.out.println("----------------------------");
            if (entry.getKey())
            {
                System.out.println("Employees older than 25 years :");
            }
            else
            {
                System.out.println("Employees younger than or equal to 25 years :");
            }
            System.out.println("----------------------------");
            List<Employee> list = entry.getValue();
            for (Employee e : list)
            {
                System.out.println(e.getName());
            }
        }

        //TODO Who is the oldest employee in the organization? What is his age and which department he belongs to?
        Optional<Employee> oldestEmployeeWrapper1 = employeeList.stream().max(Comparator.comparingInt(Employee::getAge));
        Employee oldestEmployee = oldestEmployeeWrapper1.get();
        System.out.println("Name : "+oldestEmployee.getName());
        System.out.println("Age : "+oldestEmployee.getAge());
        System.out.println("Department : "+oldestEmployee.getDepartment());
            //TODO sort employee by salary using java 8
        List<Employee> sortedEmployees = employeeList.stream().sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary)).collect(Collectors.toList());
        System.out.println(sortedEmployees);
        List<Employee> sortedEmployees1 = employeeList.stream().sorted(Comparator.comparing(Employee::getSalary)).toList();
        System.out.println(sortedEmployees1);

         */
    }

}
