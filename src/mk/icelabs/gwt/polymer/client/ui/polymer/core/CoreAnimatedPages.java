package mk.icelabs.gwt.polymer.client.ui.polymer.core;

import java.util.Arrays;
import java.util.List;

import mk.icelabs.gwt.polymer.client.dom.polymer.core.CoreAnimatedPagesElement;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

public class CoreAnimatedPages extends CoreSelector<CoreSection>  {

	public static final String STYLE = "";

	public static enum Transitions {
		CrosFadeAll("cross-fade-all"), SlideFromRight("slide-from-right");

		private String trans;

		Transitions(String trans) {
			this.trans = trans;
		}

		static String calculateTransitions(List<Transitions> ts) {
			String r = "";
			for (Transitions t : ts)
				r += t.trans + " ";

			return r;
		}
	}

	public CoreAnimatedPages() {
		this(Document.get().createElement(CoreAnimatedPagesElement.TAG), STYLE);
	}

	public CoreAnimatedPages(Element element, String styleName) {
		super(element);
		if (styleName != null && !styleName.equalsIgnoreCase(STYLE)) {
			styleName = STYLE + " " + styleName;
		}
		setStyleName(styleName);
	}

	public void setTransition(Transitions t) {
		getElement().setTransitions(
				Transitions.calculateTransitions(Arrays.asList(t)));
	}

	
	@Override
	public CoreAnimatedPagesElement getElement() {
		return (CoreAnimatedPagesElement) super.getElement();
	}

	@Override
	protected CoreSection checkAdoptInstance(Widget child) {
		
		if (!(child instanceof CoreSection)) {
			CoreSection v = new CoreSection(child);
			GWT.log("Anim pages, checkAdoptInstance adopting with creation: "
					+ v.toString());
			return v;
		}

		return super.checkAdoptInstance(child);
	}

}
