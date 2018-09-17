import java.util.Scanner;

/**
 * 
 * @author GLN
 * 将命令行参数中的字符串值转换为数值
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
/*		System.out.println("请输入一个数值:");
		Scanner in = new Scanner(System.in);
		String get = in.nextLine();
		int out = 0;
		while(!get.equals("0"))
		{
			out = Integer.parseInt(get);
			System.out.println("获得的整数是："+out);
			System.out.println("请继续输入一个数值:");
			get = in.nextLine();
		}
		System.out.println("由于您输入0，您的游戏已结束！");
*/		
		/*System.out.println("请输入一个整数：");//测试yiweiSuanfa()
		Scanner in = new Scanner(System.in);
		int get = in.nextInt();
		newRoot.yiweiSuanfa(get);*/
		newRoot.buguizeShuzu(9);
	}
	/*测试有符号右移（>>）和无符号右移（>>>）的区别*/
	public void yiweiSuanfa(int a)
	{
		int b,c;
		b = a >> 2;
		c = a >>> 2;
		System.out.println(b);
		System.out.println(c);
	}
	/*测试不规则数组，即多维数组的每一行的元素个数不一样*/
	public void buguizeShuzu(int hang)
	{
		int i = 0;
		int[][] a = new int[hang][];
		//分配具有所含行数的数组
		for(int n =0;n<hang;n++)
		{
			a[n] = new int[n+1];
		}
		//对数组的每一行进行分配
		for(int m = 0; m<a.length;m++)
		{
			//对每一行的每一列进行分配
			for(int k = 0; k <a[m].length;k++)
			{
				a[m][k] = i++;
			}
		}
		for(int m = 0; m<a.length;m++)
		{
			//对每一行的每一列进行分配
			for(int k = 0; k <a[m].length;k++)
			{
				System.out.print(a[m][k]+" ");
			}
			System.out.println();
		}
	}
}
