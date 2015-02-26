package mk.icelabs.gwt.polymer.client.ui.polymer.paper;

import mk.icelabs.gwt.polymer.client.dom.polymer.paper.PaperButtonElement;
import mk.icelabs.gwt.polymer.client.ui.Style.HorizontalAlignment;
import mk.icelabs.gwt.polymer.client.ui.polymer.core.CoreIcon;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Label;

public class PaperButton extends PaperButtonBase {
	
	public static final String STYLE = "";

	

	private CoreIcon icon;
	private String label;
	private HorizontalAlignment hAlig = HorizontalAlignment.LEFT;
	
	public PaperButton() {
		this(Document.get().createElement(PaperButtonElement.TAG), STYLE);
	}
	
	protected PaperButton(Element element, String styleName){
		super(element);
		if (styleName != null && !styleName.equalsIgnoreCase(STYLE)) {
			styleName = STYLE + " " + styleName;
		}
		setStyleName(styleName);
	}

	public void setRaisedButton(boolean status) {
		getElement().setRaisedButton(status);
	}
	
	public CoreIcon getIcon() {
		return icon;
	}

	public void setIcon(CoreIcon icon) {
		this.icon = icon;
		updateChildren();
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
		updateChildren();
	}

	public HorizontalAlignment getHAlig() {
		return hAlig;
	}

	public void setHAlig(HorizontalAlignment hAlig) {
		this.hAlig = hAlig;
		updateChildren();
	}

	@Override
	public PaperButtonElement getElement() {
		return super.getElement().cast();
	}
	
	
	protected void updateChildren(){
		//SafeHtmlBuilder b = new SafeHtmlBuilder();
		getElement().removeAllChildren();
		
		if (HorizontalAlignment.LEFT.equals(hAlig)){
			if (icon != null)
				getElement().appendChild(icon.getElement());
			
			if (label != null)
				getElement().appendChild(new Label(label).getElement());
			
			
		}else {

			if (label != null)
				getElement().appendChild(new Label(label).getElement());
		
			if (icon != null)
				getElement().appendChild(icon.getElement());
		
		}
			
			
	}
	
	

}
