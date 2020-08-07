public abstract class Employee {
    protected boolean hasMarried;

    public Employee() {
        this.hasMarried = false;
    }

    /**
     * @param hasMarried the hasMarried to set
     */
    public void setHasMarried(boolean hasMarried) {
        this.hasMarried = hasMarried;
    }

    public abstract int calculateSalary(int workHour);
}