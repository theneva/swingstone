package game;

public class SwingViewFactory implements ViewFactory
{
    @Override
    public GameView createGameView(final Game game, final Callback nextTurnCallback, final MinionPlayedCallback minionPlayedCallback)
    {
        return new SwingGameView(game, nextTurnCallback, minionPlayedCallback);
    }
}
