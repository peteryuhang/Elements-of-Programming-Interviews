/* 
 * The parity of a binary word is 1 if the number of is in the word is odd; 
 * otherwise, it is 0. For example, the parity of 1011 is 1, and the parity 
 * of 10001000 is 0. Parity checks are used to detect single bit errors in 
 * data storage and communication. It is fairly straightforward to write code 
 * that computes the parity of a single 64-bit word.
 * 
 * How would you compute the parity of a very large number of 64-bit words?
 */
public class ComputingParityOfWord {

  // O(n), n is the number of bit
  public static short bruteForce(long x) {
    short result = 0;
    while (x != 0) {
      result ^= (x & 1);
      x >>>= 1;
    }
    return result;
  }

  // O(k), k is the number of 1
  public static short optimizeV1(long x) {
    short result = 0;
    while (x != 0) {
      result ^= 1;
      x &= (x - 1);  // remove the last 1
    }
    return result;
  }

  // introduce cache, O(n/L), L is the cached data size
  public static short optimizeV2(long x) {
    final int WORD_SIZE = 16;
    final int BIT_MASK = 0xFFFF;
    int[] precomputedParity = new int[2 >> 16];// assuming this array been filled
    return (short) (
      precomputedParity[(int)((x >>> (3 * WORD_SIZE)) & BIT_MASK)]
      ^ precomputedParity[(int)((x >>> (2 * WORD_SIZE)) & BIT_MASK)]
      ^ precomputedParity[(int)((x >>> WORD_SIZE) & BIT_MASK)]
      ^ precomputedParity[(int)(x & BIT_MASK)]
    );
  }

  /* 
   * XOR is associative and commutative
   * The parity of (b63,b62,...,b3,b2,b1,b0) equals the parity of
   * the XOR of(b63,b62,...,b32) and (b31,b30,...,b0)
   * 
   * So we can do the shift and XOR with itself, take O(logN) time
   * */
  public static short optimizeV3(long x) {
    x ^= x >>> 32;
    x ^= x >>> 16;
    x ^= x >>> 8;
    x ^= x >>> 4;
    x ^= x >>> 2;
    x ^= x >>> 1;

    return (short)(x & 0x01);
  }

  /* 
   * Combine the V2 and V3, we can get a more quick version
   * */
  public static short optimizeV4(long x) {
    final int BIT_MASK = 0xFFFF;
    int[] precomputedParity = new int[2 >> 16];// assuming this array been filled

    x ^= x >>> 32;
    x ^= x >>> 16;

    return (short) (
      precomputedParity[(int)(x & BIT_MASK)]
    );
  }

  public static void main(String[] args) {
    long test1 = 9;
    long test2 = 1;
    long test3 = 0;

    System.out.println("Testcase 1:");
    System.out.println("Brute force: " + bruteForce(test1));
    System.out.println("OptimizeV1:" + optimizeV1(test1));
    // System.out.println("OptimizeV2:" + optimizeV2(test1));
    System.out.println("OptimizeV3:" + optimizeV3(test1));
    // System.out.println("OptimizeV4:" + optimizeV4(test1));
    System.out.println("==================");
    System.out.println("Testcase 2:");
    System.out.println("Brute force: " + bruteForce(test2));
    System.out.println("OptimizeV1:" + optimizeV1(test2));
    // System.out.println("OptimizeV2:" + optimizeV2(test2));
    System.out.println("OptimizeV3:" + optimizeV3(test2));
    // System.out.println("OptimizeV4:" + optimizeV4(test2));
    System.out.println("==================");
    System.out.println("Testcase 3:");
    System.out.println("Brute force: " + bruteForce(test3));
    System.out.println("OptimizeV1:" + optimizeV1(test3));
    // System.out.println("OptimizeV2:" + optimizeV2(test3));
    System.out.println("OptimizeV3:" + optimizeV3(test3));
    // System.out.println("OptimizeV4:" + optimizeV4(test3));
  }
}