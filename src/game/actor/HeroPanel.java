package game.actor;

import game.Activatable;
import game.GamePanel;
import game.HeroHudPanel;
import game.MinionPlayedCallback;

import javax.swing.*;
import java.awt.*;

public abstract class HeroPanel extends GamePanel implements Activatable
{
    protected final MinionPlayedCallback minionPlayedCallback;
    private final HeroHudPanel heroHudPanel;

    protected HeroPanel(final Hero hero, final MinionPlayedCallback minionPlayedCallback)
    {
        super(new BorderLayout());

        this.minionPlayedCallback = minionPlayedCallback;

        heroHudPanel = new HeroHudPanel(hero);

        setupFrame();
    }

    private void setupFrame()
    {
        add(heroHudPanel, BorderLayout.NORTH);
    }

    @Override
    public void render()
    {
        heroHudPanel.render();
    }

    @Override
    public void setActive()
    {
        setBorder(BorderFactory.createLineBorder(Color.GREEN, 2, true));
    }

    @Override
    public void setInactive()
    {
        setBorder(BorderFactory.createLineBorder(Color.GRAY, 2, true));
    }
}
