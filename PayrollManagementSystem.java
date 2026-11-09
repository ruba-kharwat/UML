
package payrollmanagementsystem;
import java.time.LocalDate; 
import java.util.*;

public class PayrollManagementSystem {
public static void main(String[] args) {

List<Employee> employees = new ArrayList<>();
Employee emp1 = new FullTimeEmployee("E01", "Ahmed", 5000,LocalDate.of(2024,2,1),1000);
Employee emp2 = new FullTimeEmployee("E02", "Ruba", 4500,LocalDate.of(2023,6,15),900);
Employee emp3 = new ContractorEmployee("E03", "Ali",LocalDate.of(2022,8,20),60,90);
    employees.add(emp1);
    employees.add(emp2);
    employees.add(emp3);
Map<Employee, Double> scores = new HashMap<>();
    scores.put(emp1, 4.5);
    scores.put(emp2, 3.5);
    scores.put(emp3, 4.8);
Collections.sort(employees);
System.out.println("Employees Sorted By Salary:");
for (Employee emp : employees) {
        System.out.println(emp);
    }
Comparator<Employee> byJoinDate =(e1, e2) -> e1.getJoinDate().compareTo(e2.getJoinDate());

Collections.sort(employees, byJoinDate);
 System.out.println("\nEmployees Sorted By Join Date:");
    for (Employee emp : employees) {
        System.out.println(emp.getName()+ " - " + emp.getJoinDate());
    }
    double totalTax = 0;
    double totalBonus = 0;
 for (Employee emp : employees) {
        totalTax += emp.calculateTax();
        totalBonus += emp.calculateBonus(scores.get(emp));
    }
System.out.println("\nTotal Taxes: " + totalTax);
System.out.println("Total Bonuses: " + totalBonus);
}
}