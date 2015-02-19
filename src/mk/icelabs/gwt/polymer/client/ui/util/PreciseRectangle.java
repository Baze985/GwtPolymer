package mk.icelabs.gwt.polymer.client.ui.util;


/**
 * Represents a double precision area in a coordinate system.
 */
public class PreciseRectangle {

  private double x = 0;
  private double y = 0;
  private double width = 0;
  private double height = 0;

  /**
   * Creates a double precision rectangle.
   */
  public PreciseRectangle() {
  }

  /**
   * Creates a double precision rectangle.
   * 
   * @param x the x-coordinate of the rectangle
   * @param y the y-coordinate of the rectangle
   * @param width the width of the rectangle
   * @param height the height of the rectangle
   */
  public PreciseRectangle(double x, double y, double width, double height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  /**
   * Creates a double precision rectangle using the given {@link Rectangle}.
   * 
   * @param rectangle the rectangle to use as reference
   */
  public PreciseRectangle(Rectangle rectangle) {
    this.x = rectangle.getX();
    this.y = rectangle.getY();
    this.width = rectangle.getWidth();
    this.height = rectangle.getHeight();
  }

  public boolean contains(double x, double y) {
    return contains(x, y, 0);
  }

  /**
   * Returns true if the point is within the rectangle's region.
   * 
   * @param x the x coordinate value
   * @param y the y coordinate value
   * @return true if xy is contained within the rectangle
   */
  public boolean contains(double x, double y, double tolerance) {
    return (x >= this.x - tolerance) && (y >= this.y - tolerance) && (x - this.x <= width + tolerance)
        && (y - this.y <= height + tolerance);
  }

  /**
   * Returns true if the point is within the rectangle.
   * 
   * @param p the point
   * @return true if the point is contained within the rectangle
   */
  public boolean contains(PrecisePoint p) {
    return contains(p.getX(), p.getY());
  }

  public boolean contains(PrecisePoint p, double tolerance) {
    return contains(p.getX(), p.getY(), tolerance);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof PreciseRectangle)) {
      return false;
    }
    PreciseRectangle rectangle = (PreciseRectangle) obj;
    if (Double.compare(x, rectangle.x) != 0) {
      return false;
    }
    if (Double.compare(y, rectangle.y) != 0) {
      return false;
    }
    if (Double.compare(width, rectangle.width) != 0) {
      return false;
    }
    if (Double.compare(height, rectangle.height) != 0) {
      return false;
    }
    return true;
  }

  /**
   * Returns the height of the rectangle.
   * 
   * @return the height of the rectangle
   */
  public double getHeight() {
    return height;
  }

  /**
   * Returns the width of the rectangle.
   * 
   * @return the width of the rectangle
   */
  public double getWidth() {
    return width;
  }

  /**
   * Returns the x-coordinate of the rectangle.
   * 
   * @return the x-coordinate of the rectangle
   */
  public double getX() {
    return x;
  }

  /**
   * Returns the y-coordinate of the rectangle.
   * 
   * @return the y-coordinate of the rectangle
   */
  public double getY() {
    return y;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int hash = 1;
    hash = (int) (hash * prime + x);
    hash = (int) (hash * prime + y);
    hash = (int) (hash * prime + width);
    hash = (int) (hash * prime + height);
    return hash;
  }

  /**
   * Sets the height of the rectangle.
   * 
   * @param height the height of the rectangle
   */
  public void setHeight(double height) {
    this.height = height;
  }

  /**
   * Sets the width of the rectangle.
   * 
   * @param width the width of the rectangle
   */
  public void setWidth(double width) {
    this.width = width;
  }

  /**
   * Sets the x-coordinate of the rectangle.
   * 
   * @param x the x-coordinate of the rectangle
   */
  public void setX(double x) {
    this.x = x;
  }

  /**
   * Sets the y-coordinate of the rectangle.
   * 
   * @param y the y-coordinate of the rectangle
   */
  public void setY(double y) {
    this.y = y;
  }

  @Override
  public String toString() {
    return new StringBuilder().append(x).append(", ").append(y).append(", ").append(width).append(", ").append(height).toString();
  }

}
