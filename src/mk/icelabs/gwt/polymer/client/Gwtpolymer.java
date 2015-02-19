package mk.icelabs.gwt.polymer.client;

import mk.icelabs.gwt.polymer.client.ui.Style.HorizontalAlignment;
import mk.icelabs.gwt.polymer.client.ui.Style.VerticalAlignment;
import mk.icelabs.gwt.polymer.client.ui.polymer.core.CoreAnimatedPages;
import mk.icelabs.gwt.polymer.client.ui.polymer.core.CoreAnimatedPages.Transitions;
import mk.icelabs.gwt.polymer.client.ui.polymer.core.CoreCollapse;
import mk.icelabs.gwt.polymer.client.ui.polymer.core.CoreDrawerPanel;
import mk.icelabs.gwt.polymer.client.ui.polymer.core.CoreDropdown;
import mk.icelabs.gwt.polymer.client.ui.polymer.core.CoreDropdownMenu;
import mk.icelabs.gwt.polymer.client.ui.polymer.core.CoreHeaderPanel;
import mk.icelabs.gwt.polymer.client.ui.polymer.core.CoreHeaderPanel.HeaderMode;
import mk.icelabs.gwt.polymer.client.ui.polymer.core.CoreIcon;
import mk.icelabs.gwt.polymer.client.ui.polymer.core.CoreItem;
import mk.icelabs.gwt.polymer.client.ui.polymer.core.CoreMenu;
import mk.icelabs.gwt.polymer.client.ui.polymer.core.CoreScaffold;
import mk.icelabs.gwt.polymer.client.ui.polymer.core.CoreSection;
import mk.icelabs.gwt.polymer.client.ui.polymer.core.CoreSubMenu;
import mk.icelabs.gwt.polymer.client.ui.polymer.core.CoreToolbar;
import mk.icelabs.gwt.polymer.client.ui.polymer.paper.PaperButton;
import mk.icelabs.gwt.polymer.client.ui.polymer.paper.PaperDialogActions;
import mk.icelabs.gwt.polymer.client.ui.polymer.paper.PaperDropdown;
import mk.icelabs.gwt.polymer.client.ui.polymer.paper.PaperDropdownMenu;
import mk.icelabs.gwt.polymer.client.ui.polymer.paper.PaperIconButton;
import mk.icelabs.gwt.polymer.client.ui.polymer.paper.PaperInput;
import mk.icelabs.gwt.polymer.client.ui.polymer.paper.PaperInputDecorator;
import mk.icelabs.gwt.polymer.client.ui.polymer.paper.PaperItem;
import mk.icelabs.gwt.polymer.client.ui.polymer.paper.PaperMenuButton;
import mk.icelabs.gwt.polymer.client.ui.polymer.paper.PaperSpiner;
import mk.icelabs.gwt.polymer.client.ui.polymer.paper.PaperTab;
import mk.icelabs.gwt.polymer.client.ui.polymer.paper.PaperTabs;
import mk.icelabs.gwt.polymer.client.ui.polymer.paper.PaperToggleButton;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Gwtpolymer implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
//	private final GreetingServiceAsync greetingService = GWT
//			.create(GreetingService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
//		if (true){
//			RootPanel.get().add(new GwtPolymerApp());
//			return;
//		}
		//RootPanel.get().add(new PolymerTest());
		
			
		final PaperInput pInput = new PaperInput();
		pInput.setLabel("Kade e doma");
		pInput.setFloatingLabel(true);
		
		PaperButton pButton = new PaperButton();
		pButton.setLabel("Prati doma");
		
		pButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				pInput.setValue("ete click");
			}
		});
	
		PaperToggleButton toggle = new PaperToggleButton();
		toggle.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				pInput.setValue(event.getValue().toString());
			}
		});

		
		final CoreAnimatedPages anPages = new CoreAnimatedPages();
		anPages.setTransition(Transitions.CrosFadeAll);
		anPages.add(new CoreSection(createDummyWidget("blue")));
		anPages.add(new CoreSection(createDummyWidget("green")));
		anPages.add(new CoreSection(createDummyWidget("red")));
		
		final PaperTabs paperTabs = new PaperTabs();
		paperTabs.addValueChangeHandler(new ValueChangeHandler<PaperTab>() {

			@Override
			public void onValueChange(ValueChangeEvent<PaperTab> event) {
				GWT.log(event.getValue().getLabel());
			//	anPages.setSelectedIndex(paperTabs.getSelectedIndex());
			}
		});
//		paperTabs.add("Tab1");
//		paperTabs.add("Tab2");
//		paperTabs.add("Tab3");
		add20Tabs(paperTabs);
		paperTabs.setSelectedIndex(0);
//		paperTabs.setScrollable(true);
		PaperIconButton icon = new PaperIconButton();
		icon.setIcon("menu");
		icon.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.log("Icon manu clicked");
			}
		});
		CoreToolbar toolBar = new CoreToolbar();
		toolBar.getElement().getStyle().setHeight(56, Unit.PX);
		toolBar.add(icon);
		toolBar.add(paperTabs);
		
		
		
		
//		v.add(pInput);
//		v.add(pButton);
//		v.add(toggle);
//		v.add(paperTabs);
		
		//PaperCheckBox c = new PaperCheckBox();
		
