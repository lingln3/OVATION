import java.util.Scanner;

/**
 * 
 * @author GLN
 * �������в����е��ַ���ֵת��Ϊ��ֵ
 *
 */
public class NewRoot {
	public static void main(String[] args){
		NewRoot newRoot = new NewRoot();
		/*int number = 100;
		if(args.length > 0){
			number = Integer.parseInt(args[0]);
		}
		System.out.println("The square root of " 
					+ number
					+ " is "
					+ Math.sqrt(number));*/
/*		System.out.println("������һ����ֵ:");
		Scanner in = new Scanner(System.in);
		String get = in.nextLine();
		int out = 0;
		while(!get.equals("0"))
		{
			out = Integer.parseInt(get);
			System.out.println("��õ������ǣ�"+out);
			System.out.println("���������һ����ֵ:");
			get = in.nextLine();
		}
		System.out.println("����������0��������Ϸ�ѽ�����");
*/		
		/*System.out.println("������һ��������");//����yiweiSuanfa()
		Scanner in = new Scanner(System.in);
		int get = in.nextInt();
		newRoot.yiweiSuanfa(get);*/
		newRoot.buguizeShuzu(9);
	}
	/*�����з������ƣ�>>�����޷������ƣ�>>>��������*/
	public void yiweiSuanfa(int a)
	{
		int b,c;
		b = a >> 2;
		c = a >>> 2;
		System.out.println(b);
		System.out.println(c);
	}
	/*���Բ��������飬����ά�����ÿһ�е�Ԫ�ظ�����һ��*/
	public void buguizeShuzu(int hang)
	{
		int i = 0;
		int[][] a = new int[hang][];
		//���������������������
		for(int n =0;n<hang;n++)
		{
			a[n] = new int[n+1];
		}
		//�������ÿһ�н��з���
		for(int m = 0; m<a.length;m++)
		{
			//��ÿһ�е�ÿһ�н��з���
			for(int k = 0; k <a[m].length;k++)
			{
				a[m][k] = i++;
			}
		}
		for(int m = 0; m<a.length;m++)
		{
			//��ÿһ�е�ÿһ�н��з���
			for(int k = 0; k <a[m].length;k++)
			{
				System.out.print(a[m][k]+" ");
			}
			System.out.println();
		}
	}
}
