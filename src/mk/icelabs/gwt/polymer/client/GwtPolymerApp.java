package mk.icelabs.gwt.polymer.client;

import mk.icelabs.gwt.polymer.client.ui.polymer.core.CoreAnimatedPages;
import mk.icelabs.gwt.polymer.client.ui.polymer.core.CoreSection;
import mk.icelabs.gwt.polymer.client.ui.polymer.core.CoreToolTip;
import mk.icelabs.gwt.polymer.client.ui.polymer.core.CoreToolbar;
import mk.icelabs.gwt.polymer.client.ui.polymer.core.CoreAnimatedPages.Transitions;
import mk.icelabs.gwt.polymer.client.ui.polymer.paper.PaperIconButton;
import mk.icelabs.gwt.polymer.client.ui.polymer.paper.PaperTab;
import mk.icelabs.gwt.polymer.client.ui.polymer.paper.PaperTabs;
import mk.icelabs.gwt.polymer.client.ui.polymer.paper.PaperTabsClosable;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class GwtPolymerApp extends Composite  {

	private static GwtPolymerAppUiBinder uiBinder = GWT.create(GwtPolymerAppUiBinder.class);

	interface GwtPolymerAppUiBinder extends UiBinder<Widget, GwtPolymerApp> {
	}
	
	@UiField
	CoreToolbar navigation;

	@UiField
	CoreAnimatedPages toolbars;

	public GwtPolymerApp() {
		initWidget(uiBinder.createAndBindUi(this));
		
		final CoreAnimatedPages anPages = toolbars;
		anPages.getElement().getStyle().setWidth(100, Unit.PCT);
		anPages.getElement().getStyle().setHeight(100, Unit.PCT);
		anPages.setTransition(Transitions.CrosFadeAll);
		anPages.add(new CoreSection(createDummyWidget("white")));
		anPages.add(new CoreSection(createDummyWidget("green")));
		anPages.add(new CoreSection(createDummyWidget("red")));
		
		final PaperTabs paperTabs = new PaperTabsClosable();
		paperTabs.addValueChangeHandler(new ValueChangeHandler<PaperTab>() {

			@Override
			public void onValueChange(ValueChangeEvent<PaperTab> event) {
				GWT.log(event.getValue().getLabel());
				anPages.setSelectedIndex(paperTabs.getSelectedIndex());
			}
		});
		paperTabs.add("Tab1");
		paperTabs.add("Tab2");
		paperTabs.add("Tab3");
		paperTabs.setSelectedIndex(0);
		
		PaperIconButton i = new PaperIconButton();
		i.setIcon("menu");
		i.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.log("Icon manu clicked");
			}
		});
		CoreToolTip tip = new CoreToolTip(i);
		tip.setLabel("Settings");
		CoreToolbar toolBar = navigation;
		toolBar.getElement().getStyle().setHeight(56, Unit.PX);
		toolBar.add(tip);
		toolBar.add(paperTabs);
		
		
		
		
//		v.add(pInput);
//		v.add(pButton);
//		v.add(toggle);
//		v.add(paperTabs);
		
	
		RootPanel.get().add(navigation);
		RootPanel.get().add(toolbars);
		
	}

	private Widget createDummyWidget(String bgColor){
		Widget w = new Widget(){
			{setElement(DOM.createDiv());}
			
		};
		w.getElement().getStyle().setBackgroundColor(bgColor);
		w.getElement().getStyle().setWidth(100, Unit.PCT);
		w.getElement().getStyle().setHeight(100, Unit.PCT);
		return w;
	}

	
}
