package classic;

public class Permutation {
	private static int count = 0;
	public static void permutate(int[] headNumbers,int[] tailNumbers){ 
		if (tailNumbers.length <= 1) {
			int[] numbers = new int[headNumbers.length + tailNumbers.length];
			System.arraycopy(headNumbers, 0, numbers, 0, headNumbers.length);
			System.arraycopy(tailNumbers, 0, numbers, headNumbers.length, tailNumbers.length);
			count++;
			for (int i = 0; i < numbers.length; i++) {
				System.out.print(numbers[i]);
			}
			System.out.println();
		}
		else {
			for (int i = 0; i < tailNumbers.length; i++) {						  
				int[] newHeadNumbers = new int[headNumbers.length+1];
				System.arraycopy(headNumbers, 0, newHeadNumbers, 0, headNumbers.length);
				newHeadNumbers[headNumbers.length] = tailNumbers[i];
				int[] newTailNumbers = new int[tailNumbers.length-1];
				System.arraycopy(tailNumbers, 0, newTailNumbers, 0, i);
				System.arraycopy(tailNumbers, i+1, newTailNumbers, i, tailNumbers.length-i-1);

				permutate(newHeadNumbers, newTailNumbers);
			}
		}
	}
	
	public static void permutate(int start,int end){
		int[] tail = new int[end - start + 1];
		for (int i = start; i <= end; i++) {
			tail[i] = i;
		}
		permutate(new int[]{}, tail);
	}
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		permutate(0,7);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println(count);
	}
}
