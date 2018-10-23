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
        	mapping (address => Investor) Investors;
        	mapping (address => Client) Clients;
    	}
    	
    	uint numArtworks;
    	mapping (uint => Artwork) artworks;
    	
    	function newArtwork(string name, string category, address artistAddr, string artistName, address producerAddr,
    	    string producerName, uint worth, uint fare) public returns (uint artworkID) {
        	artworkID = numArtworks++;
        	artworks[artworkID] = Artwork(name, category, Artist(artistAddr, artistName), Producer(producerAddr, producerName, 0), worth, fare);
    	}
    	
    	function productionInvestment(uint artworkID) public payable {
    	    require(msg.value > 0);
    		artworks[artworkID].artist.addr.transfer(msg.value);
    		artworks[artworkID].producer.investedAmount += msg.value;
    	}
    	
    	function privateInvestment(uint artworkID) public payable {
    	    require(msg.value > 0);
    		artworks[artworkID].artist.addr.transfer(msg.value);
    	    if(!artworks[artworkID].Investors[msg.sender].exists)  {
    		    artworks[artworkID].Investors[msg.sender] = Investor(msg.sender, msg.value, true);
    	    } else {
    	        artworks[artworkID].Investors[msg.sender].investedAmount += msg.value;
    	    }
    	}
    	
    	function buyCopy(uint artworkID) public payable {
    	    if(artworks[artworkID].Clients[msg.sender].exists) throw;
    		require(msg.value == artworks[artworkID].fare);
    		artworks[artworkID].producer.addr.transfer(msg.value);
    		artworks[artworkID].Clients[msg.sender] = Client(msg.sender, true);
    	}
    	
    	function sellRights(uint artworkID, address producerAddr) public payable {
    	    require(msg.value == artworks[artworkID].worth);
    	}
    	
    	function payShares() {
    	    
    	}
    	
    	function getArtworksCount() public view returns(uint) {
            return numArtworks;
        }
    	
    	function getArtwork(uint index) public view returns(string, string, address, string, address, string, uint, uint, uint) {
    	    Artwork artwork = artworks[index];
            return (artwork.name, artwork.category, 
                artwork.artist.addr, artwork.artist.name,
                artwork.producer.addr, artwork.producer.name, artwork.producer.investedAmount,
                artwork.worth, artwork.fare);
        }
    	
	}