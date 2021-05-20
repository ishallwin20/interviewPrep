package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo1 {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(123,24,1000,"aaa"));
        employeeList.add(new Employee(124,34,3000,"bbb"));
        employeeList.add(new Employee(125,44,5000,"ccc"));
        employeeList.add(new Employee(126,54,7000,"ddd"));
        employeeList.add(new Employee(127,28,11000,"eee"));

        Map<Integer,Integer> ageBySalaryMap = employeeList.stream().collect(Collectors.toMap(e->e.age,e->e.salary));
        System.out.println(ageBySalaryMap);
    }
}
