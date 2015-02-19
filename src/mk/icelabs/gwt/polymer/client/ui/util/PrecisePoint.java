package mk.icelabs.gwt.polymer.client.ui.util;


/**
 * Represents a double precision point on the (x, y) coordinate plane.
 */
public class PrecisePoint {

  private double x = 0;
  private double y = 0;

  /**
   * Creates a double precision point.
   */
  public PrecisePoint() {
  }

  /**
   * Creates a double precision point with the given x and y coordinates.
   * 
   * @param x the x coordinate of the point
   * @param y the y coordinate of the point
   */
  public PrecisePoint(double x, double y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Creates a copy of the given {@link PrecisePoint}.
   * 
   * @param point the point to be copied
   */
  public PrecisePoint(PrecisePoint point) {
    this.x = point.getX();
    this.y = point.getY();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (int) Math.round(prime * result + x);
    result = (int) Math.round(prime * result + y);
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (!(this instanceof PrecisePoint)) return false;
    PrecisePoint other = (PrecisePoint) obj;
    if (Double.compare(this.getX(), other.getX()) != 0) return false;
    if (Double.compare(this.getY(), other.getY()) != 0) return false;
    return true;
  }

  /**
   * Indicates whether or not the given object is equal to the rounded values of
   * this {@link PrecisePoint}.
   * 
   * @param obj the reference object with which to compare
   * @param tolerance the tolerance of the difference between the points
   * @return true if this object is the same as the obj argument; false
   *         otherwise
   */
  public boolean equalsNoPrecision(Object obj, double tolerance) {
    if (obj instanceof PrecisePoint) {
      PrecisePoint point = (PrecisePoint) obj;
      long diffX = Math.round(this.getX() - point.getX());
      long diffY = Math.round(this.getY() - point.getY());
      return (diffX >= -tolerance && diffX <= tolerance 
      && diffY >= -tolerance && diffY <= tolerance);
    }
    return super.equals(obj);

  }

  /**
   * Returns the x coordinate of the point.
   * 
   * @return the x coordinate
   */
  public double getX() {
    return x;
  }

  /**
   * Returns the y coordinate of the point.
   * 
   * @return the y coordinate
   */
  public double getY() {
    return y;
  }

  /**
   * Sets the x-coordinate.
   * 
   * @param x the x-coordinate
   */
  public void setX(double x) {
    this.x = x;
  }

  /**
   * Sets the y-coordinate
   * 
   * @param y the y-coordinate
   */
  public void setY(double y) {
    this.y = y;
  }

  @Override
  public String toString() {
    return "(" + x + ", " + y + ")";
  }

}
