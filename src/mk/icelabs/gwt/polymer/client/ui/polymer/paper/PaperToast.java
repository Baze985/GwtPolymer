package mk.icelabs.gwt.polymer.client.ui.polymer.paper;

import mk.icelabs.gwt.polymer.client.dom.polymer.paper.PaperToastElement;
import mk.icelabs.gwt.polymer.client.event.polymer.EventCoreBase;
import mk.icelabs.gwt.polymer.client.event.polymer.EventHandlerCore;
import mk.icelabs.gwt.polymer.client.ui.widgets.Container;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Widget;

public class PaperToast extends Container<Widget> {

	
	
	public static final String STYLE = "";
	
	
	/**
	 * State change event fired when the state of the collapse is changed!
	 */
	public static class PaperToastOpenedEvent extends EventCoreBase<PaperToastOpenedEvent> {

		
		private static final Type<EventHandlerCore<PaperToastOpenedEvent>> TYPE = new Type<EventHandlerCore<PaperToastOpenedEvent>>(
				"core-overlay-open-completed", new PaperToastOpenedEvent());

		public static Type<EventHandlerCore<PaperToastOpenedEvent>> getType() {
			return TYPE;
		}

		@Override
		public com.google.gwt.event.dom.client.DomEvent.Type<EventHandlerCore<PaperToastOpenedEvent>> getAssociatedType() {
			return getType();
		}
	}
	
	/**
	 * Collapse resize event fired when the size of the collapse is changed!
	 */
	public static class PaperToastClosedEvent extends EventCoreBase<PaperToastClosedEvent> {

		
		private static final Type<EventHandlerCore<PaperToastClosedEvent>> TYPE = new Type<EventHandlerCore<PaperToastClosedEvent>>(
				"core-overlay-close-completed", new PaperToastClosedEvent());

		public static Type<EventHandlerCore<PaperToastClosedEvent>> getType() {
			return TYPE;
		}

		@Override
		public com.google.gwt.event.dom.client.DomEvent.Type<EventHandlerCore<PaperToastClosedEvent>> getAssociatedType() {
			return getType();
		}
	}


	private HandlerRegistration removeHandler;

	
	public PaperToast() {
		this(Document.get().createElement(PaperToastElement.TAG), STYLE);
	}

	protected PaperToast(Element element, String styleName) {
		setElement(element);
		if (styleName != null && !styleName.equalsIgnoreCase(STYLE)) {
			styleName = STYLE + " " + styleName;
		}
		setStyleName(styleName);
		
		//getElement().makePositionable(Position.FIXED);
		
	}

	
	@Override
	public void add(Widget child) {
		super.add(child);
	}

	public void setRounded(boolean status){
		getElement().setClassName("capsule", status);
	}
	
	public boolean isRounded(){
		return getElement().hasClassName("capsule");
	}
	
	public void toggle(){
		assert(isAttached()) : "must first to be aaded to the DOM so can be toggled";	
		getElement().toggle();
	}
	
	public void dismiss(){
		getElement().dismiss();
	}

	
	public void closePlusRemove(){
		removeHandler = addCoreOverlayClosedHandler(new EventHandlerCore<PaperToast.PaperToastClosedEvent>() {

			@Override
			public void onEvent(PaperToastClosedEvent e) {
				removeFromParent();
				removeHandler.removeHandler();
				removeHandler = null;
				
			}
		});
		
		dismiss();
	}
	
	public void open(){
		assert(isAttached()) : "must first to be added to the DOM so can be opened";	
		getElement().open();
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
	
	public HandlerRegistration addCoreOverlayOpenedHandler(EventHandlerCore<PaperToastOpenedEvent> openingComplitedHandler){
		return addDomHandler(openingComplitedHandler, PaperToastOpenedEvent.getType());
	}
	
	public HandlerRegistration addCoreOverlayClosedHandler(EventHandlerCore<PaperToastClosedEvent> closingComplitedHandler){
		return addDomHandler(closingComplitedHandler, PaperToastClosedEvent.getType());
	}
	
	public boolean isSwipeDisabled() {
		return getElement().isSwipeDisabled();
	}

	public void setSwipeDisabled(boolean status) {
		getElement().setSwipeDisabled(status);
	}

	public int getResponsiveWidth() {
		return getElement().getResponsiveWidth();
	}

	public void setResponsiveWidth(int responsiveWidth) {
		getElement().setResponsiveWidth(responsiveWidth);
	}
	
	public boolean isAutoCloseDisabled() {
		return getElement().isAutoCloseDisabled();
	}

	public void setAutoCloseDisabled(boolean status) {
		getElement().setAutoCloseDisabled(status);
	}

	public int getDurationMilis() {
		return getElement().getDurationMilis();
	}

	public void setDurationMilis(int durationMilis) {
		getElement().setDurationMilis(durationMilis);
	}
	
	public String getText() {
		return getElement().getText();
	}

	public void setText(String text) {
		getElement().setText(text);
	}

	public boolean isOpened() {
		return getElement().isOpened();
	}

	public void setOpened(boolean opened) {
		getElement().setOpened(opened);
	}
	
	
	@Override
	public PaperToastElement getElement() {
		return super.getElement().cast();
	}	
	
	
}
