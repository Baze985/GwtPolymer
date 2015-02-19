package mk.icelabs.gwt.polymer.client.ui.polymer.paper;

import mk.icelabs.gwt.polymer.client.dom.polymer.paper.PaperRadioGroupElement;
import mk.icelabs.gwt.polymer.client.ui.polymer.core.CoreSelector;

import com.google.gwt.dom.client.Document;

public class PaperRadioGroup extends CoreSelector<PaperRadioButton> {

	public PaperRadioGroup(){
		super(Document.get().createElement(PaperRadioGroupElement.TAG));
	}

	@Override
	public PaperRadioGroupElement getElement() {
		return super.getElement().cast();
	}
	
//	@Override
//	protected void onSelectorChanged() {
//		// TODO Auto-generated method stub
//		super.onSelectorChanged();
//	}
//
//	@Override
//	protected void ensureDomSelectorHandlers() {
//
//		addClickHandler(new ClickHandler() {
//			@Override
//			public void onClick(ClickEvent event) {
//
//				Scheduler.get().scheduleFixedDelay(new Scheduler.RepeatingCommand() {
//					@Override
//					public boolean execute() {
//						int selectedOpt = -1;
//						NodeList<Element> items = getElement().getElementsByTagName(PaperRadioButtonElement.TAG);
//
//						for(int k = 0, len = items.getLength(); k < len; k++){
//							PaperRadioButtonElement item = (PaperRadioButtonElement) items.getItem(k);
//							if(item.hasAttribute("checked")){
//								selectedOpt = k;
//								break;
//							}
//						}
//
//						if(selectedOpt >= 0){
//							setValue( (PaperRadioButton) getChildren().get(selectedOpt), true );
//							ValueChangeEvent.fire(PaperRadioGroup.this, getValue());
//						}
//
//						return false;
//					}
//				}, 500);
//
//			}
//		});
//	}
//
//	@Override
//	protected void updateSelection() {
//		PaperRadioButton value = getValue();
//
//		if(value != null){
////			getPaperElement().setSelected(null);
////			PaperRadioButtonElement selectedOpt = null;
////			NodeList<Element> items = getPaperElement().getElementsByTagName(PaperRadioButtonElement.TAG);
////
////			for(int k = 0, len = items.getLength(); k < len; k++){
////				PaperRadioButtonElement item = (PaperRadioButtonElement) items.getItem(k);
////				item.setChecked(false);
////				if(value.equals(item.getName())){
////					selectedOpt = item;
////				}
////			}
//
//			getElement().setSelected(getSelectedIndex() + "");
//			value.setValue(true);
//			
//		}
//	}

}
