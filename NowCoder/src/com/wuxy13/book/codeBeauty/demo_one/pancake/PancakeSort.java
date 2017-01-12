package com.wuxy13.book.codeBeauty.demo_one.pancake;

public class PancakeSort {
	private int[] m_CakeArray;	//烙饼信息数组
	private int m_nCakeCnt;		//烙饼个数
	private int m_nMaxSwap;		//最多交换次数
	private int[] m_SwapArray;	//交换结果数组
	private int[] m_ReverseCakeArray;	//当前翻转烙饼信息数组
	private int[] m_ReverseSwapArray;	//当前翻转烙饼交换结果数组
	private int m_nsearch;		//当前搜索次数信息
	
	public PancakeSort() {		//构造函数 初始化部分参数
		m_nCakeCnt=0;
		m_nMaxSwap=0;
	}
	
	private void run(int[] array,int length){		//计算翻转信息
		Init(array,length);
		m_nsearch=0;
		search(0);
	}
	

	private void Init(int[] array, int length) {	//初始化
		assert(array!=null);
		assert(length>0);
		
		m_nCakeCnt=length;
		m_CakeArray=array.clone();
		m_nMaxSwap=upBound(m_nCakeCnt);
		m_SwapArray=new int[m_nMaxSwap];
		m_ReverseCakeArray=m_CakeArray.clone();
		m_ReverseSwapArray=new int[m_nMaxSwap];
	}
	
	private int upBound(int CakeCnt) {	//计算交换次数上界
		//return CakeCnt*2;
		return (CakeCnt-1)*2;
	}
	
	private int lowBound(int[] array,int CakeCnt){	//计算交换次数下界
		int t,ret=0;
		for(int i=1;i<CakeCnt;i++){
			t=array[i]-array[i-1];
			if(!((t==1)||(t==-1))){
				ret++;
			}
		}
		return ret;
	}

	private void search(int step) {	//排序
		int nEstimate;
		m_nsearch++;
		nEstimate=lowBound(m_ReverseCakeArray, m_nCakeCnt);
		if(step+nEstimate>m_nMaxSwap){return;}
		if(isSorted(m_ReverseCakeArray, m_nCakeCnt)){
			if(step<m_nMaxSwap){
				m_nMaxSwap=step;
				m_SwapArray=m_ReverseCakeArray.clone();
			}
			return;
		}
		for(int i=1;i<m_nCakeCnt;i++){
			reverse(0, i);
			m_ReverseSwapArray[step]=i;
			search(step+1);
			reverse(0, i);
		}
	}

	private boolean isSorted(int[] array,int length){	//判断数组是否已排好序
		for(int i=1;i<length;i++){
			if(array[i-1]>array[i]){return false;}
		}
		return true;
	}
	
	private void reverse(int nBegin,int nEnd){		//翻转数组(烙饼信息)
		assert(nBegin<nEnd);
		int nTemp;
		for(int i=nBegin,j=nEnd;i<j;i++,j--){
			nTemp=m_ReverseCakeArray[j];
			m_ReverseCakeArray[j]=m_ReverseCakeArray[i];
			m_ReverseCakeArray[i]=nTemp;
		}
	}
	
	public void getResult(int[] array,int length){	//输出
		run(array, length);
		for(int i=0;i<m_nCakeCnt;i++){
			System.out.print(m_SwapArray[i]+" ");
		}
		System.out.println();
		System.out.println("Search time:"+m_nsearch);
		System.out.println("Total swap times:"+m_nMaxSwap);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array=new int[]{3,1,2};
		int length=array.length;
		PancakeSort pancakeSort=new PancakeSort();
		pancakeSort.getResult(array, length);
	}

}
