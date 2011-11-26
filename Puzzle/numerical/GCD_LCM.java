package numerical;

public class GCD_LCM {
	
	public static int gcd(int m,int n){
		if (n != 0) {
			return gcd(n, m%n);
		}
		else
			return m;
	}
	
	public static int lcm(int m,int n){
		return m*n/gcd(m, n);
	}
	
	public static void main(String[] args) {
		System.out.println(gcd(10, 4));
		System.out.println(lcm(10, 4));
	}
}
