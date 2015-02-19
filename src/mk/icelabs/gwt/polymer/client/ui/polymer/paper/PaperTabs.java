package mk.icelabs.gwt.polymer.client.ui.polymer.paper;

import mk.icelabs.gwt.polymer.client.dom.polymer.paper.PaperTabsElement;
import mk.icelabs.gwt.polymer.client.ui.polymer.core.CoreSelector;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

public class PaperTabs extends CoreSelector<PaperTab> {

	public static final String STYLE = "";
	
	public PaperTabs() {
		this(Document.get().createElement(PaperTabsElement.TAG), STYLE);
	}

	protected PaperTabs(Element element, String styleName){
		super(element);
		
		if (styleName != null && !styleName.equalsIgnoreCase(STYLE)) {
			styleName = STYLE + " " + styleName;
		}
		setStyleName(styleName);
		
		
	}
	
	
	public void add(String tabName){
		PaperTab tab = new PaperTab();
		tab.setLabel(tabName);
		tab.setNoink(true);
		tab.setFlex(false);
		add(tab);
	}
	
	
	public boolean isNoink() {
		return getElement().isNoink();
	}

	public void setNoink(boolean status) {
		getElement().setNoink(status);
	}

	public boolean isNobar() {
		return getElement().isNobar();
	}

	public void setNobar(boolean status) {
		getElement().setNobar(status);
	}

	public boolean isNoslide() {
		return getElement().isNoslide();
	}

	public void setNoslide(boolean status) {
		getElement().setNoslide(status);
	}

	public boolean isScrollable() {
		return getElement().isScrollable();
	}

	public void setScrollable(boolean status) {
		getElement().setScrollableTabs(status);
	}

	public boolean getHideScrollButton() {
		return getElement().isHideScrollButton();
	}

	public void setHideScrollButton(boolean status) {
		getElement().setHideScrollButton(status);
	}


	@Override
	public PaperTabsElement getElement() {
		return super.getElement().cast();
	}
	
	protected PaperTab checkAdoptInstance(Widget child) {
		super.checkAdoptInstance(child);
		if (child instanceof PaperTab)
			return (PaperTab) child;
		
		throw new IllegalArgumentException("The chiled widget must be of type PaperTab");
	}


}
