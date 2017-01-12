/**
 * 
 */
package com.wuxy13.book.codeBeauty.demo_one.chess;

import java.sql.Struct;

/**
 * @author Administrator
 * 
 * 变量只能使用一个，所以对基本类型进行拆分复用
 * 将二维的坐标简化映射到一维
 * 通过取模运算进行位置比对
 *
 */
public class ChessJSMove {

	/**
	 * @param args
	 */
	private class ChessAB{
		public short chessA;
		public short chessB;
	}
	
	public void getChessJSMove(){
		ChessAB i=new ChessAB();
		for(i.chessA=0;i.chessA<9;i.chessA++){
			for(i.chessB=0;i.chessB<9;i.chessB++){
				if(i.chessA%3!=i.chessB%3){
					System.out.print("(A:"+(i.chessA+1)+"B:"+(i.chessB+1)+")");
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChessJSMove chessAB=new ChessJSMove();
		chessAB.getChessJSMove();
		
	}

}
