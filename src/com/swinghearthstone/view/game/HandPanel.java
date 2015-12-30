package com.swinghearthstone.view.game;

import com.swinghearthstone.model.game.MinionPlayedCallback;
import com.swinghearthstone.model.game.hero.Hand;
import com.swinghearthstone.model.game.minion.Minion;
import com.swinghearthstone.view.util.MouseClickListener;

import java.awt.*;

public class HandPanel extends GamePanel implements Activatable
{
    private final Hand hand;
    private final MinionPlayedCallback minionPlayedCallback;
    private boolean active = true;

    public HandPanel(final Hand hand, final MinionPlayedCallback minionPlayedCallback)
    {
        super(new GridLayout(1, 10));

        this.hand = hand;
        this.minionPlayedCallback = minionPlayedCallback;
    }

    @Override
    public void render()
    {
        removeAll();

        hand.minions.stream()
                .map(this::createMinionPanelWithMouseClickListener)
                .peek(this::toggleActive)
                .peek(MinionPanel::render)
                .forEach(this::add);

        revalidate();
    }

    private MinionPanel createMinionPanelWithMouseClickListener(final Minion minion)
    {
        final MinionPanel panel = new MinionPanel(minion);
        panel.addMouseListener((MouseClickListener) e -> minionPlayedCallback.apply(minion));
        return panel;
    }

    private void toggleActive(final MinionPanel panel)
    {
        if (active)
        {
            panel.setActive();
        }
        else
        {
            panel.setInactive();
        }
    }

    @Override
    public void setActive()
    {
        active = true;
    }

    @Override
    public void setInactive()
    {
        active = false;
    }
}
