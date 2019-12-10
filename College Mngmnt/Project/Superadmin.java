package project;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import shopping.Connectionshop;

public class Superadmin 
{
	ConnectionManagers con=new ConnectionManagers();
	public void display() throws ClassNotFoundException, SQLException
	{
		Scanner s=new Scanner(System.in);
		int n,c,t=0,d=0;
		System.out.println("Enter the username");
		String user1=s.next();
		System.out.println("Enter the password");
		String pwd1=s.next();
		Statement st=con.getConnection().createStatement();
		ResultSet rs=st.executeQuery("select * from super_adminlogin");
		while(rs.next())
		{
			if(rs.getString(1).equals(user1)&&rs.getString(2).equals(pwd1))
			{
				System.out.println("Welcome to admin login");
				do
				{
					System.out.println("1)Insert staff\n2)View\n3)Update staff\n4)Delete staff\n5)Logout");
					System.out.println("enter the choice");
					n=s.nextInt();
					switch(n)
					{
					case 1:
						System.out.println("Enter the staff name");
						String sname=s.next();
						System.out.println("Enter the staff id");
						int sid=s.nextInt();
						System.out.println("Enter the department");
						String sdep=s.next();
						System.out.println("Enter the basic salary");
						int salary=s.nextInt();
						System.out.println("Enter the no of days present");
						int num=s.nextInt();
						int sl=salary*num;
                        PreparedStatement ps=con.getConnection().prepareStatement("insert into staff_add(Staff_name,Staff_id,Staff_department,Basic_salary,Salary,Days_present)values(?,?,?,?,?,?)");
                        ps.setString(1,sname);
                        ps.setInt(2,sid);
                        ps.setString(3,sdep);
                        ps.setInt(4,salary);
                        ps.setInt(5,sl);
                        ps.setInt(6,num);
                        ps.executeUpdate();
                        System.out.println("Staff details added successfull");
					break;
					case 2:
					do
					{   
						System.out.println("1)View staff\n2)View student\n3)exit");
						System.out.println("enter the choice");
						c=s.nextInt();
						if(c==1)
						{
							Statement st1=con.getConnection().createStatement();
							ResultSet rs1=st1.executeQuery("Select * from staff_add");
								while(rs1.next())
								{
									System.out.println("Staff name:"+rs1.getString(1)+"\n"+"Staff id:"+rs1.getString(2)+"\n"+"Department:"+rs1.getString(3)+"\n"+"Basic_salary:"+rs1.getInt(4)+"\n"+"Salary:"+rs1.getInt(5)+"\n"+"Days_present:"+rs1.getInt(6));
						        }
						}
						else if(c==2)
						{
							Statement st1=con.getConnection().createStatement();
							ResultSet rs1=st1.executeQuery("Select * from staff_add");
								while(rs1.next())
								{
									//System.out.println("Staff name:"+rs1.getString(1)+"\n"+"Staff id:"+rs1.getString(2)+"\n"+"Department:"+rs1.getString(3)+"\n"+"Salary:"+rs1.getInt(4));
						        }
						}
						else if(c==3)
						{
							
						break;
						}
						

					}while(c!=0);
					
				break;
				case 3:
					System.out.println("Enter the staff id");
					int nid=s.nextInt();
					System.out.println("Enter the no of days present");
					int nday=s.nextInt();
					Statement st3=con.getConnection().createStatement();
					ResultSet rs3=st3.executeQuery("select Basic_salary from staff_add where Staff_id="+nid);
				    while(rs3.next())
				    {
				    	
				    	d=rs3.getInt(1);
				    	t=t+d*nday;
				    	
				    	
				    }
				    PreparedStatement pst1=con.getConnection().prepareStatement("update staff_add set Salary=?,Days_present=? where Staff_id=?");
					pst1.setInt(1,t);
					pst1.setInt(2,nday);
					pst1.setInt(3,nid);
					pst1.executeUpdate();
                    System.out.println("Updated successfully");
				break;
				case 4:
					Statement str=con.getConnection().createStatement();
					ResultSet rstr=str.executeQuery("select * from staff_add");
					System.out.println("enter the delete id");
				 int id=s.nextInt();
				 PreparedStatement pss=con.getConnection().prepareStatement("delete from staff_add where Staff_id=?");
				 pss.setInt(1,id);
				 pss.executeUpdate();
				 System.out.println("Staff details removed successfully");
				break;
				case 5:
					Mainproject mp=new Mainproject();
					mp.show();
                break;
			  }
			}while(n!=0);
			}
			else
				System.out.println("Invalid username or password");
			Mainproject mp=new Mainproject();
			mp.show();
			
		}
	}
}
			