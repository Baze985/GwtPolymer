package mk.icelabs.gwt.polymer.client.ui.util;


import com.google.gwt.dom.client.Element;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.impl.ImageResourcePrototype;
import com.google.gwt.safehtml.shared.SafeUri;
import com.google.gwt.user.client.ui.AbstractImagePrototype;

final public class IconHelper {

  private IconHelper() {
  }

  public static Element getElement(ImageResource resource) {
    return AbstractImagePrototype.create(resource).createElement().cast();
  }

  public static String getHTML(ImageResource resource) {
    return AbstractImagePrototype.create(resource).getHTML();
  }

  public static ImageResource getImageResource(SafeUri url, int width, int height) {
    return new ImageResourcePrototype(null, url, 0, 0, width, height, false, false);
  }

}
