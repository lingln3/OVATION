package zhixingshunxu;
class Parent{
	private int num = 1;
	private int num2 = 2;
	public Parent(){
		System.out.println("����Ĺ�����");
	}
	public void test(){
		System.out.println("���Ǹ����test����");
	}
}
public class Test extends Parent{
	private String name;
	private int age;
	private double d = 0.21;
	public Test(){
		System.out.println("name="+name+",age="+age+",d="+d);
		name = "Tom";
		age = 20;
		System.out.println("name="+name+",age="+age+",d="+d);
	}
	public static void main(String[] args){
		Test t = new Test();
		System.out.println(t.name + "��������"+t.age);
	}
}
