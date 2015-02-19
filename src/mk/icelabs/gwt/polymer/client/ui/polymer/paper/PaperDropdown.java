package mk.icelabs.gwt.polymer.client.ui.polymer.paper;

import mk.icelabs.gwt.polymer.client.ui.polymer.core.CoreDropdown;
import mk.icelabs.gwt.polymer.client.ui.polymer.core.CoreMenu;
import mk.icelabs.gwt.polymer.client.ui.polymer.core.CoreSelector;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;

public class PaperDropdown extends CoreDropdown<PaperItem> {
	
	public static final String STYLE = "";

	public PaperDropdown() {
		this(Document.get().createElement("paper-dropdown"), STYLE);
	}

	protected PaperDropdown(Element element, String styleName) {
		super(element, styleName);
		
		if (styleName != null && !styleName.equalsIgnoreCase(STYLE)) {
			styleName = STYLE + " " + styleName;
		}
		setStyleName(styleName);
		
	}
	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected CoreSelector createBaseMenuSelector(){
		return new CoreMenu();
	}


}
