public class Programmer extends Employee {
    public Programmer() {
        super();
    }

    @Override
    public int calculateSalary(int workHour) {
        int salary = this.hasMarried ? 4000000 : 0;
        if(workHour <= 150) {
            salary += workHour * 100000; 
        }
        else {
            salary += (150 * 100000) + ((workHour - 150) * 10000);
        }
        return salary;
    }
}