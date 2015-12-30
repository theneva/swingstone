package game.actor;

import game.HeroHudPanel;
import game.MinionPlayedCallback;
import game.Renderable;

import javax.swing.*;
import java.awt.*;

public abstract class HeroPanel extends JPanel implements Renderable
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

    public void render()
    {
        heroHudPanel.render();
    }

    public void setActive()
    {
        setBorder(BorderFactory.createLineBorder(Color.GREEN, 2, true));
    }

    public void setInactive()
    {
        setBorder(BorderFactory.createLineBorder(Color.GRAY, 2, true));
    }
}
