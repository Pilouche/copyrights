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
			string category;
			Artist artist;
			Producer producer;
        	uint worth;
        	uint numInvestors;
        	uint numClients;
        	uint fare;
        	mapping (address => Investor) Investors;
        	mapping (address => Client) Clients;
    	}
    	
    	uint numArtworks;
    	mapping (uint => Artwork) artworks;
    	
    	function newArtwork(string name, string category, address artistAddr, address producerAddr, 
    		uint worth, uint fare) public returns (uint artworkID) {
        	artworkID = numArtworks++;
        	artworks[artworkID] = Artwork(name, category, Artist(artistAddr), Producer(producerAddr, 0), worth, 0, 0, fare);
    	}
    	
    	function productionInvestment(uint artworkID) public payable {
    	    require(msg.value > 0);
    		artworks[artworkID].artist.addr.transfer(msg.value);
    		artworks[artworkID].producer.investedAmount += msg.value;
    	}
    	
    	function privateInvestment(uint artworkID) public payable {
    	    require(msg.value > 0);
    		artworks[artworkID].artist.addr.transfer(msg.value);
    		artworks[artworkID].numInvestors++;
    		artworks[artworkID].Investors[msg.sender] = Investor(msg.sender, msg.value);
    	}
    	
    	function buyCopy(uint artworkID) public payable {
    		require(msg.value == artworks[artworkID].fare);
    		artworks[artworkID].producer.addr.transfer(msg.value);
    		artworks[artworkID].numClients++;
    		artworks[artworkID].Clients[msg.sender] = Client(msg.sender);
    	}
    	
    	function sellRights(uint artworkID, address producerAddr) public payable {
    	    require(msg.value == artworks[artworkID].worth);
    	}
    	
    	function payShares() {
    	    
    	}
	}