//		RootPanel.get().add(toggle);
//		RootPanel.get().add(pInput);
		
		CoreMenu m = new CoreMenu();
		
		CoreItem i = new CoreItem();
		i.setLabel("Item 0");
		m.add(i);
		
		i = new CoreItem();
		i.setLabel("Item 1");
		m.add(i);
		
		i = new CoreItem();
		i.setLabel("Item 2");
		m.add(i);
		
		CoreSubMenu ms = new CoreSubMenu();
		ms.setLabel("sub menu 1");
		
		i = new CoreItem();
		i.setLabel("Item 3");
		ms.add(i);
		
		i = new CoreItem();
		i.setLabel("Item 4");
		ms.add(i);
		
		m.add(ms);
		
		
		m.addValueChangeHandler(new ValueChangeHandler<CoreItem>() {

			@Override
			public void onValueChange(ValueChangeEvent<CoreItem> event) {
				GWT.log(event.getValue().toString());
			}
		});
		
		//RootPanel.get().add(m);
		
		final CoreCollapse<Widget> cl = new CoreCollapse<Widget>();
		cl.add(pInput);
		PaperToggleButton clToggle = new PaperToggleButton();
		clToggle.addValueChangeHandler(new ValueChangeHandler<Boolean>() {

			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				cl.toggle();
			}
		});
		
//		RootPanel.get().add(clToggle);
//		RootPanel.get().add(cl);
		CoreHeaderPanel hPanel = new CoreHeaderPanel(paperTabs, createDummyWidget("red"));
		hPanel.setContentFitWindowSize(true);
		hPanel.setMode(HeaderMode.WATERFULL_TALL);
		hPanel.setTallClass("medium-tall");
		final CoreDrawerPanel drawer = new CoreDrawerPanel(createDummyWidget("blue"), hPanel);
		
		icon.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				drawer.toggleDrawer();
			}
		});
		
		//RootPanel.get().add(drawer);
		
		
		CoreScaffold appS = new CoreScaffold(new CoreHeaderPanel(toolBar, createDummyWidget("blue")), createDummyWidget("red"));
		appS.addTool(createDummyWidget("green"));
		

	//	RootPanel.get().add(appS);
		
		PaperInputDecorator inputD = new PaperInputDecorator(new PasswordTextBox());
		inputD.setLabel("Password");
		inputD.setFloatingLabel(true);
		
		final PaperDialogActions pDialog = new PaperDialogActions();
		//pDialog.setPixelSize(300, 300);
		pDialog.setLayered(false);
		pDialog.setAutoCloseDisabled(true);
		pDialog.setBackdrop(true);
		pDialog.setConstrainToCenter(true);
		pDialog.setTransition("core-transition-center");
		PaperSpiner s = new PaperSpiner();
		s.setActive(true);
		pDialog.add(s);
		pDialog.add(inputD);
//		pDialog.setHeading("Enter");
//		pDialog.setStyleName("scrolling");
		PaperButton okButton = new PaperButton();
		okButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				pDialog.close();
			}
		});
		okButton.setLabel("Ok");
		pDialog.addButtonAffirmative(okButton);
		pDialog.setCloseSelector("");
		
		PaperButton b = new PaperButton();
		b.setLabel("Dialog");
		b.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				pDialog.open();		
			}
		});
	    RootPanel.get().add(b);
	    RootPanel.get().add(pDialog);
		
		CoreDropdown<CoreItem> cDropDown = new CoreDropdown<>();
		CoreItem cItem = new CoreItem();
		cItem.setLabel("Blagoja");
		cDropDown.add(cItem);
		
		cItem = new CoreItem();
		cItem.setLabel("Goran");
		cDropDown.add(cItem);
		
		cItem = new CoreItem();
		cItem.setLabel("Kate"); 
		cDropDown.add(cItem);
		
		cItem = new CoreItem();
		cItem.setLabel("Bic");
		cDropDown.add(cItem);
		
		CoreDropdownMenu<CoreItem> cDropMenu = new CoreDropdownMenu<>();
		cDropMenu.setDropDown(cDropDown);
		
	//	RootPanel.get().add(cDropMenu);
		
		
		PaperDropdown pDropDown = new PaperDropdown();
		PaperItem pItem = new PaperItem();
		pItem.setLabel("Blagoja");
		pDropDown.add(pItem);
		
		pItem = new PaperItem();
		pItem.setLabel("Goran");
		pDropDown.add(pItem);
		
		pItem = new PaperItem();
		pItem.setLabel("Kate"); 
		pDropDown.add(pItem);
		
		pItem = new PaperItem();
		CoreIcon cI = new CoreIcon();
		cI.setIcon("content-copy");
		pItem.add(cI);
		pItem.setLabel("Bic");
		pDropDown.add(pItem);
		
	//	pDropDown.setValue(pItem);
		pDropDown.setHalign(HorizontalAlignment.LEFT);
		pDropDown.setValign(VerticalAlignment.TOP);
		
		
		PaperDropdownMenu pDropMenu = new PaperDropdownMenu();
		pDropMenu.setDropDown(pDropDown);
		pDropMenu.setLabel("Izberi ime");
		
		//RootPanel.get().add(pDropMenu);
		
		PaperMenuButton pManuButton = new PaperMenuButton();
		pManuButton.setDropDown(pDropDown);
		
	//	RootPanel.get().add(pManuButton);
		pDropDown.addValueChangeHandler(new ValueChangeHandler<PaperItem>() {

			@Override
			public void onValueChange(ValueChangeEvent<PaperItem> event) {
				GWT.log(event.toDebugString());	
				GWT.log(event.getValue().getLabel());
			}
		});
	}

	private Widget createDummyWidget(String bgColor){
		Widget w = new Widget(){
			{setElement(DOM.createDiv());}
			
		};
		w.getElement().getStyle().setBackgroundColor(bgColor);
//		w.getElement().getStyle().setWidth(100, Unit.PCT);
//		w.getElement().getStyle().setHeight(100, Unit.PCT);
		//w.getElement().getStyle().setMargin(20, Unit.PCT);
		return w;
	}
		
	private void add20Tabs(PaperTabs tabs){
		
		for (int i=0; i<20; i++){
			tabs.add("Tab " + (i+1));
		}
	}
}
