package musubi;

/**
 * Point class representing a point with x and y coordinates.
 */
public class Point {
  public int x, y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public boolean isLeftOfEdge(Point start, Point end) {
    // if edge is vertical
    if (start.x == end.x) {
      return this.x < start.x;
    }

    // if edge is not vertical
    return (end.x - start.x) * (this.y - start.y) - (end.y - start.y) * (this.x - start.x) > 0;
  }
}