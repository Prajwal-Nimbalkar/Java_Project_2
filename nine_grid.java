import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Iterator;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
class nine_grid extends JFrame implements ActionListener,ItemListener
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
	
			void updateTimeLabel()
			{
				int seconds = (elapsedTime % 6000000) / 1000;
				String time = String.format("%02d",seconds);
				timeLabel.setText(time);
			}
	
	nine_grid()
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
			timeLabel = new JLabel("");
			t1=new JTextField(20);
			ch1=new Choice();
			first = new JButton("FORWARD");
			second = new JButton("BACKWARD");
			third = new JButton("DOWNWARD");
			fourth = new JButton("UPWARD");
			b1 = new JButton("New Game");
			b2 = new JButton("SUBMIT");
			array=new JButton[9];
			array1=new JButton[16];
			
			ch1.add("--Level--");
			ch1.add("4 Grid Box");
			ch1.add("9 Grid Box");
			ch1.add("16 Grid Box");
			
			t1.setBounds(100,100,230,20);
			
			
			java.util.List list = Arrays.asList(1,2,3,4,5,6,7,8,9);
			Collections.shuffle(list);			
			int num = list.size();
						
			for(i=0;i<=(num-1);i++)
			{
				array[i]=new JButton(""+list.get(i));
				add(array[i]);	
				if(Integer.parseInt(array[i].getText())==9)
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
			
	array[0].setBounds(130,130,60,50);
	array[1].setBounds(190,130,60,50);
	array[2].setBounds(250,130,60,50);
	
	array[3].setBounds(130,180,60,50);
	array[4].setBounds(190,180,60,50);
	array[5].setBounds(250,180,60,50);
	
	array[6].setBounds(130,230,60,50);
	array[7].setBounds(190,230,60,50);
	array[8].setBounds(250,230,60,50);
	
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
	l3.setBounds(130,90,50,30);
	timeLabel.setBounds(170,90,50,30);
	l4.setBounds(240,90,50,30);
	l5.setBounds(290,90,50,30);
				
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
		}
		public void actionPerformed(ActionEvent e)
		{
				if(e.getSource()==first)
				{
					flag = flag+1;
					count = count+1;
					
					if(flag==0 || flag==1 || flag==2 || flag==4|| flag==5 || flag==7 || flag==8)
					{
						array[flag-1].setText(""+array[flag].getText());
						array[flag].setText("");
					}
					if(flag == 3)
					{
						flag = 2;
						count = count-1;
					}
					if(flag == 6)
					{
						flag = 5;
						count = count-1;
					}
					if(flag == 9)
					{
						flag = 8;
						count = count-1;
					}
					l5.setText(""+count);
				}
				if(e.getSource()==second)
				{
					flag = flag-1;
					count = count+1;
					
					if(flag==0 || flag==1 || flag==3 || flag==4 || flag==6 || flag==7 ||  flag==8 )
					{
						array[flag+1].setText(""+array[flag].getText());
						array[flag].setText("");
					}
					
					if(flag == -1)
					{
						flag = 0;
						count = count-1;
					}
					
					if(flag == 2)
					{
						flag = 3;
						count = count-1;
					}
					
					if(flag == 5)
					{
						flag = 6;
						count = count-1;
					}
					l5.setText(""+count);
				}
				
				if(e.getSource()==third)
				{
					flag = flag+3;
					count = count+1;
					if(flag==0 || flag==1 || flag==2 || flag==3 || flag==4 || flag==5 || flag==6 || flag==7 || flag==8 )
					{
						array[flag-3].setText(""+array[flag].getText());
						array[flag].setText("");
					}
					
					if(flag == 9)
					{
						flag = 6;
						count = count-1;
					}
					if(flag == 10)
					{
						flag = 7;
						count = count-1;
					}
					if(flag == 11)
					{
						flag = 8;
						count = count-1;
					}
					l5.setText(""+count);
				}
				
				if(e.getSource()==fourth)
				{
					flag = flag-3;
					count = count+1;
					if(flag==0 || flag==1 || flag==2 || flag==3 || flag==4 || flag==5 || flag==6 || flag==7 || flag==8 )
					{
						array[flag+3].setText(""+array[flag].getText());
						array[flag].setText("");
					}
					
					if(flag == -3)
					{
						flag = 0;
						count = count-1;
					}
					if(flag == -2)
					{
						flag = 1;
						count = count-1;
					}
					if(flag == -1)
					{
						flag = 2;
						count = count-1;
					}
					l5.setText(""+count);
				}

				if(e.getSource() == b1)
				{	
					new nine_grid();
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
								a = 5;
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Please Try Again!");
							}
						}
						if(a==5)
						{
							if(Integer.parseInt(array[5].getText())==6)
							{
								a = 6;
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Please Try Again!");
							}
						}
						if(a==6)
						{
							if(Integer.parseInt(array[6].getText())==7)
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
								a = 8;
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Please Try Again!");
							}
						}
						if(a==8)
						{
							if(array[8].getText()=="")
							{
								JOptionPane.showMessageDialog(null, "You Win!");
							    new nine_grid();
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
			new nine_grid();
		}
}