package mk.icelabs.gwt.polymer.client.dom;

import mk.icelabs.gwt.polymer.client.ui.Style;
import mk.icelabs.gwt.polymer.client.ui.util.Size;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safecss.shared.SafeStyles;
import com.google.gwt.safecss.shared.SafeStylesUtils;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.DOM;

/**
 * Provides additional static methods that allow you to manipulate the browser's
 * Document Object Model (DOM).
 *
 * <p/>
 *
 *
 * @see DOM
 */
public class PDOM {

  private static final PDOMImpl instance = GWT.create(PDOMImpl.class);

  /**
   * An empty safe styles instance.
   */
  public static final SafeStyles EMPTY_SAFE_STYLE = SafeStylesUtils.fromTrustedString("");

  /**
   * Creates a new element from the given markup.
   * 
   * @param html the markup
   * @return the new element
   */
  public static ElementBase create(SafeHtml html) {
    return create(html.asString());
  }

  /**
   * Creates an element form the given markup.
   * 
   * @param html the markup
   * @return the new element
   */
  public static ElementBase create(String html) {
    Element div = Document.get().createDivElement();
    div.setInnerHTML(html);
    Element firstChild = div.getFirstChildElement();
    // support text node creation
    if (firstChild != null) {
      firstChild.removeFromParent();
    }
    return ((firstChild != null) ? firstChild : div).cast();
  }

  /**
   * Creates an element of the given name space and tag.
   * 
   * @param ns the name space of the element
   * @param tag the tag of the element
   * @return name space element
   */
  public static native Element createElementNS(String ns, String tag) /*-{
		return $doc.createElementNS(ns, tag);
  }-*/;

  /**
   * Creates a text node from the given text.
   * 
   * @param text the text to insert inside the node
   * @return text node
   */
  public static native Element createTextNode(String text) /*-{
		return $doc.createTextNode(text);
  }-*/;

  /**
   * Returns the last focused element. This will be null or the body element if no element currently has focus,
   * depending on the browser. See https://developer.mozilla.org/en-US/docs/Web/API/document.activeElement for more
   * details.
   *
   * @return the last focused element
   */
  public static native Element getActiveElement() /*-{
    return $doc.activeElement;
  }-*/;
  /**
   * Returns the auto id prefix.
   * 
   * @return the auto id prefix
   */
  public static String getAutoIdPrefix() {
    return instance.getAutoIdPrefix();
  }

  /**
   * Returns the body elements horizontal scroll.
   * 
   * @return the scroll amount in pixels
   */
  public static native int getBodyScrollLeft() /*-{
		return $doc.documentElement.scrollLeft || $doc.body.scrollLeft || 0;
  }-*/;

  /**
   * Return the body elements vertical scroll.
   * 
   * @return the scroll amount in pixels
   */
  public static native int getBodyScrollTop() /*-{
		return $doc.documentElement.scrollTop || $doc.body.scrollTop || 0;
  }-*/;

  /**
   * Returns the document's height.
   * 
   * @return the document height
   */
  public static native int getDocumentHeight()/*-{
		var scrollHeight = ($doc.compatMode != "CSS1Compat") ? $doc.body.scrollHeight
				: $doc.documentElement.scrollHeight;
		return Math.max(scrollHeight,
				@mk.icelabs.gwt.polymer.client.dom.PDOM::getViewportHeight()());
  }-*/;

  /**
   * Returns the document width.
   * 
   * @return the document width
   */
  public static native int getDocumentWidth()/*-{
		var scrollWidth = ($doc.compatMode != "CSS1Compat") ? $doc.body.scrollWidth
				: $doc.documentElement.scrollWidth;
		return Math.max(scrollWidth,
				@mk.icelabs.gwt.polymer.client.dom.PDOM::getViewportWidth()());
  }-*/;

  /**
   * Returns the HTML head element.
   * 
   * @return the head
   */
  public static native Element getHead() /*-{
		return $doc.getElementsByTagName('head')[0];
  }-*/;

  /**
   * Returns the width of the scroll bar.
   * 
   * @return the scroll bar width
   */
  public static int getScrollBarWidth() {
    return instance.getScrollBarWidth();
  }

  /**
   * Increments and returns the top z-index value. Use this value to ensure the
   * z-index is the highest value of all elements in the DOM.
   * 
   * @return the z-index
   */
  public static int getTopZIndex() {
    return instance.getTopZIndex();
  }

