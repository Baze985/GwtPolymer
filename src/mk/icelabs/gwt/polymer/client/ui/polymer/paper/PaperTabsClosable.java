package mk.icelabs.gwt.polymer.client.ui.polymer.paper;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Widget;

public class PaperTabsClosable extends PaperTabs {

	public static final String STYLE = "x-tabs-closable";

	public PaperTabsClosable() {
		super();
	}

	
	protected void onRemoveTab(PaperTab tab){
		remove(tab);
		// fire maybe event...
	
	}
	
	@Override
	protected PaperTab checkAdoptInstance(Widget child) {
		final PaperTab tab =  super.checkAdoptInstance(child);
		PaperIconButton i = new PaperIconButton();
		i.setIcon("cancel");
		
//		PaperIconButton i = new PaperIconButton();
	   
	    i.addDomHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.log("CLose icon clicked");
				onRemoveTab(tab);
			}
				
		}, ClickEvent.getType());
	    
	    tab.setWidget(i);
		
		return tab;
	}


//	private void onClickClose(PaperTab tab) {
//		GWT.log("CLose icon clicked");
//	}
	
//	 public native void addHandler(Element x, PaperTab parent) /*-{
//	 var that = this;
//	 x.addEventListener("click", function(){
//	  // Call instance method on this
//    	that.@mk.icelabs.gwt.polymer.client._paperelements.PaperTabsClosable::onClickClose(Lmk/icelabs/gwt/polymer/client/_paperelements/PaperTab;)(parent);
//  
//	 }, false);
//	  
//	 // Write instance field on x
//   //	x.@com.google.gwt.user.client.ui.Widget::parent = parent;
//    
//    }-*/;

}
