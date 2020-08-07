import java.util.ArrayList;
import java.util.List;

class Utility{
  public static double getMidpoint(final List<? extends Number> arr) {
    final int array_length = arr.size();
    if(array_length % 2 == 0) {
      return ((arr.get(array_length/2).doubleValue() + arr.get(array_length/2 - 1).doubleValue()) / 2);
    }
    else {
      return (arr.get(array_length/2).doubleValue());
    }
  }
  public static <T> T getMidpoint(final List<?> arr) {
    return (arr.get(arr.length/2));
  }

  public static <T> T getLast(final T[] arr) {
    return (arr[arr.length -1]);
  }

  public static double getAverage(final List<? extends Number> arr) {
    double sum = 0;
    for (final Number number: arr) {
      sum += number.doubleValue();
    }
    return (sum / arr.size());
  }
  public static void main(String[] args) {
    List<Double> arr;
    for(int i = 0 ; i < 5 ; i++) {
      arr.add(Math.random());
    }
    for(Double elmt: arr) {
      System.out.println(elmt);
    }
    System.out.println(Utility.<Double>getLast(arr));
    System.out.println(Utility.getAverage(arr));
  }
}