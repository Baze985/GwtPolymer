package mk.icelabs.gwt.polymer.client.ui.polymer.core;

import mk.icelabs.gwt.polymer.client.dom.polymer.core.CoreCollapseElement;
import mk.icelabs.gwt.polymer.client.event.polymer.EventCoreBase;
import mk.icelabs.gwt.polymer.client.event.polymer.EventHandlerCore;
import mk.icelabs.gwt.polymer.client.ui.widgets.ContainerExt;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

public class CoreCollapse<T extends Widget> extends ContainerExt<T> {

	
	
	public static final String STYLE = "";
	
	
	/**
	 * State change event fired when the state of the collapse is changed!
	 */
	public static class CoreCollapseStateEvent extends EventCoreBase<CoreCollapseStateEvent> {

		
		private static final Type<EventHandlerCore<CoreCollapseStateEvent>> TYPE = new Type<EventHandlerCore<CoreCollapseStateEvent>>(
				"core-collapse-open", new CoreCollapseStateEvent());

		public static Type<EventHandlerCore<CoreCollapseStateEvent>> getType() {
			return TYPE;
		}

		@Override
		public com.google.gwt.event.dom.client.DomEvent.Type<EventHandlerCore<CoreCollapseStateEvent>> getAssociatedType() {
			return getType();
		}
	}
	
	/**
	 * Collapse resize event fired when the size of the collapse is changed!
	 */
	public static class CoreCollapseResizedEvent extends EventCoreBase<CoreCollapseResizedEvent> {

		
		private static final Type<EventHandlerCore<CoreCollapseResizedEvent>> TYPE = new Type<EventHandlerCore<CoreCollapseResizedEvent>>(
				"core-resize", new CoreCollapseResizedEvent());

		public static Type<EventHandlerCore<CoreCollapseResizedEvent>> getType() {
			return TYPE;
		}

		@Override
		public com.google.gwt.event.dom.client.DomEvent.Type<EventHandlerCore<CoreCollapseResizedEvent>> getAssociatedType() {
			return getType();
		}
	}

	
	public CoreCollapse() {
		this(Document.get().createElement(CoreCollapseElement.TAG), STYLE);
	}

	protected CoreCollapse(Element element, String styleName) {
		setElement(element);
		if (styleName != null && !styleName.equalsIgnoreCase(STYLE)) {
			styleName = STYLE + " " + styleName;
		}
		setStyleName(styleName);
	}

	public void toggle(){
		getElement().toggle();
	}
	
	public void addCoreStateChangeHandler(EventHandlerCore<CoreCollapseStateEvent> stateChangeHandler){
		addDomHandler(stateChangeHandler, CoreCollapseStateEvent.getType());
	}
	
	public void addCoreSizeChangeHandler(EventHandlerCore<CoreCollapseResizedEvent> sizeChangedHandler){
		addDomHandler(sizeChangedHandler, CoreCollapseResizedEvent.getType());
	}
	
	public boolean isHorizontal() {
		return getElement().isHorizontal();
	}

	public void setHorizontal(boolean horizontal) {
		getElement().setHorizontal(horizontal);
	}

	public boolean isFixedSize() {
		return getElement().isFixedSize();
	}

	public void setFixedSize(boolean fixedSize) {
		getElement().setFixedSize(fixedSize);
	}

	public boolean isAllowOverflow() {
		return getElement().isAllowOverflow();
	}

	public void setAllowOverflow(boolean allowOverflow) {
		getElement().setAllowOverflow(allowOverflow);
	}

	public Integer getDuration() {
		return getElement().getDuration();
	}

	public void setDuration(Integer duration) {
		getElement().setDuration(duration);
	}

	public boolean isOpened() {
		return getElement().isOpened();
	}

	public void setOpened(boolean opened) {
		getElement().setOpened(opened);
	}

	@Override
	public CoreCollapseElement getElement() {
		return super.getElement().cast();
	}


}
