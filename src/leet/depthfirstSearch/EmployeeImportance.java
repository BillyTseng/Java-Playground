package leet.depthfirstSearch;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*690. Employee Importance - easy*/
public class EmployeeImportance {

    // Employee info
    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0) {
            return 0;
        }
        Map<Integer, Employee> employeesMap = buildMap(employees);
        return getImportance(id, employeesMap);
    }

    private int getImportance(int id, Map<Integer, Employee> employeesMap) {
        Employee curr = employeesMap.get(id);
        int totalImportance = curr.importance;
        for (int subsId : curr.subordinates) {
            totalImportance += getImportance(subsId, employeesMap);
        }
        return totalImportance;
    }

    private Map<Integer, Employee> buildMap(List<Employee> employees) {
        Map<Integer, Employee> retMap = new HashMap<>();
        for (Employee employee : employees) {
            if (employee != null) {
                retMap.put(employee.id, employee);
            }
        }
        return  retMap;
    }
}
