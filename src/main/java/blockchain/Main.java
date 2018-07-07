package blockchain;

public class Main {
	static Blockchain blockchain;
	
	public static void main(String[] args) {
		blockchain = new Blockchain();
		blockchain.addBlock(new Block(blockchain.getLatestBlock().getBlockHash(), "John", "Kowalski"));
		blockchain.addBlock(new Block(blockchain.getLatestBlock().getBlockHash(), "Jan", "Nowak"));
		blockchain.addBlock(new Block(blockchain.getLatestBlock().getBlockHash(), "Abddscd", "Efgh"));
		
		System.out.println(blockchain);
		System.out.println("Is blockchain valid? " + blockchain.isChainValid());

		blockchain.getBlockchain().get(1).setFirstName("NEW");
		System.out.println("First name changed");
		System.out.println("Is blockchain valid? " + blockchain.isChainValid());
	}
}
