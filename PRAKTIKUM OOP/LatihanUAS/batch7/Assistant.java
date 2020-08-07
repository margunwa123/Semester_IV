import java.util.*;

public class Assistant {
  private int salary;
  private List<String> recommendations;

  Assistant(int salary) {
    this.salary = salary;
    recommendations = new ArrayList<>();
  }

  private void addPersonToRecommendations(String name) {
    this.recommendations.add(name);
    System.out.println(this.recommendations);
  }
}