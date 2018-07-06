package blockchain;

import java.util.Arrays;

public class Block {
	private String firstName;
	private String lastName;
	private int previousHash;
	private int blockHash;
	
	public Block(int previousHash, String firstName, String lastName) {
		this.previousHash = previousHash;
		this.firstName = firstName;
		this.lastName = lastName;
		this.blockHash = calculateHash();
	}
	
	public int calculateHash() {
		Object[] content = {this.firstName.hashCode(), this.lastName.hashCode(), this.previousHash};
		return Arrays.hashCode(content);
	}
	
	@Override
	public String toString() {
		return "hash = " + blockHash;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public int getPreviousHash() {
		return previousHash;
	}
	
	public void setPreviousHash(int previousHash) {
		this.previousHash = previousHash;
	}
	
	public int getBlockHash() {
		return blockHash;
	}
}
