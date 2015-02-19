package mk.icelabs.gwt.polymer.client.ui.polymer.core;

import mk.icelabs.gwt.polymer.client.dom.polymer.core.CoreScaffoldElement;
import mk.icelabs.gwt.polymer.client.ui.widgets.Container;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

public class CoreScaffold extends Container<Widget>{
	
	
	public static final String STYLE = "";


	public CoreScaffold(CoreHeaderPanel navigation, Widget content) {
		this(navigation, content, Document.get().createElement(CoreScaffoldElement.TAG), STYLE);
	}

	protected CoreScaffold(CoreHeaderPanel navigation, Widget content, Element element, String styleName) {
		setElement(element);
		if (styleName != null && !styleName.equalsIgnoreCase(STYLE)) {
			styleName = STYLE + " " + styleName;
		}
		setStyleName(styleName);
		
		navigation.getElement().setAttribute("navigation", "");
		navigation.getElement().setAttribute("flex", "");
		navigation.setContentFitWindowSize(true);
		add(navigation);
		//content.getElement().setAttribute("fit", "");
		add(content);
	}
	
	public void addTool(Widget tool){
		tool.getElement().setAttribute("tool", "");
		insert(tool, getWidgetCount() - 1);
	}
	
	
	public void setContentFitWindowSize(boolean status) {
		Widget mainWidget = null;
		for (Widget c : getChildren())
			if (!(c.getElement().hasAttribute("navigation") 
					&& c.getElement().hasAttribute("tool"))){
				mainWidget = c;
				break;
			}
		
		if (mainWidget == null)
			return;
		
		if (status)
			mainWidget.getElement().setAttribute("fit", "");
		else
			mainWidget.getElement().removeAttribute("fit");
	}	
	
}
