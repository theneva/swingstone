package com.swinghearthstone.view.game;

import com.swinghearthstone.model.game.minion.Minion;

import java.awt.*;
import java.util.List;

public class MinionBoardPanel extends GamePanel
{
    private static final int MINION_LIMIT = 5;

    private final List<Minion> minions;

    public MinionBoardPanel(final List<Minion> minions)
    {
        super(new GridLayout(1, MINION_LIMIT));

        this.minions = minions;
    }

    @Override
    public void render()
    {
        removeAll();

        minions.stream()
                .map(MinionPanel::new)
                .peek(MinionPanel::setActive)
                .peek(MinionPanel::render)
                .forEach(this::add);

        revalidate();
    }
}
