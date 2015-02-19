package mk.icelabs.gwt.polymer.client.ui.polymer.paper;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

public class PaperDialogActions extends PaperDialog {

	public static final String STYLE = "";

	public PaperDialogActions() {
		this(Document.get().createElement("paper-action-dialog"), STYLE);
	}

	protected PaperDialogActions(Element element, String styleName) {
		super(element, styleName);
		if (styleName != null && !styleName.equalsIgnoreCase(STYLE)) {
			styleName = STYLE + " " + styleName;
		}
		setStyleName(styleName);
	
	}

	@Override
	public void add(Widget child) {
		if (getWidgetCount() == 0)
			super.add(child);
		else{
			boolean inserted = false;
			for (int i= getWidgetCount(); i>0; i--){
				if (getWidget(i - 1) instanceof PaperButton)
					continue;
				
				insert(child, i);
				inserted = true;
				break;
			}
			
			if (!inserted)
				insert(child, 0);
		}
	}
	
	public void addButtonDismissive(PaperButton dismissive){
		dismissive.getElement().setAttribute("dismissive", "");
		insert(dismissive, getWidgetCount());
		
	}
	
	public void addButtonAffirmative(PaperButton affirmative){
		affirmative.getElement().setAttribute("affirmative", "");
		insert(affirmative, getWidgetCount());
		//addClickHendler(this, affirmative.getElement());
	}
	
	/**
	 * default: '[affirmative],[dismissive]'
	 */
	public void setCloseSelector(String selectorValue){
		getElement().setAttribute("closeSelector", selectorValue);
	}
	
//	private void onClick(String sss){
//		GWT.log("onCLicckkkkk");
//	}
//	
//	private final native void addClickHendler(PaperDialogActions o, JavaScriptObject element) /*-{
//	element.addEventListener("click", function(){
//		console.log("clickeddddd");
//		o.@mk.icelabs.gwt.polymer.client.ui.polymer.paper.PaperDialogActions::onClick(Ljava/lang/String;)("dummy");
//	}, false);
//	
//  }-*/;

}
