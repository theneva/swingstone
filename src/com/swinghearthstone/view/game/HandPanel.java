package com.swinghearthstone.view.game;

import com.swinghearthstone.model.game.Hand;
import com.swinghearthstone.model.game.MinionPlayedCallback;

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
                .map(minion -> new MinionInHandPanel(minion, minionPlayedCallback))
                .peek(panel -> {
                    if (active)
                    {
                        panel.setActive();
                    }
                    else
                    {
                        panel.setInactive();
                    }
                })
                .peek(MinionInHandPanel::render)
                .forEach(this::add);

        revalidate();
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
