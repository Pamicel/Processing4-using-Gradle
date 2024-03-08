package musubi;

/**
 * Polygon class representing a polygon with an array of Point objects as
 * vertices.
 */
public class Polygon {
  public Point[] points;

  public Polygon(Point[] points) {
    // assert that the polygon has at least 3 vertices
    assert points.length >= 3 : "A polygon must have at least 3 vertices";
    this.points = points;
  }

  /**
   * Checks whether a point is inside this polygon using the crossing number
   * algorithm.
   *
   * The algorithm counts how many times a horizontal ray starting from the point
   * to infinity intersects with the edges of the polygon. If this count is odd,
   * the point is inside; if even, outside. This method assumes that the polygon
   * is closed (the first and last vertices are not the same).
   *
   * @param point a Point object representing the point to check.
   * @return true if the point is inside the polygon, false otherwise.
   */
  public boolean contains(Point point) {
    boolean odd = false; // Odd crossings count signifies the point is inside the polygon.

    // Loop through each edge of the polygon
    for (int i = 0, j = this.points.length - 1; i < this.points.length; i++) {
      // Check if the horizontal line that passes through the point crosses the vertex
      // of the polygon by checking that one end of the vertex is above the point and
      // the other end below.
      boolean intersects = (this.points[i].y > point.y) != (this.points[j].y > point.y);
      // Check if the point is in the half-plane to the left of the edge.
      boolean isOnLeft = point.isLeftOfEdge(this.points[i], this.points[j]);
      // Each time the horizontal line intersects AND the point is to the left, we
      // flip the odd flag.
      if (intersects && isOnLeft) {
        odd = !odd;
      }
      // Move to the next vertex, with j following i to use the previous vertex in the
      // next iteration.
      j = i;
    }
    // If odd is true (an odd number of crossings), the point is inside the polygon.
    return odd;
  }
}