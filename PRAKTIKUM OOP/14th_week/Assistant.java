import java.util.ArrayList;
import java.util.List;
class Assistant {
  private int salary;
  private List recommendations;

  Assistant(int salary) {
    this.salary = salary;
    recommendations = new ArrayList();
  }

  public void addPersonToRecommendations(String name) {
    this.recommendations.add(name);
  }

  public void printRecList() {
    System.out.println(this.recommendations);
  }

  /**
   * @return the salary
   */
  public int getSalary() {
      return salary;
  }

  /**
   * @param salary the salary to set
   */
  public void setSalary(int salary) {
      this.salary = salary;
  }
}