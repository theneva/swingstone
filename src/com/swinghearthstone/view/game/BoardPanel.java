package com.swinghearthstone.view.game;

import com.swinghearthstone.model.game.hero.Opponent;
import com.swinghearthstone.model.game.hero.Player;
import com.swinghearthstone.util.Callback;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends GamePanel
{
    public BoardPanel(final Player player, final Opponent opponent, final Callback nextTurnCallback)
    {
        final JButton nextTurnButton = new JButton("Next turn");
        nextTurnButton.addActionListener(e -> nextTurnCallback.apply());
        add(nextTurnButton, BorderLayout.EAST);
    }

    @Override
    public void render()
    {

    }
}
