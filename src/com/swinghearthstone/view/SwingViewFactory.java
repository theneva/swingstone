package com.swinghearthstone.view;

import com.swinghearthstone.model.game.Game;
import com.swinghearthstone.model.game.MinionAttackedHeroCallback;
import com.swinghearthstone.model.game.MinionPlayedCallback;
import com.swinghearthstone.util.Callback;
import com.swinghearthstone.view.game.GameView;
import com.swinghearthstone.view.game.SwingGameView;

public class SwingViewFactory implements ViewFactory
{
    @Override
    public GameView createGameView(
            final Game game,
            final Callback nextTurnCallback,
            final MinionPlayedCallback minionPlayedCallback,
            final MinionAttackedHeroCallback minionAttackedHeroCallback
    )
    {
        return new SwingGameView(game, nextTurnCallback, minionPlayedCallback, minionAttackedHeroCallback);
    }
}
