package connection;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class generate_payslip extends JFrame implements ActionListener 
{
    JLabel l1,l2,l3,l4,l5,l6;
    JTextArea ta; 
    Choice ch;
    JButton btn1;
    JPanel p1;
    Font f;
    
    generate_payslip()
    {
      super("Generate Pay Slip");
      setSize(500,500);
      setLocation(100,100);
      setResizable(false);
      
      f=new Font("Arial",Font.BOLD,16);
      
      l2=new JLabel("Employee ID");
      l2.setFont(f);

   ch=new Choice();
   try
   {
       connectionclass obj=new connectionclass();
       String q="select * from new_employee";
       ResultSet rs=obj.stm.executeQuery(q);
       while(rs.next())
       {
           ch.add(rs.getString("Eid"));
       }
   }
   catch(Exception ex)
   {
       ex.printStackTrace();
   }
   
      btn1=new JButton("Print");
      btn1.setFont(f);
      btn1.setBackground(Color.BLACK);
      btn1.setForeground(Color.WHITE);   
      btn1.addActionListener(this);
      
      ta=new JTextArea();
      JScrollPane sp=new JScrollPane(ta);
      ta.setEditable(false);
      ta.setFont(f);
      
      p1=new JPanel();
      p1.setLayout(new GridLayout(1,3,10,10));
      p1.add(l2);
      p1.add(ch);
      p1.add(btn1);

      setLayout(new BorderLayout());
      add(sp,"Center");
      add(p1,"South");
}
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==btn1)
        {
            ta.setText("------------Pay Slip-----------");
            try
            {
                connectionclass obj1=new connectionclass();
                int id=Integer.parseInt(ch.getSelectedItem());
                String q1="select * from new_employee where Eid='"+id+"'";
                ResultSet rs1=obj1.stm.executeQuery(q1);
                while(rs1.next())
                {
                    ta.append("\n\nEmployee Id :"+Integer.parseInt(rs1.getString("Eid")));
                    ta.append("\n\nEmployee Name :"+rs1.getString("name"));
                    ta.append("\n--------------------------------------\n\n");
                }
                String q2="select * from salary where Eid='"+id+"'";
                ResultSet rs2=obj1.stm.executeQuery(q2);
                while(rs2.next())
                {
                    ta.append("\nHRA :"+Float.parseFloat(rs2.getString("hra")));
                    ta.append("\nDA :"+Float.parseFloat(rs2.getString("da")));
                    ta.append("\nMID :"+Float.parseFloat(rs2.getString("mid")));
                    ta.append("\nPF :"+Float.parseFloat(rs2.getString("pf")));
                    ta.append("\nBASIC SALARY :"+Float.parseFloat(rs2.getString("basic")));
                    ta.append("\n--------------------------------------\n\n");
                    float gross_salary=Float.parseFloat(rs2.getString("hra"))+Float.parseFloat(rs2.getString("da"))+Float.parseFloat(rs2.getString("mid"))+Float.parseFloat(rs2.getString("pf"))+Float.parseFloat(rs2.getString("basic"));
                    double tax=(gross_salary*2.1)/100;
                    ta.append("\nGross Salary:"+gross_salary);
                    ta.append("\nTotal:"+gross_salary);
                    ta.append("\nTax 2.1% of salary:"+tax);
                }   
            }
                
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
    public static void main(String[]args)
    {
        new generate_payslip().setVisible(true);
    }
}
