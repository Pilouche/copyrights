pragma solidity ^0.4.25;
	contract mortal {
		address owner;
        constructor() public { owner = msg.sender; }
        function kill() public { if (msg.sender == owner) selfdestruct(owner); }
	}
	
	contract copyrights is mortal{
		struct Investor {
			address addr;
        	uint investedAmount;
		}
		
		struct Client {
			address addr;
		}
		
		struct Artist {
			address addr;	
		}
		
		struct Producer {
			address addr;
        	uint investedAmount;
		}
		
		struct Artwork {
			string name;
			string type;
			Artist artist;
			Producer producer;
        	uint worth;
        	uint numInvestors;
        	uint fare;
        	mapping (uint => Investor) Investors;
        	mapping (uint => Client) Clients;
    	}
    	
    	uint numArtworks;
    	mapping (uint => Artwork) artworks;
    	
    	function newArtwork(string name, string type, address artistAddr, address producerAddr, 
    		uint worth, uint fare) public returns (uint artworkID) {
        	artworkID = numArtworks++;
        	artworks[artworkID] = Artwork(name, type, Artist(artistAddr), Producer(producerAddr), worth, 0, fare);
    	}
    	
    	function buyCopy(uint artworkID) public payable {
    		require(msg.value == artworks[artworkID].fare);
    	}
	}