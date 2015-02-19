package mk.icelabs.gwt.polymer.client.event.polymer;

import com.google.gwt.event.dom.client.MouseEvent;


@SuppressWarnings("rawtypes")
public abstract class EventCoreBase<E extends EventCoreBase> extends MouseEvent<EventHandlerCore<E>> {

	
	@SuppressWarnings("unchecked")
	@Override
	protected void dispatch(EventHandlerCore<E> handler) {
		handler.onEvent((E) this);
	}

}
