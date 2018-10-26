package blockchain.copyrights;

import java.math.BigInteger;

public class Artwork {

    public String name;
    public String category;
    public String artist_addr;
    public String artist_name;
    public String producer_addr;
    public String producer_name;
    public int worth;
    public int fare;

    public Artwork(String name,
                   String category,
                   String artist_addr,
                   String artist_name,
                   String producer_addr,
                   String producer_name,
                   BigInteger worth,
                   BigInteger fare) {
        this.name = name;
        this.category = category;
        this.artist_addr = artist_addr;
        this.artist_name = artist_name;
        this.producer_addr = producer_addr;
        this.producer_name = producer_name;
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
                +", Total worth : "+worth
                +", Fare : "+fare;
        return s;
    }
}
