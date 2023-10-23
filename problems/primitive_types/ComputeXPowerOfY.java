/* 
 * Write a program that takes a double x and an integer y and returns x^y.
 * You can ignore overflow and underflow.
 */
public class ComputeXPowerOfY {
  // brute force -> O(y)
  public static double compute(double x, int y) {
    double result = 1.0;
    while (y-- >= 1) {
      result *= x;
    }
    return result;
  }

  // O(logy)
  public static double computeV2(double x, int y) {
    if (y == 1) {
      return x;
    }

    if (y == 0) {
      return 1;
    }

    double res = computeV2(x, y/2);
    if ((y & 0x01) == 1) {
      return res * res * x;
    }
    
    return res * res;
  }

  // O(logy) in loop version and also consider negative y
  public static double computeV3(double x, int y) {
    double result = 1.0;
    if (y < 0) {
      y = -y;
      x = 1.0 / x;
    }

    while (y > 0) {
      if ((y & 1) == 1) {
        result *= x;
      }
      x = x * x;
      y >>>= 1;
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(compute(2.0, 3));
    System.out.println(computeV2(2.0, 3));
    System.out.println(computeV3(2.0, 3));
  }
}
