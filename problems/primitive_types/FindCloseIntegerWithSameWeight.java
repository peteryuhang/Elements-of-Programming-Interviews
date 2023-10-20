
/* 
 * Define the weight of a nonnegative integer x to be the number of bits that
 * are set to 1 in its binary representation. For example, since 92 in base2
 * equals (1011100)2, the weight of 92 is 4. Write a program which takes as input
 * a nonnegative integer x and returns a number y which is not equal to x, but
 * has the same weight as x and their difference, |y - x|, is as small as possible.
 * You can assume x is not 0, or all Is. For example, if x = 6, you should
 * return 5.
 */
public class FindCloseIntegerWithSameWeight {
  private static final int NUM_UNSIGN_BITS = 31;

  // swap the two rightmost consecutive bits that differ
  public static int bruteForce(int x) {
    for (int i = 0; i < NUM_UNSIGN_BITS; i++) {
      if ((((x >>> i) & 1) !=((x >>> (i + 1)) & 1))){
        x ^= (1 << i)| (1 << (i + 1)); // Swaps bit-i and bit-(i + 1). return x;
        return x;
      }
    }

    throw new IllegalArgumentException("All bits are 0 or 1");
  }

  // Variant: Solve the same problem in 0(1) time and space
  // 
  // x & ~(x - 1)       -> find the rightmost 1
  // (~x) & ~(~x - 1)   -> find the rightmost 0
  // if the rightmost 0 pos less than rightmost 1, rightmost 1 swap with its right closest 0:
  //      ((x & ~(x - 1)) >> 1) | (x & (x - 1))
  // if the rightmost 0 pos large than rightmost 1, rightmost 0 swap with its right closest 1:
  //      x ^ (((~x) & ~(~x - 1)) | (((~x) & ~(~x - 1)) >> 1))
  public static long findCloseInt(long x) {
    if (x == 0 || x == Long.MAX_VALUE) {
      throw new IllegalArgumentException("All bits are 0 or 1");
    }

    if ( ((~x) & ~(~x - 1)) < (x & ~(x - 1)) ) {
      return ((x & ~(x - 1)) >> 1) | (x & (x - 1));
    }

    return x ^ ( ((~x) & ~(~x - 1)) | (((~x) & ~(~x - 1)) >> 1) );
  }

  public static void main(String[] args) {
    System.out.println(bruteForce(1));
    System.out.println(bruteForce(2));
    System.out.println(bruteForce(3));
    System.out.println(bruteForce(4));
    System.out.println(bruteForce(5));
    System.out.println(bruteForce(6));
    System.out.println(bruteForce(7));
    System.out.println(bruteForce(8));
    System.out.println(bruteForce(9));
    System.out.println(bruteForce(10));
    System.out.println("=================");
    System.out.println(findCloseInt(1));
    System.out.println(findCloseInt(2));
    System.out.println(findCloseInt(3));
    System.out.println(findCloseInt(4));
    System.out.println(findCloseInt(5));
    System.out.println(findCloseInt(6));
    System.out.println(findCloseInt(7));
    System.out.println(findCloseInt(8));
    System.out.println(findCloseInt(9));
    System.out.println(findCloseInt(10));
  }
}
