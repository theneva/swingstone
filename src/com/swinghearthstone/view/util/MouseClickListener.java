package com.swinghearthstone.view.util;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Provides default implementations for all {@code }MouseListener} methods
 * except {@code mouseClicked(MouseEvent)}.
 */
@FunctionalInterface
public interface MouseClickListener extends MouseListener
{
    @Override
    default void mousePressed(MouseEvent e)
    {
    }

    @Override
    default void mouseReleased(MouseEvent e)
    {
    }

    @Override
    default void mouseEntered(MouseEvent e)
    {
    }

    @Override
    default void mouseExited(MouseEvent e)
    {
    }
}
