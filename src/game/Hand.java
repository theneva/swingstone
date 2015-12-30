package game;

import game.actor.Minion;

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
