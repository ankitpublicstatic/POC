import java.io.IOException;

public class Reboot {
  public static void main(String[] args) {

    rebootUsingProcessBuilder();
  }

  public static void rebootUsingProcess() {
    try {
      // Using -S to read password from stdin
      Process process = Runtime.getRuntime()
          .exec(new String[] {"/bin/bash", "-c", "echo 'Pmankit@2023' | sudo -S reboot now"});
      process.waitFor();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void rebootUsingProcessBuilder() {

    ProcessBuilder pb =
        new ProcessBuilder("bash", "-c", "echo 'Pmankit@2023' | sudo -S reboot now");
    try {
      Process process = pb.start();
      process.waitFor();
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
  }
}
