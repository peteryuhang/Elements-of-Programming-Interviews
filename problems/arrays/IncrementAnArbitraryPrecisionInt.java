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

  /* 
   * Variant: Write a program which takes as input two strings s and t of bits encoding binary numbers
   * Bs and Bt, respectively, and returns a new string of bits representing the number Bs + Bt
   */
  public static String plusBinary(String s, String t) {
    int ps = s.length() - 1, pt = t.length() - 1;
    String result = "";
    int carry = 0;
    while (ps >= 0 && pt >= 0) {
      int cur = (s.charAt(ps) - '0') + (t.charAt(pt) - '0') + carry;
      result = (cur == 1 || cur == 3 ? "1" : "0") + result;
      carry = cur - 1 > 0 ? 1 : 0;
      ps--; pt--;
    }

    while (ps >= 0) {
      int cur = (s.charAt(ps) - '0') + carry;
      result = (cur == 1 ? "1" : "0") + result;
      carry = cur - 1 > 0 ? 1 : 0;
      ps--;
    }

    while (pt >= 0) {
      int cur = (t.charAt(pt) - '0') + carry;
      result = (cur == 1 ? "1" : "0") + result;
      carry = cur - 1 > 0 ? 1 : 0;
      pt--;
    }

    if (carry > 0) {
      result = "1" + result;
    }

    return result;
  }

  public static void main(String[] args) {
    arrPrint(plusOne(new int[]{1,2,9}));
    arrPrint(plusOne(new int[]{9,9,9}));
    arrPrint(plusOne(new int[]{9,0,9}));
    arrPrint(plusOne(new int[]{0,0,0}));

    System.out.println("===========================");

    System.out.println(plusBinary("11111111","1"));
    System.out.println(plusBinary("10001111","1"));
    System.out.println(plusBinary("0000001","1"));
    System.out.println(plusBinary("0000001","100000"));
    System.out.println(plusBinary("0000001","100111"));
  }
}
