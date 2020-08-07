class Programmer extends Employee {
    public int calculateSalary(int workHour) {
        int result = 0;
        if(workHour <= 150) {
            result =  100000 * workHour;
        }
        else{
            result = 100000 * 150 + (workHour - 150) * 10000;
        }
        if(this.hasMarried) {
            result += 4000000;
        }
        return result;
    }
}