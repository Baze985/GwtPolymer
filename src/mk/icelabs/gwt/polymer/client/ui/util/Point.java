package mk.icelabs.gwt.polymer.client.ui.util;



/**
 * Instances of this class represent places on the (x, y) coordinate plane.
 * 
 * @see Rectangle
 */
public class Point {

  private int x;
  private int y;

  /**
   * Constructs a new point with the given x and y coordinates.
   * 
   * @param x the x coordinate of the new point
   * @param y the y coordinate of the new point
   */
  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + x;
    result = prime * result + y;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (!(this instanceof Point)) return false;
    Point other = (Point) obj;
    if (x != other.x) return false;
    if (y != other.y) return false;
    return true;
  }

  /**
   * Returns the x coordinate of the point.
   * 
   * @return the x coordinate
   */
  public int getX() {
    return x;
  }

  /**
   * Returns the y coordinate of the point.
   * 
   * @return the y coordinate
   */
  public int getY() {
    return y;
  }

  /**
   * Sets the x-coordinate.
   * 
   * @param x the x-coordinate
   */
  public void setX(int x) {
    this.x = x;
  }

  /**
   * Sets the y-coordinate
   * 
   * @param y the y-coordinate
   */
  public void setY(int y) {
    this.y = y;
  }

  public String toString() {
    return ("x: " + x + ", y: " + y);
  }

}
