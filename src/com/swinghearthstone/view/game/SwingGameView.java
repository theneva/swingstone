package com.swinghearthstone.view.game;

import com.swinghearthstone.model.game.Game;
import com.swinghearthstone.model.game.MinionPlayedCallback;
import com.swinghearthstone.model.game.hero.Player;
import com.swinghearthstone.model.game.minion.Minion;
import com.swinghearthstone.util.Callback;

import javax.swing.*;
import java.awt.*;

public class SwingGameView extends JFrame implements GameView
{
    private final Game game;
    private final Callback nextTurnCallback;
    private final MinionPlayedCallback minionPlayedCallback;

    private final PlayerPanel playerPanel;
    private final OpponentPanel opponentPanel;
    private final BoardPanel boardPanel;

    public SwingGameView(final Game game, final Callback nextTurnCallback, final MinionPlayedCallback minionPlayedCallback)
    {
        this.game = game;

        this.nextTurnCallback = nextTurnCallback;
        this.minionPlayedCallback = minionPlayedCallback;

        this.opponentPanel = new OpponentPanel(game.opponent, this::triggerMinionPlayed);
        this.boardPanel = new BoardPanel(game.player, game.opponent, this::triggerNextTurn);
        this.playerPanel = new PlayerPanel(game.player, this::triggerMinionPlayed);

        setupFrame();
    }

    private void setupFrame()
    {
        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        add(opponentPanel, BorderLayout.NORTH);
        add(boardPanel);
        add(playerPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void start()
    {
        resetListeners();
    }

    private void triggerNextTurn()
    {
        System.out.println("triggerNextTurn");
        nextTurnCallback.apply();
        resetListeners();
    }

    private void triggerMinionPlayed(final Minion minion)
    {
        System.out.println("triggerMinionPlayed");
        minionPlayedCallback.apply(minion);
    }

    private void resetListeners()
    {
        if (game.getActiveHero() instanceof Player)
        {
            opponentPanel.setInactive();
            playerPanel.setActive();
        }
        else
        {
            playerPanel.setInactive();
            opponentPanel.setActive();
        }
    }

    @Override
    public void render()
    {
        playerPanel.render();
        opponentPanel.render();
        boardPanel.render();
    }
}
