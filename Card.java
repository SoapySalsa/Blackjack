public class Card
{
    private int num_value;
    private String face_value;
    private final String suit;

    Card(int value, String suit)
    {
        this.num_value = value;
        this.suit = suit;
    }

//    public String get_suit()
//    {
//        return this.suit;
//    }
//    public String get_value()
//    {
//        return this.suit;
//    }


    public String toString()
    {
        return this.get_value() + " " + this.suit;
    }

    public int get_value()
    {
        return this.num_value;
    }

    public String get_card_details()
    {
        if (this.num_value <= 10)
        {
            face_value = this.toString();
        }
        if (this.num_value == 1)
        {
            face_value = "Ace " + this.suit;
        }
        if (this.num_value == 11)
        {
            face_value = "Jack " + this.suit;
        }
        if (this.num_value == 12)
        {
            face_value = "Queen " + this.suit;
        }
        if (this.num_value == 13)
        {
            face_value = "King " + this.suit;
        }
        return face_value;
    }

//    public static int ace_check(Card hand[])
//    {
//        int check_total = 0;
//        int ace_value = 1;
//        for (int i = 0; i < hand.length; i++)
//        {
//            if (hand[i].get_value() == 1 && check_total + 11 < 22)
//            {
//                ace_value = 11;
//            }
//            check_total += hand[i].get_value();
//        }
//        return ace_value;
//    }

//    public boolean compare_value()
//    {
//
//    }
}