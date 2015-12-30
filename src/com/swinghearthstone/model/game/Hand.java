package com.swinghearthstone.model.game;

import com.swinghearthstone.model.game.minion.Minion;

import java.util.List;

public class Hand
{
    public final List<Minion> minions;

    public Hand(final List<Minion> minions)
    {
        this.minions = minions;
    }

    public void play(final Minion minion)
    {
        minions.remove(minion);
    }
}
