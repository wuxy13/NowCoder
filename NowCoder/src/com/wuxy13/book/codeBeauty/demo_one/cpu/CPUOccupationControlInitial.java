package com.wuxy13.book.codeBeauty.demo_one.cpu;

/*
 * cpu占用率固定在50%，为一条直线
 * 
 * 本方法通过获取时间戳来计算时间差，进而通过循环与休眠来实现对cpu占用率的控制
 * bug:仅考虑了本程序为系统唯一进程的情况，没有考虑其他进程的影响
 * */

public class CPUOccupationControlInitial {
	public void control() throws InterruptedException{
		int busyTime=10;
		int idleTime=busyTime;
		long currentTime;
		while(true){
			currentTime=System.currentTimeMillis();
			while(System.currentTimeMillis()-currentTime<=busyTime){
				System.out.println("**********");
			}
			System.out.println("sleep");
			Thread.sleep(idleTime);
		}
	}
	
	public static void main(String[] args) {
		CPUOccupationControlInitial coc=new CPUOccupationControlInitial();
		try {
				coc.control();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
