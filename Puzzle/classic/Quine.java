package classic;

public class Quine {
	public static void main(String[] args) {
		String h = "public class PrintSelf{\n  public static void main(String[] args){\n";
		String d = "String h=String d=String s=String c=";
		String s = "\"\\n;}    ";
		String c = "    System.out.println(h+s.substring(5)+d.substring(0,9)+s.charAt(0)+h.substring(0,23)+s.substring(1,3)+h.substring(24,65)+s.substring(1,3)+s.charAt(0)+s.charAt(3));System.out.println(s.substring(5)+d.substring(9,18)+s.charAt(0)+d+s.charAt(0)+s.charAt(3));System.out.println(s.substring(5)+d.substring(18,27)+s.charAt(0)+s.charAt(1)+s.charAt(0)+s.charAt(1)+s.charAt(1)+s.substring(2)+s.charAt(0)+s.charAt(3));System.out.println(s.substring(5)+d.substring(27)+s.charAt(0)+c+s.charAt(0)+s.charAt(3));    System.out.println(c+s.substring(7)+s.charAt(4)+s.charAt(4));";
		System.out.println(h + s.substring(5) + d.substring(0, 9) + s.charAt(0)
				+ h.substring(0, 23) + s.substring(1, 3) + h.substring(24, 65)
				+ s.substring(1, 3) + s.charAt(0) + s.charAt(3));
		System.out.println(s.substring(5) + d.substring(9, 18) + s.charAt(0)
				+ d + s.charAt(0) + s.charAt(3));
		System.out.println(s.substring(5) + d.substring(18, 27) + s.charAt(0)
				+ s.charAt(1) + s.charAt(0) + s.charAt(1) + s.charAt(1)
				+ s.substring(2) + s.charAt(0) + s.charAt(3));
		System.out.println(s.substring(5) + d.substring(27) + s.charAt(0) + c
				+ s.charAt(0) + s.charAt(3));
		System.out.println(c + s.substring(7) + s.charAt(4) + s.charAt(4));
	}
}
