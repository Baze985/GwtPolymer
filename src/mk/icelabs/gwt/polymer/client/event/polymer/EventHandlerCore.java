package mk.icelabs.gwt.polymer.client.event.polymer;

import com.google.gwt.event.shared.EventHandler;


@SuppressWarnings("rawtypes")
public abstract class EventHandlerCore<E extends EventCoreBase> implements EventHandler {

	public abstract void onEvent(E e);
}
