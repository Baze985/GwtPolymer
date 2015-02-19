package mk.icelabs.gwt.polymer.client.ui;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public interface BindingPropertySet {
	  @Retention(RetentionPolicy.RUNTIME)
	  @Target(ElementType.TYPE)
	  public @interface PropertyName {
	    String value();
	  }
	  @Retention(RetentionPolicy.RUNTIME)
	  @Target(ElementType.METHOD)
	  public @interface PropertyValue {
	    String value();
	    /** If false, suppresses a warning from a missing value, defaults to true */
	    boolean warn() default true;
	  }
	}