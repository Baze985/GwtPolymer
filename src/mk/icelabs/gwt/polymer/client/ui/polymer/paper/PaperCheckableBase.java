package mk.icelabs.gwt.polymer.client.ui.polymer.paper;

import mk.icelabs.gwt.polymer.client.dom.polymer.paper.PaperCheckableElementBase;
import mk.icelabs.gwt.polymer.client.event.polymer.EventCoreBase;
import mk.icelabs.gwt.polymer.client.event.polymer.EventHandlerCore;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.FocusWidget;
import com.google.gwt.user.client.ui.HasValue;

public abstract class PaperCheckableBase extends FocusWidget implements HasValue<Boolean> {

	public static class StateChangeEvent extends EventCoreBase<StateChangeEvent> {

		/**
		 * Event type for click events. Represents the meta-data associated with
		 * this event.
		 */
		private static final Type<EventHandlerCore<StateChangeEvent>> TYPE = new Type<EventHandlerCore<StateChangeEvent>>("change", // we are interested just in user changes, core-change fires with programmatic also 
				new StateChangeEvent());
		
		/**
		 * Gets the event type associated with core selector events.
		 * 
		 * @return the handler type
		 */
		public static Type<EventHandlerCore<StateChangeEvent>> getType() {
			return TYPE;
		}

		@Override
		public com.google.gwt.event.dom.client.DomEvent.Type<EventHandlerCore<StateChangeEvent>> getAssociatedType() {
			return getType();
		}
	}
	
	private boolean valueChangeHandlerInitialized;

	protected PaperCheckableBase(Element elem) {
		super(elem);
	}

	public boolean isChecked() {
		return getElement().isChecked();
	}

	public void seChecked(boolean status) {
		getElement().setChecked(status);
	}

	@Override
	public HandlerRegistration addValueChangeHandler(
			ValueChangeHandler<Boolean> handler) {
		// Is this the first value change handler? If so, time to add handlers
		if (!valueChangeHandlerInitialized) {
			ensureDomStateChangeHandlers();
			valueChangeHandlerInitialized = true;
		}
		return addHandler(handler, ValueChangeEvent.getType());
	}

	protected void ensureDomStateChangeHandlers() {
		addDomHandler(new EventHandlerCore<StateChangeEvent>() {
			@Override
			public void onEvent(StateChangeEvent event) {
				GWT.log("On state change: " +getValue());
				ValueChangeEvent.fire(PaperCheckableBase.this, getValue());
				
			}

		}, StateChangeEvent.getType());
	}

	/**
	 * Determines whether this toggle button is currently checked.
	 *
	 * @return <code>true</code> if the check box is checked, false otherwise.
	 *         Will not return null
	 */
	@Override
	public Boolean getValue() {
		if (isAttached()) {
			return getElement().isChecked();
		} else {
			return getElement().isDefaultChecked();
		}
	}

	/**
	 * Checks or unchecks the toggle button.
	 *
	 * @param value
	 *            true to check, false to uncheck; null value implies false
	 */
	@Override
	public void setValue(Boolean value) {
		setValue(value, false);
	}

	/**
	 * Checks or unchecks the toggle button, firing {@link ValueChangeEvent} if
	 * appropriate.
	 *
	 * @param value
	 *            true to check, false to uncheck; null value implies false
	 * @param fireEvents
	 *            If true, and value has changed, fire a
	 *            {@link ValueChangeEvent}
	 */
	@Override
	public void setValue(Boolean value, boolean fireEvents) {
		if (value == null) {
			value = Boolean.FALSE;
		}

		Boolean oldValue = getValue();
		getElement().setChecked(value);
		if (value.equals(oldValue)) {
			return;
		}
		if (fireEvents) {
			ValueChangeEvent.fireIfNotEqual(this, oldValue, value);
		}

	}

	@Override
	public PaperCheckableElementBase getElement() {
		return super.getElement().cast();
	}

}
