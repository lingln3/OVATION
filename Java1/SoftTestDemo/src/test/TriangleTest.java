package test;

import java.util.Arrays;
import java.util.Scanner;

import tools.Sys;

public class TriangleTest {

	public static void main(String[] args) {
		Sys.out("�����������ε����߳��ȣ�");
		Scanner scan = new Scanner(System.in);
		int A[] = new int[3];
		//��ȡ�����ε������߳�
		/*for(int i = 0; i <3; i--){
			A[i] = scan.nextInt();
		}*/
		A = getBianchang(scan);
//		Arrays.sort(A);//���߳����鰴��С����
//		if(A[0]+A[1]<A[2]){
//			Sys.out("���棺�ⲻ��һ�������ε���Ч�߳���С���������������룺");
//			A = getBianchang(scan);
//		}
		int deta1 = A[1] - A[0];
		int deta2 = A[2] - A[1];
		if(deta1*deta2 !=0){
			Sys.out("��ͨ������");
		}else if(deta1 == deta2 ){
			Sys.out("�ȱ�������");
		}else{
			Sys.out("����������");
		}
	}
		
		public static int[] getBianchang(Scanner s){
			int A[] = new int[3];
			for(int i = 0; i <3; i++){
				A[i] = s.nextInt();
		}
			Arrays.sort(A);//���߳����鰴��С����
			if(A[0]+A[1]<= A[2] || A[0]<=0 || A[1]<=0 || A[2]<=0){
				Sys.out("���棺�ⲻ��һ�������ε���Ч�߳���С���������������룺");
				A = getBianchang(s);
			}
			return A;
	}

}
