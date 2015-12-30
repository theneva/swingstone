import game.Controller;
import game.SwingViewFactory;
import minion.MinionRepository;

public class GameStarter
{
    public static void main(String[] args)
    {
        final MinionRepository minionRepository = new MinionRepository();

        final Controller controller = new Controller(
                minionRepository,
                new SwingViewFactory()
        );

        controller.startGame();
    }
}
