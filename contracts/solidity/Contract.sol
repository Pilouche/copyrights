pragma solidity ^0.4.25;
	contract mortal {
		address owner;
        constructor() public { owner = msg.sender; }
        function kill() public { if (msg.sender == owner) selfdestruct(owner); }
	}
	
	contract copyrights is mortal {
		struct Investor {
			address addr;
        	uint investedAmount;
        	bool exists;
		}
		
		struct Client {
			address addr;
			bool exists;
		}
		
		struct Artist {
			address addr;	
			string name;
		}
		
		struct Producer {
			address addr;
			string name;
        	uint investedAmount;
		}
		
		struct Artwork {
			string name;
			string category;
			Artist artist;
			Producer producer;
        	uint worth;
        	uint fare;
        	uint numInvestors;
        	mapping (address => Investor) investors;
        	mapping (uint => address) investorsIndex;
        	mapping (address => Client) Clients;
    	}
    	
    	uint numArtworks;
    	mapping (uint => Artwork) artworks;
    	
    	function newArtwork(string name, string category, address artistAddr, string artistName, address producerAddr,
    	    string producerName, uint fare) public returns (uint artworkID) {
        	artworkID = numArtworks++;
        	artworks[artworkID] = Artwork(name, category, Artist(artistAddr, artistName), Producer(producerAddr, producerName, 0), 0, 0, fare);
    	}
    	
    	function productionInvestment(uint artworkID) public payable {
    	    require(msg.value > 0);
    	    if(artworks[artworkID].producer.investedAmount == 0) {
    	        artworks[artworkID].worth = msg.value;
    	    } else {
    		    artworks[artworkID].worth += msg.value;
    		}
    		artworks[artworkID].artist.addr.transfer(msg.value);
    		artworks[artworkID].producer.investedAmount += msg.value;
    	}
    	
    	function privateInvestment(uint artworkID) public payable {
    	    require(msg.value > 0);
    	    if(!artworks[artworkID].investors[msg.sender].exists)  {
    		    artworks[artworkID].investors[msg.sender] = Investor(msg.sender, msg.value, true);
    		    artworks[artworkID].investorsIndex[artworks[artworkID].numInvestors++] = msg.sender;
    	    } else {
    	        artworks[artworkID].investors[msg.sender].investedAmount += msg.value;
    	    }
    		artworks[artworkID].artist.addr.transfer(msg.value);
    	    artworks[artworkID].worth += msg.value;
    	}
    	
    	function buyCopy(uint artworkID) public payable {
    		require(msg.value == artworks[artworkID].fare);
    		if(!artworks[artworkID].Clients[msg.sender].exists)  {
    		    artworks[artworkID].Clients[msg.sender] = Client(msg.sender, true);
                payShares(artworkID, artworks[artworkID].fare);  
    	    } else {
                return;
    	    }  
    	}
    	
    	function buyRights(uint artworkID, address producerAddr, string producerName) public payable {
    	    require(msg.value > artworks[artworkID].producer.investedAmount);
    	    uint oldAmount = artworks[artworkID].producer.investedAmount;
    	    artworks[artworkID].producer = Producer(producerAddr, producerName, msg.value);
    	    //update the worth as the redemption price is superior to the previous producer's investedAmount
    	   artworks[artworkID].worth += msg.value-oldAmount;
    	}
    	
    	function payShares(uint artworkID, uint amountToDivide) {
    	    //artworks[artworkID].artist.addr.transfer(amountToDivide*0.1);
    	    //artworks[artworkID].producer.addr.transfer((amountToDivide*producer.investedAmount)/(artworks[artworkID]*0.9));
    	    for(uint i=0; i<artworks[artworkID].numInvestors; i++)
            {
                artworks[artworkID].investors[artworks[artworkID].investorsIndex[i]].investedAmount;
            }
    	}
    	
    	function getArtworksCount() public view returns(uint) {
            return numArtworks;
        }
    	
    	function getArtwork(uint index) public view returns(string, string, address, string, address, string, uint, uint, uint) {
    	    Artwork memory artwork = artworks[index];
            return (artwork.name, artwork.category, 
                artwork.artist.addr, artwork.artist.name,
                artwork.producer.addr, artwork.producer.name, artwork.producer.investedAmount,
                artwork.worth, artwork.fare);
        }
    	
	}