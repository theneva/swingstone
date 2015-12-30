package com.swinghearthstone.view.game;

import com.swinghearthstone.model.game.MinionAttackedCallback;
import com.swinghearthstone.model.game.minion.Minion;
import com.swinghearthstone.view.util.MouseClickListener;

import java.awt.*;
import java.util.List;

public class MinionBoardPanel extends GamePanel
{
    private static final int MINION_LIMIT = 5;

    private final List<Minion> minions;
    private final MinionAttackedCallback minionAttackedCallback;

    public MinionBoardPanel(final List<Minion> minions, final MinionAttackedCallback minionAttackedCallback)
    {
        super(new GridLayout(1, MINION_LIMIT));

        this.minions = minions;
        this.minionAttackedCallback = minionAttackedCallback;
    }

    @Override
    public void render()
    {
        removeAll();

        minions.stream()
                .map(this::createMinionPanelWithMouseClickListener)
                .peek(MinionPanel::setActive)
                .peek(MinionPanel::render)
                .forEach(this::add);

        revalidate();
    }

    private MinionPanel createMinionPanelWithMouseClickListener(final Minion minion)
    {
        final MinionPanel panel = new MinionPanel(minion);
        panel.addMouseListener((MouseClickListener) e -> minionAttackedCallback.apply(minion));
        return panel;
    }
}
