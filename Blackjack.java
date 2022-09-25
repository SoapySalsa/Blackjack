import java.util.Scanner;

public class Blackjack
{
    private Player[] players;
    private int users;
    private String name;
    private Deck deck;
    private Scanner scan = new Scanner(System.in);

    public void create_game()
    {
        String player_name;
        System.out.println("Welcome to Blackjack.");
        System.out.println("");
        System.out.println("First we will go over the rules.");
        System.out.println("Each player is dealt two cards including the Dealer who has one face up and the other face down.");
        System.out.println("Each card has a value with the cards 2-10 having a value equal to the number shown.");
        System.out.println("jacks, Queens, and Kings are all worth 10 and Ace's having a value of either 1 or 11.");
        System.out.println("The object of the game is to have a score of 21 or as close as possible without going over.");
        System.out.println("If the player or Dealer goes over they will bust and lose the round.");
        System.out.println("Each player is trying to have a hand that is higher than the Dealer.");
        System.out.println("If a player gets 21 or 'Blackjack' on the opening hand 'a natural' they win 1.5x their bet.");
        System.out.println("If the Dealer has a natural an no other player does then the round is automatically over " +
                "with the player losing the round.");
        System.out.println("");
        System.out.println("A player may either hit or stand on their turn.");
        System.out.println("If a player hits they are dealt another card, if they stand the turn is passed to the next player.");
        System.out.println("A player can hit as much as they like until they decide to stand or bust.");
        System.out.println("");
        System.out.println("If a player ties with the dealer their bet is 'pushed' to the next round.");
        System.out.println("If a tie happens with the player and the Dealer having Blackjack the player receives their bet back.");
        System.out.println("Each player will start out with a bank of 150, and if their bank reaches 0 and they " +
                "can not place a bet they are out of the game.");
        System.out.println("");
        System.out.println("The game continues until all players are removed or they decided to quit");
        System.out.println("");

        System.out.println("How many people are playing today? (1-6)");
        while(users == 0 || users > 6)
        {
            if (scan.hasNextInt())
            {
                users = scan.nextInt();
            }
            else
            {
                System.out.println("Please enter a valid number (1-6)");
            }

        }
        players = new Player[users];
        deck = new Deck();

        for (int i = 0; i <= users; i++)
        {
            System.out.println("Please enter your name");
            players[i].set_name(scan.next());
        }

        
    }


}
