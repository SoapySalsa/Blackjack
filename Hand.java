public class Hand
{
    private Card[] hand = new Card[12];
    private int hand_count = 0;
    Card current_hand;

    public int calc_total()
    {
        int total = 0;
        int temp_total = 0;
        for (int i = 0; i < hand_count; i++)
        {
            int card_value = hand[i].get_value();
            if (card_value > 10)
            {
                card_value = 10;
            }
            else if (card_value == 1 && i < hand_count)
            {
                temp_total += 11 + total;
                //card_value = Card.ace_check(hand);
                for (int j = i + 1; j < hand_count; j++)
                {
                    temp_total += hand[j].get_value();
                    if (temp_total <= 21 && j == hand_count)
                    {
                        card_value = 11;
                    }
                }
            }
            total += card_value;
        }
        return total;
    }

//    public String get_card()
//    {
//        return hand[i].get_card_details();
//    }

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
    public boolean blackjack_check(Hand hand, int total)
    {
        boolean blackjack_flag = true;
        if (total != 21)
        {
            blackjack_flag = false;
        }
        return blackjack_flag;
    }

//    public int dealer_peek()
//    {
//        return hand[0].get_value();
//    }

//    public void show_cards()
//    {
//        Card current_hand;
//        for (int i = 0; i <= hand.length; i++)
//        {
//            hand[i].get_card_details();
//        }
//    }

}
