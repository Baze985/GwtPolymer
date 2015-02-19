package mk.icelabs.gwt.polymer.client.dom;


import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NodeList;

/**
 * Provides high performance selector/xpath processing.
 * 
 * <p>
 * DomQuery supports most of the <a
 * href="http://www.w3.org/TR/2005/WD-css3-selectors-20051215/#selectors">CSS3
 * selectors spec</a>, along with some custom selectors and basic XPath.
 * </p>
 * <p>
 * All selectors, attribute filters and pseudos below can be combined infinitely
 * in any order. For example "div.foo:nth-child(odd)[@foo=bar].bar:first" would
 * be a perfectly valid selector. Node filters are processed in the order in
 * which they appear, which allows you to optimize your queries for your
 * document structure.
 * </p>
 * <p>
 * <h4>Element Selectors:</h4>
 * <ul class="list">
 * <li><b>*</b> any element</li>
 * <li><b>E</b> an element with the tag E</li>
 * <li><b>E F</b> All descendent elements of E that have the tag F</li>
 * <li><b>E > F</b> or <b>E/F</b> all direct children elements of E that have
 * the tag F</li>
 * <li><b>E + F</b> all elements with the tag F that are immediately preceded by
 * an element with the tag E</li>
 * <li><b>E ~ F</b> all elements with the tag F that are preceded by a sibling
 * element with the tag E</li>
 * </ul>
 * <h4>Attribute Selectors:</h4>
 * <p>
 * The use of '@' and quotes are optional. For example, div[@foo='bar'] is also
 * a valid attribute selector.
 * </p>
 * <ul class="list">
 * <li><b>E[foo]</b> has an attribute "foo"</li>
 * <li>
 * <b>E[foo=bar]</b> has an attribute "foo" that equals "bar"</li>
 * <li>
 * <b>E[foo^=bar]</b> has an attribute "foo" that starts with "bar"</li>
 * <li>
 * <b>E[foo$=bar]</b> has an attribute "foo" that ends with "bar"</li>
 * <li>
 * <b>E[foo*=bar]</b> has an attribute "foo" that contains the substring "bar"</li>
 * <li><b>E[foo%=2]</b> has an attribute "foo" that is evenly divisible by 2</li>
 * <li><b>E[foo!=bar]</b> has an attribute "foo" that does not equal "bar"</li>
 * </ul>
 * <h4>Pseudo Classes:</h4>
 * <ul class="list">
 * <li><b>E:first-child</b> E is the first child of its parent</li>
 * <li><b>E:last-child</b> E is the last child of its parent</li>
 * <li><b>E:nth-child(<i>n</i>)</b> E is the <i>n</i>th child of its parent (1
 * based as per the spec)</li>
 * <li>
 * <b>E:nth-child(odd)</b> E is an odd child of its parent</li>
 * <li>
 * <b>E:nth-child(even)</b> E is an even child of its parent</li>
 * <li>
 * <b>E:only-child</b> E is the only child of its parent</li>
 * <li>
 * <b>E:checked</b> E is an element that is has a checked attribute that is true
 * (e.g. a radio or checkbox)</li>
 * <li><b>E:first</b> the first E in the resultset</li>
 * <li><b>E:last</b> the last E in the resultset</li>
 * <li>
 * <b>E:nth(<i>n</i>)</b> the <i>n</i>th E in the resultset (1 based)</li>
 * <li>
 * <b>E:odd</b> shortcut for :nth-child(odd)</li>
 * <li><b>E:even</b> shortcut for :nth-child(even)</li>
 * <li><b>E:contains(foo)</b> E's innerHTML contains the substring "foo"</li>
 * <li><b>E:nodeValue(foo)</b> E contains a textNode with a nodeValue that
 * equals "foo"</li>
 * <li><b>E:not(S)</b> an E element that does not match simple selector S</li>
 * <li><b>E:has(S)</b> an E element that has a descendent that matches simple
 * selector S</li>
 * <li><b>E:next(S)</b> an E element whose next sibling matches simple selector
 * S</li>
 * <li>
 * <b>E:prev(S)</b> an E element whose previous sibling matches simple selector
 * S</li>
 * </ul>
 * <h4>CSS Value Selectors:</h4>
 * <ul class="list">
 * <li>
 * <b>E{display=none}</b> css value "display" that equals "none"</li>
 * <li>
 * <b>E{display^=none}</b> css value "display" that starts with "none"</li>
 * <li>
 * <b>E{display$=none}</b> css value "display" that ends with "none"</li>
 * <li>
 * <b>E{display*=none}</b> css value "display" that contains the substring
 * "none"</li>
 * <li><b>E{display%=2}</b> css value "display" that is evenly divisible by 2</li>
 * <li><b>E{display!=none}</b> css value "display" that does not equal "none"</li>
 * </p>
 */
