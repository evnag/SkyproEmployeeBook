package ru.skypro.coursework1;

import java.util.Arrays;

public class EmployeeBook {
    private final Employee[] employeeBook;

    public EmployeeBook(int arraySize) {
        this.employeeBook = new Employee[arraySize];
    }

    @Override
    public String toString() {
        return "EmployeeBook{" +
                "employeeBook=" + Arrays.toString(employeeBook) +
                '}';
    }

    public void getListOfEmployees() {
        System.out.println("=============== List of employees ===============");
        for (Employee employee : employeeBook) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
        System.out.println("================end of list=======================");
    }

    public int calcSalaryAmountPerMonth() {
        int sum = 0;
        for (Employee employee : employeeBook) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public Employee getEmployeeWithMinSalary() {
        Employee employeeWithMinSalary = employeeBook[0];
        for (Employee employee : employeeBook) {
            if (employee != null) {
                if (employee.getSalary() < employeeWithMinSalary.getSalary()) {
                    employeeWithMinSalary = employee;
                }
            }
        }
        return employeeWithMinSalary;
    }

    public Employee getEmployeeWithMaxSalary() {
        Employee employeeWithMaxSalary = employeeBook[0];
        for (Employee listOfEmployee : employeeBook) {
            if (listOfEmployee != null) {
                if (listOfEmployee.getSalary() > employeeWithMaxSalary.getSalary()) {
                    employeeWithMaxSalary = listOfEmployee;
                }
            }
        }
        return employeeWithMaxSalary;
    }

    public int calcAverageSalary() {
        int numberOfEmployees = 0;
        for (Employee employee : employeeBook) {
            if (employee != null) {
                numberOfEmployees++;
            }
        }
        return calcSalaryAmountPerMonth() / numberOfEmployees;
    }

    public void printFullNameOfEmployees() {
        System.out.println("================ Full names ================");
        for (Employee employee : employeeBook) {
            if (employee != null) {
                System.out.printf("%S %S %S\n", employee.getLastName(), employee.getFirstName(), employee.getMiddleName());
            }
        }
    }

    public void indexSalaryOfAllEmployees(int indexingPercent) {
        for (Employee employee : employeeBook) {
            if (employee != null) {
                employee.setSalary((employee.getSalary() / indexingPercent) + employee.getSalary());
            }
        }
    }

    public Employee[] sortEmployeesByDepartment(String department) {
        Employee[] employeeByDepartment = new Employee[employeeBook.length];

        for (int i = 0, j = 0; i < employeeBook.length; i++) {
            if (employeeBook[i] != null && employeeBook[i].getDepartment().equals(department)) {
                employeeByDepartment[j] = employeeBook[i];
                j++;
            }
        }
        return employeeByDepartment;
    }

        public Employee getEmployeeWithMinSalaryByDepartment(String department) {
            Employee[] employeeByDepartment = sortEmployeesByDepartment(department);
            Employee employeeWithMinSalary = employeeByDepartment[0];
            for (Employee employee : employeeByDepartment) {
                if (employee != null) {
                    if (employee.getSalary() < employeeWithMinSalary.getSalary()) {
                        employeeWithMinSalary = employee;
                    }
                }
            }
            return employeeWithMinSalary;
        }

    public Employee getEmployeeWithMaxSalaryByDepartment(String department) {
        Employee[] employeeByDepartment = sortEmployeesByDepartment(department);
        Employee employeeWithMaxSalary = employeeByDepartment[0];
        for (Employee employee : employeeByDepartment) {
            if (employee != null) {
                if (employee.getSalary() > employeeWithMaxSalary.getSalary()) {
                    employeeWithMaxSalary = employee;
                }
            }
        }
        return employeeWithMaxSalary;
    }

    public int calcAverageSalaryByDepartment(String department) {
        Employee[] employeeByDepartment = sortEmployeesByDepartment(department);
        int averageSum = 0;
        for (Employee employee : employeeByDepartment) {
            if (employee != null) {
                averageSum += employee.getSalary();
            }
        }
        return averageSum;
    }

    public void indexSalaryOfEmployeesByDepartment(String department, int indexingPercent) {
        Employee[] employeeByDepartment = sortEmployeesByDepartment(department);
        for (Employee employee : employeeByDepartment) {
            if (employee != null) {
                employee.setSalary((employee.getSalary() / indexingPercent) + employee.getSalary());
            }
        }
    }

    public void printEmployeesByDepartment(String department) {
        Employee[] employeeByDepartment = sortEmployeesByDepartment(department);
        for (Employee employee: employeeByDepartment) {
            if (employee != null) {
                System.out.printf("%S %S %S %S %s\n", employee.getId(), employee.getLastName(), employee.getFirstName(), employee.getMiddleName(), employee.getSalary());
            }
        }
    }

    public void getEmployeeWithSalaryLess(int number) {
        for (Employee employee: employeeBook) {
            if (employee != null && employee.getSalary() < number) {
                System.out.printf("%S %S %S %S %s\n", employee.getId(), employee.getLastName(), employee.getFirstName(), employee.getMiddleName(), employee.getSalary());
            }
        }
    }

    public void getEmployeeWithSalaryGreater(int number) {
        for (Employee employee: employeeBook) {
            if (employee != null && employee.getSalary() > number) {
                System.out.printf("%S %S %S %S %s\n", employee.getId(), employee.getLastName(), employee.getFirstName(), employee.getMiddleName(), employee.getSalary());
            }
        }
    }

    public boolean addEmployee(String firstName, String lastName, String middleName, String department, int salary) {
        Employee newEmployee = new Employee(firstName, lastName, middleName, department, salary);
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i] == null) {
                employeeBook[i] = newEmployee;
                return true;
            }
        }
        return false;
    }

    public boolean deleteEmployee(int id) {
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i].getId() == id) {
                employeeBook[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean editEmployee(String firstName, String lastName, String middleName, int setSalary, String setDepartment) {
        for (Employee employee : employeeBook) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName) && employee.getMiddleName().equals(middleName)) {
                employee.setSalary(setSalary);
                employee.setDepartment(setDepartment);
                return true;
            }
        }
        return false;
    }

    public void printSplitListOfEmployees() {
        for (int i = 1; i <= 5; i++) {
            switch (i) {
                case 1:
                    System.out.println("======= firstDepartment =====");
                    printEmployeesByDepartment("firstDepartment");
                    break;
                case 2:
                    System.out.println("======= secondDepartment =====");
                    printEmployeesByDepartment("secondDepartment");
                    break;
                case 3:
                    System.out.println("======= thirdDepartment =====");
                    printEmployeesByDepartment("thirdDepartment");
                    break;
                case 4:
                    System.out.println("======= fourthDepartment =====");
                    printEmployeesByDepartment("fourthDepartment");
                    break;
                case 5:
                    System.out.println("======= fifthDepartment =====");
                    printEmployeesByDepartment("fifthDepartment");
                    break;
            }
        }
        System.out.println("!!!!!!!!!!!!!!!");
    }
}
