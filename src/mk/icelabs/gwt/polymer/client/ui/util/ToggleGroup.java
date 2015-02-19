package mk.icelabs.gwt.polymer.client.ui.util;


import java.util.AbstractSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasValue;

/**
 * Group HasValue<Boolean> implementers like checkboxes and radios so they can be controlled as a group.
 * <p/>
 * Note: to reset all the items in a group to false use {@link #reset()}.
 */
public class ToggleGroup extends AbstractSet<HasValue<Boolean>> implements HasValue<HasValue<Boolean>> {

  protected ValueChangeHandler<Boolean> handler = new ValueChangeHandler<Boolean>() {
    @SuppressWarnings("unchecked")
    @Override
    public void onValueChange(ValueChangeEvent<Boolean> event) {
      if (event.getValue() && getValue() != event.getSource()) {
        setValue((HasValue<Boolean>) event.getSource(), true);
      }
    }
  };
  
  protected Map<HasValue<Boolean>, HandlerRegistration> toggles = new HashMap<HasValue<Boolean>, HandlerRegistration>();
  protected HasValue<Boolean> value;

  private HandlerManager handlerManager;

  @Override
  public boolean add(HasValue<Boolean> toggle) {
    if (toggles.containsKey(toggle)) {
      return false;
    } else {
      return toggles.put(toggle, toggle.addValueChangeHandler(handler)) == null;
    }
  }

  @Override
  public HandlerRegistration addValueChangeHandler(ValueChangeHandler<HasValue<Boolean>> handler) {
    return ensureHandlers().addHandler(ValueChangeEvent.getType(), handler);
  }

  /**
   * Remove all of the items added to this toggle group. This calls {@link java.util.AbstractSet#clear()}.
   * <p>
   * To Reset all of the toggle group HasValue<Boolean> items to false use {@link #reset()}.
   */
  @Override
  public void clear() {
    super.clear();
  }

  @Override
  public void fireEvent(GwtEvent<?> event) {
    if (handlerManager != null) {
      handlerManager.fireEvent(event);
    }
  }

  @Override
  public HasValue<Boolean> getValue() {
    return value;
  }

  @Override
  public Iterator<HasValue<Boolean>> iterator() {
    return toggles.keySet().iterator();
  }

  @Override
  public boolean remove(Object toggle) {
    HandlerRegistration reg = toggles.remove(toggle);
    if (reg != null) {
      reg.removeHandler();
      return true;
    }
    return false;

  }

  /**
   * Reset all of the toggle group HasValue<Boolean> items to false.
   * <p>
   * To remove all of the items use {@link #clear()}.
   */
  public void reset() {
    this.value = null;

    Iterator<HasValue<Boolean>> it = iterator();
    while (it.hasNext()) {
      HasValue<Boolean> item = it.next();
      item.setValue(false, false);
    }
  }

  @Override
  public void setValue(HasValue<Boolean> value) {
    setValue(value, false);
  }

  @Override
  public void setValue(HasValue<Boolean> value, boolean fireEvents) {
    if (!contains(value)) {
      value = null;
    }
    HasValue<Boolean> oldValue = getValue();
    this.value = value;
    if (value != null && !value.getValue()) {
      value.setValue(true, fireEvents);
    }

    for (HasValue<Boolean> toggle : ToggleGroup.this) {
      if (toggle != value) {
        toggle.setValue(false, fireEvents);
      }
    }
    if (fireEvents) {
      ValueChangeEvent.fireIfNotEqual(this, oldValue, value);
    }
  }

  @Override
  public int size() {
    return toggles.size();
  }

  protected HandlerManager ensureHandlers() {
    return handlerManager == null ? handlerManager = new HandlerManager(this) : handlerManager;
  }

}
