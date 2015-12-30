package com.swinghearthstone.view.game;

import com.swinghearthstone.model.game.MinionPlayedCallback;
import com.swinghearthstone.model.game.hero.Player;

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
