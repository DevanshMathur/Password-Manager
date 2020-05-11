import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

/*import javax.swing.JScrollPane;
import javax.swing.JTable;*/
/*import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Rectangle;
*/

class DBMS 
{
	JFrame frame =new JFrame();
	Connection con;
	Statement stmt;
	DBMS()
	{
		String sql="CREATE TABLE Reg ("+
					"FNAME VARCHAR(30) NOT NULL ,"+
					"LNAME VARCHAR(30) ,"+
					"UNAME VARCHAR(45) NOT NULL ,"+
					"PWORD VARCHAR(32) NOT NULL ,"+
					"PNUM VARCHAR(13) NOT NULL ,"+
					"PRIMARY KEY (UNAME))";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pmng","root","Tiger");
			stmt=con.createStatement();
		}
		catch(Exception e)
		{
			//System.out.println("P1:"+e);
			JOptionPane.showMessageDialog(frame,"Creating Database\n"+e);
			try
			{
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","Tiger");
				stmt=con.createStatement();
				stmt.executeUpdate("create database pmng");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pmng","root","Tiger");
				stmt=con.createStatement();
				stmt.executeUpdate(sql);
			}
			catch(Exception e1)
			{
				//System.out.println("P2:"+e1);
				JOptionPane.showMessageDialog(frame,"Error No 6\n"+e1);
			}
		}	 
	}
}
public class PasswordManager extends DBMS implements MouseListener, ActionListener
{
	JFrame f=new JFrame("PasswordManager");
	JFrame f1;
	JFrame jf1=new JFrame("Delete Record");

	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JPanel p3=new JPanel();

	JButton b1=new JButton("Sign In");
	JButton b2=new JButton("Sign Up");
	JButton b3=new JButton("Login");
	JButton b4=new JButton("Register");

	
	JLabel l1=new JLabel("Welcome To Password Manager.");
	JLabel l2=new JLabel("Your Passwords are secure with us.");
	JLabel l3=new JLabel("User Name");
	JLabel l4=new JLabel("Password");
	JLabel l5=new JLabel("Login with your Account"); 
	JLabel l6=new JLabel("Create your Account");
	JLabel l7=new JLabel("First name");
	JLabel l8=new JLabel("Last name");
	JLabel l9=new JLabel("User Name");
	JLabel l10=new JLabel("Password");
	JLabel l11=new JLabel("Confirm");
	JLabel l12=new JLabel("Mobile Number");
	JLabel jl3;
	JLabel jl4;

	JTextField t1=new JTextField(25);
	JTextField t2=new JTextField(25);
	JTextField t3=new JTextField(25);
	JTextField t4=new JTextField(25);
	JTextField t5=new JTextField(25);
	JTextField jtf=new JTextField(10);

	JTextArea ta=new JTextArea(); 

	JPasswordField ps1=new JPasswordField();
	JPasswordField ps2=new JPasswordField();
	JPasswordField ps3=new JPasswordField();

	String unm;

	/*	JScrollBar hbar=new JScrollBar(JScrollBar.HORIZONTAL);
	JScrollBar vbar=new JScrollBar(JScrollBar.VERTICAL);*/
	
