package numerical;

/*
 * 谜面
 *  XXX
 * *  X
 * -----
 * XXXX
 * 其中呢,X是[2,3,4,5,6,7,8]中的任意一个
 * 
 */

public class Solve_01 {

	private static String magic = "2345678";

	public static void main(String[] args) {

		for (int i = 0; i < magic.length(); i++) {
			for (int j = 0; j < magic.length(); j++) {
				for (int k = 0; k < magic.length(); k++) {
					for (int l = 0; l < magic.length(); l++) {

						char a = magic.charAt(i);
						char b = magic.charAt(j);
						char c = magic.charAt(k);
						char d = magic.charAt(l);

						Integer xxx = new Integer("" + a + b + c);
						Integer x = new Integer("" + d);

						Integer xxxx = xxx.intValue() * x;
						
						String result = ""+xxx+x+xxxx;
						boolean result_check = true;
						boolean global_check = true;
						
						for (int m = 0; m < xxxx.toString().length(); m++){
							result_check = magic.contains(""+xxxx.toString().charAt(m)) && result_check;
						}
						
						for(int n = 0 ; n < magic.length(); n++){
							global_check = result.contains(""+magic.charAt(n)) && global_check;
						}
						
						if (result_check && global_check) {
							System.out.println(""+ xxx + " * " + x + " = " + xxxx);
						}
					}
				}
			}
		}
	}
}
