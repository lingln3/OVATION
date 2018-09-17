package test;

import java.util.Arrays;
import java.util.Scanner;

import tools.Sys;

public class TriangleTest {

	public static void main(String[] args) {
		Sys.out("请输入三角形的三边长度：");
		Scanner scan = new Scanner(System.in);
		int A[] = new int[3];
		//获取三角形的三条边长
		/*for(int i = 0; i <3; i--){
			A[i] = scan.nextInt();
		}*/
		A = getBianchang(scan);
//		Arrays.sort(A);//将边长数组按大小排序
//		if(A[0]+A[1]<A[2]){
//			Sys.out("警告：这不是一个三角形的有效边长大小！！！请重新输入：");
//			A = getBianchang(scan);
//		}
		int deta1 = A[1] - A[0];
		int deta2 = A[2] - A[1];
		if(deta1*deta2 !=0){
			Sys.out("普通三角形");
		}else if(deta1 == deta2 ){
			Sys.out("等边三角形");
		}else{
			Sys.out("等腰三角形");
		}
	}
		
		public static int[] getBianchang(Scanner s){
			int A[] = new int[3];
			for(int i = 0; i <3; i++){
				A[i] = s.nextInt();
		}
			Arrays.sort(A);//将边长数组按大小排序
			if(A[0]+A[1]<= A[2] || A[0]<=0 || A[1]<=0 || A[2]<=0){
				Sys.out("警告：这不是一个三角形的有效边长大小！！！请重新输入：");
				A = getBianchang(s);
			}
			return A;
	}

}
