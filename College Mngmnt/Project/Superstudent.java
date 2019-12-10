package project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Superstudent
{
	ConnectionManagers con=new ConnectionManagers();
	public void display() throws ClassNotFoundException, SQLException
	{
		Scanner s=new Scanner(System.in);
		int ch1;
		System.out.println("Enter the username");
		String user2=s.next();
		System.out.println("Enter the password");
		String pwd2=s.next();
		Statement stt=con.getConnection().createStatement();
		ResultSet rst=stt.executeQuery("select * from student_login");
		while(rst.next())
		{
			if(rst.getString(1).equals(user2)&&rst.getString(2).equals(pwd2))
			{
				System.out.println("Welcome to Student login");
				do
				{
					System.out.println("1)View\n2)Logout");
					System.out.println("Enter the choice");
					ch1=s.nextInt();
					switch(ch1)
					{
					case 1:
						Statement st1=con.getConnection().createStatement();
						ResultSet rs1=st1.executeQuery("Select * from student_add");
							while(rs1.next())
							{
								System.out.println("Student name:"+rs1.getString(1)+"\n"+"Student id:"+rs1.getString(2)+"\n"+"Student_department:"+rs1.getString(3)+"\n"+"Subject1:"+rs1.getInt(4)+"\n"+"Subject2:"+rs1.getInt(5)+"\n"+"Subject3:"+rs1.getInt(6)+"\n"+"Subject4:"+rs1.getInt(7)+"\n"+"Subject5:"+rs1.getInt(8)+"\n"+"Total_mark:"+rs1.getInt(9)+"\n"+"Attendance:"+rs1.getInt(10)+"\n");
					        }

					break;
					case 2:
						
						Mainproject mp=new Mainproject();
						mp.show();

					break;
					}
				}while(ch1!=0);
			}
			else
				System.out.println("Invalid username or password");
			Mainproject mp=new Mainproject();
			mp.show();

		}
		
	}

}
