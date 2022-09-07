package ru.skypro.coursework1;

public class Main {
    public static void main(String[] args) {
        Employee[] employeeBook = new Employee[10];
        employeeBook[0] = new Employee("Ivan", "Ivanov", "Ivanovich", "firstDepartment", 55000);
        employeeBook[1] = new Employee("Petr", "Petrov", "Petrovich", "secondDepartment", 65000);
        employeeBook[2] = new Employee("Sidor", "Sidorov", "Sidorovich", "thirdDepartment", 85000);

        getListOfEmployees(employeeBook);
        System.out.println("======= Amount of salary costs per month =======\n" + calcSalaryAmountPerMonth(employeeBook));
        System.out.println("=========== Employee with a minimum salary =========\n" + getEmployeeWithMinSalary(employeeBook));
        System.out.println("=========== Employee with a maximum salary =========\n" + getEmployeeWithMaxSalary(employeeBook));
        System.out.println("========= Average value of salaries =========\n" + calcAverageSalary(employeeBook));
        printFullNameOfEmployees(employeeBook);
    }

    public static void getListOfEmployees(Employee[] listOfEmployees) {
        System.out.println("=============== List of employees ===============");
        for (Employee employee: listOfEmployees) {
            System.out.println(employee);
        }
        System.out.println("================end of list=======================");
    }

    public static int calcSalaryAmountPerMonth(Employee[] listOfEmployees) {
        int sum = 0;
        for (Employee employee : listOfEmployees) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public static Employee getEmployeeWithMinSalary(Employee[] listOfEmployees) {
        Employee employeeWithMinSalary = listOfEmployees[0];
        for (Employee listOfEmployee : listOfEmployees) {
            if (listOfEmployee != null) {
                if (listOfEmployee.getSalary() < employeeWithMinSalary.getSalary()) {
                    employeeWithMinSalary = listOfEmployee;
                }
            }
        }
        return employeeWithMinSalary;
    }

    public static Employee getEmployeeWithMaxSalary(Employee[] listOfEmployees) {
        Employee employeeWithMaxSalary = listOfEmployees[0];
        for (Employee listOfEmployee : listOfEmployees) {
            if (listOfEmployee != null) {
                if (listOfEmployee.getSalary() > employeeWithMaxSalary.getSalary()) {
                    employeeWithMaxSalary = listOfEmployee;
                }
            }
        }
        return employeeWithMaxSalary;
    }

    public static int calcAverageSalary(Employee[] listOfEmployees) {
        int numberOfEmployees = 0;
        for (Employee employee : listOfEmployees) {
            if (employee != null) {
                numberOfEmployees++;
            }
        }
        return calcSalaryAmountPerMonth(listOfEmployees) / numberOfEmployees;
    }

    public static void printFullNameOfEmployees(Employee[] listOfEmployees) {
        System.out.println("================ Full names ================");
        for (Employee employee : listOfEmployees) {
            if (employee != null) {
                System.out.printf("%S %S %S\n", employee.getLastName(), employee.getFirstName(), employee.getMiddleName());
            }
        }
    }
}
