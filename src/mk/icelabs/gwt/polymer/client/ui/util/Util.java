package mk.icelabs.gwt.polymer.client.ui.util;


import java.util.ArrayList;
import java.util.List;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.AbstractImagePrototype;

/**
 * Various utility functions.
 */
public class Util {

  /**
   * Constrains the value by a minimum and max value.
   * 
   * @param value the value
   * @param min the minimum
   * @param max the maximum
   * @return the adjusted value
   */
  public static int constrain(int value, int min, int max) {
    value = Math.max(value, min);
    value = Math.min(value, max);
    return value;
  }
  
  /**
   * Creates a new list and adds the element(s).
   * 
   * @param element the item to add to the list
   * @return the new list
   */
  public static <T> List<T> createList(T... element) {
    List<T> list = new ArrayList<T>();
    fill(list, element);
    return list;
  }

  /**
   * Does an equals check by first checking identity, then equality.
   * 
   * @param obj1 object 1
   * @param obj2 object 2
   * @return boolean if equal
   */
  public static boolean equalWithNull(Object obj1, Object obj2) {
    if (obj1 == obj2) {
      return true;
    } else if (obj1 == null) {
      return false;
    } else {
      return obj1.equals(obj2);
    }
  }

  /**
   * Populates a list with an array of elements.
   * 
   * @param list the list
   * @param elements the elements to be added to the list
   */
  public static <T> void fill(List<T> list, T[] elements) {
    for (int i = 0; i < elements.length; i++) {
      list.add(elements[i]);
    }
  }

  /**
   * Returns an element for the given image.
   * 
   * @param ir the image resource
   * @return the element
   */
  public static Element getImage(ImageResource ir) {
    return AbstractImagePrototype.create(ir).createElement();
  }

  /**
   * Returns true if the string is null or equals to the empty string.
   * 
   * @param string the string to test
   * @return true if the string is empty
   */
  public static boolean isEmptyString(String string) {
    return string == null || "".equals(string);
  }

  /**
   * Tests if the value is an integer.
   * 
   * @param value the value to test
   * @return the integer state
   */
  public static boolean isInteger(String value) {
    try {
      Integer.parseInt(value);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  /**
   * Parses a string value and returns an integer.
   * 
   * @param value the string value
   * @param defaultValue the default value
   * @return the integer value
   */
  public static native int parseInt(String value, int defaultValue) /*-{
		var v = parseInt(value, 10);
		if (v === 0) {
			return 0;
		}
		return v || defaultValue;
  }-*/;

  /**
   * Parses a string value and returns the applicable {@link Overflow} object.
   * 
   * @param value the string value
   * @return the {@link Overflow} object
   */
  public static Overflow parseOverflow(String value) {
    if (value.equals(Overflow.AUTO.getCssName())) {
      return Overflow.AUTO;
    } else if (value.equals(Overflow.HIDDEN.getCssName())) {
      return Overflow.HIDDEN;
    } else if (value.equals(Overflow.SCROLL.getCssName())) {
      return Overflow.SCROLL;
    } else if (value.equals(Overflow.VISIBLE.getCssName())) {
      return Overflow.VISIBLE;
    } else {
      return null;
    }
  }

  /**
   * Converts a node list to an element array.
   * 
   * @param nodes the nodes
   * @return the element array
   */
  public static Element[] toElementArray(List<Element> nodes) {
    Element[] e = new Element[nodes.size()];
    for (int i = 0; i < nodes.size(); i++) {
      e[i] = nodes.get(i);
    }
    return e;
  }

  /**
   * Converts a node list to an element array.
   * 
   * @param nodes the nodes
   * @return the element array
   */
  public static Element[] toElementArray(NodeList<Element> nodes) {
    Element[] e = new Element[nodes.getLength()];
    for (int i = 0; i < nodes.getLength(); i++) {
      e[i] = nodes.getItem(i);
    }
    return e;
  }

}
