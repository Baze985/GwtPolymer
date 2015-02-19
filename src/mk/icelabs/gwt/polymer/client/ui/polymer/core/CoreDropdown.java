package mk.icelabs.gwt.polymer.client.ui.polymer.core;

import java.util.Collection;

import mk.icelabs.gwt.polymer.client.ui.Style.HorizontalAlignment;
import mk.icelabs.gwt.polymer.client.ui.Style.VerticalAlignment;
import mk.icelabs.gwt.polymer.client.ui.widgets.Container;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasConstrainedValue;
import com.google.gwt.user.client.ui.Widget;

public class CoreDropdown<T extends CoreItem> extends Container<CoreSelector<T>> implements
HasConstrainedValue<T> {
	
	public static final String STYLE = "";

	public CoreDropdown() {
		this(Document.get().createElement("core-dropdown"), STYLE);
	}

	protected CoreDropdown(Element element, String styleName) {
		setElement(element);
		
		if (styleName != null && !styleName.equalsIgnoreCase(STYLE)) {
			styleName = STYLE + " " + styleName;
		}
		setStyleName(styleName);
		
		CoreSelector<T> s = createBaseMenuSelector();
		s.setStyleName("menu");
		add(s);
	}
	
	
	
	public void add(T item) {
		getWidget(0).add(item);
	}


	public boolean isOpened() {
		return getElement().hasAttribute("opened");
	}

	public void setOpened(boolean opened) {
		getElement().setAttribute("opened", "");
	}


	protected CoreSelector<T> createBaseMenuSelector(){
		return new CoreSelector<>();
	}

	@Override
	public T getValue() {
		return getWidget(0).getValue();
	}

	@Override
	public void setValue(T value) {
		getWidget(0).setValue(value);
	}

	@Override
	public void setValue(T value, boolean fireEvents) {
		getWidget(0).setValue(value, fireEvents);
	}

	@Override
	public HandlerRegistration addValueChangeHandler(
			ValueChangeHandler<T> handler) {
		return getWidget(0).addValueChangeHandler(handler);
	}

	@Override
	public void setAcceptableValues(Collection<T> values) {
		getWidget(0).setAcceptableValues(values);
	}
	
	/**
	 * Target must have a defined id attribute
	 * @param trigger
	 */
	public void setTriggerTarget(Widget trigger){
		getElement().setAttribute("relatedTarget", trigger.getElement().getId());
	}
	
	public void setHalign(HorizontalAlignment allign){
		assert(allign != HorizontalAlignment.CENTER) : "just left right are supported";
		getElement().setAttribute("halign", allign.name().toLowerCase());
	}
	
	public void setValign(VerticalAlignment allign){
		assert(allign != VerticalAlignment.MIDDLE) : "just top bootom are supported";
		getElement().setAttribute("valign", allign.name().toLowerCase());
	}
}
