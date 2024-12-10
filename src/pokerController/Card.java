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
        if (this.value == "J"){
            return 11;
        }
        if (this.value == "Q"){
            return 12;
        }
        if (this.value == "K"){
            return 13;
        }
        if (this.value == "A"){
            return 14;
        }
        else{
            return Integer.parseInt(this.value);
        }
    }

    @Override
    public int compareTo(Card otherCard){
        if(this.equals(otherCard)){
            return 0;
        }
        if (this.hashCode() < otherCard.hashCode()){
            return -1;
        }
        else{
            return 1;
        }
        
    }
    
}
