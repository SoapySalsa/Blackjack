import java.util.Random;

public class Deck
{
    Card[] deck = new Card[52];

 public Deck()
    {
        int placement = 0;
        for (int i = 1; i < 14; i++)
        {
            deck[placement] = new Card(i, "of Spades");
            placement++;
        }
        for (int i = 1; i < 14; i++)
        {
            deck[placement] = new Card(i, "of Diamonds");
            placement++;
        }
        for (int i = 1; i < 14; i++)
        {
            deck[placement] = new Card(i, "of Hearts");
            placement++;
        }
        for (int i = 1; i < 14; i++)
        {
            deck[placement] = new Card(i, "of Clubs");
            placement++;
        }
    }

    public void shuffle()
    {
        Random ran = new Random();
        Card temp;
        int new_spot;
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 51; j++)
            {
                temp = deck[j];
                new_spot = ran.nextInt(52);
                deck[j] = deck[new_spot];
                deck[new_spot] = temp;
            }
        }
    }

    public Card getCard(int next_card)
    {
        return deck[next_card];
    }
}
