package blockchain.copyrights;

import java.math.BigInteger;

public class Artwork {

    public String name;
    public String category;
    public String artist_addr;
    public String artist_name;
    public String producer_addr;
    public String producer_name;
    public int producer_investment;
    public int worth;
    public int fare;

    public Artwork(String name,
                   String category,
                   String artist_addr,
                   String artist_name,
                   String producer_addr,
                   String producer_name,
                   BigInteger producer_investment,
                   BigInteger worth,
                   BigInteger fare) {
        this.name = name;
        this.category = category;
        this.artist_addr = artist_addr;
        this.artist_name = artist_name;
        this.producer_addr = producer_addr;
        this.producer_name = producer_name;
        this.producer_investment = producer_investment.intValue();
        this.worth = worth.intValue();
        this.fare = fare.intValue();
    }

    @Override
    public String toString() {
        String s = "Name : "+name
                +", Category : "+category
                +", Artist address : "+artist_addr
                +", Artist name : "+artist_name
                +", Producer address : "+producer_addr
                +", Producer name : "+producer_name
                +", Producer investment : "+producer_investment
                +", Total worth : "+worth
                +", Fare : "+fare;
        return s;
    }

    public String resume() {
        String s = "Name : "+name
                +", Category : "+category
                +", Artist name : "+artist_name
                +", Producer name : "+producer_name
                +", Total worth : "+worth
                +", Fare : "+fare;
        return s;
    }

    public Object[] toArray() {
            Object[] array = {
                    name,
                    category,
                    artist_name,
                    producer_name,
                    producer_investment,
                    worth,
                    fare
            };
            return array;
    }
}
