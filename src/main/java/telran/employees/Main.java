package telran.employees;

import java.io.PrintWriter;
import static telran.employees.Properties.*;

public class Main {
    public static void main(String[] args) {
        String fileName = "employees-sql-data.csv";
        CountEmployeesInDepartment[] company = {
                new CountEmployeesInDepartment(DEPARTMENT1, MANAGERS_IN_DEP1, EMPLOYEES_IN_DEP1, WAGE_EMPLOYEES_IN_DEP1,
                        SALES_PERSON_IN_DEP1),
                new CountEmployeesInDepartment(DEPARTMENT2, MANAGERS_IN_DEP2, EMPLOYEES_IN_DEP2, WAGE_EMPLOYEES_IN_DEP2,
                        SALES_PERSON_IN_DEP2),
                new CountEmployeesInDepartment(DEPARTMENT3, MANAGERS_IN_DEP3, EMPLOYEES_IN_DEP3, WAGE_EMPLOYEES_IN_DEP3,
                        SALES_PERSON_IN_DEP3),
                new CountEmployeesInDepartment(DEPARTMENT4, MANAGERS_IN_DEP4, EMPLOYEES_IN_DEP4, WAGE_EMPLOYEES_IN_DEP4,
                        SALES_PERSON_IN_DEP4)
        };
        try (PrintWriter writer = new PrintWriter(fileName)) {
            saveToFile(company, writer);
            writer.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void saveToFile(CountEmployeesInDepartment[] company, PrintWriter writer) {
        for (int i = 0; i < company.length; i++) {
            for (int j = 0; j < company[i].managers(); j++) {
                int id = Ranges.getId();
                int salary = Ranges.getBasicSalary();
                float factor = Ranges.getFactor();
                writer.println(String.format("%d,%s,%d,%s,%s,%s,%s,%s,%s", id, "Manager", salary, company[i].departnment(), factor, "", "", "", ""));
            }
            for (int j = 0; j < company[i].employees(); j++) {
                int id = Ranges.getId();
                int salary = Ranges.getBasicSalary();
                writer.println(String.format("%d,%s,%d,%s,%s,%s,%s,%s,%s", id, "Employee", salary, company[i].departnment(), "", "", "", "", ""));
            }
            for (int j = 0; j < company[i].wageEmployees(); j++) {
                int id = Ranges.getId();
                int salary = Ranges.getBasicSalary();
                int wage = Ranges.getWage(); 
                int hours = Ranges.getHours();
                writer.println(String.format("%d,%s,%d,%s,%s,%s,%s,%s,%s", id, "WageEmployee", salary, company[i].departnment(), "", wage, hours, "", ""));
            }
            for (int j = 0; j < company[i].salesPersons(); j++) {
                int id = Ranges.getId();
                int salary = Ranges.getBasicSalary();
                int wage = Ranges.getWage(); 
                int hours = Ranges.getHours();
                float percent = Ranges.getPercent();
                long sales = Ranges.getSales();
                writer.println(String.format("%d,%s,%d,%s,%s,%s,%s,%s,%s", id, "WageEmployee", salary, company[i].departnment(), "", wage, hours, percent, sales));
            }
        }
    }
}