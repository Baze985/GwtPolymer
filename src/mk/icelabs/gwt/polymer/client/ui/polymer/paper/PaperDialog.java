package mk.icelabs.gwt.polymer.client.ui.polymer.paper;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

public class PaperDialog extends PaperDialogBase {

	public static final String STYLE = "";

	public PaperDialog() {
		this(Document.get().createElement("paper-dialog"), STYLE);
	}

	protected PaperDialog(Element element, String styleName) {
		super(element, styleName);
		if (styleName != null && !styleName.equalsIgnoreCase(STYLE)) {
			styleName = STYLE + " " + styleName;
		}
		setStyleName(styleName);
	
	}

	@Override
	public void add(Widget child) {
		super.add(child);
	}
	
}
