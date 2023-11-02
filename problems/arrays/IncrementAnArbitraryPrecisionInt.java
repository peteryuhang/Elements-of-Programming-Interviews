/*
 * Write a program which takes as input an array of digits encoding a decimal
 * number D and updates the array to represent the number D + 1.
 * 
 * For example, if the input 65 is (1,2,9) then you should update the array to (1,3,0).
 * Your algorithm should work even if it is implemented in a language that has finite 
 * precision arithmetic.
 */
public class IncrementAnArbitraryPrecisionInt {
  public static void arrPrint(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + ", ");
    }
    System.out.println();
  }

  public static int[] plusOne(int[] arr) {
    arr[arr.length - 1]++;
    for (int i = arr.length - 1; arr[i] == 10 && i > 0; i--) {
      arr[i] = 0;
      arr[i - 1]++;
    }
    if (arr[0] == 10) {
      int[] newArr = new int[arr.length + 1];
      newArr[0]++;
      return newArr;
    }

    return arr;
  }

  public static void main(String[] args) {
    arrPrint(plusOne(new int[]{1,2,9}));
    arrPrint(plusOne(new int[]{9,9,9}));
    arrPrint(plusOne(new int[]{9,0,9}));
    arrPrint(plusOne(new int[]{0,0,0}));
  }
}