	PasswordManager()
	{
		/*Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		int h=screenSize.height;
		int w=screenSize.width;
		h=3*h/4;
		w=w/2;*/
			
		
		
		l1.setBounds(80,30,290,20);
		l2.setBounds(70,50,290,20);
		b1.setBounds(75,100,90,20);
		b2.setBounds(175,100,90,20);

		p1.add(b1);
		p1.add(b2);
		p1.add(l1);
		p1.add(l2);
		f.add(p1);
		/*f.add(hbar,BorderLayout.SOUTH);
		f.add(vbar,BorderLayout.EAST);*/

		//f.add(p1,BorderLayout.CENTER);

		p1.setLayout(null);
		jf1.setLayout(null);
		//p1.setBackground(Color.blue);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		
		f.setSize(600,700);
		jf1.setSize(400,300);
		
		f.setVisible(true);
		p1.setLocation(200,200);
		p1.setSize(350,450);
		f.setLayout(new BorderLayout());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Bound();
		f.addMouseListener(this);
		/*addMouseListener(new MouseListener(){public void mouseClicked(MouseEvent e){Bound();}});*/
	}
	void Bound()
	{
		Rectangle r=f.getBounds();
		int y=r.height,x=r.width;
		x-=350;
		y-=450;
		x/=2;
		y/=2;		
		p1.setLocation(x,y);
	}
	void Login()
	{
		p1.remove(p3);
		p1.remove(b1);
		p1.add(b2);

		p2.setBounds(0,150,400,450);
		l5.setBounds(100,30,200,20);
		l3.setBounds(70,70,100,20);
		t1.setBounds(70,90,200,20);
		l4.setBounds(70,120,100,20);
		ps1.setBounds(70,140,200,20);
		b3.setBounds(120,180,90,20);
		
		p2.add(l5);
		p2.add(b3);
		p2.add(l3);
		p2.add(l4);	
		p2.add(t1);
		p2.add(ps1);
		p1.add(p2);

		b3.addActionListener(this);		
		p2.setLayout(null);
		f.repaint();
	}
	void Register()
	{
		p1.remove(p2);
		p1.add(b1);
		p1.remove(b2);
		
		p3.setBounds(0,150,400,450);
		l6.setBounds(95,10,200,20);
		l7.setBounds(50,40,100,20);
		l8.setBounds(162,40,100,20);
		t2.setBounds(50,60,108,20);
		t3.setBounds(160,60,108,20);
		l9.setBounds(50,90,200,20);
		t4.setBounds(50,110,220,20);
		l10.setBounds(50,140,100,20);
		l11.setBounds(162,140,100,20);
		ps2.setBounds(50,160,108,20);
		ps3.setBounds(160,160,108,20);
		l12.setBounds(50,190,200,20);		
		t5.setBounds(50,210,220,20);
		b4.setBounds(110,270,90,20);

		p3.add(b4);
		p3.add(l6);
		p3.add(l7);
		p3.add(l8);
		p3.add(l9);
		p3.add(l10);
		p3.add(l11);
		p3.add(l12);
		p3.add(t2);
		p3.add(t3);
		p3.add(t4);
		p3.add(t5);
		p3.add(ps2);
		p3.add(ps3);
		p1.add(p3);

		b4.addActionListener(this);
		p3.setLayout(null);
		f.repaint();	
	}
	public void mouseEntered(MouseEvent e)
	{
		Bound();
	}
	public void mouseClicked(MouseEvent e)
	{
		f.repaint();
	}
	public void mouseExited(MouseEvent e)
	{
		//Bound();
	}
	public void mouseReleased(MouseEvent e)
	{
		//Bound();
	}
	public void mousePressed(MouseEvent e)
	{
		//Bound();
	}
	public void actionPerformed(ActionEvent e)
	{
		String str=e.getActionCommand();
		Bound();
		if (str=="Sign In")
		{
			Login();
			t1.setText("");
			ps1.setText("");
		}
		else if (str=="Sign Up")
		{
			Register();
			t2.setText("");
			t3.setText("");
			t4.setText("");
			ps2.setText("");
			ps3.setText("");
			t5.setText("");
		}
		else if (str=="Login")
		{
			unm=t1.getText();
			DBlogin();
			t1.setText("");
			ps1.setText("");
		}
		else if (str=="Register")
		{
			if (DBReg()==1)
				Login();
		}
		else if(str=="New")
		{
			New();
		}
		else if(str=="Update")
		{
			Update();
		}
		else if(str=="Delete")
		{
			Del();
		}
		else if(str=="Delete Account")
		{
			DelAcc();
		}
		else if (str=="Remove")
		{
			Remove();
		}
		else if(str=="Done")
		{
			Done();
		}
		else if(str=="Add")
		{
			ADD();
		}
	}
	void New()
	{
		


	}
	void ADD()
	{

	}
	void Update()		
	{

	}
	void Done()
	{

	}
	void Del()
	{
		
		jl3=new JLabel("Delete Record");
		jl4=new JLabel("Id");
		JButton b5=new JButton("Remove");
		
		jl3.setBounds(130,25,100,20);
		jl4.setBounds(120,80,40,20);
		jtf.setBounds(150,80,70,20);
		b5.setBounds(130,120,90,20);

		jf1.add(jl3);
		jf1.add(jl4);
		jf1.add(jtf);
		jf1.add(b5);

		jf1.setVisible(true);
		b5.addActionListener(this);
	}
	void Remove()
	{
		try
		{
			if (jtf.equals(""))
			{
				JOptionPane.showMessageDialog(frame,"Id cannot be empty");
			}
			else
			{
				ResultSet rs=stmt.executeQuery("select * from "+unm+" where id="+jtf.getText());
				if (rs.next())
				{
					stmt.executeUpdate("delete from "+unm+" where id="+jtf.getText());
					JOptionPane.showMessageDialog(frame,"Deleted successfully");
					 /*delete from a where id='118';*/
				}
				else
				{
					JOptionPane.showMessageDialog(frame,"ID "+jtf.getText()+" does not exist");
				}
			}
		}
		catch(Exception e1)
		{
			JOptionPane.showMessageDialog(frame,"Error No 7\n"+e1);
		}
		finally
		{
			f1.dispose();
			jf1.dispose();
			show();
			jtf.setText("");
		}
	}
	void DelAcc()
	{
		try
		{
			stmt.executeUpdate("drop table "+unm);
			stmt.executeUpdate("delete from reg where uname='"+unm+"'");
			f1.dispose();
			JOptionPane.showMessageDialog(frame,"Account deleted successfully");
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(frame,"Unable to process\tTry again.\n"+e);
		}
	}
	void show()
	{
		try
		{
			String[] col={"Id","Web","Username","Password"};
			f1=new JFrame(unm);		
			JButton jb1=new JButton("New");
			JButton jb2=new JButton("Update");
			JButton jb3=new JButton("Delete");
			JButton jb4=new JButton("Delete Account");
			JPanel jp1=new JPanel();
			JScrollPane sp;
			ResultSet rs;
			JLabel jl1,jl2;
			JTable jt;

				
			rs=stmt.executeQuery("select fname,uname from reg where uname='"+unm+"'");
			rs.next();
			jl1=new JLabel("Hello "+rs.getString(1));
			jl2=new JLabel(rs.getString(2));
				
			rs=stmt.executeQuery("select count(*) from "+unm);
			rs.next();
			Object data[][]=new Object[rs.getInt(1)][4];
			rs=stmt.executeQuery("select * from "+unm);
			int i=0;
			while (rs.next())
			{	
				data[i][0]=rs.getString(1);
				data[i][1]=rs.getString(2);
				data[i][2]=rs.getString(3);
				data[i][3]=rs.getString(4);
				i++;
			}
		
			jt=new JTable(data,col);	
			sp = new JScrollPane(jt); 

			jl1.setBounds(20,20,100,20);			
			jl2.setBounds(20,50,100,20);
			jb1.setBounds(20,80,80,20);
			jb2.setBounds(110,80,80,20);
			jb3.setBounds(200,80,80,20);
			jb4.setBounds(290,80,120,20);
			jt.setBounds(0,120,400,350);
			jp1.setLayout(null);
			f1.setSize(450,500);
			jp1.setSize(450,50);

			jp1.add(jl1);
			jp1.add(jl2);
			jp1.add(jb1);
			jp1.add(jb2);
			jp1.add(jb3);
			jp1.add(jb4);
			f1.add(jp1);
			f1.add(sp);
			jb1.addActionListener(this);
			jb2.addActionListener(this);
			jb3.addActionListener(this);
			jb4.addActionListener(this);

			f1.setVisible(true);
			f1.setLayout(new GridLayout(2,1));
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(frame,"Error No 5\n"+e);
		}
	}
	void DBlogin()
	{
		try
		{
			String que="select uname from reg where uname='"+unm+"'";
			ResultSet rs=stmt.executeQuery(que);
			if (rs.next())
			{	
				que="select pword from reg where uname='"+unm+"'";
				rs=stmt.executeQuery(que);
				rs.next();
				if(rs.getString(1).equals(ps1.getText()))
				{
					show();
				}
				else
				{
					JOptionPane.showMessageDialog(frame,"Invalid Username or Password");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(frame,"Enter a valid Username");
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(frame,"Error No 4\n"+e);
		}
	}
	int DBReg()
	{
		String que="";
		try
		{
			if (t2.getText().isEmpty()==false)
			{
				if (t4.getText().isEmpty()==false)
				{
					if (CheckID(t4.getText())==0)
					{
						if(ps2.getText().isEmpty()==false)
						{
							if (ps3.getText().equals(ps2.getText()))
							{
								if (t5.getText().isEmpty()==false)
								{
									try
									{
										if (t3.getText().isEmpty()==false)
										{
											que="insert into reg values('"+t2.getText()+"',null,'"+t4.getText()+"','"+ps2.getText()+"','"+t5.getText()+"')";
										}
										else
										{
											que="insert into reg values('"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"','"+ps2.getText()+"','"+t5.getText()+"')";
										}
										stmt.executeUpdate(que);
										que="create table "+t4.getText()+"(ID INT AUTO_INCREMENT PRIMARY KEY,WEB VARCHAR(15),EID VARCHAR(25),PAS VARCHAR(25))";
										stmt.executeUpdate(que);
										return 1;
									} 		
									catch(Exception e)
									{	
										JOptionPane.showMessageDialog(frame,"Error No 3\n"+e);
									}
								}
								else
								{
									JOptionPane.showMessageDialog(frame,"Mobile Number cannot be empty");
								}
							}
							else
							{
								JOptionPane.showMessageDialog(frame,"Password does not match");
								JOptionPane.showMessageDialog(frame,"P1:"+ps2.getText()+"P2:"+ps3.getText());
								ps3.setText("");
							}
						}
						else
						{
							JOptionPane.showMessageDialog(frame,"Password cannot be empty");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(frame,"User already exist\nPlease Login");
					}
				}	
				else
				{
					JOptionPane.showMessageDialog(frame,"Username cannot be empty");
				}														
			}
			else
			{
				JOptionPane.showMessageDialog(frame,"First name Cannot be empty");
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(frame,"Error No 1\n"+e);
		}
		return 0;
	}
	int CheckID(String uname)
	{
		ResultSet rs;
		try
		{
			rs=stmt.executeQuery("select * from reg where uname like '"+uname+"'");
			if (rs.next())
				return 1;
			else
				return 0;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(frame,"Error No 2\n"+e);
		}
		return 2;
	}
	public static void main(String[] Args)
	{
		new PasswordManager();
	}
}