package com.swinghearthstone.model.game;

import com.swinghearthstone.model.game.minion.Minion;

import java.util.Optional;
import java.util.Stack;

public class Deck
{
    private final Stack<Minion> minions;

    public Deck(final Stack<Minion> minions)
    {
        this.minions = minions;
    }

    public Optional<Minion> draw()
    {
        if (minions.isEmpty())
        {
            return Optional.empty();
        }

        return Optional.of(minions.pop());
    }

    public void insert(final Minion minion)
    {
        minions.push(minion);
    }

    public int size()
    {
        return minions.size();
    }
}
