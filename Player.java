public class Player
{
    private String name;
    private int bank;
    private int bet;

    Player(String name, int bank, int bet)
    {
        this.name = name;
        this.bank = 150;
        Hand hand = new Hand();
    }
//    public void add_players(String name)
//    {
//        player[] = new Player(name, 150, 0);
//    }


//    public void set_name(String name)
//    {
//    }

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
