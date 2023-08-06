package connection;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class take_attendance extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4;
    Choice ch1,ch2,ch3;
    JButton btn1;
    JPanel p1;
    Font f;
    
    take_attendance()
    {
      super("Take Attendence");
      setSize(330,290);
      setLocation(100,100);
      setResizable(false);
      
      f=new Font("Arial",Font.BOLD,14);
      
      l1=new JLabel("First Half");
      l2=new JLabel("Second Half");
      l3=new JLabel("Employee ID");
 
      l1.setFont(f);
      l2.setFont(f);
      l3.setFont(f);

   ch1=new Choice();
   ch1.add("Present");
   ch1.add("Absent");
   ch1.setFont(f);
   
   ch2=new Choice();
   ch2.add("Present");
   ch2.add("Absent");
   ch2.setFont(f);
   
   ch3=new Choice();
   
   try
   {
       connectionclass obj=new connectionclass();
       String q="Select Eid from new_employee";
       ResultSet rs=obj.stm.executeQuery(q);
       while(rs.next())
       {
           ch3.add(rs.getString("Eid"));
       }
   }
   catch(Exception ex)
   {
       ex.printStackTrace();
   }
   ch3.setFont(f);

   
      btn1=new JButton("Submit");
      btn1.setFont(f);
      btn1.setBackground(Color.BLACK);
      btn1.setForeground(Color.WHITE);   
      btn1.addActionListener(this);

      
      p1=new JPanel();
      p1.setLayout(new GridLayout(4,2,10,10));
      p1.add(l3);
      p1.add(ch3);
      p1.add(l1);
      p1.add(ch1);
      p1.add(l2);
      p1.add(ch2);
      
      setLayout(new BorderLayout(30,30));
      add(p1,"Center");
      add(btn1,"South");
}
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==btn1)
        {  
            try
            {
            int id=Integer.parseInt(ch3.getSelectedItem());
           String first_half=ch1.getSelectedItem();
           String second_half=ch2.getSelectedItem();
           String dt=new java.util.Date().toString();
           
                connectionclass obj1=new connectionclass();
                String q1="insert into attendence values('"+id+"','"+first_half+"','"+second_half+"','"+dt+"')";
                obj1.stm.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"Data inserted successfully");
                setVisible(false);
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
    public static void main(String[]args)
    {
        new take_attendance().setVisible(true);
    }
}
