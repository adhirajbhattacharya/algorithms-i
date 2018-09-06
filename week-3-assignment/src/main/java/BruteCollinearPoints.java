import edu.princeton.cs.algs4.Quick3way;
import edu.princeton.cs.algs4.ResizingArrayStack;

public class BruteCollinearPoints {

  private Point[] points;
  private ResizingArrayStack<LineSegment> segments;

  public BruteCollinearPoints(Point[] points) {
    if (points == null) {
      throw new IllegalArgumentException();
    }

    for (int i = 0; i < points.length; i++) {
      if (points[i] == null) {
        throw new IllegalArgumentException();
      }
    }

    this.points = points;
    Quick3way.sort(this.points);
    for (int i = 0; i < this.points.length - 3;) {
      Point p1 = this.points[i];
      Point p2 = this.points[i + 1];
      Point p3 = this.points[i + 2];
      Point p4 = this.points[i + 3];

      double slope1 = p1.slopeTo(p2);
      double slope2 = p2.slopeTo(p3);
      double slope3 = p3.slopeTo(p4);

      if (slope1 == slope2) {
        i += 2;
      } else {
        i++;
        continue;
      }

      if (slope2 == slope3) {
        i += 2;
      } else {
        continue;
      }
      segments.push(new LineSegment(p1, p4));
    }
  }

  public int numberOfSegments() {
    return 0;
    // the number of line segments
  }

  public LineSegment[] segments() {
    return null;
    // the line segments
  }
}
