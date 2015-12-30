package com.swinghearthstone;

import com.swinghearthstone.presenter.game.GamePresenter;
import com.swinghearthstone.view.SwingViewFactory;

public class GameStarter
{
    public static void main(String[] args)
    {
        final MinionRepository minionRepository = new MinionRepository();

        final GamePresenter gamePresenter = new GamePresenter(
                minionRepository,
                new SwingViewFactory()
        );

        gamePresenter.startGame();
    }
}
