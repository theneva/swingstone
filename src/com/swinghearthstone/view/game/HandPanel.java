package com.swinghearthstone.view.game;

import com.swinghearthstone.model.game.Hand;
import com.swinghearthstone.model.game.MinionPlayedCallback;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class HandPanel extends GamePanel implements Activatable
{
    private final List<MinionPanel> minionPanels;

    public HandPanel(final Hand hand, final MinionPlayedCallback minionPlayedCallback)
    {
        super(new GridLayout(1, 10));

        // TODO support dynamic max hand size
        this.minionPanels = hand.minions.stream()
                .map(minion -> new MinionPanel(minion, minionPlayedCallback))
                .peek(panel -> panel.setBorder(BorderFactory.createLineBorder(Color.RED, 2, true)))
                .peek(this::add)
                .collect(Collectors.toList());
    }

    @Override
    public void render()
    {
        minionPanels.forEach(MinionPanel::render);
    }

    @Override
    public void setActive()
    {
        minionPanels.forEach(MinionPanel::setActive);
    }

    @Override
    public void setInactive()
    {
        minionPanels.forEach(MinionPanel::setInactive);
    }
}
