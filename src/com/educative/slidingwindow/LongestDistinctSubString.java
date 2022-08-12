import java.util.HashSet;
import java.util.Set;

public class LongestDistinctSubString {
	
	public static int findLength(String str) {
		
		Set<String> disChar = new HashSet<>();
		int maxLen = Integer.MIN_VALUE;
		int windowStart=0;
		
		for(int windowEnd=0; windowEnd<str.length(); windowEnd++) {
			
			if(disChar.contains(String.valueOf(str.charAt(windowEnd)))) {
				//move start
				while(str.charAt(windowStart)!=str.charAt(windowEnd) && windowStart<=windowEnd) {
					disChar.remove(String.valueOf(str.charAt(windowStart)));
					windowStart++;
				}
				disChar.remove(String.valueOf(str.charAt(windowStart)));
				windowStart++;
			}
			
			disChar.add(String.valueOf(str.charAt(windowEnd)));
			
			if(windowEnd-windowStart+1 > maxLen)
				maxLen = windowEnd-windowStart+1;
		}
		
		return maxLen;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findLength("abccdefgzyabc"));
		
	}

}
