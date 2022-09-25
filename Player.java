public class Player
{
    private String name;
    private int bank;
    private int bet;

    Player()
    {
        bank = 150;
        Hand hand = new Hand();
    }

    public void set_name(String name)
    {
        name = name;
    }

    public String get_name()
    {
        return name;
    }


//    public void set_bet(int bet)
//    {
//    }
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

    public void clear_bet()
    {
        bet = 0;
    }

    public void remove_player()
    {
        bank = -1;
    }
}
