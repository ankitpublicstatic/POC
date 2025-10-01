import java.util.Arrays;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class TestM {

  public static void main(String[] args) {
    int[] nums = {2, 4, 5, 2, 4, 3, 6, 4, 2};
    Entry<Integer, Long> maxCount =
        Arrays.stream(nums).boxed().collect(Collectors.groupingBy(x -> x, Collectors.counting()))
            .entrySet().stream().filter(x -> x.getValue() > 1).findFirst().get();
    System.out.println("Array : " + Arrays.toString(nums));
    System.out.printf("Number = %d%n Maximum comes %d time.", maxCount.getKey(),
        maxCount.getValue());
  }


  // Pojo Request class
  // Lombok Anotation for Getter, Setters, ToString, Constructor all/no arguments
  // QuestionReq
  //
  // {
  // Long userId;
  // String question;
  // String category;
  // QuestionLevel level; // Enum : Easy, Medium, Hard
  // String description;
  // }
  //
  // // Entity Domain class
  // // Lombok Anotation for Getter, Setters, ToString, Constructor all/no arguments
  // @Table("questions")Question extends AbstractAuditClass{
  // Long questionId;
  // Long userId;
  // String question;
  // String category;
  // QuestionLevel level; // Enum : Easy, Medium, Hard
  // String description;
  //
  // // Audit Fields extends from Abstract AuditClass
  // }
  //
  //
  //
  // // add question
  // @PostMapping("/add/question")
  // ResponseEntity<?> addQuestion(Body QuestionReq questionRreq){
  // try {
  // service.addQuestion(questionreq);
  //
  // // Request validation logic
  //
  // // User validation else throw UserNotFound/ InvalidUser id
  //
  // // Question required fields and Input data is correct or not else throw custom exception.
  //
  //
  // // Service logic
  // Question question = new Question();
  // BeanUtils.copyProperties(QuestionReq, question);
  // // write any business logic that will transform request data to any
  // // business specific logic
  //
  // repo.save(question);
  // Map<String,Object> response;
  // response.put("message", "Question added successfully");
  // response.put("status", HttpsStatus.Created);
  // response.put("data", question);
  //
  // // return to controller
  // // response
  //
  // return new ResponseEntity.ok(map);
  // }catch(Exception e) {
  // Map<String,Object> response;
  // response.put("message", "Question adding failed.");
  // response.put("status", HttpsStatus.Created);
  // response.put("data", question);
  //
  // return new ResponseEntity.ok();
  // }
  //
  //
  // }
  // // rate question
  // // give answer
  //

}
