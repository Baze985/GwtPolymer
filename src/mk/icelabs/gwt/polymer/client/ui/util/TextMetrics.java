package mk.icelabs.gwt.polymer.client.ui.util;


import java.util.ArrayList;
import java.util.List;

import mk.icelabs.gwt.polymer.client.dom.ElementBase;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Visibility;

/**
 * Provides precise pixel measurements for blocks of text so that you can determine exactly how high and wide, in
 * pixels, a given block of text will be.
 */
public class TextMetrics {

  private static final TextMetrics instance = GWT.create(TextMetrics.class);

  /**
   * Returns the singleton instance.
   * 
   * @return the text metrics instance
   */
  public static TextMetrics get() {
    return instance;
  }

  private ElementBase el;
  private List<String> styleNames;

  private TextMetrics() {
    el = ElementBase.createElement("div");
    Document.get().getBody().appendChild(el);
    el.makePositionable(Position.ABSOLUTE);
    el.setLeftTop(-10000, -10000);
    el.getStyle().setVisibility(Visibility.HIDDEN);

    styleNames = new ArrayList<String>();
    styleNames.add("fontSize");
    styleNames.add("fontWeight");
    styleNames.add("fontStyle");
    styleNames.add("fontFamily");
    styleNames.add("lineHeight");
    styleNames.add("textTransform");
    styleNames.add("letterSpacing");
  }

  /**
   * Binds this TextMetrics instance to an element from which to copy existing CSS styles that can affect the size of
   * the rendered text.
   * 
   * @param el the element
   */
  public void bind(Element el) {
    bind(ElementBase.as(el));
  }

  /**
   * Binds the TextMetrics instance using the styles from the given class name.
   * 
   * @param className the class name
   */
  public void bind(String className) {
    clearStyles();

    this.el.setClassName(className);
  }

  /**
   * Binds this TextMetrics instance to an element from which to copy existing CSS styles that can affect the size of
   * the rendered text.
   * 
   * @param el the element
   */
  public void bind(ElementBase el) {
    clearStyles();

//    Map<String, String> map = el.getComputedStyle(styleNames);
//    for (String key : map.keySet()) {
//      String value = map.get(key);
//      if (value == null) {
//        value = "";
//      }
//      this.el.getStyle().setProperty(key, value);
//    }
  }

  /**
   * Returns the measured height of the specified text. For multiline text, be sure to call {@link #setFixedWidth} if
   * necessary.
   * 
   * @param text the text to be measured
   * @return the height in pixels
   */
  public int getHeight(String text) {
    return getSize(text).getHeight();
  }

  /**
   * Returns the size of the specified text based on the internal element's style and width properties.
   * 
   * @param text the text to measure
   * @return the size
   */
  public Size getSize(String text) {
    el.setInnerHTML(text);
    Size size = el.getSize();
    el.setInnerHTML("");
    return size;
  }

  /**
   * Returns the measured width of the specified text.
   * 
   * @param text the text to measure
   * @return the width in pixels
   */
  public int getWidth(String text) {
    el.getStyle().setProperty("width", "auto");
    return getSize(text).getWidth();
  }

  /**
   * Sets a fixed width on the internal measurement element. If the text will be multiline, you have to set a fixed
   * width in order to accurately measure the text height.
   * 
   * @param width the width to set on the element
   */
  public void setFixedWidth(int width) {
    el.setWidth(width);
  }

  private void clearStyles() {
    el.setClassName("");

//    Map<String, String> map = el.getComputedStyle(styleNames);
//    for (String key : map.keySet()) {
//      el.getStyle().setProperty(key, "");
//    }

    // needed sometimes to force a refresh
    el.repaint();

  }

}
