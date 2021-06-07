//project/phoebus-master/app/display/model/src/main/java/org/csstudio/display/builder/model/properties/WritePV1ActionInfo.java

/*******************************************************************************
 * Copyright (c) 2015-2016 Oak Ridge National Laboratory.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.csstudio.display.builder.model.properties;

/** Information about an action that writes a PV
 *
 *  @author Kay Kasemir
 */
@SuppressWarnings("nls")
public class WritePV1ActionInfo extends ActionInfo
{
    private final String pv1;
    private final String value1;

    /** @param description Action description
     *  @param pv1 PV1 name
     *  @param value1 Value1 to write
     */
    public WritePV1ActionInfo(final String description, final String pv1, final String value1)
    {
        super(description);
        this.pv1 = pv1;
        this.value1 = value1;
    }

    @Override
    public ActionType getType()
    {
        return ActionType.WRITE_PV1;
    }

    /** @return PV name */
    public String getPV1()
    {
        return pv1;
    }

    /** @return Value to write */
    public String getValue1()
    {
        return value1;
    }

    @Override
    public String toString()
    {
        if (getDescription().isEmpty())
            return "Write " + value1 + " to " + pv1;
        else
            return getDescription();
    }
}
