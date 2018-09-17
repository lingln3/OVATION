package duotaiceshi;
/**
 * 进行Java多态和动态绑定学习
 * @author snpas
 *
 */
public class DuotaiTest {
	public static void main(String[] args){
		Father f = new Son();
		
		f.setMoney(10);
		//f.setMoney(0.54);
		
	}
	
}
class Father{
	private int money;
	public Father(){
		System.out.println("调用父类的构造方法");
	}
	public void setMoney(int m){
		money = m;
		System.out.println("调用父类的方法");
	}
	public void setMoney2(int m){
		System.out.println("调用父类的方法2");
	}
	public int getMoney(){
		return money;
	}
}
class Son extends Father{
	private float money;
	public Son(){
		System.out.println("调用子类的构造方法");
	}
	public void setMoney(float m){
		money = m;
		System.out.println("调用子类的方法");
	}
	public void setMoney2(float m){
		System.out.println("调用子类的方法2");
	}
	public int getMoney(){
		return (int)money;
	}
}