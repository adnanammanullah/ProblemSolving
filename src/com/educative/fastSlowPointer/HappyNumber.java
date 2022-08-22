package com.educative.fastSlowPointer;

import java.util.*;

class HappyNumber {

  public static boolean find(int num) {
    // // TODO: Write your code here
    List<Integer> visitedNumers = new ArrayList<Integer>();
    while(!visitedNumers.contains(num)) {
    	visitedNumers.add(num);
    	num = squareSum(num);
    	if(num==1) return true;
    }
    return false;
  }

  public static int squareSum(int num){
	  int newNum=0;
	  while(num>0) {
		  newNum+=(num%10*num%10);
		  num/=10;
	  }
	  return newNum;
  }

  public static void main(String[] args) {
    System.out.println(HappyNumber.find(23));
    System.out.println(HappyNumber.find(12));
     System.out.println(HappyNumber.find(145));
  }
}