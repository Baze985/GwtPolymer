package mk.icelabs.gwt.polymer.client.ui.polymer.core;

import mk.icelabs.gwt.polymer.client.dom.polymer.core.CoreOverlayElement;
import mk.icelabs.gwt.polymer.client.event.polymer.EventCoreBase;
import mk.icelabs.gwt.polymer.client.event.polymer.EventHandlerCore;
import mk.icelabs.gwt.polymer.client.ui.widgets.Container;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Widget;

public class CoreOverlay extends Container<Widget> {

	
	
	public static final String STYLE = "";
	
	
	/**
	 * State change event fired when the state of the collapse is changed!
	 */
	public static class CoreOverlayOpenedEvent extends EventCoreBase<CoreOverlayOpenedEvent> {

		
		private static final Type<EventHandlerCore<CoreOverlayOpenedEvent>> TYPE = new Type<EventHandlerCore<CoreOverlayOpenedEvent>>(
				"core-overlay-open-completed", new CoreOverlayOpenedEvent());

		public static Type<EventHandlerCore<CoreOverlayOpenedEvent>> getType() {
			return TYPE;
		}

		@Override
		public com.google.gwt.event.dom.client.DomEvent.Type<EventHandlerCore<CoreOverlayOpenedEvent>> getAssociatedType() {
			return getType();
		}
	}
	
	/**
	 * Collapse resize event fired when the size of the collapse is changed!
	 */
	public static class CoreOverlayClosedEvent extends EventCoreBase<CoreOverlayClosedEvent> {

		
		private static final Type<EventHandlerCore<CoreOverlayClosedEvent>> TYPE = new Type<EventHandlerCore<CoreOverlayClosedEvent>>(
				"core-overlay-close-completed", new CoreOverlayClosedEvent());

		public static Type<EventHandlerCore<CoreOverlayClosedEvent>> getType() {
			return TYPE;
		}

		@Override
		public com.google.gwt.event.dom.client.DomEvent.Type<EventHandlerCore<CoreOverlayClosedEvent>> getAssociatedType() {
			return getType();
		}
	}

	private boolean constrainToCenter;
	private HandlerRegistration removeHandler;

	
	public CoreOverlay() {
		this(Document.get().createElement(CoreOverlayElement.TAG), STYLE);
	}

	protected CoreOverlay(Element element, String styleName) {
		setElement(element);
		if (styleName != null && !styleName.equalsIgnoreCase(STYLE)) {
			styleName = STYLE + " " + styleName;
		}
		setStyleName(styleName);
		
		//getElement().makePositionable(Position.FIXED);
		
		initResizeHandler(this, getElement());
	}
	
	@Override
	public void add(Widget child) {
		super.add(child);
	}

	public void toggle(){
		assert(isAttached()) : "must first to be aaded to the DOM so can be toggled";	
		getElement().toggle();
	}
	
	public void close(){
		getElement().close();
	}

	
	public void closePlusRemove(){
		removeHandler = addCoreOverlayClosedHandler(new EventHandlerCore<CoreOverlay.CoreOverlayClosedEvent>() {

			@Override
			public void onEvent(CoreOverlayClosedEvent e) {
				removeFromParent();
				removeHandler.removeHandler();
				removeHandler = null;
				
			}
		});
		
		close();
	}
	
	public void open(){
		assert(isAttached()) : "must first to be aaded to the DOM so can be opened";	
		getElement().open();
	}
	
	public void setConstrainToCenter(boolean status){
		this.constrainToCenter = status;
	}
	
//	public void openOnCenter(){
//		 constrainToCenter = true;
//		 centerHandler = addCoreOverlayOpenedHandler(new EventHandlerCore<CoreOverlay.CoreOverlayOpenedEvent>() {
//
//			@Override
//			public void onEvent(CoreOverlayOpenedEvent e) {
//				getElement().makePositionable(Position.FIXED);
//				getElement().center(true);
//				centerHandler.removeHandler();
//				centerHandler = null;
//			}
//		});
//		 
//		//addCompliteLoadingHandler(this, getElement());
////		getElement().getStyle().setWidth(300, Unit.PX);
////		getElement().getStyle().setHeight(300, Unit.PX);
//		open();
//		//getElement().center(true);
//	}
	
	public HandlerRegistration addCoreOverlayOpenedHandler(EventHandlerCore<CoreOverlayOpenedEvent> openingComplitedHandler){
		return addDomHandler(openingComplitedHandler, CoreOverlayOpenedEvent.getType());
	}
	
	public HandlerRegistration addCoreOverlayClosedHandler(EventHandlerCore<CoreOverlayClosedEvent> closingComplitedHandler){
		return addDomHandler(closingComplitedHandler, CoreOverlayClosedEvent.getType());
	}
	
	public boolean isBackdrop() {
		return getElement().isBackdrop();
	}

	public void setBackdrop(boolean status) {
		getElement().setBackdrop(status);
	}

	public boolean isLayered() {
		return getElement().hasAttribute("layered");
	}

	public void setLayered(boolean status) {
		if (status)
			getElement().setAttribute("layered", new Boolean(status).toString());
		else
			getElement().removeAttribute("layered");
	}

	public boolean isAutoFocusDisabled() {
		return getElement().isAutoFocusDisabled();
	}

	public void setAutoFocusDisabled(boolean status) {
		getElement().setAutoFocusDisabled(status);
	}
	
	public boolean isAutoCloseDisabled() {
		return getElement().isAutoCloseDisabled();
	}

	public void setAutoCloseDisabled(boolean status) {
		getElement().setAutoCloseDisabled(status);
	}

	public String getCloseAttribute() {
		return getElement().getCloseAttribute();
	}

	public void setCloseAttribute(String attrName) {
		getElement().setCloseAttribute(attrName);
	}
	
	public String getCloseSelector() {
		return getElement().getCloseSelector();
	}

	public void setCloseSelector(String attrName) {
		getElement().setCloseSelector(attrName);
	}

	public boolean isOpened() {
		return getElement().isOpened();
	}

	public void setOpened(boolean opened) {
		getElement().setOpened(opened);
	}
	
	public String getTransition() {
		return getElement().getTransition();
	}

	public void setTransition(String trans) {
		getElement().setTransition(trans);
	}
	
	
	@Override
	public CoreOverlayElement getElement() {
		return super.getElement().cast();
	}
	


	protected void onResizeOverlay(){if (constrainToCenter) getElement().center(true);}

	
	/**
	 * Must have some input parameter its not working other way bug GWT 2.7?! 
	 * 
	 * @param dummy
	 */
	private void callResizeOverlay(String dummy){
		onResizeOverlay();
	}

	
	private final native void initResizeHandler(CoreOverlay o, JavaScriptObject element) /*-{
		element.resizeHandler = function() {
			o.@mk.icelabs.gwt.polymer.client.ui.polymer.core.CoreOverlay::callResizeOverlay(Ljava/lang/String;)("dummy");
		};

	}-*/;
	
//	private final native void addCompliteLoadingHandler(CoreOverlay o, JavaScriptObject element) /*-{
//		element.addEventListener("core-overlay-open-completed", function(){
//			console.log("opeeeeeeeennneeeed");
//			o.@mk.icelabs.gwt.polymer.client.ui.polymer.core.CoreOverlay::callResizeOverlay(Ljava/lang/String;)("dummy");
//		}, false);
//		
//
//	}-*/;
	
	
	
	
}
