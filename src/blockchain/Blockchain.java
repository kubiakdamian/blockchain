package blockchain;

import java.util.ArrayList;

public class Blockchain {
	private ArrayList<Block> blockchain = new ArrayList<>();
	
	public Blockchain() {
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
		return "Blockchain [blockchain=" + blockchain + "]";
	}
	
	private boolean isChainValid() {
		for(int i = 1; i < blockchain.size(); i++) {
			Block currentBlock = blockchain.get(i);
			Block previousBlock = blockchain.get(i - 1);
			
			if(currentBlock.getBlockHash() != currentBlock.calculateHash()) {
				return false;
			}
			
			if(currentBlock.getPreviousHash() != previousBlock.getBlockHash()) {
				return false;
			}
		}
		
		return true;
	}

	private Block createGenesisBlock() {
		return new Block(0, "aaaa", "bbbb");
	}
	
	
}
