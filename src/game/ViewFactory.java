package game;

public interface ViewFactory
{
    GameView createGameView(
            Game game,
            Callback nextTurnCallback,
            MinionPlayedCallback minionPlayedCallback
    );
}
