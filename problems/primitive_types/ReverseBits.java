/* 
 * Write a program that takes a 64-bit word and returns the 64-bit word
 * consisting of the bits of the input word in reverse order. For example,
 * if the input is alternating 1s and 0s, i.e.,(1010...10), the output should
 * be alternating 0s and 1s, i.e.,(0101...01).
 */
public class ReverseBits {
  private static long[] precomputedReverse;

  // Do the swap for each bit, O(N)
  public static long bruteForce(long x) {
    long r = 0;
    for (int i = 63; i >= 0; i--) {
        r |= ((x >>> i) & 1) << (63 - i);
    }
    return r;
  }

  // add a lookup table, O(N/L)
  public static long reverseBits(long x) {
    final int BIT_MASK = 0xFFFF;
    return (
      (precomputedReverse[(int)(x & BIT_MASK)] << 48) |
      (precomputedReverse[(int)((x >>> 16) & BIT_MASK)] << 32) |
      (precomputedReverse[(int)((x >>> 32) & BIT_MASK)] << 16) |
      (precomputedReverse[(int)((x >>> 48) & BIT_MASK)])
    );
  }

  public static void main(String[] args) {
    precomputedReverse = new long[65536];
    for (int x = 0; x < precomputedReverse.length; x++) {
      precomputedReverse[x] = bruteForce(x) >>> 48;
    }

    long test = -1;
    System.out.println(bruteForce(test));
    System.out.println(reverseBits(test));
  }
}
