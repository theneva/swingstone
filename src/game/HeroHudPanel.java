package game;

import game.actor.Hero;

import javax.swing.*;
import java.awt.*;

public class HeroHudPanel extends JPanel implements Renderable
{
    private final Hero hero;

    private final JLabel healthIndicator = new JLabel();
    private final JLabel cardsLeftIndicator = new JLabel();

    public HeroHudPanel(final Hero hero)
    {
        super(new GridLayout(2, 2));
        this.hero = hero;

        add(new JLabel("Health"));
        add(healthIndicator);

        add(new JLabel("Cards in deck"));
        add(cardsLeftIndicator);
    }

    @Override
    public void render()
    {
        healthIndicator.setText("" + hero.health);
        cardsLeftIndicator.setText("" + hero.deck.size());
    }
}
