package Hospital_Project;
import java.util.*;


public class Patinent1 {
	
	static Map<Integer,Patinent1> m = new HashMap<>();
	String name;
	int age;
	int id;
	int n = 0;
public void Patinent2(String name , int age)
{
	this.name=name;
	this.age= age;
	this.id=n++;
}


public static void main(String[] args) 
{
	
	Patinent1 p = new Patinent1();
	p.Patinent2("ran",18);
	m.put(p.id, p);
	p.Patinent2("gayu",19);
	m.put(p.id, p);
	System.out.println(m.values());
	
	
//	for(Patinent1 w : m.values())
//	{
//		System.out.println(w.name);
//		System.out.println(w.age);
//
//	}
	
}

}
