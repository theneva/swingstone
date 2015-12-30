package com.swinghearthstone.model.game.hero;

import com.swinghearthstone.model.game.minion.Minion;

import java.util.List;

public class Player extends Hero
{
    public Player(final int health, final Hand hand, final Deck deck, final List<Minion> minions)
    {
        super(health, hand, deck, minions);
    }
}
