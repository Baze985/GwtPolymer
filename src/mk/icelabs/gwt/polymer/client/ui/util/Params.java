package mk.icelabs.gwt.polymer.client.ui.util;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Aggregates both a list of values and a map of named values. Allows methods to
 * support both list and maps in a single parameter.
 * <p>
 * Note that only one type of values should be specified.
 * </p>
 */
public class Params {

  private List<Object> values;
  private Map<String, Object> mapValues;

  /**
   * True if the parameters are a list of values.
   * 
   */
  private boolean isList = false;

  /**
   * True if the parameters are a map of key / value pairs.
   * 
   */
  private boolean isMap = false;

  /**
   * Creates a new params instance.
   */
  public Params() {

  }

  /**
   * Creates a new params instance.
   * 
   * @param values the initial values
   */
  public Params(Map<String, Object> values) {
    mapValues = values;
  }

  /**
   * Creates a new params instance.
   * 
   * @param values the initial values
   */
  public Params(Object... values) {
    for (int i = 0; i < values.length; i++) {
      add(values[i]);
    }
  }

  /**
   * Creates a new parameters instance.
   * 
   * @param key the key
   * @param value the value
   */
  public Params(String key, Object value) {
    mapValues = new HashMap<String, Object>();
    mapValues.put(key, value);
  }

  /**
   * Adds a value.
   * 
   * @param value the value to add
   * @return this
   */
  public Params add(Object value) {
    isList = true;
    if (values == null) values = new ArrayList<Object>();
    values.add(value);
    return this;
  }

  /**
   * Returns the list values.
   * 
   * @return the list values
   */
  public List<Object> getList() {
    return values;
  }

  /**
   * Returns the values as a map.
   * 
   * @return the map of values
   */
  public Map<String, Object> getMap() {
    return mapValues;
  }

  /**
   * Returns true if the parameters are a list.
   * 
   * @return true if a list
   */
  public boolean isList() {
    return isList;
  }

  /**
   * Returns true if the parameters are a map.
   * 
   * @return true if a map
   */
  public boolean isMap() {
    return isMap;
  }

  /**
   * Sets a value.
   * 
   * @param key the key
   * @param value the value
   * @return this
   */
  public Params set(String key, Object value) {
    isMap = true;
    if (value == null) return this;
    if (mapValues == null) {
      mapValues = new HashMap<String, Object>();
    }
    mapValues.put(key, value);
    return this;
  }

}
