package com.ankit.poc.java8;

public class DoTest {
  public static void main(String[] args) {
    // int a = 10;
    // int c = a / 0;
    // System.out.println(c);
    //
    // File file = new File("C:\\home\\user\\log.txt");
    // try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
    // if (bufferedReader.readLine() != null) {
    // System.out.println(bufferedReader.readLine());
    // }
    // } catch (FileNotFoundException e) {
    // e.printStackTrace();
    // } catch (IOException e) {
    // e.printStackTrace();
    // }
    String value = "en_loan_tractor";
    // List<String> list = Arrays.stream(value.split("_")).collect(Collectors.toList());
    // String firstString = list.get(1);
    // String secondString = list.get(2);
    // System.out.println(("" + firstString.toCharArray()[0]).toUpperCase()
    // + firstString.substring(1, firstString.length()) + " "
    // + ("" + secondString.toCharArray()[0]).toUpperCase()
    // + secondString.substring(1, secondString.length()));
    String[] valArray = value.split("_");
    System.out.println(Character.toUpperCase(valArray[1].charAt(0))
        + valArray[1].substring(1, valArray[1].length()) + " "
        + Character.toUpperCase(valArray[2].charAt(0))
        + valArray[2].substring(1, valArray[2].length()));
  }
}
