package game.actor;

import game.Deck;
import game.Hand;

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

    public void takeDamage(final int damage)
    {
        health -= damage;
    }
}
