import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Iterator;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
class four_grid extends JFrame implements ActionListener,ItemListener
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
	
	four_grid()
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
			t1=new JTextField(20);
			ch1=new Choice();
			first = new JButton("FORWARD");
			second = new JButton("BACKWARD");
			third = new JButton("DOWNWARD");
			fourth = new JButton("UPWARD");
			b1 = new JButton("New Game");
			b2 = new JButton("SUBMIT");
			array=new JButton[4];
			array1=new JButton[5];
			
			ch1.add("--Level--");
			ch1.add("4 Grid Box");
			ch1.add("9 Grid Box");
			ch1.add("16 Grid Box");
			
			t1.setBounds(100,100,230,20);
			
			
			java.util.List list = Arrays.asList(1,2,3,4);
			Collections.shuffle(list);			
			int num = list.size();
						
			for(i=0;i<=3;i++)
			{
				array[i]=new JButton(""+list.get(i));
				add(array[i]);	
				if(Integer.parseInt(array[i].getText())==4)
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
			
	array[0].setBounds(120,130,100,80);
	array[1].setBounds(220,130,100,80);
	array[2].setBounds(120,210,100,80);
	array[3].setBounds(220,210,100,80);
	
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
	l3.setBounds(120,90,50,30);
	timeLabel.setBounds(140,90,50,30);
	l4.setBounds(250,90,50,30);
	l5.setBounds(300,90,50,30);
				
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
		}
		public void actionPerformed(ActionEvent e)
		{
				if(e.getSource()==first)
				{
					flag = flag+1;
					count = count+1;
					
					if(flag==0 || flag==1 || flag==3)
					{
						array[flag-1].setText(""+array[flag].getText());
						array[flag].setText("");
					}
					if(flag == 2)
					{
						flag = 1;
						count = count-1;
					}
					if(flag == 4)
					{
						flag = 3;
						count = count-1;
					}
					l5.setText(""+count);
				}
				
				if(e.getSource()==second)
				{
					flag = flag-1;
					count = count+1;
					
					if(flag==0 || flag==2)
					{
						array[flag+1].setText(""+array[flag].getText());
						array[flag].setText("");
					}
					
					if(flag == -1)
					{
						flag = 0;
						count = count-1;
					}
					
					if(flag == 1)
					{
						flag = 2;
						count = count-1;
					}
					l5.setText(""+count);
				}
				
				if(e.getSource()==third)
				{
					flag = flag+2;
					count = count+1;
					if(flag==0 || flag==1 || flag==2 || flag==3)
					{
						array[flag-2].setText(""+array[flag].getText());
						array[flag].setText("");
					}
					
					if(flag == 4)
					{
						flag = 2;
						count = count-1;
					}
					if(flag == 5)
					{
						flag = 3;
						count = count-1;
					}
					l5.setText(""+count);
				}
				
				if(e.getSource()==fourth)
				{
					flag = flag-2;
					count = count+1;
					if(flag==0 || flag==2 || flag==3 || flag==1)
					{
						array[flag+2].setText(""+array[flag].getText());
						array[flag].setText("");
					}
					
					if(flag == -2)
					{
						flag = 0;
						count = count-1;
					}
					if(flag == -1)
					{
						flag = 1;
						count = count-1;
					}
					l5.setText(""+count);
				}

				if(e.getSource() == b1)
				{
					new four_grid();
					setVisible(false);
				}
				
				if(e.getSource()==b2)
				{
				try{
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
							if(array[3].getText()=="")
							{
								JOptionPane.showMessageDialog(null, "You Win!");
							    new four_grid();
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
			new four_grid();
		}
}