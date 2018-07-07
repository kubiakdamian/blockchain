package blockchain;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Blockchain {
	private ArrayList<Block> blockchain = new ArrayList<>();
    private static int difficulty;

	public Blockchain() {
        this.difficulty = 4;
        blockchain.add(createGenesisBlock());
	}
	
	public void addBlock(Block newBlock) {
		blockchain.add(newBlock);
	}
	
	public Block getLatestBlock() {
		return blockchain.get(blockchain.size() - 1);
	}
	
	@Override
	public String toString() {
		return "blockchain:\n" + blockchain;
	}
	
	public boolean isChainValid() {
		for(int i = 1; i < blockchain.size(); i++) {
			Block currentBlock = blockchain.get(i);
			Block previousBlock = blockchain.get(i - 1);

			if(!currentBlock.getBlockHash().equals(currentBlock.mineBlock(difficulty))) {
				return false;
			}

			if(!currentBlock.getPreviousHash().equals(previousBlock.getBlockHash())) {
				return false;
			}
		}
		
		return true;
	}

	private Block createGenesisBlock() {
		return new Block("0000", "aaaa", "bbbb");
	}


    public static int getDifficulty() {
        return difficulty;
    }
}
