import java.util.ArrayDeque;
import java.util.Random;
import java.util.Stack;

public class Deck
{
    private Card[] deck = new Card[52];
    public static Stack<Card> playing_deck;
    //private Stack<Card> playing_deck;

    public Deck()
    {
        int placement = 0;
        for (int i = 0; i < 14; i++)
        {
            deck[placement++] = new Card(i, "of Spades");
        }
        for (int i = 0; i < 14; i++)
        {
            deck[placement++] = new Card(i, "of Diamonds");
        }
        for (int i = 0; i < 14; i++)
        {
            deck[placement++] = new Card(i, "of Hearts");
        }
        for (int i = 0; i < 14; i++)
        {
            deck[placement++] = new Card(i, "of Clubs");
        }
    }

    public void shuffle()
    {
        Random ran = new Random();
        Card temp;
        int new_spot;
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 52; j++)
            {
                temp = deck[j];
                new_spot = ran.nextInt(52);
                deck[j] = deck[new_spot];
                deck[new_spot] = temp;
            }
        }
    }

    public Stack new_deck()
    {
        for (int i = 0; i < 52; i++)
        {
            playing_deck.push(deck[i]);
        }
        return playing_deck;
    }

//    public Stack<Card> get_deck()
//    {
//        return playing_deck;
//    }
//
//    public Card get_card()
//    {
//        return playing_deck.pop();
//    }
}
