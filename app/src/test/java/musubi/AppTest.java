package musubi;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
  // Test that Polygon.contains returns true for a point inside the polygon
  @Test
  void testContainsInside() {
    Point[] polygonPoints = {
        new Point(1, 1),
        new Point(1, 6),
        new Point(8, 7),
        new Point(8, 2)
    };
    Polygon polygon = new Polygon(polygonPoints);

    Point pointToCheck = new Point(5, 5);

    assertTrue(polygon.contains(pointToCheck));
  }

  // Test that Polygon.contains returns false for a point outside the polygon
  @Test
  void testContainsOutside() {
    Point[] polygonPoints = {
        new Point(1, 1),
        new Point(1, 6),
        new Point(8, 7),
        new Point(8, 2)
    };
    Polygon polygon = new Polygon(polygonPoints);

    Point pointToCheck = new Point(10, 10);

    assertFalse(polygon.contains(pointToCheck));
  }

  // Test that Polygon.contains does not throw if an edge is vertical
  @Test
  void testWithVerticalEdge() {
    Point[] polygonPoints = {
        new Point(1, 1),
        new Point(1, 6),
        new Point(8, 7),
        new Point(8, 1)
    };
    Polygon polygon = new Polygon(polygonPoints);

    Point pointToCheck = new Point(10, 10);

    // should not throw
    assertDoesNotThrow(() -> polygon.contains(pointToCheck));
  }

  // assert that creating a Polygon with less than 3 vertices throws an exception
  @Test
  void testWithLessThan3Vertices() {
    Point[] polygonPoints = {
        new Point(1, 1),
        new Point(1, 6)
    };

    assertThrows(AssertionError.class, () -> new Polygon(polygonPoints));
  }
}
