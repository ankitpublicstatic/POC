import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import com.ankit.poc.StaticData;
import com.ankit.poc.java_8.Employee;

public class Test {
  public static void main(String[] args) {
    // List<Student> studentList = StaticData.getAllStudents();
    List<Employee> employeesList = StaticData.getAllEmployees();

    // 1) We have to group all the employees using Department Name
    Map<String, List<String>> employeeNameMapByDepartmentName =
        employeesList.stream().collect(Collectors.groupingBy(Employee::getDept, LinkedHashMap::new,
            Collectors.mapping(Employee::getName, Collectors.toList())));

    System.out.println(employeeNameMapByDepartmentName);
    // 2) Based on employee salary, order the employees in descending order
    List<String> employeeNames =
        employeesList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
            .map(Employee::getName).toList();

    System.out.println(employeeNames);
    // List<Integer> uniqueStudentIdsSet =
    // studentList.stream().filter(student -> student.getId() != null)
    // .collect(Collectors.toMap(Student::getId, student -> student,
    // (exitsing, replacement) -> exitsing))
    // .values().stream().map(stud -> stud.getId()).collect(Collectors.toList());
    // List<Integer> list = studentList.stream().filter(student -> student.getId() != null)
    // .map(Student::getId).distinct().toList();
    // System.out.println(uniqueStudentIdsSet);
    // System.out.println(list);
    // <Student, Integer, Student>
    // Collector<Student, ?, Map<Integer, Student>> java.util.stream.Collectors.toMap(
    // Function<? super Student, ? extends Integer> keyMapper,
    // Function<? super Student, ? extends Student> valueMapper,
    // BinaryOperator<Student> mergeFunction

    // let s1 = 'abcd'
    // let s2 = 'pqr'
    //
    // we need to merge the string alternative characters & reverse it.
    //
    // o/p: apbqcd
    //
    // expected: dcqbpa

    // mergeAndReverseTheString();


  }

  public static void calculator() {
    while (true) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter First number, Expressoin, Second number without any space.");
      String text = scanner.next();
      String[] input = text.split("");
      if (input.length > 3) {
        throw new IllegalArgumentException("Invalid input");
      }
      Long firstNumber = Long.parseLong(input[0]);
      String expression = input[1];
      Long secondNumber = Long.parseLong(input[2]);
      long result = 0l;
      switch (expression) {
        case "+": {
          result = firstNumber + secondNumber;
          break;
        }
        case "-": {
          result = firstNumber - secondNumber;
          break;
        }
        case "*": {
          result = firstNumber * secondNumber;
          break;
        }
        case "/": {
          if (secondNumber <= 0) {
            throw new ArithmeticException("Cannot devided by zero");
          }
          result = firstNumber / secondNumber;
          break;
        }
        default:
          throw new IllegalArgumentException("Unexpected value: " + expression);
      }
      System.out.println(result);
    }
  }

  public static String mergeAndReverseTheString() {
    String s1 = "abcd";
    String s2 = "pqr";

    int length = Math.max(s1.length(), s2.length());
    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < length; i++) {

      if (i < s1.length()) {
        builder.append(s1.charAt(i));
      }

      if (i < s2.length()) {
        builder.append(s2.charAt(i));
      }
    }

    return builder.reverse().toString();

  }
}
