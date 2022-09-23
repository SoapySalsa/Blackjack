public class Player
{
    private Player[] player;
    private String name;
    private int bank;
    private int bet;

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

    public void player_hand()
    {

    }


    public void player_bust()
    {

    }

    public void player_blackjack()
    {

    }
}