  /**
   * Increments and returns the top z-index value. Use this value to ensure the
   * z-index is the highest value of all elements in the DOM.
   * 
   * @param i the increment amount
   * @return the z-index
   */
  public static int getTopZIndex(int i) {
    return instance.getTopZIndex(i);
  }

  /**
   * Returns an unique id.
   * 
   * @return the id
   */
  public static String getUniqueId() {
    return instance.getUniqueId();
  }

  /**
   * Returns the view height.
   * 
   * @param full true to return the document height, false for viewport height
   * @return the view height
   */
  public static int getViewHeight(boolean full) {
    return full ? getDocumentHeight() : getViewportHeight();
  }

  /**
   * Returns the viewport height.
   * 
   * @return the viewport height
   */
  public static native int getViewportHeight()/*-{
		if (@mk.icelabs.gwt.polymer.client.ui.PGWT::isIE()()) {
			return $doc.documentElement.clientHeight;
		} else {
			return $wnd.self.innerHeight;
		}
  }-*/;

  /**
   * Returns the viewports size.
   * 
   * @return the viewport size
   */
  public static Size getViewportSize() {
    return new Size(getViewportWidth(), getViewportHeight());
  }

  /**
   * Returns the viewport width.
   * 
   * @return the viewport width
   */
  public static native int getViewportWidth() /*-{
		if (@mk.icelabs.gwt.polymer.client.ui.PGWT::isIE()()) {
			return $doc.documentElement.clientWidth;
		} else {
			return $wnd.self.innerWidth;
		}
  }-*/;

  /**
   * Returns the view width.
   * 
   * @param full true to return the document width, false for viewport width
   * @return the view width
   */
  public static int getViewWidth(boolean full) {
    return full ? getDocumentWidth() : getViewportWidth();
  }

  /**
   * Sets the auto id prefix which is prepended to the auto id counter when
   * generating auto ids (defaults to 'x-auto').
   * 
   * @param autoIdPrefix the auto id prefix
   */
  public static void setAutoIdPrefix(String autoIdPrefix) {
    instance.setAutoIdPrefix(autoIdPrefix);
  }


  /**
   * Actual implementation of any PDOM methods.
   */
  public static class PDOMImpl {
    private int zIndexId = 1000;
    private int scrollBarWidth = Style.DEFAULT;
    private int autoId = 0;
    private String autoIdPrefix = "x-auto";

    public String getAutoIdPrefix() {
      return autoIdPrefix;
    }

    public int getScrollBarWidth() {
      if (scrollBarWidth == Style.DEFAULT) {
        int width = getScrollBarWidthInternal();
        // testing shows the method is 1px off
        // 5 is a number picked out of the sky, so that 0 is passed on. 
        if (width > 5) {
          scrollBarWidth = width + 1;
        }

        // mac osx lion+ scroll may not give a measurement
        if (scrollBarWidth < 0) {
          scrollBarWidth = 0;
        }
      }
      return scrollBarWidth;
    }
    public int getTopZIndex() {
      return ++zIndexId;
    }
    public int getTopZIndex(int i) {
      zIndexId += i + 1;
      return zIndexId;
    }

    public String getUniqueId() {
      return autoIdPrefix + "-" + autoId++;
    }

    public void setAutoIdPrefix(String autoIdPrefix) {
      this.autoIdPrefix = autoIdPrefix;
    }

    protected native int getScrollBarWidthInternal() /*-{
      var scr = null;
      var inn = null;
      var wNoScroll = 0;
      var wScroll = 0;
      scr = $doc.createElement('div');
      scr.style.position = 'absolute';
      scr.style.top = '-1000px';
      scr.style.left = '-1000px';
      scr.style.width = '100px';
      scr.style.height = '50px';
      scr.style.overflow = 'hidden';
      inn = $doc.createElement('div');
      inn.style.height = '200px';
      scr.appendChild(inn);
      $doc.body.appendChild(scr);
      wNoScroll = inn.offsetWidth;
      scr.style.overflow = 'auto';
      if (inn.clientWidth != 'undefined') {
          wScroll = inn.clientWidth;
      } else {
          wScroll = inn.offsetWidth;
      }

      $doc.body.removeChild($doc.body.lastChild);

      return (wNoScroll - wScroll);
    }-*/;
  }
}

