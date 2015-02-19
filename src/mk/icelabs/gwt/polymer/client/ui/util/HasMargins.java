package mk.icelabs.gwt.polymer.client.ui.util;


/**
 * A class that implements this interface has a margin specification. This
 * interface provides access to the margin specification without compromising
 * the ability to provide a mock container instance in JRE unit tests.
 */
public interface HasMargins {
  /**
   * Returns the margin specification.
   * 
   * @return the margin specification
   */
  Margins getMargins();

  /**
   * Sets the margin specification.
   * 
   * @param margins the margin specification
   */
  void setMargins(Margins margins);
}
