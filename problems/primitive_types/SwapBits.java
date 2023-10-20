/* 
 * A 64-bit integer can be viewed as an array of 64 bits,
 * with the bit at index 0 corresponding to the least significant bit (LSB),
 * and the bit at index 63 corresponding to the most significant bit (MSB).
 * Implement code that takes as input a 64-bit integer and swaps the bits at
 * indices i and j.
 * */
public class SwapBits {
  // if the bits are same at both position, no action needed
  // if the bits are different, do the swapping by XOR with mask
  public static long swapBits(long x, int i, int j) {
    if ((x >>> i) != (x >>> j)) {
      x ^= ((1L << i) | (1L << j));
    }
    return x;
  }

  public static void main(String[] args) {
    System.out.println(swapBits(73, 1, 6));
  }
}
