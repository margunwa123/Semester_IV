import java.util.ArrayList;
import java.util.Random;

class Utility{
  public static <T extends Number> double getMidpoint(final T[] arr) {
    final int array_length = arr.length;
    if(array_length % 2 == 0) {
      return ((arr[array_length/2].doubleValue() + arr[array_length/2 - 1].doubleValue()) / 2);
    }
    else {
      return (arr[array_length/2].doubleValue());
    }
  }
  public static <T> T getMidpoint(final T[] arr) {
    return (arr[arr.length/2]);
  }


  public static <T> T getLast(final T[] arr) {
    return (arr[arr.length -1]);
  }

  public static <T extends Number> double getAverage(final T[] arr) {
    double sum = 0;
    for (final T number: arr) {
      sum += number.doubleValue();
    }
    return (sum / arr.length);
  }
  public static void main(String[] args) {
    Double[] arr = new Double[5];
    for(int i = 0 ; i < arr.length ; i++) {
      arr[i] = Math.random();
    }
    for(Double elmt: arr) {
      System.out.println(elmt);
    }
    System.out.println(Utility.<Double>getLast(arr));
    System.out.println(Utility.<Double>getAverage(arr));
  }
}