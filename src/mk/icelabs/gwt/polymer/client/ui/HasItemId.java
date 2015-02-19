package mk.icelabs.gwt.polymer.client.ui;


/**
 * Implemented by objects that have an item id. An item id is managed by the
 * component, does not need to be unique and should not to be confused with the
 * id attribute of the underlying element.
 */
public interface HasItemId {
  /**
   * Sets the widget's item id. Unlike a widget's id, the widget's item id is
   * not tied to id attribute of the widget's root element. As such, the item id
   * does not have to be unique.
   * 
   * @param itemId the item id
   */
  void setItemId(String itemId);

  /**
   * Returns the item id. Unlike the widget's id, the item id does not have to
   * be unique.
   * 
   * @return the item id
   */
  String getItemId();
}