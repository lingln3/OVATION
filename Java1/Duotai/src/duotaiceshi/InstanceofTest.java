package duotaiceshi;

public class InstanceofTest {
	private static int count_p = 0;
	private static int count_t = 0;
	private static int count_d = 0;
	public static void main(String[] args){
		People p1 = new People();
		People p2 = new Teacher();//向上转型
		People p3 = new Doctor();
		People[] p = {p1,p2,p3};
		Teacher t1;
		Doctor d1;
		if(p3 instanceof Doctor){
			d1 = (Doctor)p3;
		}
		t1 = (Teacher) p2;
		//t1 = (Teacher)p1;
		for(People ps :p){
			if(ps instanceof People){
				count_p++;
				System.out.println("我是普通人"+count_p);
			}
			if(ps instanceof Teacher){
				t1 = (Teacher)ps;
				count_t++;
				System.out.println("我是老师"+count_t);
			}
			if(ps instanceof Doctor){
				d1 = (Doctor)ps;
				count_d++;
				System.out.println("我是医生"+count_d);
			}
		}
	}
}
class People{
}
class Teacher extends People{
	
}
class Doctor extends People{
	
}
