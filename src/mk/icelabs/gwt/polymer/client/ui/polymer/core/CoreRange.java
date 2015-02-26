package mk.icelabs.gwt.polymer.client.ui.polymer.core;

import mk.icelabs.gwt.polymer.client.dom.polymer.core.CoreRangeElement;
import mk.icelabs.gwt.polymer.client.ui.widgets.Component;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;

public class CoreRange extends Component {

	
	
	public static final String STYLE = "";
	

	public CoreRange() {
		this(Document.get().createElement(CoreRangeElement.TAG), STYLE);
	}

	protected CoreRange(Element element, String styleName) {
		setElement(element);
		if (styleName != null && !styleName.equalsIgnoreCase(STYLE)) {
			styleName = STYLE + " " + styleName;
		}
		setStyleName(styleName);
	}

	public int getValue() {
		return getElement().getValue();
	}

	public void setValue(int value) {
		getElement().setValue(value);
	}

	public int getMax() {
		return getElement().getMax();
	}

	public void setMax(int max) {
		getElement().setMax(max);
	}

	public int getMin() {
		return getElement().getMin();
	}

	public void setMin(int min) {
		getElement().setMin(min);
	}

	public int getStep() {
		return getElement().getStep();
	}

	public void setStep(int step) {
		getElement().setStep(step);
	}

	public int getRatio() {
		return getElement().getRatio();
	}

	public void setRatio(int ratio) {
		getElement().setRatio(ratio);
	}

	@Override
	public CoreRangeElement getElement() {
		return super.getElement().cast();
	}
}
