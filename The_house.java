import javax.xml.transform.stream.StreamSource;
import java.util.Stack;

public class The_house
{
    Hand hand;

    The_house()
    {
        hand = new Hand();
    }
    public void add_card()
    {
        hand.add_card(Deck.playing_deck.pop());
    }

    public String dealer_turn()
    {
        String status = "stand";
        if (hand.calc_total() <= 16)
        {
            while (hand.calc_total() < 17)
            {
                hand.add_card(Deck.playing_deck.pop());
                System.out.println("The Dealer draws a card and has a hand of " + hand.toString() + " with a total of " + hand.calc_total() + ".");

                if (hand.calc_total() == 17)
                {
                    System.out.println("The Dealer stands with a hand of " + hand.toString() + " with a total of " + hand.calc_total() + ".");
                }
                else if (hand.calc_total() > 21)
                {
                    System.out.println("The dealer busts with a with a total of " + hand.calc_total() + ".");
                    status = "bust";
                }
            }
        }
        if (hand.calc_total() > 17 && hand.calc_total() < 22)
        {
            System.out.println("The Dealer stands with a hand of " + hand.toString() + " with a total of " + hand.calc_total() + ".");
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
}
