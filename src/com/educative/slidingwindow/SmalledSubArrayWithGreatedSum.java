
public class SmalledSubArrayWithGreatedSum {

	
	private static int findMinSubArray(int S, int[] a) {
		
		int startWindow=0;
		int runnningSum=0;
		int minLength=Integer.MAX_VALUE;
		for(int endOfWindow=0; endOfWindow<a.length; endOfWindow++) {
			runnningSum+=a[endOfWindow];
			
			while(runnningSum >= S) {
				if(endOfWindow-startWindow+1 < minLength)
					minLength=endOfWindow-startWindow+1;
				runnningSum-=a[startWindow];
				startWindow++;
			}
		}
		return minLength==Integer.MAX_VALUE?0:minLength;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = new int[] {2,1,5,2,3,2};
		
		System.out.println( findMinSubArray(7, nums) );
	}

}
