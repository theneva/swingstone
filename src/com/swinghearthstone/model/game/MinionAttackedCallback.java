package com.swinghearthstone.model.game;

import com.swinghearthstone.model.game.minion.Minion;

public interface MinionAttackedCallback
{
    void apply(Minion attacker);
}
