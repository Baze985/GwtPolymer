package mk.icelabs.gwt.polymer.client.ui.util;



/**
 * Instances of this class represent a rectangle's size.
 */
public class Size {

  private int width;
  private int height;

  /**
   * Creates a new size instance.
   * 
   * @param width the width
   * @param height the height
   */
  public Size(int width, int height) {
    this.width = width;
    this.height = height;
  }

  public String toString() {
    return "width: " + width + ", height: " + height;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + height;
    result = prime * result + width;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (!(this instanceof Size)) return false;
    Size other = (Size) obj;
    if (height != other.height) return false;
    if (width != other.width) return false;
    return true;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

}
