/*
 * Jitsi, the OpenSource Java VoIP and Instant Messaging client.
 *
 * Copyright @ 2015 Atlassian Pty Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.java.sip.communicator.impl.gui.lookandfeel;

import java.awt.*;

import javax.swing.*;
import javax.swing.plaf.*;
import javax.swing.plaf.basic.*;

import net.java.sip.communicator.plugin.desktoputil.*;

/**
 * The SIPCommCheckBoxMenuItemUI implementation.
 *
 * @author Yana Stamcheva
 */
public class SIPCommCheckBoxMenuItemUI
    extends BasicCheckBoxMenuItemUI {

    /**
     * Creates a new SIPCommCheckBoxMenuItemUI instance.
     */
    public static ComponentUI createUI(JComponent x) {
        return new SIPCommCheckBoxMenuItemUI();
    }

    /**
     * Draws the background of the menu item.
     *
     * @param g the paint graphics
     * @param menuItem menu item to be painted
     * @param bgColor selection background color
     * @since 1.4
     */
    @Override
    protected void paintBackground(
        Graphics g, JMenuItem menuItem, Color bgColor)
    {
        super.paintBackground(g, menuItem, bgColor);

        g = g.create();
        try
        {
            internalPaintBackground(g, menuItem, bgColor);
        }
        finally
        {
            g.dispose();
        }
    }

    private void internalPaintBackground(
        Graphics g, JMenuItem menuItem, Color bgColor)
    {
        AntialiasingManager.activateAntialiasing(g);

        ButtonModel model = menuItem.getModel();
        Color oldColor = g.getColor();

        int menuWidth = menuItem.getWidth();
        int menuHeight = menuItem.getHeight();

        if (menuItem.isOpaque()) {
            if (model.isArmed()
                || (menuItem instanceof JMenu && model.isSelected())) {
                g.setColor(bgColor);
                g.fillRoundRect(0, 0, menuWidth, menuHeight, 5, 5);

                g.setColor(SIPCommLookAndFeel.getControlDarkShadow());
                g.drawRoundRect(0, 0, menuWidth - 1, menuHeight - 1, 5, 5);
            }
            else {
                g.setColor(menuItem.getBackground());
                g.fillRoundRect(0, 0, menuWidth, menuHeight, 5, 5);
            }
            g.setColor(oldColor);
        }
    }
}
