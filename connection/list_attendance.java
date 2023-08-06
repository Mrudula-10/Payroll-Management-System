package connection;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class list_attendance extends JFrame implements ActionListener {
    JTable tb;
    String x[]={"Eid","First Half","Second Half","Date"};
    String y[][]=new String[20][4];
    JButton btn1;
    int i=0;
    int j=0;
    Font f;
    list_attendance()
    {
        super("List Attendance");
        setSize(600,400);
        setLocation(100,100);
        setResizable(false);
        f=new Font("Arial",Font.BOLD,14);
        try
        {
            connectionclass obj=new connectionclass();
            String q="select * from attendence";
            ResultSet rs=obj.stm.executeQuery(q);
            while(rs.next())
            {
                y[i][j++]=rs.getString("Eid");
                y[i][j++]=rs.getString("first_half");
                y[i][j++]=rs.getString("second_half");
                y[i][j++]=rs.getString("date");
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
        new list_attendance().setVisible(true);
    }
}

