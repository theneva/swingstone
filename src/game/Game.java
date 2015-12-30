package game;

import game.actor.Hero;
import game.actor.Minion;
import game.actor.Opponent;
import game.actor.Player;

public class Game
{
    public final Player player;
    public final Opponent opponent;

    private Hero activeHero;

    public Game(final Player player, final Opponent opponent)
    {
        this.player = player;
        this.opponent = opponent;
    }

    public void start()
    {
        // TODO randomly select a player to start
        this.activeHero = player;
    }

    public void nextTurn()
    {
        if (activeHero == player)
        {
            System.out.println("Opponent's turn");
            activeHero = opponent;
        }
        else
        {
            System.out.println("Player's turn");
            activeHero = player;
        }
    }

    public void playMinion(final Minion minion)
    {
        activeHero.hand.play(minion);
        activeHero.minions.add(minion);
    }

    public Hero getActiveHero()
    {
        return activeHero;
    }
}
