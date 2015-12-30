package com.swinghearthstone.view.game;

import com.swinghearthstone.model.game.minion.Minion;

import javax.swing.*;
import java.awt.*;

public class MinionOnBoardPanel extends MinionPanel
{
    public MinionOnBoardPanel(final Minion minion)
    {
        super(minion);
    }

    @Override
    public void setActive()
    {
        setBorder(BorderFactory.createLineBorder(Color.GREEN));
    }

    @Override
    public void setInactive()
    {
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
    }
}
