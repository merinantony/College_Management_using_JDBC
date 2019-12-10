package project;

import java.sql.SQLException;
import java.util.Scanner;

public class Mainproject {

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Mainproject mp=new Mainproject();
		mp.show();
	}

  public void show() throws ClassNotFoundException, SQLException
  {
     Scanner s=new Scanner(System.in);
     System.out.println("1)Admin\n2)Staff\n3)Student\n4)Exit");
     System.out.println("enter the choice");
     int ch=s.nextInt();
     switch(ch)
     {
     case 1:
    	 Superadmin superadmin=new Superadmin();
    	 superadmin.display();
     break;
     case 2:
    	 Superstaff superstaff=new Superstaff();
    	 superstaff.display();
     break;
     case 3:
    	 Superstudent superstudent=new Superstudent();
    	 superstudent.display();
     break;
     case 4:
    	 System.exit(0);
     
    }
  }
}
