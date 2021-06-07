//project/phoebus-master/app/display/model/src/main/java/org/csstudio/display/builder/model/widgets/WriteReadPV.java

/*******************************************************************************
 * Copyright (c) 2015-2016 Oak Ridge National Laboratory.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.csstudio.display.builder.model.widgets;

import static org.csstudio.display.builder.model.properties.CommonWidgetProperties.runtimePropPVWritable;
//NEW
import static org.csstudio.display.builder.model.properties.CommonWidgetProperties.runtimePropPV1Writable;
import static org.csstudio.display.builder.model.properties.CommonWidgetProperties.propBorderAlarmSensitive;
import static org.csstudio.display.builder.model.properties.CommonWidgetProperties.propHeight;
import static org.csstudio.display.builder.model.properties.CommonWidgetProperties.propWidth;
import static org.csstudio.display.builder.model.properties.CommonWidgetProperties.propX;
import static org.csstudio.display.builder.model.properties.CommonWidgetProperties.propY;

import java.util.List;

import org.csstudio.display.builder.model.Version;
import org.csstudio.display.builder.model.Widget;
import org.csstudio.display.builder.model.WidgetProperty;
import org.csstudio.display.builder.model.persist.ModelReader;
import org.csstudio.display.builder.model.properties.WidgetColor;
import org.csstudio.display.builder.model.properties.WidgetFont;
import org.phoebus.framework.persistence.XMLUtil;
import org.w3c.dom.Element;


/** Base class for BoolButtonWidget1 that write to a primary PV and Read from Secondary PV1.
 *
 *  @author Kay Kasemir
 */
public class WriteReadPV extends PV1Widget
{
    private volatile WidgetProperty<Boolean> pv_writable;
    //NEW
    private volatile WidgetProperty<Boolean> pv1_writable;
    
    protected volatile WidgetProperty<WidgetFont> font;
    protected volatile WidgetProperty<WidgetColor> foreground;
    protected volatile WidgetProperty<WidgetColor> line_color;
    protected volatile WidgetProperty<Boolean> square;
    
    /** @param type Widget type. */
    public WriteReadPV(final String type)
    {
        super(type);
    }

    protected static void handle_legacy_LED(final ModelReader model_reader, final Widget widget, final Version xml_version, final Element xml)
            throws Exception
	{
	    final BaseLEDWidget led = (BaseLEDWidget) widget;
	    if (xml_version.getMajor() < 2)
	    {   // Border was included in the size,
	        // so with the same nominal size an "alarm sensitive" LED
	        // was smaller than a non-a.s. LED */
	        if (widget.getProperty(propBorderAlarmSensitive).getValue())
	        {
	            // Use old border width, defaulting to 2 for style 'None'
	            final int style = Integer.parseInt(XMLUtil.getChildString(xml, "border_style").orElse("0"));
	            final int border = style <= 0
	                             ? 2
	                             : Integer.parseInt(XMLUtil.getChildString(xml, "border_width").orElse("1"));
	
	            // Border goes around the widget,
	            // so X, Y get adjusted by 1*border
	            // and Width, Height by 2*border.
	            WidgetProperty<Integer> prop = led.getProperty(propX);
	            prop.setValue(prop.getValue() + border);
	            prop = led.getProperty(propY);
	            prop.setValue(prop.getValue() + border);
	            prop = led.getProperty(propWidth);
	            prop.setValue(prop.getValue() - 2*border);
	            prop = led.getProperty(propHeight);
	            prop.setValue(prop.getValue() - 2*border);
	        }
	
	        // Legacy used "bulb_border_color" instead of "line_color"
	        final Element element = XMLUtil.getChildElement(xml, "bulb_border_color");
	        if (element != null)
	            led.propLineColor().readFromXML(model_reader, element);
	
	        // Legacy used "square_led" instead of "square"
	        led.propSquare().setValue(XMLUtil.getChildBoolean(xml, "square_led").orElse(false));
	    }
	}
    
    /** @param type Widget type.
     *  @param default_width Default widget width.
     *  @param default_height Default widget height.
     */
    public WriteReadPV(final String type, final int default_width, final int default_height)
    {
        super(type, default_width, default_height);
    }

    @Override
    protected void defineProperties (final List<WidgetProperty<?>> properties )
    {
        super.defineProperties(properties);
        // Start 'true' for editor to enable widgets.
        // Runtime will set false when PVs are not writable.
        properties.add(pv_writable = runtimePropPVWritable.createProperty(this, true));
        
        //NEW
        properties.add(pv1_writable = runtimePropPV1Writable.createProperty(this, true));

    }

    /** @return 'pv_writable' property */
    public final WidgetProperty<Boolean> runtimePropPVWritable()
    {
        return pv_writable;
    }
    
    //NEW
    public final WidgetProperty<Boolean> runtimePropPV1Writable()
    {
        return pv1_writable;
    }
    
    /** @return 'font' property */
    public WidgetProperty<WidgetFont> propFont()
    {
        return font;
    }

    /** @return 'foreground' property*/
    public WidgetProperty<WidgetColor> propForegroundColor()
    {
        return foreground;
    }

    /** @return 'line_color' property */
    public WidgetProperty<WidgetColor> propLineColor()
    {
        return line_color;
    }

    /** @return 'square' property*/
    public WidgetProperty<Boolean> propSquare()
    {
        return square;
    }
}
