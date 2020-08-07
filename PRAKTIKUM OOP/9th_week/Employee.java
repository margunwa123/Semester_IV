abstract class Employee {
    protected boolean hasMarried = false;
    
    public Employee() {
        
    }
    public void setHasMarried(boolean hasMarried) {
        this.hasMarried = hasMarried;
    }
    public abstract int calculateSalary(int workHour);
}