import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Iterator;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.Timer.*;
class Number_arranging_game extends JFrame implements ActionListener,ItemListener
{
	public int flag = 0,flag1=0,count=0;
	JButton array[],array1[];
	JLabel l1,l2,l3,l4,l5,timeLabel;
	JButton first,second,third,fourth,b1,b2;
	JTextField t1;
	Choice ch1;
	Font f;
	int i,j,elapsedTime;
	javax.swing.Timer timer;
	
	
	/*public void verify()
			{
					  int a = 0;
					if(Integer.parseInt(array[a].getText())==(a+1))
					{
						array[a] = array[a+1];
					}
					else if(a==15)
					{
						JOptionPane.showMessageDialog(null, "You Win!");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Please Try Again!");
					}
			}*/
			
			 void updateTimeLabel()
			 {
				int seconds = (elapsedTime % 6000000) / 1000;
				String time = String.format("%02d",seconds);
				timeLabel.setText(time);
			 }
	
	
	Number_arranging_game()
		{
			setTitle("Number Arranging Game");
			setSize(450,600);
			setLocation(350,50);
			setLayout(null);
			
			l1 = new JLabel("Choose Level:");
			l2 = new JLabel("Arrange Puzzle Game");
			l3 = new JLabel("Time:");
			l4 = new JLabel("Moves:");
			l5 = new JLabel("0");
			timeLabel = new JLabel("",JLabel.CENTER);
			//timeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
			//timeLabel.setForeground(Color.red);
			t1=new JTextField(20);
			ch1=new Choice();
			first = new JButton("FORWARD");
			second = new JButton("BACKWARD");
			third = new JButton("DOWNWARD");
			fourth = new JButton("UPWARD");
			b1 = new JButton("New Game");
			b2 = new JButton("SUBMIT");
			array=new JButton[16];
			array1=new JButton[16];
			
			ch1.add("--Level--");
			ch1.add("4 Grid Box");
			ch1.add("9 Grid Box");
			ch1.add("16 Grid Box");
			
			t1.setBounds(100,100,230,20);
			
			
			java.util.List list = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16);
			Collections.shuffle(list);			
			int num = list.size();
						
			for(i=0;i<=(num-1);i++)
			{
				array[i]=new JButton(""+list.get(i));
				add(array[i]);	
				if(Integer.parseInt(array[i].getText())==16)
				{
					array[i].setText("");
					flag = i;
				}	
				array[i].addActionListener(this);			
			}					
					
