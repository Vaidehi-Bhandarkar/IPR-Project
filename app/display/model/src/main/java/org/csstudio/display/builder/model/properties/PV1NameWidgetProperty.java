/*******************************************************************************
 * Copyright (c) 2017 Oak Ridge National Laboratory.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.csstudio.display.builder.model.properties;

import org.csstudio.display.builder.model.Widget;
import org.csstudio.display.builder.model.WidgetPropertyDescriptor;

/** Widget property with PV1 Name as value.
 *
 *  <p>Basically just a string-based property,
 *  but class is used to identify the property as a PV1 name.
 *  Editor can use this to offer for example PV1 name lookup.
 *
 *  @author Kay Kasemir
 */
public class PV1NameWidgetProperty extends StringWidgetProperty
{
    /** Constructor
     *  @param descriptor Property descriptor
     *  @param widget Widget that holds the property and handles listeners
     *  @param default_value Default and initial value
     */
    public PV1NameWidgetProperty(
            final WidgetPropertyDescriptor<String> descriptor,
            final Widget widget,
            final String default_value)
    {
        super(descriptor, widget, default_value);
    }
}
