package mk.icelabs.gwt.polymer.client.ui.util;


/**
 * Represents an area in a coordinate system.
 * 
 * @see Point
 */
public class Rectangle {

  private int x;

  private int y;

  private int width;

  private int height;

  /**
   * Create a new rectangle instance.
   */
  public Rectangle() {

  }

  /**
   * Creates a new rectangle instance.
   * 
   * @param x the x value
   * @param y the y value
   * @param width the rectangle's width
   * @param height the rectangle's height
   */
  public Rectangle(int x, int y, int width, int height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  /**
   * Returns true if the point is within the rectangle's region.
   * 
   * @param x the x coordinate value
   * @param y the y coordinate value
   * @return true if xy is contained within the rectangle
   */
  public boolean contains(int x, int y) {
    return (x >= this.x) && (y >= this.y) && ((x - this.x) < width) && ((y - this.y) < height);
  }

  /**
   * Returns true if the point is within the rectangle.
   * 
   * @param p the point
   * @return true if the point is contained within the rectangle
   */
  public boolean contains(Point p) {
    return contains(p.getX(), p.getY());
  }

  public int getHeight() {
    return height;
  }

  public int getWidth() {
    return width;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public String toString() {
    return "left: " + x + " top: " + y + " width: " + width + " height: " + height;
  }

}
