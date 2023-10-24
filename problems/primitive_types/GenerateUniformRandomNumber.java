import java.util.Random;

/* 
 * This problem is motivated by the following scenario. Six friends have to
 * select a designated driver using a single unbiased coin. The process should
 * be fair to everyone.
 * 
 * How would you implement a random number generator that generates a random
 * integer i between a and b, inclusive, given a random number generator that
 * produces zero or one with equal probability? All values in [a,b] should be
 * equally likely.
 * */
public class GenerateUniformRandomNumber {
  // a - b = 1: 2 situations, throw coin one time
  // a - b = 2: 3 situations, throw coin two times, 00 01 10 11
  // a - b = 3: 4 situations, throw coin two times, 00 01 10 11
  // a - b = 4: 5 situations, throw coin three times, 000 001 010 011 100 101 110 111
  // ...
  public static int generate(int a, int b) {
    int situations = (int)Math.abs(a - b) + 1;
    if (situations == 1) {
      return a;
    }

    Random random = new Random();
    int res = Integer.MAX_VALUE;
    while (res >= situations) {       // check if the random number is in situations
      res = 0;
      for (int i = 0; (1 << i) < situations; i++) {
        res = (res << 1) | random.nextInt(2);
      }
    }

    return Math.min(a, b) + res;
  }

  public static void main(String[] args) {
    System.out.println(generate(1, 6));
    System.out.println(generate(1, 6));
    System.out.println(generate(1, 6));
    System.out.println(generate(1, 6));
    System.out.println(generate(1, 6));
    System.out.println(generate(1, 6));
    System.out.println(generate(1, 6));
    System.out.println(generate(1, 6));
    System.out.println(generate(1, 6));
    System.out.println(generate(1, 6));
    System.out.println(generate(1, 6));
    System.out.println(generate(1, 6));
    System.out.println(generate(1, 6));
    System.out.println(generate(1, 6));
    System.out.println(generate(1, 6));
    System.out.println(generate(1, 6));
    System.out.println(generate(1, 6));
    System.out.println(generate(1, 6));
    System.out.println(generate(1, 6));
    System.out.println(generate(1, 6));
    System.out.println(generate(1, 6));
    System.out.println(generate(1, 6));
    System.out.println(generate(1, 6));
    System.out.println(generate(1, 6));
    System.out.println(generate(1, 6));
    System.out.println(generate(1, 6));
    System.out.println(generate(1, 6));
    System.out.println(generate(1, 6));
    System.out.println(generate(1, 6));
    System.out.println(generate(1, 6));
  }
}
