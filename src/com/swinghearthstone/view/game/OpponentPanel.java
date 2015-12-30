package com.swinghearthstone.view.game;

import com.swinghearthstone.model.game.MinionPlayedCallback;
import com.swinghearthstone.model.game.hero.Opponent;

public class OpponentPanel extends HeroPanel
{
    public OpponentPanel(final Opponent opponent, final MinionPlayedCallback minionPlayedCallback)
    {
        super(opponent, minionPlayedCallback);
    }
}
