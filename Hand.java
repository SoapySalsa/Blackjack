import java.util.Stack;

public class Hand
{
    private Card[] hand = new Card[12];
    private int hand_count;

    public int calc_total()
    {
        int total = 0;
        for (int i = 0; i <= hand_count; i++)
        {
            int card_value = hand[i].get_value();
            if (card_value > 10)
            {
                card_value = 10;
            } else if (card_value == 1 && i < hand.length)
            {
                card_value = Card.ace_check(i, hand, total);
            }
            total += card_value;
        }
        return total;
    }

    public void hand_reset()
    {
        hand_count = 0;
    }

    public void add_card(Card card)
    {
        hand[hand_count++] = card;
    }

}
