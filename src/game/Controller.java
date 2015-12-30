package game;

import game.actor.Minion;
import game.actor.Opponent;
import game.actor.Player;
import minion.MinionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Controller
{
    private final List<Minion> availableMinions;
    private final Game game;

    private final GameView gameView;

    public Controller(
            final MinionRepository minionRepository,
            final ViewFactory viewFactory
    )
    {
        this.availableMinions = minionRepository.findAll();

        final Player player = createRandomPlayer();
        final Opponent opponent = createRandomOpponent();

        this.game = new Game(player, opponent);
        this.gameView = viewFactory.createGameView(game, game::nextTurn, game::playMinion);
    }

    public void startGame()
    {
        game.start();
        gameView.start();
        gameView.render();
    }

    private Player createRandomPlayer()
    {
        final Deck deck = createRandomDeck(10);

        final List<Minion> cardsInHand = ArrayHelper.asList(
                // TODO Handle fatigue in opening hand?
                deck.draw().get(),
                deck.draw().get()
        );

        final Hand hand = new Hand(cardsInHand);

        return new Player(
                30,
                hand,
                createRandomDeck(3),
                new ArrayList<>()
        );
    }

    private Opponent createRandomOpponent()
    {
        final Deck deck = createRandomDeck(10);

        final List<Minion> cardsInHand = ArrayHelper.asList(
                // TODO Handle fatigue in opening hand?
                deck.draw().get(),
                deck.draw().get()
        );

        final Hand hand = new Hand(cardsInHand);

        return new Opponent(
                30,
                hand,
                createRandomDeck(3),
                new ArrayList<>()
        );
    }

    private Deck createRandomDeck(final int count)
    {
        final Random random = new Random();

        final Stack<Minion> randomMinions = new Stack<>();

        for (int i = 0; i < count; i++)
        {
            randomMinions.add(availableMinions.get(random.nextInt(availableMinions.size())));
        }

        return new Deck(randomMinions);
    }
}
