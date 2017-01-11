package com.wuxy13.programme.year_2017.udache.demo_1.initial;

import java.util.Scanner;

public class GetMaxChildArraySum {

	public int getMaxChildArraySum(int length,int[] array){
		int tempResult;
		int result=getMaxChildArraySumOfStep(1, array);
		for(int step=2;step<length;step++){
			tempResult=getMaxChildArraySumOfStep(step, array);
			if(tempResult>result){
				result=tempResult;
			}
		}
		return result;
	}
	
	public int getMaxChildArraySumOfStep(int step,int[] array){
		int tempResult;
		int result=-99999;
		for(int i=0;i<array.length-step+1;i++){
			tempResult=0;
			for(int j=0;j<step;j++){
				tempResult+=array[i+j];
			}
			if(tempResult>result){
				result=tempResult;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetMaxChildArraySum gmca=new GetMaxChildArraySum();
		
		int length;
		int[] array;
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入元素个数");
		length=scanner.nextInt();
		System.out.println("请输入每个元素");
		array=new int[length];
		for(int i=0;i<length;i++){
			array[i]=scanner.nextInt();
		}
		System.out.println("所有连续子数组中和最大的值为:"+gmca.getMaxChildArraySum(length, array));
	}

}
