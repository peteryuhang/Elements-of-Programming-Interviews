
/* 
 * Sometimes the processors used in ultra low-power devices such as hearing
 * aids do not have dedicated hardware for performing multiplication. A 
 * program that needs to perform multiplication must do so explicitly using
 * lower-level primitives.
 * 
 * Write a program that multiplies two nonnegative integers. The only operators
 * you are allowed to use are:
 *   • assignment
 *   • the bitwise operators >>, <<, |, &, ^ and
 *   • equality checks and Boolean combinations thereof.
 * You may use loops and functions that you write yourself. These constraints
 * imply, for example, that you cannot use increment or decrement, or test if
 * x < y.
 */
public class ComputeXxYWithoutArithmeticalOperators {
  /* 
   * Step for calculation:
   *    1. Convert multiply to addition, x * y = y + ... + y = (2^0 * y) + (2^1 * y) + ...
   *    2. For addition, we add bit by bit
   */
  public static long multiply(long x, long y) {
    long sum = 0;
    while (x != 0) {
      if ((x & 0x01) != 0) {
        sum = add(sum, y);
      }
      x >>>= 1;
      y <<= 1;
    }
    return sum;
  }

  private static long add(long a, long b) {
    long carryin = 0, result = 0, k = 1, tmpA = a, tmpB = b;
    while (tmpA != 0 || tmpB != 0) {
      long ak = a & k, bk = b & k;
      long carryout = (ak & bk) | (ak & carryin) | (bk & carryin);
      result |= (ak ^ bk ^ carryin);
      carryin = carryout << 1;
      tmpA >>>= 1;
      tmpB >>>= 1;
      k <<= 1;
    }
    return result | carryin;
  }

  public static void main(String[] args) {
    System.out.println("10 * 8 = " + multiply(10, 8));
    System.out.println("10 * 0 = " + multiply(10, 0));
    System.out.println("121 * 2 = " + multiply(121, 2));
    System.out.println("10 * 890 = " + multiply(10, 890));
  }
}
