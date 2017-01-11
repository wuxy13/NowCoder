package com.wuxy13.programme.year_2017.udache.demo_1.modify;

import java.util.Scanner;

public class GetMaxChildArraySumModify {
	
	public int getMaxChildArraySum(int length,int[] array){
		int result=array[0];
		int current=0;
		for(int i=0;i<length;i++){
			current+=array[i];
			if(current>result){
				result=current;
			}
			if(current<0){
				current=0;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetMaxChildArraySumModify gmca=new GetMaxChildArraySumModify();
		
		int length;
		int[] array;
		Scanner scanner=new Scanner(System.in);
		System.out.println("������Ԫ�ظ���");
		length=scanner.nextInt();
		System.out.println("������ÿ��Ԫ��");
		array=new int[length];
		for(int i=0;i<length;i++){
			array[i]=scanner.nextInt();
		}
		System.out.println(gmca.getMaxChildArraySum(length, array));
	}
}
