package ru.skypro.coursework1;

public class Main {
    public static void main(String[] args) {
        Employee[] employeeBook = new Employee[10];
        employeeBook[0] = new Employee("Ivan", "Ivanov", "Ivanovich", "firstDepartment", 55000);
        employeeBook[1] = new Employee("Petr", "Petrov", "Petrovich", "secondDepartment", 65000);
        employeeBook[2] = new Employee("Sidor", "Sidorov", "Sidorovich", "thirdDepartment", 85000);
        employeeBook[3] = new Employee("Vasily", "Vasiliev", "Vasilievich", "thirdDepartment", 95000);

        getListOfEmployees(employeeBook);
        System.out.println("======= Amount of salary costs per month =======\n" + calcSalaryAmountPerMonth(employeeBook));
        System.out.println("=========== Employee with a minimum salary =========\n" + getEmployeeWithMinSalary(employeeBook));
        System.out.println("=========== Employee with a maximum salary =========\n" + getEmployeeWithMaxSalary(employeeBook));
        System.out.println("========= Average value of salaries =========\n" + calcAverageSalary(employeeBook));
        printFullNameOfEmployees(employeeBook);

        indexSalaryOfAllEmployees(employeeBook, 10);
        getListOfEmployees(employeeBook);

        System.out.println(getEmployeeWithMinSalaryByDepartment(employeeBook, "thirdDepartment"));
        System.out.println(getEmployeeWithMaxSalaryByDepartment(employeeBook, "thirdDepartment"));
        System.out.println(calcAverageSalaryByDepartment(employeeBook, "thirdDepartment"));
        indexSalaryOfEmployeesByDepartment(employeeBook, "thirdDepartment", 10);
        getListOfEmployees(employeeBook);

        printEmployeesByDepartment(employeeBook, "thirdDepartment");

        System.out.println("======= Less =======");
        getEmployeeWithSalaryLess(employeeBook, 100_000);
        System.out.println("======= Greater =======");
        getEmployeeWithSalaryGreater(employeeBook, 100_000);

    }

