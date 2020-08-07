class Utility {
    public static <T extends Number> double getMidpoint(T[] array) {
        if(array.length % 2 == 0) {
            return (array[array.length/2].doubleValue() + array[array.length/2 - 1].doubleValue()) / 2;
        }
        return array[array.length/2].doubleValue();
    } 

    public static <T> T getMidpoint(T[] array) {
        return array[array.length/2];
    }

    public static <T> T getLast(T[] array) {
        return array[array.length - 1];
    }

    public static <T extends Number> double getAverage(T[] array) {
        double sum = 0;
        for(T elmt : array) {
            sum += elmt.doubleValue();
        }
        return (sum/array.length);
    }

    // public static void main(String[] args) {
    //     String[] a = {"aa", "bb"};
    //     System.out.println(Utility.<String>getMidpoint(a));
    // }
}