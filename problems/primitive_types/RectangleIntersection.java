import java.util.HashSet;
/* 
 * This problem is concerned with rectangles whose sides are parallel to
 * the X-axis and Y-axis. 
 * 
 * Write a program which tests if two rectangles have a nonempty intersection.
 * If the intersection is nonempty, return the rectangle formed by their
 * intersection.
 */
public class RectangleIntersection {
  private static class Rectangle {
    // x, y represent the left bottom corner
    int x, y, height, width;
    Rectangle(int x, int y, int height, int width) {
      this.x = x;
      this.y = y;
      this.height = height;
      this.width = width;
    }
    public String toString() {
      return x + "," + y + "," + height + "," + width; 
    }
  }

  public static Rectangle intersect(Rectangle recA, Rectangle recB) {
    if (
      recA.x <= recB.x + recB.width && recB.x <= recA.x + recA.width
      && recA.y <= recB.y + recB.height && recB.y <= recA.y + recA.height
    ) {
      return new Rectangle(
        Math.max(recA.x, recB.x), Math.max(recA.y, recB.y),
        Math.min(recA.y + recA.height, recB.y + recB.height) - Math.max(recA.y, recB.y),
        Math.min(recA.x + recA.width, recB.x + recB.width) - Math.max(recA.x, recB.x)
      );
    }

    return new Rectangle(-1, -1, -1, -1);
  }

  /* 
   * Variant 1: Given four points in the plane, how would you check if they are the
   * vertices of a rectangle?
   */
  public static boolean isRec(int[] a, int[] b, int[] c, int[] d) {
    HashSet<String> set = new HashSet<>();
    set.add(a[0]+","+a[1]);
    set.add(b[0]+","+b[1]);
    set.add(c[0]+","+c[1]);
    set.add(d[0]+","+d[1]);

    // left bottom
    int[] lb = new int[]{
      Math.min( Math.min(a[0], b[0]), Math.min(c[0], d[0]) ),
      Math.min( Math.min(a[1], b[1]), Math.min(c[1], d[1]) )
    };

    // right top
    int[] rt = new int[]{
      Math.max( Math.max(a[0], b[0]), Math.max(c[0], d[0]) ),
      Math.max( Math.max(a[1], b[1]), Math.max(c[1], d[1]) )
    };
    return set.contains(lb[0]+","+lb[1])
          && set.contains(rt[0]+","+rt[1])
          && set.contains(lb[0]+","+rt[1])
          && set.contains(rt[0]+","+lb[1]);
  }

  /* 
   * Variant 2: How would you check if two rectangles, not necessarily aligned
   * with the X and Y axes, intersect?
   * */
  public static boolean intersect2(Rectangle recA, Rectangle recB) {
    
  }

  public static void main(String[] args) {
    System.out.println(
      intersect(
        new Rectangle(0, 0, 5, 5),
        new Rectangle(2, 2, 7, 8)
      )
    );

    System.out.println(
      isRec(
        new int[]{0,0},
        new int[]{5,5},
        new int[]{0,1},
        new int[]{5,0}
      )
    );
  }
}
