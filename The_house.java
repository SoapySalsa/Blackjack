import javax.xml.transform.stream.StreamSource;
import java.util.Stack;

public class The_house
{
    Hand hand;

    The_house()
    {
        Hand hand = new Hand();
    }
    public void add_card()
    {
        hand.add_card(Deck.playing_deck.pop());
    }

    public String dealer_turn()
    {
        String status = "stand";
        Card next_card;
        while (hand.calc_total() <= 16)
        {
            next_card = Deck.playing_deck.pop();
            hand.add_card(next_card);
            if (next_card.get_value() + hand.calc_total() < 22)
            {
                System.out.println("The Dealer draws a " + next_card.get_card_details() +".");
            }
            else if (next_card.get_value() + hand.calc_total() > 21)
            {
                System.out.println("The dealer busts with a " + hand.calc_total()+ ".");
                status = "bust";
            }
        }
        if (hand.calc_total() > 17)
        {
            System.out.println("The Dealer stands with a " + hand.calc_total() + ".");
        }
        return status;
    }

    public String dealer_hand()
    {
        return hand.toString();
    }

    public boolean dealer_blackjack_check()
    {
        if(hand.calc_total() == 21)
         {
             System.out.println("The dealer has blackjack with " + hand.toString());
             return true;
         }
         else
         {
          return false;
         }
    }


//    public void dealer_bust()
//    {
//        if (hand.calc_total() > 21)
//        {
//            System.out.println("The Dealer busts.");
//        }
//    }
}
