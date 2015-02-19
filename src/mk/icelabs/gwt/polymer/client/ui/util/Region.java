package mk.icelabs.gwt.polymer.client.ui.util;


/**
 * Represents a region in the coordinate system.
 */
public class Region {

  private int left;
  private int top;
  private int right;
  private int bottom;

  public Region() {

  }

  public Region(int spacing) {
    this(spacing, spacing, spacing, spacing);
  }

  public Region(int top, int right, int bottom, int left) {
    this.left = left;
    this.top = top;
    this.right = right;
    this.bottom = bottom;
  }

  /**
   * Returns the bottom value.
   * 
   * @return the bottom value
   */
  public int getBottom() {
    return bottom;
  }

  /**
   * Returns the left value.
   * 
   * @return the left value
   */
  public int getLeft() {
    return left;
  }

  /**
   * Returns the right value.
   * 
   * @return the right value
   */
  public int getRight() {
    return right;
  }

  /**
   * Returns the top value.
   * 
   * @return the top value
   */
  public int getTop() {
    return top;
  }

  /**
   * Sets the bottom value.
   * 
   * @param bottom the bottom value
   */
  public void setBottom(int bottom) {
    this.bottom = bottom;
  }

  /**
   * Sets the left value.
   * 
   * @param left the left value
   */
  public void setLeft(int left) {
    this.left = left;
  }

  /**
   * Sets the right value.
   * 
   * @param right the right value
   */
  public void setRight(int right) {
    this.right = right;
  }

  /**
   * Sets the top value.
   * 
   * @param top the top value
   */
  public void setTop(int top) {
    this.top = top;
  }

  @Override
  public String toString() {
    return left + ":" + top + ":" + right + ":" + bottom;
  }

}
