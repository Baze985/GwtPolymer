package mk.icelabs.gwt.polymer.client.ui.util;

import com.google.gwt.core.client.GWT;

public final class ImageHelper {

  public static String createModuleBasedUrl(String path) {
    return "url('" + GWT.getModuleBaseURL() + path + "');";
   }
}
