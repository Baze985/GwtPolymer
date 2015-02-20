package mk.icelabs.gwt.polymer.client.ui.widgets;


import java.util.Iterator;

import com.google.gwt.user.client.ui.IsWidget;


/**
 * Abstract base for components that can contain child widgets and public crud-able.
 */
public abstract class ContainerExt<T extends IsWidget> extends Container<T> {

	@Override
	public void insert(T w, int beforeIndex) {
		super.insert(w, beforeIndex);
	}

 
	@Override
	public void add(T child) {
		super.add(child);
	}
	
	public T getWidget(int index) {
		return super.getWidget(index);
	}
	
	@Override
	public int getWidgetCount() {
		return super.getWidgetCount();
	}
	
	@Override
	public int getWidgetIndex(IsWidget child) {
		return super.getWidgetIndex(child);
	}
	
	
	@Override
	public Iterator<T> iterator() {
		return super.iterator();
	}
	
	@Override
	public boolean remove(int index) {
		return super.remove(index);
	}
	
	@Override
	public boolean remove(IsWidget child) {
		return super.remove(child);
	}
	
	@Override
	public void clear() {
		super.clear();
	}
}
