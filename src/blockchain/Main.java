package blockchain;

public class Main {
	static Blockchain blockchain;
	
	public static void main(String[] args) {
		blockchain = new Blockchain();
		blockchain.addBlock(new Block(blockchain.getLatestBlock().getBlockHash(), "John", "Kowalski"));
		blockchain.addBlock(new Block(blockchain.getLatestBlock().getBlockHash(), "Jan", "Nowak"));
		blockchain.addBlock(new Block(blockchain.getLatestBlock().getBlockHash(), "Abcd", "Efgh"));
		
		System.out.println(blockchain);
			
	}
}
