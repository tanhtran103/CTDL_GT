package lab2;

public class Task1_1 {
	// S(n)=1-2+3-4+…+ ((-1)^(n+1) ).n , n>0
	public static int getSn1(int n) {
		if (n == 1) {
			return 1;
		}
		return getSn1(n - 1) + (int) Math.pow(-1, (n + 1)) * n;
	}

	// S(n)=1+1.2+1.2.3+…+1.2.3…n, n>0
	public static int getSn2(int n) {
		if (n == 1) {
			return 1;
		}
		return getSn2(n - 1) + n * (n - 1);
	}

	// S(n)=1^2+2^2+3^2+....+n^2 , n>0
	public static int getSn3(int n) {
		if (n == 1) {
			return 1;
		}
		return getSn3(n - 1) + (int) (Math.pow(n, 2));
	}

	// S(n)=1+1/2+1/(2.4)+1/(2.4.6)+…+1/(2.4.6.2n), n>=0
	public static double getSn4(int n) {
		if (n == 0) {
			return 1;
		}
		return getSn4(n - 1) + (1 / (getSn4(n - 1) * 2 * n));
	}

	public static void main(String[] args) {
		System.out.println(getSn1(3));
		System.out.println(getSn2(3));
		System.out.println(getSn3(3));
		System.out.println(getSn4(3));

	}
}
