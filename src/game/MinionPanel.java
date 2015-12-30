package game;

import game.actor.Minion;

import javax.swing.*;
import java.awt.*;

public class MinionPanel extends GamePanel implements Activatable
{
    private final Minion minion;

    private final JLabel nameIndicator = new JLabel();
    private final JLabel costIndicator = new JLabel();
    private final JLabel attackIndicator = new JLabel();
    private final JLabel healthIndicator = new JLabel();

    private final JButton playButton = new JButton("Play");

    public MinionPanel(final Minion minion, final MinionPlayedCallback minionPlayedCallback)
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

        playButton.addActionListener(e -> minionPlayedCallback.apply(minion));

        add(minionDataPanel);
        add(playButton, BorderLayout.SOUTH);
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
        playButton.setEnabled(true);
    }

    @Override
    public void setInactive()
    {
        playButton.setEnabled(false);
    }
}
