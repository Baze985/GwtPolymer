package mk.icelabs.gwt.polymer.client.ui.util;


/**
 * Represents 4-side padding.
 */
public class Padding extends Region {
  /**
   * Creates a new padding instance with 0 values for all sides.
   */
  public Padding() {
    super();
  }

  /**
   * Creates a new padding instance.
   * 
   * @param padding the padding value for all 4 sides.
   */
  public Padding(int padding) {
    super(padding);
  }

  /**
   * Creates a new padding instance.
   * 
   * @param top the top padding
   * @param right the right padding
   * @param bottom the bottom padding
   * @param left the left padding
   */
  public Padding(int top, int right, int bottom, int left) {
    super(top, right, bottom, left);
  }
}
