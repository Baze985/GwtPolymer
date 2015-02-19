package mk.icelabs.gwt.polymer.client.core;


import java.util.SortedSet;

import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.linker.ConfigurationProperty;
import com.google.gwt.core.ext.linker.PropertyProviderGenerator;
import com.google.gwt.user.rebind.SourceWriter;
import com.google.gwt.user.rebind.StringSourceWriter;

public class UserAgentPropertyGenerator implements PropertyProviderGenerator {
  @Override
  public String generate(TreeLogger logger, SortedSet<String> possibleValues, String fallback,
      SortedSet<ConfigurationProperty> configProperties) throws UnableToCompleteException {

    SourceWriter sw = new StringSourceWriter();
    sw.println("{");

    sw.println("var ua = navigator.userAgent.toLowerCase();");
    uaContains(sw, "chrome", "chrome");
    uaContains(sw, "opera", "opera");

    sw.println("if (ua.indexOf('msie') != -1) {");
    sw.indent();

    // TODO ChromeFrame?
    docModeGreaterThan(sw, 10, "ie10");
    docModeGreaterThan(sw, 9, "ie9");
    docModeGreaterThan(sw, 8, "ie8");
    
    uaContains(sw, "msie 7", "ie7");
    uaContains(sw, "msie 6", "ie6");
    
    // last assume newest
    sw.println("return 'ie10';");
    sw.outdent();
    sw.println("}");

    sw.println("if (ua.indexOf('safari') != -1) {");
    sw.indent();
    uaContains(sw, "version/3", "safari3");
    uaContains(sw, "version/4", "safari4");
    // else assume newest
    // simpleStatement(sw, "version/5", "safari5");
    sw.println("return 'safari5';");
    sw.outdent();
    sw.println("}");

    sw.println("if (ua.indexOf('gecko') != -1) {");
    sw.indent();
    uaContains(sw, "rv:1.8", "gecko1_8");
    // Don't check for rev 1.9, check instead for the newest version, and treat
    // all
    // gecko browsers that don't match a rule as the newest version
    // simpleStatement(sw, "rv:1.9", "gecko1_9");
    sw.println("return 'gecko1_9';");
    sw.outdent();
    sw.println("}");


    uaContains(sw, "adobeair", "air");

    sw.println("return null;}");
    return sw.toString();
  }

  private void docModeGreaterThan(SourceWriter sw, int i, String value) {
    sw.println("if ($doc.documentMode >= %1$d) return '%2$s'", i, value);
  }

  private void uaContains(SourceWriter sw, String ua, String value) {
    sw.println("if (ua.indexOf('%1$s') != -1) return '%2$s';", ua, value);
  }
}
