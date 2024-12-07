package pokerController;

public class Card implements Comparable<Card>{
    private String color;
    private String value;

    public Card(String color,String value){
        this.color = color;
        this.value = value;
    }


    public String getColor() {
        return color;
    }



    public String getValue() {
        return value;
    }



    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        if(!(o instanceof Card)){
            return false;
        }
        Card card = (Card) o;
        if(card.value == this.value){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public int hashCode(){
        
    }

    @Override
    public int compareTo(Card otherCard){
        if(this.equals(otherCard)){
            return 0;
        }
        
    }
    
}
