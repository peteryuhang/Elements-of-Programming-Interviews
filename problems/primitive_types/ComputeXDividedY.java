/* 
 * Given two positive integers, compute their quotient, using only the addition,
 * subtraction, and shifting operators.
 * */
public class ComputeXDividedY {
  // brute force, O(2^63)
  public static long getQuotient(long x, long y) {
    long res = 0;
    while (x >= y) {
      res++;
      x -= y;
    }
    return res;
  }

  // better version depend on 2^k * y, O(n^2), n is the number of bits(32)
  public static long getQuotientV2(long x, long y) {
    long res = 0;
    while (x >= y) {
      long k = 0;
      while ((y << (k+1)) > 0 && (y << (k+1)) <= x) {
        k++;
      }
      x -= (y << k);
      res += (1 << k);
    }

    return res;
  }

  // better version based on v2, O(n)
  public static long getQuotientV3(long x, long y) {
    long res = 0;
    long power = 32;
    long yPower = (y << power);
    while (x >= y) {
      while (yPower > x) {
        yPower >>>= 1;
        power--;
      }
      x -= yPower;
      res += (1L << power);
    }

    return res;
  }

  public static void main(String[] args) {
    System.out.println(getQuotient(100, 2));
    System.out.println(getQuotientV2(100, 2));
    System.out.println(getQuotientV3(100, 2));
  }
}
