public class Player
{
    private String name;
    private int bank;
    private int bet;
   Hand hand;

    Player()
    {
        bank = 150;
        hand = new Hand();
    }

    public void set_name(String name1)
    {
        name = name1;
    }

    public String get_name()
    {
        return name;
    }

    public int get_bank()
    {
        return bank;
    }

    public void set_bank(int new_bank)
    {
        bank += new_bank;
    }

    public void set_bet(int new_bet)
    {
        bet = new_bet;
    }

    public int get_bet()
    {
       return bet;
    }

    public void add_card()
    {
        hand.add_card(Deck.playing_deck.pop());
    }

    public String show_hand()
    {
        return hand.toString();
    }


    public boolean player_blackjack_check()
    {
        if(hand.calc_total() == 21)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public void player_win()
    {
        bank += bet;
        bet = 0;
    }

    public void player_bust()
    {
        bank -= bet;
        bet = 0;
    }

    public void player_push()
    {
        bet = bet;
    }

    public void player_blackjack()
    {
        bank += (bet * 1.5);
        bet = 0;
    }

    public void blackjack_tie()
    {
        bank += bet;
        bet = 0;
    }

    public void remove_player()
    {
        bank = -1;
    }

    public void reset_bank()
    {
        bank = 150;
    }

}
