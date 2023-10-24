/* 
 * Write a program which takes an integer and returns the integer corresponding
 * to the digits of the input written in reverse order. For example, the reverse
 * of 42 is 24, and the reverse of -314 is -413.
 */
public class ReverseDigits {
  public static int reverseDigits(int x) {
    int sign = x >= 0 ? 1 : -1;

    if (sign == -1) {
      x = -x;
    }

    int result = 0;

    while (x > 0) {
      result = result * 10 + x % 10;
      x /= 10;
    }
    return result * sign;
  }

  public static void main(String[] args) {
    System.out.println(reverseDigits(42));
    System.out.println(reverseDigits(-314));
  }
}
