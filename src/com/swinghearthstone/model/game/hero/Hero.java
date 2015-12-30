package com.swinghearthstone.model.game.hero;

import com.swinghearthstone.model.game.Deck;
import com.swinghearthstone.model.game.Hand;
import com.swinghearthstone.model.game.minion.Minion;

import java.util.List;

public abstract class Hero
{
    public final Hand hand;
    public final List<Minion> minions;
    public final Deck deck;
    public int health;

    public Hero(final int health, final Hand hand, final Deck deck, final List<Minion> minions)
    {
        this.health = health;
        this.hand = hand;
        this.deck = deck;
        this.minions = minions;
    }

    public void playMinion(final Minion minion)
    {
        this.hand.play(minion);
        this.minions.add(minion);
    }

    public void takeDamage(final int damage)
    {
        health -= damage;
    }
}
