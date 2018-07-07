package blockchain;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Arrays;

@Getter
@Setter
public class Block {
	private String firstName;
	private String lastName;
	private String previousHash;
	private String blockHash;
	private int nonce;
	
	public Block(String previousHash, String firstName, String lastName) {
		this.previousHash = previousHash;
		this.firstName = firstName;
		this.lastName = lastName;
		mineBlock(Blockchain.getDifficulty());
		this.nonce = 0;
	}
	
	public String calculateHash() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.firstName).append(this.lastName).append(this.previousHash).append(this.nonce);
		Object[] content = {this.firstName.hashCode(), this.lastName.hashCode(), this.previousHash, this.nonce};
		return DigestUtils.sha256Hex(builder.toString());
	}

	public void mineBlock(int difficulty){
		blockHash = calculateHash();
		while(!blockHash.substring(0, difficulty).equals(createStringOfZeros(difficulty))){
			nonce++;
			blockHash = calculateHash();
		}

		System.out.println("Block mained: " + blockHash);
	}

	private String createStringOfZeros(int length){
		StringBuilder builder = new StringBuilder();

		for(int i = 0; i < length; i++){
			builder.append("0");
		}

		return builder.toString();
	}
	
	@Override
	public String toString() {
		return "hash = " + blockHash + "\n";
	}
}
