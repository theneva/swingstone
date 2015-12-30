package com.swinghearthstone.model.game;

import com.swinghearthstone.model.game.minion.Minion;

@FunctionalInterface
public interface MinionPlayedCallback
{
    void apply(Minion minion);
}
