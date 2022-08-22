package com.educative.twopointer;

public class StringWithBackspaces {
	
	 public static boolean compare(String str1, String str2) {
		 boolean isEqual=true;
		 int i=str1.length()-1;
		 int bpCount1=0;
		 int j=str2.length()-1;
		 int bpCount2=0;
		 while(isEqual && i>=0 && j>=0) {
			 while(i>=0 && str1.charAt(i)=='#') {
				 bpCount1++;
				 i--;
			 }
			 
			 while(j>=0 && str2.charAt(j)=='#') {
				 bpCount2++;
				 j--;
			 }
			 
			 i=i-bpCount1;
			 bpCount1=0;
			 j=j-bpCount2;
			 bpCount2=0;
			 
			 if(i>=0 && j>=0 && str1.charAt(i)==str2.charAt(j)) {
				 i--;
				 j--;
			 }else {
				 isEqual=false;
			 }
		 }
		 
		 return isEqual;
	 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(compare("xy#z", "xzz#"));
	    System.out.println(compare("xy#z", "xyz#"));
	    System.out.println(compare("xp#", "xyz##"));    
	    System.out.println(compare("xywrrmp", "xywrrmu#p"));
	    System.out.println(compare("abc", "abcabc###"));

	}

}
