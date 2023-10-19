## Primitive types boot camp

- Programs count the number of 1 in a integer
```java
public static short countBits(int x) { 
  short numBits = 0;
  while (x != 0) {
    numBits += (x & 1);
    x >>>= 1;
  }
  return numBits;
}
```

- Things we better know
  1. box-types and primitive types
  2. auto-boxing and the limitation
  3. Random library
  4. Bitwise operations
  5. Constant denoting the maximum and minimum values for numeric types
  6. Know the box-type's method, especially factories, eg. `Double.valueOf()`
  7. Prefer the box-type static methods for comparing values, e.g., Double.compare(x,1.23) == 8 rather than x == 1.23, these methods are
far more resilient to floating point values like infinity, negative infinity, NaN
  8. Key methods in `Math` are `abs`, `ceil`, `floor`, `min`, `max`, `pow`, and `sqrt`
  9. Understand the limits of autoboxing, e.g., why `Character[] C = new char[]{'a' ,'b'};` will not compile
  10. Know how to interconvert integers, characters, and strings, e.g.,
`Character.getNumericValue(x)` (or just `x - '8'`) to convert a digit character to an integer, String.valueOf(123) to convert an integer to a string, etc.
  11. The key methods in Random are nextlnt(16), nextlntO, nextBooleanO, and nextDoubleO (which returns a value in [0, 1)).