public class DomQuery {

  static {
    Ext.loadExt();
    Ext.loadDomQuery();
  }

  /**
   * Filters an array of elements to only include matches of a simple selector
   * (e.g. div.some-class or span:first-child).
   * 
   * @param elems an array of elements
   * @param selector the selector/xpath query
   * @param nonMatches if true, it returns the elements that DON'T match the
   *          selector instead of the ones that match
   * @return the matching elements
   */
  public static Element[] filter(Element[] elems, String selector, boolean nonMatches) {
    JavaScriptObject jsObj = internalFilter(elems, selector, nonMatches);
    return toElementArray(jsObj);
  }

  /**
   * Returns true if the passed element(s) match the passed simple selector
   * (e.g. div.some-class or span:first-child).
   * 
   * @param elem the element
   * @param selector The selector/xpath query (can be a comma separated list of
   *          selectors)
   * @return true if matches
   */
  public static native boolean is(Element elem, String selector) /*-{
		var Ext = @mk.icelabs.gwt.polymer.client.dom.Ext::ext;
		return Ext.DomQuery.is(elem, selector);
  }-*/;

  /**
   * Selects a group of elements using the document as the root node.
   * 
   * @param selector the selector/xpath query
   * @return the matching elements
   */
  public static NodeList<Element> select(String selector) {
    return internalSelect(selector).cast();
  }

  /**
   * Selects a group of elements.
   * 
   * @param selector the selector/xpath query
   * @param root the start of the query
   * @return the matching elements
   */
  public static NodeList<Element> select(String selector, Element root) {
    return internalSelect(selector, root).cast();
  }

  /**
   * Selects a single element using the document as the root node.
   * 
   * @param selector the selector/xpath query
   * @return the matching element
   */
  public static Element selectNode(String selector) {
    return select(selector).getItem(0);
  }

  /**
   * Selects a single element using the given root node.
   * 
   * @param selector the selector / xpath query
   * @param root the start of the query
   * @return the matching element
   */
  public static Element selectNode(String selector, Element root) {
    return select(selector, root).getItem(0);
  }

  /**
   * Selects the value of a node,
   * 
   * @param selector the selector/xpath query
   * @param root the start of the query
   * @return the value
   */
  public static native String selectValue(String selector, Element root) /*-{
		var Ext = @mk.icelabs.gwt.polymer.client.dom.Ext::ext;
		return Ext.DomQuery.selectValue(selector, root);
  }-*/;

  /**
   * Selects the value of a node,
   * 
   * @param selector the selector/xpath query
   * @param root the start of the query
   * @return the value
   */
  public static native String selectValue(String selector, JavaScriptObject root) /*-{
		var Ext = @mk.icelabs.gwt.polymer.client.dom.Ext::ext;
		return Ext.DomQuery.selectValue(selector, root);
  }-*/;

  private static native Element getElement(JavaScriptObject jsArray, int index) /*-{
		return jsArray[index];
  }-*/;

  private static native int getLength(JavaScriptObject jsArray) /*-{
		return jsArray.length;
  }-*/;

  private static native JavaScriptObject internalFilter(Element[] elems, String selector, boolean nonMatches) /*-{
		var Ext = @mk.icelabs.gwt.polymer.client.dom.Ext::ext;
		var result = Ext.DomQuery.filter(elems, selector, root, nonMatches);
		return result;
  }-*/;

  private static native JavaScriptObject internalSelect(String selector) /*-{
		var Ext = @mk.icelabs.gwt.polymer.client.dom.Ext::ext;
		var result = Ext.DomQuery.select(selector);
		return result;
  }-*/;

  private static native JavaScriptObject internalSelect(String selector, Element root) /*-{
		var Ext = @mk.icelabs.gwt.polymer.client.dom.Ext::ext;
		var result = Ext.DomQuery.select(selector, root);
		return result;
  }-*/;

  private static Element[] toElementArray(JavaScriptObject jsArray) {
    Element[] elems = new Element[getLength(jsArray)];
    for (int i = 0; i < elems.length; i++) {
      elems[i] = getElement(jsArray, i);
    }
    return elems;
  }

}
