/**
 * Sencha GXT 3.1.1 - Sencha for GWT
 * Copyright(c) 2007-2014, Sencha, Inc.
 * licensing@sencha.com
 *
 * http://www.sencha.com/products/gxt/license/
 */
package mk.icelabs.gwt.polymer.client.event;

import mk.icelabs.gwt.polymer.client.event.AddEvent.AddHandler;
import mk.icelabs.gwt.polymer.client.event.AddEvent.HasAddHandlers;
import mk.icelabs.gwt.polymer.client.event.BeforeAddEvent.BeforeAddHandler;
import mk.icelabs.gwt.polymer.client.event.BeforeAddEvent.HasBeforeAddHandlers;
import mk.icelabs.gwt.polymer.client.event.BeforeRemoveEvent.BeforeRemoveHandler;
import mk.icelabs.gwt.polymer.client.event.BeforeRemoveEvent.HasBeforeRemoveHandlers;
import mk.icelabs.gwt.polymer.client.event.RemoveEvent.HasRemoveHandlers;
import mk.icelabs.gwt.polymer.client.event.RemoveEvent.RemoveHandler;

import com.google.gwt.event.shared.HandlerRegistration;


/**
 * Aggregating handler interface for:
 * 
 * <dl>
 * <dd>{@link BeforeAddEvent}</b></dd>
 * <dd>{@link AddEvent}</b></dd>
 * <dd>{@link BeforeRemoveEvent}</b></dd>
 * <dd>{@link RemoveEvent}</b></dd>
 * </dl>
 */
public interface ContainerHandler extends BeforeAddHandler, AddHandler, BeforeRemoveHandler,
    RemoveHandler {

  /**
   * A widget that implements this interface is a public source of
   * {@link BeforeAddEvent}, {@link AddEvent}, {@link BeforeRemoveEvent},
   * {@link RemoveEvent} events.
   */
  public interface HasContainerHandlers extends HasBeforeAddHandlers,
          HasAddHandlers, HasBeforeRemoveHandlers, HasRemoveHandlers {

      /**
       * Adds a {@link ContainerHandler} handler for {@link BeforeAddEvent} ,
       * {@link AddEvent}, {@link BeforeRemoveEvent}, {@link RemoveEvent} events.
       * 
       * @param handler
       *            the handler
       * @return the registration for the event
       */
      HandlerRegistration addContainerHandler(ContainerHandler handler);
  }
}
