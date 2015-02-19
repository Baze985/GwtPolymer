package mk.icelabs.gwt.polymer.client.ui.polymer.core;

import java.util.Collection;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasConstrainedValue;

public class CoreDropdownMenu<T extends CoreItem> extends CoreDropdownBase<CoreDropdown<T>> implements
HasConstrainedValue<T> {
	
	public static final String STYLE = "";

	public CoreDropdownMenu() {
		this(Document.get().createElement("core-dropdown-menu"), STYLE);
	}

	protected CoreDropdownMenu(Element element, String styleName) {
		super(element);
		
		if (styleName != null && !styleName.equalsIgnoreCase(STYLE)) {
			styleName = STYLE + " " + styleName;
		}
		setStyleName(styleName);
		
	}
	
	
	
	public <X extends CoreDropdown<T>> void setDropDown(X dropDown) {
		if (getWidgetCount() > 0)
			getWidget(0).removeFromParent();
		
		dropDown.setStyleName("dropdown");
		dropDown.getElement().setAttribute("layered", "true");
		add(dropDown);
	}
	
	
	public CoreDropdown<T> getDropDown() {
		assert (getWidgetCount() > 0);
		
		return getWidget(0);
	}


	public String getLabel() {
		return getElement().getAttribute("label");
	}

	public void setLabel(String lbl) {
		getElement().setAttribute("label", lbl);
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
	
}
