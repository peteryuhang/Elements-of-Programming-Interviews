/* 
 * A palindromic string is one which reads the same forwards and backwards,
 * e.g., "redivider". In this problem, you are to write a program which 
 * determines if the decimal representation of an integer is a palindromic string.
 * For example, your program should return true for the inputs 0,1,7,11,121,333,
 * and 2147447412, and false for the inputs -1,12,100, and 2147483647.
 * 
 * Write a program that takes an integer and determines if that integer's representation
 * as a decimal string is a palindrome.
 */
public class CheckIfADecimalIntegerIsAPalindrome {
  // convert to string
  public static boolean check(long x) {
    String xStr = Long.toString(x);

    for (int i = 0, j = xStr.length() - 1; i <= j; i++, j--) {
      if (xStr.charAt(i) != xStr.charAt(j)) {
        return false;
      }
    }
    return true;
  }

  // without convertion
  public static boolean checkDirectly(long x) {
    if (x < 0) { return false; }

    final long numDigits = (long)Math.floor(Math.log10(x)) + 1L;
    long mask = (long)Math.pow(10, numDigits - 1);
    while (x > 10 && (x / mask) == (x % 10)) {
      x %= mask;      // remove the most significant digit
      x /= 10;        // remove the least significant digit
      mask /= 100;    // update mask
    }
    return x < 10 ? true : false;
  }

  public static void main(String[] args) {
    // 0,1,7,11,121,333
    System.out.println(checkDirectly(0));
    System.out.println(checkDirectly(1));
    System.out.println(checkDirectly(7));
    System.out.println(checkDirectly(11));
    System.out.println(checkDirectly(121));
    System.out.println(checkDirectly(333));
    System.out.println(checkDirectly(2147447412));

    System.out.println(checkDirectly(-1));
    System.out.println(checkDirectly(12));
    System.out.println(checkDirectly(100));
    System.out.println(checkDirectly(2147483647));
  }
}
