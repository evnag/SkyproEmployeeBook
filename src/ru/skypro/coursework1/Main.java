package ru.skypro.coursework1;

public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook(10);
        employeeBook.getListOfEmployees();
        employeeBook.addEmployee("Ivan", "Ivanov", "Ivanovich", "firstDepartment", 55000);
        employeeBook.addEmployee("Ivan", "Ivanov", "Ivanovich", "firstDepartment", 55000);
        employeeBook.addEmployee("Ivan", "Ivanov", "Ivanovich", "firstDepartment", 55000);
        employeeBook.addEmployee("Petr", "Petrov", "Petrovich", "secondDepartment", 65000);
        employeeBook.addEmployee("Sidor", "Sidorov", "Sidorovich", "thirdDepartment", 85000);
        employeeBook.addEmployee("Vasily", "Vasiliev", "Vasilievich", "thirdDepartment", 95000);
        employeeBook.addEmployee("Petr", "Petrov", "Petrovich", "secondDepartment", 65000);

        System.out.println(employeeBook.calcSalaryAmountPerMonth());
        System.out.println(employeeBook.getEmployeeWithMinSalary());
        System.out.println(employeeBook.getEmployeeWithMaxSalary());

        System.out.println(employeeBook.calcAverageSalary());
        employeeBook.printFullNameOfEmployees();

        employeeBook.indexSalaryOfAllEmployees(10);
        System.out.println("SalaryOfAllEmployees after Index: " + employeeBook.calcSalaryAmountPerMonth());

        System.out.println("Employee With Min Salary By Department:\n" + employeeBook.getEmployeeWithMinSalaryByDepartment("thirdDepartment"));
        System.out.println("Employee With Max Salary By Department:\n" + employeeBook.getEmployeeWithMaxSalaryByDepartment("thirdDepartment"));
        System.out.println("AverageSalaryByDepartment: " + employeeBook.calcAverageSalaryByDepartment("thirdDepartment"));

        System.out.println("SalaryOfEmployeesByDepartment after index: ");

        employeeBook.indexSalaryOfEmployeesByDepartment("thirdDepartment", 10);
        System.out.println("AverageSalaryByDepartment: " + employeeBook.calcAverageSalaryByDepartment("thirdDepartment"));
        employeeBook.printSplitListOfEmployees();

        employeeBook.printEmployeesByDepartment("thirdDepartment");
        System.out.println("+++++++++++++");
        employeeBook.getEmployeeWithSalaryLess(90_000);
        employeeBook.getEmployeeWithSalaryGreater(70_000);

        employeeBook.getListOfEmployees();
        employeeBook.deleteEmployee(1);
        employeeBook.getListOfEmployees();
        employeeBook.editEmployee("Ivan", "Ivanov", "Ivanovich", 150_000, "secondDepartment");
        employeeBook.getListOfEmployees();
        employeeBook.addEmployee("Petr", "Petrov", "Petrovich", "secondDepartment", 65000);
        employeeBook.getListOfEmployees();
    }
}
