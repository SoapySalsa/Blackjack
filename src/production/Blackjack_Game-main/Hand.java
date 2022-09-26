public class Hand
{
    private Card[] hand = new Card[12];
    private int hand_count = 0;

    public int calc_total()
    {
        int card_value = 0;
        int total = 0;
        int temp_total = 0;
        for (int i = 0; i < hand_count; i++)
        {
            if (hand[i].get_value() <= 10)
            {
                card_value = hand[i].get_value();
            }
            if (hand[i].get_value() > 10)
            {
                card_value = 10;
            }
            if (hand[i].get_value() == 1 && hand_count == 2)
            {
                card_value = 11;
            }
            if (hand[i].get_value() == 1 && hand_count > 2)
            {
                temp_total = 11;

                for (int j = i + 1; j < hand_count; j++)
                {
                    temp_total += hand[j].get_value();
                    if (temp_total <= 21 && j == hand_count)
                    {
                        card_value = 11;
                    } else
                    {
                        card_value = 1;
                    }
                }
            }
            total += card_value;
        }
        return total;
    }

    public String toString()
    {
        String hand_cards = "";
        for (int i = 0; i < hand_count; i++)
        {
            hand_cards += hand[i].get_card_details() + ", ";
        }
     return hand_cards.substring(0, hand_cards.length() - 2);
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
