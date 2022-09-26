import javax.sound.midi.SysexMessage;
import java.util.Scanner;
import java.util.Stack;

public class Blackjack
{
    The_house dealer = new The_house();
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
        while (users == 0 || users > 6)
        {
            if (scan.hasNextInt())
            {
                users = scan.nextInt();
            }
            else
            {
                System.out.println("Please enter a valid number (1-6)");
                users = scan.nextInt();
            }

        }
        players = new Player[users];

        for (int i = 0; i < users; i++)
        {
            System.out.println("Please enter your name");
            players[i].set_name(scan.nextLine());
        }
        deck = new Deck();
    }

    public Stack dealer_deck()
    {
        deck.shuffle();
        return deck.new_deck();
    }


    public void collect_bets()
    {
        int bet_amount;
        for (int i = 0; i < users; i++)
        {
            if (players[i].get_bank() < 0)
            {
                System.out.println("How much do you want to bet " + players[i].get_name());
                bet_amount = scan.nextInt();

                while (bet_amount == 0 || bet_amount > players[i].get_bank())
                {
                    if (bet_amount <= players[i].get_bank())
                    {
                        players[i].set_bet(bet_amount);
                    } else
                    {
                        System.out.println("Please enter an amount between 1 and your bank.");
                    }
                }
            }
        }
    }

    public void deal()
    {
        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < users; j++)
            {
                if (players[i].get_bank() > 0)
                {
                    players[j].add_card();
                }
            }
            if (i == 1)
            {
                System.out.println("The dealer is show a " + Deck.playing_deck.peek().toString());
                dealer.add_card();
            }
            else
            {
                dealer.add_card();
            }
        }
    }

    public void blackjack_check()
    {
        if (dealer.dealer_blackjack_check())
        {
            for (int i = 0; i < users; i++)
            {
                if (players[i].player_blackjack_check())
                {
                    System.out.println(players[i].get_name() + "pushes.");
                    players[i].player_push();
                } else if (dealer.dealer_blackjack_check())
                {
                    System.out.println(players[i].get_name() + "does not have Blackjack and loses.");
                    players[i].player_bust();
                }
            }
        } else
        {
            System.out.println("The dealer peeks and does not have blackjack.");

            for (int i = 0; i < users; i++)
            {
                if (players[i].player_blackjack_check())
                {
                    System.out.println(players[i].get_name() + "has Blackjack with " + players[i].hand.toString() + ".");
                    players[i].player_blackjack();
                }
            }
        }
    }

    public void player_action()
    {
        String action;
        int player = 0;
        while (player < users)
        {
            if (players[player].get_bank() > 0)
            {
                System.out.println(players[player].get_name() + " do you want to hit or stand?");
                action = scan.next().toLowerCase();
                if (action.equals("hit"))
                {
                    while (!action.equals("stand"))
                    {
                        players[player].add_card();
                        System.out.println(players[player].get_name() + " has " + players[player].get_hand());
                        if (players[player].hand.calc_total() > 21)
                        {
                            System.out.println(players[player].get_name() + " has busted with " + players[player].hand.calc_total());
                            players[player].player_bust();
                            player++;
                            break;
                        }
                        System.out.println(players[player].get_name() + " do you want to hit or stand?");
                        action = scan.next().toLowerCase();
                    }
                } else
                {
                    while (!(action.equals("hit") || action.equals("stand")))
                    {
                        System.out.println("Please enter a valid response, 'hit' or 'stand'");
                        action = scan.next();
                    }
                }
                player++;
            }
        }
    }

    public void dealer_action()
    {
        String dealer_status;
        System.out.println("The dealer is currently showing" + dealer.dealer_hand());
        dealer_status = dealer.dealer_turn();

        if (dealer_status.equals("stand"))
        {
            for (int i = 0; i < users; i++)
            {
                if (players[i].get_bank() > 0 && players[i].get_bet() > 0)
                {
                    if (players[i].hand.calc_total() > dealer.hand.calc_total())
                    {
                        System.out.println(players[i].get_name() + "has won against the house.");
                        players[i].player_win();
                    }
                    else if (players[i].hand.calc_total() == dealer.hand.calc_total())
                    {
                        System.out.println(players[i].get_name() + "has tied against the house.");
                        players[i].player_push();
                    }
                    else
                    {
                        System.out.println(players[i].get_name() + "has lost against the house.");
                        players[i].player_bust();
                    }
                }
            }
        }
        else
        {
            for (int i = 0; i < users; i++)
            {
                players[i].player_win();
            }
        }
    }

    public void display_hand()
    {
        for (int i = 0; i < users; i++)
        {
            if (players[i].get_bank() > 0)
            {
                System.out.println(players[i].get_name() +"is showing " + players[i].hand.toString() + ".");
            }
        }
        System.out.println("The dealer is showing " + dealer.hand.toString());
    }

    public void player_bank_status()
    {
        int start_bank = 150;
        int balance;
        for (int i = 0; i < users; i++)
        {
            if (players[i].get_bank() > 0)
            {
                if (players[i].get_bank() - start_bank > 150)
                {
                    balance = players[i].get_bank() - start_bank;
                    System.out.println(players[i].get_name() + "has gained " + balance + "for a total of " + players[i].get_bank() + ".");
                    System.out.println("");
                    players[i].hand.hand_reset();
                }
                if (start_bank - players[i].get_bank() < 150)
                {
                    balance = start_bank - players[i].get_bank();
                    System.out.println(players[i].get_name() + "has lost " + balance + "with a remainder of " + players[i].get_bank() +  ".");
                    System.out.println("");
                    players[i].hand.hand_reset();
                }
            }
            if (players[i].get_bank() == 0 )
            {
                System.out.println(players[i].get_name() + "has a bank of 0 and is removed from the game.");
                System.out.println("");
                players[i].hand.hand_reset();
                players[i].remove_player();
            }
            else
            {
                System.out.println(players[i].get_name() + "has broke even with a bank of " + players[i].get_bank() + ".");
                players[i].hand.hand_reset();
                System.out.println("");
            }
        }
    }

    public boolean force_stop()
    {
        boolean stop_flag = true;
        int players_left = 0;

        for (int i = 0; i < users; i++)
        {
            if (players[i].get_bank() > 0)
            {
                players_left++;
            }
        }
        if (players_left > 0)
        {
            stop_flag = false;
        }
        else
        {
            System.out.println("");
            System.out.println("There are no more players left in the game");
            System.out.println("");
        }
        return stop_flag;
    }

    public boolean next_game()
    {
        String play_again;
        boolean new_game = true;

        if (force_stop())
        {
            new_game = false;
        }
        else
        {
            System.out.println("");
            System.out.println("Do you want to play another game? Yes or no?");
            play_again = scan.next().toLowerCase();

            while (!(play_again.equals("yes") || play_again.equals("no")))
            {
                System.out.println("Please enter a valid response. (yes or no)");
                play_again = scan.next().toLowerCase();
            }
            if (play_again.equals("no"))
            {
                new_game = false;
            }
        }
        return new_game;
    }

    public void endgame()
    {
        int start_bank = 150;
        int balance;
        for (int i = 0; i < users; i++)
        {
            if (players[i].get_bank() > 0)
            {
                if (players[i].get_bank() - start_bank > 150)
                {
                    balance = players[i].get_bank() - start_bank;
                    System.out.println(players[i].get_name() + " ends the game with with winning " + balance + "for a total of " + players[i].get_bank() + ".");
                    System.out.println("");
                }
                if (start_bank - players[i].get_bank() < 150)
                {
                    balance = start_bank - players[i].get_bank();
                    System.out.println(players[i].get_name() + " ends the game losing " + balance + "with a remainder of " + players[i].get_bank() +  ".");
                    System.out.println("");
                }
            }
            if (players[i].get_bank() <= 0 )
            {
                System.out.println(players[i].get_name() + " ended the game with a bank of 0.");
                System.out.println("");
               players[i].reset_bank();
            }
            else
            {
                System.out.println(players[i].get_name() + " ends the game by breaking even with a bank of " + players[i].get_bank() + ".");
                System.out.println("");
            }
        }
        System.out.println("");
        System.out.println("Thank you for playing.");
    }

}