			timer = new javax.swing.Timer(1000, new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					elapsedTime += 1000;
					updateTimeLabel();
				}
			}
			);	
			timer.start();
			
			add(first);
			add(second);
			add(third);
			add(fourth);
			add(b1);
			add(b2);
			add(ch1);
			add(l1);	add(l2);	add(l3);	add(l4);	add(l5);	add(timeLabel);
			first.addActionListener(this);
			second.addActionListener(this);
			third.addActionListener(this);
			fourth.addActionListener(this);
			b1.addActionListener(this);
			b2.addActionListener(this);
			ch1.addItemListener(this);
			
	array[0].setBounds(100,130,60,50);
	array[1].setBounds(160,130,60,50);
	array[2].setBounds(220,130,60,50);
	array[3].setBounds(280,130,60,50);
	
	array[4].setBounds(100,180,60,50);
	array[5].setBounds(160,180,60,50);
	array[6].setBounds(220,180,60,50);
	array[7].setBounds(280,180,60,50);
	
	array[8].setBounds(100,230,60,50);
	array[9].setBounds(160,230,60,50);
	array[10].setBounds(220,230,60,50);
	array[11].setBounds(280,230,60,50);
	
	array[12].setBounds(100,280,60,50);
	array[13].setBounds(160,280,60,50);
	array[14].setBounds(220,280,60,50);
	array[15].setBounds(280,280,60,50);
	
	first.setBounds(100,350,110,50);
	second.setBounds(230,350,110,50);
	fourth.setBounds(100,410,110,50);
	third.setBounds(230,410,110,50);
	b2.setBounds(100,470,240,50);
	l2.setBounds(130,20,300,30);
	f = new Font("Arial",Font.BOLD,20);
	l2.setFont(f);
	l1.setBounds(50,53,90,30);
	ch1.setBounds(140,60,90,30);
	b1.setBounds(240,60,98,22);
	l3.setBounds(100,90,50,30);
	timeLabel.setBounds(130,90,50,30);
	l4.setBounds(270,90,50,30);
	l5.setBounds(320,90,50,30);
				
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
		}
		public void actionPerformed(ActionEvent e)
		{
				if(e.getSource()==first)
				{
					flag = flag+1;
					count = count+1;
					
					if(flag==0 || flag==1 || flag==2 || flag==3  || flag==5 || flag==6 || flag==7  || flag==9 || flag==10 || flag==11 || flag==13 || flag==14 || flag==15)
					{
						array[flag-1].setText(""+array[flag].getText());
						array[flag].setText("");
					}
					if(flag == 4)
					{
						flag = 3;
						count = count-1;
					}
					if(flag == 8)
					{
						flag = 7;
						count = count-1;
					}
					if(flag == 12)
					{
						flag = 11;
						count = count-1;
					}
					if(flag == 16)
					{
						flag = 15;
						count = count-1;
					}
					
					/*if(flag==16)
					{
						array[15].setText(""+array[0].getText());
						array[0].setText("");
						flag = 0;
					}*/
					l5.setText(""+count);
				}
				if(e.getSource()==second)
				{
					flag = flag-1;
					count = count+1;
					
					if(flag==0 || flag==1 || flag==2 || flag==4 || flag==5 || flag==6 || flag==8 || flag==9 || flag==10 || flag==12 || flag==13 || flag==14 || flag==15)
					{
						array[flag+1].setText(""+array[flag].getText());
						array[flag].setText("");
					}
					
					if(flag == -1)
					{
						flag = 0;
						count = count-1;
					}
					
					if(flag == 3)
					{
						flag = 4;
						count = count-1;
					}
					
					if(flag == 7)
					{
						flag = 8;
						count = count-1;
					}
					
					if(flag == 11)
					{
						flag = 12;
						count = count-1;
					}
					l5.setText(""+count);
				}
				
				if(e.getSource()==third)
				{
					flag = flag+4;
					count = count+1;
					if(flag==0 || flag==1 || flag==2 || flag==3 || flag==4 || flag==5 || flag==6 || flag==7 || flag==8 || flag==9 || flag==10 || flag==11 || flag==12 || flag==13 || flag==14 || flag==15)
					{
						array[flag-4].setText(""+array[flag].getText());
						array[flag].setText("");
					}
					
					if(flag == 16)
					{
						flag = 12;
						count = count-1;
					}
					if(flag == 17)
					{
						flag = 13;
						count = count-1;
					}
					if(flag == 18)
					{
						flag = 14;
						count = count-1;
					}
					if(flag == 19)
					{
						flag = 15;
						count = count-1;
					}
					l5.setText(""+count);
				}
				
				if(e.getSource()==fourth)
				{
					flag = flag-4;
					count = count+1;
					if(flag==0 || flag==1 || flag==2 || flag==3 || flag==4 || flag==5 || flag==6 || flag==7 || flag==8 || flag==9 || flag==10 || flag==11 || flag==12 || flag==13 || flag==14 || flag==15)
					{
						array[flag+4].setText(""+array[flag].getText());
						array[flag].setText("");
					}
					
					if(flag == -4)
					{
						flag = 0;
						count = count-1;
					}
					if(flag == -3)
					{
						flag = 1;
						count = count-1;
					}
					if(flag == -2)
					{
						flag = 2;
						count = count-1;
					}
					if(flag == -1)
					{
						flag = 3;
						count = count-1;
					}
					l5.setText(""+count);
				}

				if(e.getSource() == b1)
				{	
					new Number_arranging_game();
					setVisible(false);
				}
				
				if(e.getSource()==b2)
				{
					try
					{
						int a = 0;
						if(Integer.parseInt(array[0].getText())==1)
						{
							a = 1;
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Please Try Again!");
						}
						if(a==1)
						{
							if(Integer.parseInt(array[1].getText())==2)
							{
								a = 2;
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Please Try Again!");
							}
						}
						if(a==2)
						{
							if(Integer.parseInt(array[2].getText())==3)
							{
								a = 3;
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Please Try Again!");
							}
						}
						if(a==3)
						{
							if(Integer.parseInt(array[3].getText())==4)
							{
								a = 4;
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Please Try Again!");
							}
						}
						if(a==4)
						{
							if(Integer.parseInt(array[4].getText())==5)
							{
								a = 7;
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Please Try Again!");
							}
						}
						if(a==7)
						{
							if(Integer.parseInt(array[7].getText())==8)
							{
								a = 13;
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Please Try Again!");
							}
						}
						if(a==13)
						{
							if(Integer.parseInt(array[13].getText())==14)
							{
								a = 14;
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Please Try Again!");
							}
						}
						if(a==14)
						{
							if(Integer.parseInt(array[14].getText())==15)
							{
								a = 15;
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Please Try Again!");
							}
						}
						if(a==15)
						{
							if(array[15].getText()=="")
							{
								JOptionPane.showMessageDialog(null, "You Win!");
							    new Number_arranging_game();
								setVisible(false);
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Please Try Again!");
							}
						}
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, "Please Try Again!");
					}
				}		
		}
		
		public void itemStateChanged(ItemEvent ee)
		{
			if (ch1.getSelectedIndex() == 1)
			{
				new four_grid();
				setVisible(false);
			}
			if (ch1.getSelectedIndex() == 2)
			{
				new nine_grid();
				setVisible(false);
			}
			if (ch1.getSelectedIndex() == 3)
			{
				new Number_arranging_game();
				setVisible(false);
			}
		}
		public static void main(String args[])
		{
			new Number_arranging_game();
		}
}