package game;

import game.actor.Opponent;
import game.actor.Player;

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
