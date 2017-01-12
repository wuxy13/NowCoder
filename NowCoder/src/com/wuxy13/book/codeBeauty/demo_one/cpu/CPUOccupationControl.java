package com.wuxy13.book.codeBeauty.demo_one.cpu;

import org.hyperic.sigar.Cpu;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

/*
 * cpu占用率固定在50%，为一条直线
 * 
 * 本方法直接监控cpu总的占用率，从而实现更准确的控制
 * 本方法通过sigar包实现对cpu占用率的监控
 * */

public class CPUOccupationControl {
	public void control() throws InterruptedException, SigarException{
		double level=0.5;
		double currentCpuOccupy;
		Sigar sigar=new Sigar();
		while(true){
			currentCpuOccupy=sigar.getCpuPerc().getCombined();
			if(currentCpuOccupy>level){
				Thread.sleep(10);
			}else{
				System.out.println(currentCpuOccupy);
			}
		}
		
	}
	
	public static void main(String[] args) throws SigarException, InterruptedException {
		CPUOccupationControl coc=new CPUOccupationControl();
		coc.control();
	}
}
