public class Player
{
    private Player[] player;
    private String name;
    private int bank;
    private int bet;
    private Hand hand;

    Player(String name, int bank, int bet)
    {
        this.name = name;
        this.bank = bank;
    }
    public void add_players(int num_players, String name, int bet)
    {
        for (int i = 0; i <= num_players; i++)
        {
            player[i] = new Player(name, 200, bet);
        }
    }

//    public void clear_bet(int num_players)
//    {
//        for (int i = 0; i <= num_players; i++)
//        {
//            player[i].bet = 0;
//        }
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

    public void remove_player()
    {
        bank = -1;
    }

    public void add_card()
    {

    }


}
