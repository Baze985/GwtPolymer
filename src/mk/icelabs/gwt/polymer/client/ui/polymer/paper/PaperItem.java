package mk.icelabs.gwt.polymer.client.ui.polymer.paper;

import mk.icelabs.gwt.polymer.client.dom.polymer.core.CoreItemElement;
import mk.icelabs.gwt.polymer.client.ui.polymer.core.CoreItem;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Label;

public class PaperItem extends CoreItem { // Convenience extension

	public static final String STYLE = "";

	private Label text;
	
	public PaperItem() {
		this(Document.get().createElement("paper-item"), STYLE);
	}

	public PaperItem(Element element, String styleName){
		super(element);
		if (styleName != null && !styleName.equalsIgnoreCase(STYLE)) {
			styleName = STYLE + " " + styleName;
		}
		setStyleName(styleName);
	}

	public String getLabel() {
		if (text != null)
			return text.getText();
		
		return "";
	}

	public void setLabel(String lbl){
		if (text == null)
			text = new Label();
		
		text.setText(lbl);
		add(text);
	}

	public String getIconSrc() {
		throw new IllegalArgumentException("not implemented in paper not used");
	}

	public void setIconSrc(String iconsrc) {
		throw new IllegalArgumentException("not implemented in paper not used");
	}

	public String getIcon() {
		throw new IllegalArgumentException("not implemented in paper not used");
	}

	public void setIcon(String ico) {
		throw new IllegalArgumentException("not implemented in paper not used");
	}

	public boolean isRaisedButton() {
		return getElement().hasAttribute("raised");
	}

	public void setRaisedButton(boolean status) {
		getElement().setAttribute("raised", "");
	}
	
	public boolean isFill() {
		return getElement().hasAttribute("fill");
	}

	public void setFill(boolean status) {
		getElement().setAttribute("fill", "");
	}

	@Override
	public CoreItemElement getElement() {
		return super.getElement().cast();
	}

}
