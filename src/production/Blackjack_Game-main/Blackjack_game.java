public class Blackjack_game
{
    public static void main(String[] args)
    {
        Blackjack game = new Blackjack();

        game.create_game();

        while (game.next_game())
        {
            game.dealer_deck();
            game.collect_bets();
            game.deal();
            game.display_hand();
            game.blackjack_check();
            game.player_action();
            game.dealer_action();
            game.showdown();
            game.player_bank_status();
        }
        game.endgame();
    }
}
