package project;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Superstaff
{
	ConnectionManagers con=new ConnectionManagers();
	public void display() throws ClassNotFoundException, SQLException 
	{

		Scanner s=new Scanner(System.in);
		int c,ch1,new_mark=0;
		System.out.println("Enter the username");
		String user2=s.next();
		System.out.println("Enter the password");
		String pwd2=s.next();
		Statement stt=con.getConnection().createStatement();
		ResultSet rst=stt.executeQuery("select * from staff_login");
		while(rst.next())
		{
			if(rst.getString(1).equals(user2)&&rst.getString(2).equals(pwd2))
			{
				System.out.println("Welome to staff login");
				do
				{
					
					System.out.println("1)Insert student\n2)View(Staff/Student)\n3)Update student\n4)Delete student\n5)Logout");
				    System.out.println("enter the choice");
				    c=s.nextInt();
				    switch(c)
				    {
				    case 1:
				    	System.out.println("Enter the student id");
						int id1=s.nextInt();
				    	System.out.println("Enter the student name");
						String name1=s.next();
						System.out.println("Enter the department");
						String dep1=s.next();
						System.out.println("Enter the mark of subject1");
						int sub1=s.nextInt();
						System.out.println("Enter the mark of subject2");
						int sub2=s.nextInt();
						System.out.println("Enter the mark of subject3");
						int sub3=s.nextInt();
						System.out.println("Enter the mark of subject4");
						int sub4=s.nextInt();
						System.out.println("Enter the mark of subject5");
						int sub5=s.nextInt();
						int mark=sub1+sub2+sub3+sub4+sub5;
						System.out.println("Enter the total mark"+mark);
						System.out.println("Enter the attendance");
						int att=s.nextInt();
                        PreparedStatement ps=con.getConnection().prepareStatement("insert into student_add(Student_id,Student_name,Student_department,Subject1,Subject2,Subject3,Subject4,Subject5,Total_mark,Attendance)values(?,?,?,?,?,?,?,?,?,?)");
                        ps.setInt(1,id1);
                        ps.setString(2,name1);
                        ps.setString(3,dep1);
                        ps.setInt(4,sub1);
                        ps.setInt(5,sub2);
                        ps.setInt(6,sub3);
                        ps.setInt(7,sub4);
                        ps.setInt(8,sub5);
                        ps.setInt(9,mark);
                        ps.setInt(10,att);
                        ps.executeUpdate();
                        System.out.println("Student details added successfull");
                      break;
				    case 2:
				    	do
				    	{
				    	System.out.println("1)View staff\n2)View student\n3)Exit");
				    	System.out.println("enter the choice");
				    	ch1=s.nextInt();
				    	if(ch1==1)
				    	{
				    		Statement st1=con.getConnection().createStatement();
							ResultSet rs1=st1.executeQuery("Select * from staff_add");
								while(rs1.next())
								{
									System.out.println("Staff name:"+rs1.getString(1)+"\n"+"Staff id:"+rs1.getString(2)+"\n"+"Department:"+rs1.getString(3)+"\n"+"Salary:"+rs1.getInt(4));
						        }
						}
						else if(ch1==2)
						{
							Statement st1=con.getConnection().createStatement();
							ResultSet rs1=st1.executeQuery("Select * from student_add");
								while(rs1.next())
								{
									System.out.println("Student name:"+rs1.getString(1)+"\n"+"Student id:"+rs1.getString(2)+"\n"+"Student_department:"+rs1.getString(3)+"\n"+"Subject1:"+rs1.getInt(4)+"\n"+"Subject2:"+rs1.getInt(5)+"\n"+"Subject3:"+rs1.getInt(6)+"\n"+"Subject4:"+rs1.getInt(7)+"\n"+"Subject5:"+rs1.getInt(8)+"\n"+"Total_mark:"+rs1.getInt(9)+"\n"+"Attendance:"+rs1.getInt(10)+"\n");
						        }
                        }
						else if(ch1==3)
						{
						
							break;
						}
				    	}while(ch1!=0);
				    	con.getConnection().close();
				    break;
				    case 3:
						System.out.println("Enter the student id");
						int nid=s.nextInt();
						System.out.println("Enter the mark for subject 1");
						int new_sub1=s.nextInt();
						System.out.println("Enter the mark for subject 2");
						int new_sub2=s.nextInt();
						System.out.println("Enter the mark for subject 3");
						int new_sub3=s.nextInt();
						System.out.println("Enter the mark for subject 4");
						int new_sub4=s.nextInt();
						System.out.println("Enter the mark for subject 5");
						int new_sub5=s.nextInt();
						Statement st3=con.getConnection().createStatement();
						ResultSet rs3=st3.executeQuery("select Subject1,Subject2,Subject3,Subject4,Subject5,Total_mark from student_add where Student_id="+nid);
					    while(rs3.next())
					    {
					    	
					    	new_mark=new_sub1+new_sub2+new_sub3+new_sub4+new_sub5;
					    }
					    PreparedStatement pst1=con.getConnection().prepareStatement("update student_add set Subject1=?,Subject2=?,Subject3=?,Subject4=?,Subject5=?,Total_mark=? where Student_id=?");
					    pst1.setInt(1,new_sub1);
					    pst1.setInt(2,new_sub2);
					    pst1.setInt(3,new_sub3);
					    pst1.setInt(4,new_sub4);
					    pst1.setInt(5,new_sub5);
					    pst1.setInt(6,new_mark);
						pst1.setInt(7,nid);
						pst1.executeUpdate();
		                System.out.println("Updated successfully");
					break;
				    case 4:
				    	Statement str=con.getConnection().createStatement();
						ResultSet rstr=str.executeQuery("select * from student_add");
						System.out.println("enter the delete id");
					 int id=s.nextInt();
					 PreparedStatement pss=con.getConnection().prepareStatement("delete from student_add where Student_id=?");
					 pss.setInt(1,id);
					 pss.executeUpdate();
					 System.out.println("Student details removed successfully");
				    break;
				    case 5:
				    	Mainproject mp=new Mainproject();
						mp.show();
				    break;

				    }
				}while(c!=0);
			
			
			}
			else
				System.out.println("invalid username or password");
			Mainproject mp=new Mainproject();
			mp.show();
		}
		
		
	}

}