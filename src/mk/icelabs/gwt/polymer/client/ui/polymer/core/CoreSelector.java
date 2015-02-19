package mk.icelabs.gwt.polymer.client.ui.polymer.core;

import java.util.Collection;

import mk.icelabs.gwt.polymer.client.dom.polymer.core.CoreSelectorElement;
import mk.icelabs.gwt.polymer.client.event.polymer.EventCoreBase;
import mk.icelabs.gwt.polymer.client.event.polymer.EventHandlerCore;
import mk.icelabs.gwt.polymer.client.ui.widgets.ContainerExt;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasConstrainedValue;
import com.google.gwt.user.client.ui.Widget;

@SuppressWarnings("unchecked")
public class CoreSelector<T extends Widget> extends ContainerExt<T> implements
HasConstrainedValue<T> {

	public static class CoreSelectorEvent extends EventCoreBase<CoreSelectorEvent> {

		/**
		 * Event type for click events. Represents the meta-data associated with
		 * this event.
		 */
		private static final Type<EventHandlerCore<CoreSelectorEvent>> TYPE = new Type<EventHandlerCore<CoreSelectorEvent>>(
				"core-select", new CoreSelectorEvent());

		public static Type<EventHandlerCore<CoreSelectorEvent>> getType() {
			return TYPE;
		}

		@Override
		public com.google.gwt.event.dom.client.DomEvent.Type<EventHandlerCore<CoreSelectorEvent>> getAssociatedType() {
			return getType();
		}
	}
	
	private T value;

	private boolean valueChangeHandlerInitialized;

	private boolean isValueAttrUsedAsSelection;

	public CoreSelector() {
		this( Document.get().createElement(CoreSelectorElement.TAG));
	}

	public CoreSelector(Element elem) {
		setElement(elem);
		
	}

	public T getSelected() {
		return getValue();
	}

	public void setSelected(T selected) {
		setValue(selected, true);
	}

	public boolean isMulti() {
		return getElement().isMulti();
	}

	public void setMulti(boolean status) {
		getElement().setMulti(status);
	}

	public String getValueAttribute() {
		return getElement().getValueAttribute();
	}

	public void setValueAttribute(String attr) {
		isValueAttrUsedAsSelection = attr != null && !"".equals(attr) ? true : false;
		getElement().setValueAttribute(attr);
	}

	public String getSelectedClass() {
		return getElement().getSelectedClass();
	}

	public void setSelectedClass(String cls) {
		getElement().setSelectedClass(cls);
	}

	public String getSelectedProperty() {
		return getElement().getSelectedProperty();
	}

	public void setSelectedProperty(String prop) {
		getElement().setSelectedProperty(prop);
	}

	public String getSelectedAttribute() {
		return getElement().getSelectedAttribute();
	}

	public void setSelectedAttribute(String attr) {
		getElement().setSelectedAttribute(attr);
	}

	public int getSelectedIndex() {
		return getWidgetIndex(getValue());
	}

	public void setSelectedIndex(int index) {
		T selected = (T) getWidget(index);
		setSelected(selected);
	}

	public Element getTarget() {
		return getElement().getTarget();
	}

	public void setTarget(Element target) {
		getElement().setTarget(target);
	}

	public String getItemSelector() {
		return getElement().getItemSelector();
	}

	public void setItemSelector(String selector) {
		getElement().setItemSelector(selector);
	}

	public String getActivateEvent() {
		return getElement().getActivateEvent();
	}

	public void setActivateEvent(String evt) {
		getElement().setActivateEvent(evt);
	}

	public boolean isNotap() {
		return getElement().isNotap();
	}

	public void setNotap(boolean status) {
		getElement().setNotap(status);
	}

	@Override
	public T getValue() {
		return value;
	}

	@Override
	public void setValue(T value) {
		setValue(value, false);
	}

	@Override
	public void setValue(T value, boolean fireEvents) {
		if (value == this.value
				|| (this.value != null && this.value.equals(value))) {
			return;
		}

		T before = this.value;
		this.value = value;
		
		updateSelection();

		if (fireEvents) {
			ValueChangeEvent.fireIfNotEqual(this, before, value);
		}
	}

	@Override
	public HandlerRegistration addValueChangeHandler(
			ValueChangeHandler<T> handler) {
		if (!valueChangeHandlerInitialized) {
			ensureDomSelectorHandlers();
			valueChangeHandlerInitialized = true;
		}
		return addHandler(handler, ValueChangeEvent.getType());
	}

	@Override
	public void setAcceptableValues(Collection<T> newValues) {
		clear();

		for (T nextNewValue : newValues) {
			add(nextNewValue);
		}

		updateSelection();
	}

	public CoreSelectorElement getElement() {
		return super.getElement().cast();
	}


	protected void updateSelection() {
		if (getValue() == null)
			return;
	
		if(isValueAttrUsedAsSelection){
			getElement().setSelected(getValue().getElement().getAttribute(getElement().getValueAttribute()));
			return;
		}
		
		getElement().setSelected(getChildren().indexOf(getValue()) + "");
	}
	
	protected void onSelectorChanged() {	
		String sel = getElement().getSelected();	
		T before = value;
		try {
			Integer index = Integer.valueOf(sel);
			value = (T) getChildren().get(index);
			
		} catch (Exception e) {
			String attr = getElement().getValueAttribute();
			if (isValueAttrUsedAsSelection && attr != null){
				// valueAttr is set, find element by this value
				for (int i=0; i < getChildren().size(); i++){
					Element el = getChildren().get(i).getElement();
					if (sel.equals(el.getAttribute(attr)))
						value = (T) getChildren().get(i);
				}
			}
		}
		
		ValueChangeEvent.fireIfNotEqual(this, before, value);
		
		
	}

	  
	protected void ensureDomSelectorHandlers() {
		addDomHandler(new EventHandlerCore<CoreSelectorEvent>() {
			@Override
			public void onEvent(CoreSelectorEvent event) {
				GWT.log("OnSelector: " + getElement().getSelected());
				onSelectorChanged();
				
			}

		}, CoreSelectorEvent.getType());
	}
	
}
