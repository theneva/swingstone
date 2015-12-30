package com.swinghearthstone;

import com.swinghearthstone.model.game.Game;
import com.swinghearthstone.model.game.MinionPlayedCallback;
import com.swinghearthstone.util.Callback;
import com.swinghearthstone.view.game.GameView;

public interface ViewFactory
{
    GameView createGameView(
            Game game,
            Callback nextTurnCallback,
            MinionPlayedCallback minionPlayedCallback
    );
}
