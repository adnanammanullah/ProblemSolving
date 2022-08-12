import java.util.HashSet;
import java.util.Set;

public class FruitsIntoBasket {
	
	public static int findLength(char[] arr) {
		int k=2;
		Set<String> fruitBasket = new HashSet<>();
		int maxFruits = Integer.MIN_VALUE;
		int windowStart=0;
		
		for(int windowEnd=0; windowEnd<arr.length; windowEnd++) {
			
			fruitBasket.add(String.valueOf(arr[windowEnd]));
			if(fruitBasket.size()<=k) {
				if(windowEnd-windowStart+1 > maxFruits)
					maxFruits=windowEnd-windowStart+1;
			} else {
				while(arr[windowStart]==arr[windowStart+1] && windowStart<arr.length-1)
					windowStart++;
				fruitBasket.remove(String.valueOf(arr[windowStart]));
				windowStart++;
			}
		}
		
		return maxFruits;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
		System.out.println(findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));

	}

}
