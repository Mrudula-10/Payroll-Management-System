package connection;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class list_employee extends JFrame implements ActionListener {
    JTable tb;
    String x[]={"Eid","name","gender","address","state","city","email","phone"};
    String y[][]=new String[20][8];
    JButton btn1;
    int i=0;
    int j=0;
    Font f;
    list_employee()
    {
        super("List Employee");
        setSize(900,400);
        setLocation(100,100);
        setResizable(false);
        f=new Font("Arial",Font.BOLD,14);
        try
        {
            connectionclass obj=new connectionclass();
            String q="select * from new_employee";
            ResultSet rs=obj.stm.executeQuery(q);
            while(rs.next())
            {
                y[i][j++]=rs.getString("Eid");
                y[i][j++]=rs.getString("name");
                y[i][j++]=rs.getString("gender");
                y[i][j++]=rs.getString("address");
                y[i][j++]=rs.getString("state");
                y[i][j++]=rs.getString("city");
                y[i][j++]=rs.getString("email");
                y[i][j++]=rs.getString("phone");
                i++;
                j=0;
            }
            tb=new JTable(y,x);
            tb.setFont(f);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        JScrollPane js=new JScrollPane(tb);
        add(js);
        btn1=new JButton("Print");
        add(btn1,"South");
        btn1.setBackground(Color.BLACK);
        btn1.setForeground(Color.WHITE);
        btn1.addActionListener(this);
        btn1.setFont(f);
        
        add(btn1,"South");
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==btn1)
        {
            try
            {
                tb.print();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
    public static void main(String args[]){
        new list_employee().setVisible(true);
    }
}