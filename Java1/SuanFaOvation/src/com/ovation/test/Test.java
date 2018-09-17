package com.ovation.test;

import java.util.Scanner;

import com.ovation.suanfa.FLIPFLOP;
import com.ovation.tools.Out;
/**
 * 测试代码
 * @author snpas
 *
 */
public class Test {

	public static void main(String[] args) {
		Out.out("请设定算法类型type为SET或RESET");
		Scanner scan = new Scanner(System.in);
		String set,reset;
		FLIPFLOP flip = new FLIPFLOP(scan.nextLine().toUpperCase());//获取算法类型
		while(true){
			Out.out("请设定算法的S值：");
			set = scan.nextLine();
			Out.out("请设定算法的R值：");
			reset = scan.nextLine();
			flip.set(Out.fromStrToBool(set),Out.fromStrToBool(reset));
			Out.out(flip.get_out()+"");
		}
	}

}
