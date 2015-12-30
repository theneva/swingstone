package com.swinghearthstone.model.game;

import com.swinghearthstone.model.game.minion.Minion;

public interface MinionPlayedCallback
{
    void apply(Minion minion);
}
