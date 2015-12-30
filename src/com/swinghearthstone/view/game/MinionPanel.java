package com.swinghearthstone.view.game;

import com.swinghearthstone.model.game.minion.Minion;

import javax.swing.*;
import java.awt.*;

public class MinionPanel extends GamePanel implements Activatable
{
    private final Minion minion;

    private final JLabel nameIndicator = new JLabel();
    private final JLabel costIndicator = new JLabel();
    private final JLabel attackIndicator = new JLabel();
    private final JLabel healthIndicator = new JLabel();

    public MinionPanel(final Minion minion)
    {
        super(new BorderLayout());

        this.minion = minion;

        final JPanel minionDataPanel = new JPanel(new GridLayout(4, 2));

        minionDataPanel.add(new JLabel("Name"));
        minionDataPanel.add(nameIndicator);

        minionDataPanel.add(new JLabel("Cost"));
        minionDataPanel.add(costIndicator);

        minionDataPanel.add(new JLabel("Attack"));
        minionDataPanel.add(attackIndicator);

        minionDataPanel.add(new JLabel("Health"));
        minionDataPanel.add(healthIndicator);

        add(minionDataPanel);
    }

    @Override
    public void render()
    {
        nameIndicator.setText("" + minion.name);
        costIndicator.setText("" + minion.cost);
        attackIndicator.setText("" + minion.attack);
        healthIndicator.setText("" + minion.health);
    }

    @Override
    public void setActive()
    {
        setBorder(BorderFactory.createLineBorder(Color.GREEN));
    }

    @Override
    public void setInactive()
    {
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
    }
}
