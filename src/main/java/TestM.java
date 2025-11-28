import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class TestM {

  public static void main(String[] args) {
    int[] nums = {2, 4, 5, 2, 4, 3, 6, 4, 2};
    Entry<Integer, Long> maxCount = Arrays.stream(nums).boxed()
        .collect(Collectors.groupingBy(x -> x, LinkedHashMap::new, Collectors.counting()))
        .entrySet().stream().filter(x -> x.getValue() > 1).findFirst().get();
    System.out.println("Array : " + Arrays.toString(nums));
    System.out.printf("Number = %d%n Maximum comes %d time.", maxCount.getKey(),
        maxCount.getValue());
  }
}
