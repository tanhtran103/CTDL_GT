package lab1;

public class MyCaesar {
	public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	private int n;// shift steps (right shift)

	public MyCaesar(int shiftSteps) {
		this.n = shiftSteps;
	}

	// Encrypt a character according to the given shift steps.
	// Encrypt: En(x) = (x + n) mod 26. x represents the index of c in the ALPHABET
	// array
	public char encryptChar(char c) {
		for (int i = 0; i < ALPHABET.length; i++) {
			if (ALPHABET[i] == c) {
				int encrypt = (i + n) % 26;
				if (encrypt < 0) {
					encrypt += 26;
				}
				return ALPHABET[encrypt];
			}
		}
		return c;
	}

	// Encrypt a text using the above function for encrypting a character.
	public String encrypt(String input) {
		String result = "";
		input = input.toUpperCase();
		for (int i = 0; i < input.length() ;i++) {
			result += encryptChar(input.charAt(i));
		}
		return result;
	}

	// Decrypt a character according to the given shift steps.
	// Decrypt: Dn(x) = (x – n) mod 26. x represents the index of c in the ALPHABET
	// array
	public char decryptChar(char c) {
		for (int i = 0; i < ALPHABET.length; i++) {
			if (ALPHABET[i] == c) {
				int encrypt = (i - n) % 26;
				if (encrypt < 0) {
					encrypt += 26;
				}
				return ALPHABET[encrypt];
			}
		}
		return c;
	}

	// Decrypt a encrypted text using the above function for decrypting a character.
	public String decrypt(String input) {
		String result = "";
		input = input.toUpperCase();
		for (int i = 0; i < input.length() ;i++) {
			result += decryptChar(input.charAt(i));
		}
		return result;
	}

	// Encrypt a encrypted the text content in the srcfile and save it into desFile.
	public void encrypt(String srcFile, String desFile) {
	}

	// Decrypt a encrypted the text content in the srcfile and save it into desFile.
	public void decrypt(String srcFile, String desFile) {
	}

	public static void main(String[] args) {
		MyCaesar myCaesar = new MyCaesar(3);
		System.out.println(myCaesar.encryptChar('A'));
		System.out.println(myCaesar.decryptChar('D'));
		System.out.println(myCaesar.encrypt("ABCDe")) ;
		System.out.println(myCaesar.decrypt("DEFGH")) ;
	}
}
