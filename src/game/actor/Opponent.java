package game.actor;

import game.Deck;
import game.Hand;

import java.util.List;

public class Opponent extends Hero
{
    public Opponent(final int health, final Hand hand, final Deck deck, final List<Minion> minions)
    {
        super(health, hand, deck, minions);
    }
}
