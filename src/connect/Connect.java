/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author TranThuyNga
 */
public class Connect {
    Statement  stm = null;
    ResultSet rs = null;
    Connection con = null;
    PreparedStatement pr=null;
    
    public void getConnect() 
    {
        try{
            String url="jdbc:derby://localhost:1527/QLySV";
            String user="Nhom10";
            String pass="123456";
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con=(Connection)DriverManager.getConnection(url, user, pass);
        }
        catch (ClassNotFoundException|SQLException e)
        {
            JOptionPane.showMessageDialog(null,"Không thể kết nối được database \n"+e);
        }
        
    }
     public void closeConnect() throws SQLException {
        if(this.rs!=null&&!this.rs.isClosed())
        try{
            this.rs.close();
            this.rs=null;
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đóng kết quả");
        }
        
        if(this.stm!=null&&!this.stm.isClosed())
        try{
            this.stm.close();
            this.stm=null;
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đóng lệnh thực thi");
        }
        if(this.pr!=null&&!this.pr.isClosed())
        try{
            this.pr.close();
            this.pr=null;
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đóng lệnh thực thi");
        }
        if(this.con!=null&&!this.con.isClosed())
        try{
            this.con.close();
            this.con=null;
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đóng kết nối");
        }
    }
}
