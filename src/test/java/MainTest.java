import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Main main;

    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testParseCSV() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "John", "Smith", "USA", 25));
        employeeList.add(new Employee(2, "Ivan", "Petrov", "RU", 23));
        String fileName = "date.csv";
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        List<Employee> list = main.parseCSV(columnMapping, fileName);
        assertEquals(employeeList, list);
        assertNotNull(main.parseCSV(columnMapping, fileName));
    }

    @Test
    void testListToJson() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1, "John", "Smith", "USA", 25));
        list.add(new Employee(2, "Ivan", "Petrov", "RU", 23));
        List<Employee> list1 = new ArrayList<>();
        list1.add(new Employee(1, "John", "Smith", "USA", 25));
        list1.add(new Employee(2, "Ivan", "Petrov", "RU", 23));
        String json = main.listToJson(list);
        String json1 = main.listToJson(list1);
        assertEquals(json, json1);
    }

    @Test
    void testParseXML() {
        String fileName = "date.xml";
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "John", "Smith", "USA", 25));
        employeeList.add(new Employee(2, "Ivan", "Petrov", "RU", 23));
        List<Employee> list = main.parseXML(fileName);
        assertEquals(employeeList, list);
    }
}