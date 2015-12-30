package com.swinghearthstone.view.game;

import com.swinghearthstone.model.game.MinionPlayedCallback;
import com.swinghearthstone.model.game.minion.Minion;

import javax.swing.*;
import java.awt.*;

public class MinionInHandPanel extends MinionPanel
{
    private final JButton playButton = new JButton("Play");

    public MinionInHandPanel(final Minion minion, final MinionPlayedCallback minionPlayedCallback)
    {
        super(minion);

        playButton.addActionListener(e -> minionPlayedCallback.apply(minion));
        add(playButton, BorderLayout.SOUTH);
    }

    @Override
    public void setActive()
    {
        setBorder(BorderFactory.createLineBorder(Color.GREEN));
        playButton.setEnabled(true);
    }

    @Override
    public void setInactive()
    {
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        playButton.setEnabled(false);
    }
}
