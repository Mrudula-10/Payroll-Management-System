package connection;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class salary extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5,l6;
    JTextField t1,t2,t3,t4,t5,t6;
    Choice ch1;
    JButton btn1,btn2;
    JPanel p1;
    Font f;
    
    salary()
    {
      super("Salary");
      setSize(740,380);
      setLocation(100,100);
      setResizable(false);
      
      f=new Font("Arial",Font.BOLD,14);
      
      l1=new JLabel("Select ID");
      l2=new JLabel("HRA");
      l3=new JLabel("DA");
      l4=new JLabel("MID");
      l5=new JLabel("PF");
      l6=new JLabel("Basic Salary");
 
      l1.setFont(f);
      l2.setFont(f);
      l3.setFont(f);
      l4.setFont(f);
      l5.setFont(f);
      l6.setFont(f);

   ch1=new Choice();
   try
   {
       connectionclass obj=new connectionclass();
       String q="Select Eid from new_employee";
       ResultSet rs=obj.stm.executeQuery(q);
       while(rs.next())
       {
           ch1.add(rs.getString("Eid"));
       }
   }
   catch(Exception ex)
   {
       ex.printStackTrace();
   }
   ch1.setFont(f);
   
   t1=new JTextField();
   t2=new JTextField();
   t3=new JTextField();
   t4=new JTextField();
   t5=new JTextField();
   
   t1.setFont(f);
   t2.setFont(f);
   t3.setFont(f);
   t4.setFont(f);
   t5.setFont(f);
   
         btn1=new JButton("Submit");
      btn2=new JButton("Close");
      
      btn1.setFont(f);
      btn2.setFont(f);
      
      btn1.setBackground(Color.BLACK);
      btn1.setForeground(Color.WHITE);
      btn2.setBackground(Color.BLACK);
      btn2.setForeground(Color.WHITE);
      
      btn1.addActionListener(this);
      btn2.addActionListener(this);
      
            p1=new JPanel();
      p1.setLayout(new GridLayout(7,2,10,10));
      p1.add(l1);
      p1.add(ch1);
      p1.add(l2);
      p1.add(t1);
      p1.add(l3);
      p1.add(t2);
      p1.add(l4);
      p1.add(t3);
      p1.add(l5);
      p1.add(t4);
      p1.add(l6);
      p1.add(t5);
      p1.add(btn1);
      p1.add(btn2); 
      
      setLayout(new BorderLayout(30,30));
      add(p1,"Center");
}
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==btn1)
        {
            
           int Eid=Integer.parseInt(ch1.getSelectedItem());
            float hra=Float.parseFloat(t1.getText());
            float da=Float.parseFloat(t2.getText());
            float mid=Float.parseFloat(t3.getText());
            float pf=Float.parseFloat(t4.getText());
            float basic=Float.parseFloat(t5.getText());
            
            try
            {
                connectionclass obj1=new connectionclass();
                String q1="insert into salary values('"+Eid+"','"+hra+"','"+da+"','"+mid+"','"+pf+"','"+basic+"')";
                obj1.stm.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"Data inserted successfully");
                setVisible(false);
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
            if(e.getSource()==btn2)
            {
                JOptionPane.showMessageDialog(rootPane, "Are you sure");
                setVisible(false);
            }
        }
    public static void main(String[]args)
    {
        new salary().setVisible(true);
    }
    }

