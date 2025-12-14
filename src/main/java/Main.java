import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
  public static void main(String[] args) {


    List<String> list =
        Arrays.asList("Chennai", "Bangalore", "Chennai", "Hyderabad", "Bangalore", "Hyderabad");
    // find second duplicate element from the list

    // System.out.println(list.stream() .collect(Collectors.groupingBy(x -> x, LinkedHashMap::new,
    // Collectors.counting())) .entrySet().stream().filter(x -> x.getValue() >
    // 1).collect(Collectors.toList()).get(1));


    // 🎯 Explanation (How to think about the problem?)
    // Step-by-step thought process:
    //
    // You need to check how many times "DEMO" appears inside a bigger string.
    //
    // A substring can be searched using indexOf.
    //
    // Every time you find one occurrence, increase the count.
    //
    // Move the index forward to continue searching.
    //
    // Continue until no more substring is found (indexOf returns -1).

    String str = "TESTDEMOTESTDEMO";
    String sub = "DEMO";

    int count = 0;
    int index = 0;
    Matcher matcher = Pattern.compile(sub).matcher(str);

    while (matcher.find()) {
      count++;
    }


    while ((index = str.indexOf(sub, index)) != -1) {
      count++;
      index = index + sub.length(); // move ahead
    }
    int count1 = (str.length() - str.replace(sub, "").length()) / sub.length();
    System.out.println(count);
  }
}

// EMP
//
// NAME ID MANAGERID
//
// RAKESH 1
//
// ABHISHEK 2 1
//
// PRAKASH 3 2
//
// MANJU 4 3
//
// SHINATH 5 2
//
// Get employees and their manager names ?
//
// select e.name as employee_name, e.name as manager_name from emp e
// left join emp r on e.managerid = r.id;
//


