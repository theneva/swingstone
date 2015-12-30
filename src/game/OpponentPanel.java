package game;

import game.actor.HeroPanel;
import game.actor.Opponent;

public class OpponentPanel extends HeroPanel
{
    public OpponentPanel(final Opponent opponent, final MinionPlayedCallback minionPlayedCallback)
    {
        super(opponent, minionPlayedCallback);
    }
}