    /**
     * Prints a list of all employees with all the data available on them (output the values of all fields to the console (toString)).
     * @param listOfEmployees the array to be iterated
     */
    public static void getListOfEmployees(Employee[] listOfEmployees) {
        System.out.println("=============== List of employees ===============");
        for (Employee employee: listOfEmployees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
        System.out.println("================end of list=======================");
    }

    /**
     * Calculate the amount of salary costs per month.
     * @param listOfEmployees the array to be iterated
     * @return the amount of salary costs per month.
     */
    public static int calcSalaryAmountPerMonth(Employee[] listOfEmployees) {
        int sum = 0;
        for (Employee employee : listOfEmployees) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    /**
     * Return an employee with a minimum salary.
     * @param listOfEmployees the array to be iterated
     * @return object employeeWithMinSalary
     */
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

    /**
     * Return an employee with the maximum salary.
     * @param listOfEmployees the array to be iterated
     * @return employeeWithMaxSalary
     */
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

    /**
     * Call calcSalaryAmountPerMonth() and Calculate the average value of salaries
     * @param listOfEmployees the array to be iterated
     * @return the average value of salaries per month
     */
    public static int calcAverageSalary(Employee[] listOfEmployees) {
        int numberOfEmployees = 0;
        for (Employee employee : listOfEmployees) {
            if (employee != null) {
                numberOfEmployees++;
            }
        }
        return calcSalaryAmountPerMonth(listOfEmployees) / numberOfEmployees;
    }

    /**
     * Prints the full name of all employees from the list
     * @param listOfEmployees the array to be iterated
     */
    public static void printFullNameOfEmployees(Employee[] listOfEmployees) {
        System.out.println("================ Full names ================");
        for (Employee employee : listOfEmployees) {
            if (employee != null) {
                System.out.printf("%S %S %S\n", employee.getLastName(), employee.getFirstName(), employee.getMiddleName());
            }
        }
    }

    /**
     * Changes the salaries of all employees by the value of the argument in %
     * @param listOfEmployees the array to be iterated
     * @param indexingPercent the value will increase the salary of employees
     */
    public static void indexSalaryOfAllEmployees(Employee[] listOfEmployees, int indexingPercent) {
        for (Employee employee : listOfEmployees) {
            if (employee != null) {
                employee.setSalary((employee.getSalary() / indexingPercent) + employee.getSalary());
            }
        }
    }

    /**
     * Finds all employees in the specified department
     * @param listOfEmployees the array to be iterated
     * @param department the field by which sort
     * @return an array of employees for the specified department
     */
    public static Employee[] sortEmployeesByDepartment(Employee[] listOfEmployees, String department) {
        Employee[] employeeByDepartment = new Employee[listOfEmployees.length];

        for (int i = 0, j = 0; i < listOfEmployees.length; i++) {
            if (listOfEmployees[i] != null && listOfEmployees[i].getDepartment().equals(department)) {
                employeeByDepartment[j] = listOfEmployees[i];
                j++;
            }
        }
        return employeeByDepartment;
    }

    /**
     * Find an employee with a minimum salary in the department
     * @param listOfEmployees the array to be iterated
     * @param department the field by which sort
     * @return an employee with a minimum salary in the department
     */
    public static Employee getEmployeeWithMinSalaryByDepartment(Employee[] listOfEmployees, String department) {
        return getEmployeeWithMinSalary(sortEmployeesByDepartment(listOfEmployees, department));
    }
    /**
     * Find an employee with a maximum salary in the department
     * @param listOfEmployees the array to be iterated
     * @param department the field by which sort
     * @return an employee with a maximum salary in the department
     */
    public static Employee getEmployeeWithMaxSalaryByDepartment(Employee[] listOfEmployees, String department) {

        return getEmployeeWithMaxSalary(sortEmployeesByDepartment(listOfEmployees, department));
    }

    /**
     * Calculate average value of salary per month for the specified department
     * @param listOfEmployees the array to be iterated
     * @param department the field by which sort
     * @return average value of salary per month by department
     */
    public static int calcAverageSalaryByDepartment(Employee[] listOfEmployees, String department) {
        return calcAverageSalary(sortEmployeesByDepartment(listOfEmployees, department));
    }

    /**
     * Changes the salaries of employees for the specified department by the value of the argument in %
     * @param listOfEmployees the array to be iterated
     * @param indexingPercent the value will increase the salary of employees
     */
    public static void indexSalaryOfEmployeesByDepartment(Employee[] listOfEmployees, String department, int indexingPercent) {
        indexSalaryOfAllEmployees(sortEmployeesByDepartment(listOfEmployees, department), indexingPercent);
    }

    /**
     * Prints all employees of the department (all data except the department).
     * @param listOfEmployees the array to be iterated
     * @param department the field by which sort
     */
    public static void printEmployeesByDepartment(Employee[] listOfEmployees, String department) {
        for (Employee employee: sortEmployeesByDepartment(listOfEmployees, department)) {
            if (employee != null) {
                System.out.printf("%S %S %S %S %s\n", employee.getId(), employee.getLastName(), employee.getFirstName(), employee.getMiddleName(), employee.getSalary());
            }
        }
    }

    /**
     * Prints employees with a salary less than a number
     * @param listOfEmployees the array to be iterated
     * @param number value for salary comparison
     */
    public static void getEmployeeWithSalaryLess(Employee[] listOfEmployees, int number) {
        for (Employee employee: listOfEmployees) {
            if (employee != null && employee.getSalary() < number) {
                System.out.printf("%S %S %S %S %s\n", employee.getId(), employee.getLastName(), employee.getFirstName(), employee.getMiddleName(), employee.getSalary());
            }
        }
    }

    /**
     * Prints employees with a salary greater than a number
     * @param listOfEmployees the array to be iterated
     * @param number value for salary comparison
     */
    public static void getEmployeeWithSalaryGreater(Employee[] listOfEmployees, int number) {
        for (Employee employee: listOfEmployees) {
            if (employee != null && employee.getSalary() > number) {
                System.out.printf("%S %S %S %S %s\n", employee.getId(), employee.getLastName(), employee.getFirstName(), employee.getMiddleName(), employee.getSalary());
            }
        }
    }
}
