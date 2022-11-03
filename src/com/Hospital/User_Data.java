package com.Hospital;
import java.util.*;
public class User_Data 
{
	
	int doct;
    private String Name;
	private int Age;
	private String Blood_Group;
	private ArrayList<User_Data> items = new ArrayList<User_Data>();

    public  void details(String Name,int Age,String Blood_Group) 
  	{   
  		this.Name= Name;
		this.Age =Age;
		this.Blood_Group =Blood_Group;
	}
    
    public String getName() 
    {
		return Name;
	}

	public int getAge() 
	{
		return Age;
	}

	public String getBlood_Group() {
		return Blood_Group;
	}

	public ArrayList<User_Data> getItems() {
		return items;
	}

    




}