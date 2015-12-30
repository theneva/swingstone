package com.swinghearthstone.view.game;

import com.swinghearthstone.model.game.MinionAttackedHeroCallback;
import com.swinghearthstone.model.game.hero.Opponent;
import com.swinghearthstone.model.game.hero.Player;
import com.swinghearthstone.util.Callback;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends GamePanel
{
    private MinionBoardPanel playerMinionBoardPanel;
    private MinionBoardPanel opponentMinionBoardPanel;


    public BoardPanel(
            final Player player,
            final Opponent opponent,
            final Callback nextTurnCallback,
            final MinionAttackedHeroCallback minionAttackedHeroCallback
    )
    {
        final JPanel minionBoardContainer = createMinionBoardContainer(player, opponent, minionAttackedHeroCallback);
        add(minionBoardContainer);

        final JButton nextTurnButton = createNextTurnButton(nextTurnCallback);
        add(nextTurnButton, BorderLayout.SOUTH);
    }

    private JPanel createMinionBoardContainer(final Player player, final Opponent opponent, final MinionAttackedHeroCallback minionAttackedHeroCallback)
    {
        final JPanel minionBoardContainer = new JPanel(new GridLayout(2, 1));

        minionBoardContainer.setBackground(Color.YELLOW);

        this.opponentMinionBoardPanel = new MinionBoardPanel(
                opponent.minions,
                minion -> minionAttackedHeroCallback.apply(minion, player)
        );

        this.playerMinionBoardPanel = new MinionBoardPanel(
                player.minions,
                minion -> minionAttackedHeroCallback.apply(minion, opponent)
        );

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
