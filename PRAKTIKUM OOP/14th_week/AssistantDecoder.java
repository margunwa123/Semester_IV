import java.lang.reflect.*;

public class AssistantDecoder {
  private Assistant assistant;

  AssistantDecoder(Assistant assistant) {
    this.assistant = assistant;
  }

  public void addPersonToRecommendations(String name) throws Exception {
    Method addperson = this.assistant.getClass().getDeclaredMethod("addPersonToRecommendations", String.class);
    addperson.setAccessible(true);
    addperson.invoke(this.assistant, name);
  }

  public int getSalary() throws Exception {
      Field salary = this.assistant.getClass().getDeclaredField("salary");
      salary.setAccessible(true);
      return (Integer) salary.get(this.assistant);
  }
  public static void main(String[] args) {
    try {
      AssistantDecoder decoder = new AssistantDecoder(new Assistant(100000));
      System.out.println(decoder.getSalary());
      decoder.addPersonToRecommendations("bejo");
    }
    catch (Exception e) {
      System.out.println("hohoho");
    }
  }
}