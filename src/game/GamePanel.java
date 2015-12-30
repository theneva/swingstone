package game;

import javax.swing.*;
import java.awt.*;

public abstract class GamePanel extends JPanel implements Renderable
{
    public GamePanel()
    {
    }

    public GamePanel(final LayoutManager layout)
    {
        super(layout);
    }
}
