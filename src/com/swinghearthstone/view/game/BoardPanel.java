package com.swinghearthstone.view.game;

import com.swinghearthstone.model.game.hero.Opponent;
import com.swinghearthstone.model.game.hero.Player;
import com.swinghearthstone.util.Callback;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends GamePanel
{
    private MinionBoardPanel playerMinionBoardPanel;
    private MinionBoardPanel opponentMinionBoardPanel;

    public BoardPanel(final Player player, final Opponent opponent, final Callback nextTurnCallback)
    {
        final JPanel minionBoardContainer = createMinionBoardContainer(player, opponent);
        add(minionBoardContainer);

        final JButton nextTurnButton = createNextTurnButton(nextTurnCallback);
        add(nextTurnButton, BorderLayout.SOUTH);
    }

    private JPanel createMinionBoardContainer(final Player player, final Opponent opponent)
    {
        final JPanel minionBoardContainer = new JPanel(new GridLayout(2, 1));

        minionBoardContainer.setBackground(Color.YELLOW);

        this.opponentMinionBoardPanel = new MinionBoardPanel(opponent.minions);
        this.playerMinionBoardPanel = new MinionBoardPanel(player.minions);

        minionBoardContainer.add(opponentMinionBoardPanel);
        minionBoardContainer.add(playerMinionBoardPanel);

        return minionBoardContainer;
    }

    private JButton createNextTurnButton(final Callback nextTurnCallback)
    {
        final JButton nextTurnButton = new JButton("Next turn");
        nextTurnButton.addActionListener(e -> nextTurnCallback.apply());
        return nextTurnButton;
    }

    @Override
    public void render()
    {
        playerMinionBoardPanel.render();
        opponentMinionBoardPanel.render();
    }
}
