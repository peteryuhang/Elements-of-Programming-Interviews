
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

  public static void main(String[] args) {
    System.out.println(
      intersect(
        new Rectangle(0, 0, 5, 5),
        new Rectangle(2, 2, 7, 8)
      )
    );
  }
}
