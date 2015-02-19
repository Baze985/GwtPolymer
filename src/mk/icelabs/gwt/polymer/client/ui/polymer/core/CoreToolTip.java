package mk.icelabs.gwt.polymer.client.ui.polymer.core;

import mk.icelabs.gwt.polymer.client.dom.polymer.core.CoreTooTipElement;
import mk.icelabs.gwt.polymer.client.ui.widgets.SimpleContainer;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

public class CoreToolTip extends SimpleContainer {

	public static final String STYLE = "";

	public static enum Position {
		TOP("top"), BOTTOM("bottom"),
		LEFT("left "), RIGHT("right");

		private String poss;

		Position(String poss) {
			this.poss = poss;
		}
		
		static Position calcPosition(String poss){
			for (Position p : values())
				if (p.poss.equals(poss))
					return p;
			
			return Position.BOTTOM;
		}

	}
	
	public CoreToolTip(Widget content) {
		this(content, Document.get().createElement(CoreTooTipElement.TAG), STYLE);
	}

	protected CoreToolTip(Widget content, Element element, String styleName) {
		super(true);
		setElement(element);
		setWidget(content);
		if (styleName != null && !styleName.equalsIgnoreCase(STYLE)) {
			styleName = STYLE + " " + styleName;
		}
		setStyleName(styleName);
	}

	public String getLabel() {
		return getElement().getLabel();
	}

	public void setLabel(String lbl){
		getElement().setLabel(lbl);
	}
	
	public boolean isShow() {
		return getElement().isShow();
	}

	public void setShow(boolean status) {
		getElement().setShow(status);
	}
	
	public Position getPosition() {
		return Position.calcPosition(getElement().getPosition());
	}

	public void setPosition(Position poss) {
		getElement().setPosition(poss.poss);
	}

	public String getTipAttribute() {
		return getElement().getTipAttribute();
	}

	public void setTipAttribute(String tipAttribute) {
		getElement().setTipAttribute(tipAttribute);
	}

	public boolean isNoArrow() {
		return getElement().isNoarrow();
	}

	public void setNoArrow(boolean noArrow) {
		getElement().setNoarrow(noArrow);
	}
	
	@Override
	public CoreTooTipElement getElement() {
		return super.getElement().cast();
	}


}
