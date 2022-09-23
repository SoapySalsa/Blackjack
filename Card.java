public class Card
{
    private int num_value;
    private String face_value;
    private String suit;
    Card(int value, String suit)
    {
        this.num_value = value;
        this.suit = suit;
    }

    public String get_suit()
    {
        return this.suit;
    }

    public int get_value()
    {
        return this.num_value;
    }
    public String get_face_value()
    {
        if (this.value <= 10)
        {
            face_value = this.value.toString();
        }
        if (this.value == 1)
        {
            face_value = "Ace";
        }
        if (this.value == 11)
        {
            face_value = "Jack";
        }
        if (this.value == 12)
        {
            face_value = "Queen";
        }
        if (this.value == 13)
        {
            face_value = "King";
        }
        return face_value.substring(0,1).toUpperCase();
    }

//    public boolean compare_value()
//    {
//
//    }
}
