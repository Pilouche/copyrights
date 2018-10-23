package blockchain.copyrights;

import java.math.BigInteger;

public class Artwork {

    public String name;
    public String category;
    public String artist_addr;
    public String producer_addr;
    public BigInteger producer_investment;
    public BigInteger worth;
    public BigInteger fare;

    public Artwork(String name,
                   String category,
                   String artist_addr,
                   String producer_addr,
                   BigInteger producer_investment,
                   BigInteger worth,
                   BigInteger fare) {
        this.name = name;
        this.category = category;
        this.artist_addr = artist_addr;
        this.producer_addr = producer_addr;
        this.producer_investment = producer_investment;
        this.worth = worth;
        this.fare = fare;
    }
}
