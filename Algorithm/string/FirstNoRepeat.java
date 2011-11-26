public class FirstNoRepeat {
	public static char search(String str) {
		char ch =' ';
		for(int i =0 ; i < str.length(); i++){
			if (str.indexOf(str.charAt(i)) == str.lastIndexOf(str.charAt(i))) {
				ch = str.charAt(i);
				break;
			}
		}
		return ch;
	}
	public static void main(String[] args) {
		System.out.println(search("initantion"));
	}
}
