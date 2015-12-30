package game;

import game.actor.HeroPanel;
import game.actor.Player;

public class PlayerPanel extends HeroPanel
{
    private HandPanel handPanel;

    public PlayerPanel(final Player player, final MinionPlayedCallback minionPlayedCallback)
    {
        super(player, minionPlayedCallback);

        handPanel = new HandPanel(player.hand, minionPlayedCallback);
        add(handPanel);
    }

    @Override
    public void render()
    {
        super.render();
        handPanel.render();
    }

    @Override
    public void setActive()
    {
        super.setActive();
        handPanel.setActive();
    }

    @Override
    public void setInactive()
    {
        super.setInactive();
        handPanel.setInactive();
    }
}
