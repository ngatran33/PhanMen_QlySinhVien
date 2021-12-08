/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
/**
 *
 * @author TranThuyNga
 */
public class ConnectSV extends Connect{
    
    public Vector<Vector<String>> GetData(String jtable) throws SQLException
    {
        Vector<Vector<String>> data = new Vector<>();
        ResultSet rs=null;// khai báo
       stm=con.createStatement();//khởi tạo đối tượng stm
        rs=stm.executeQuery("select * from SINHVIEN");
         while(rs.next())
            {
                Vector vt=new Vector();
                vt.add(rs.getString("MASV"));
                vt.add(rs.getString("MALOP"));
                vt.add(rs.getString("HOTEN"));
                vt.add(rs.getString("GIOITINH"));
                vt.add(rs.getString("QUEQUAN"));
                vt.add(rs.getString("QUOCTICH"));
                vt.add(rs.getString("CMTND"));
                vt.add(rs.getString("NGAYSINH"));
                data.add(vt);
            }
        return data;
    }
   public int add(String masv, String malop ,String hoten  ,String gt, String qquan, String quoctich,
           String ns, String cmtnd)
    {
        int t=0;
        try {
             pr= con.prepareStatement("insert into SINHVIEN values"
                                                                                                + "(?,?,?,?,?,?,?,'"+ns+"')");
            //setxxx(),
             pr.setString(1, masv);
            pr.setString(2, malop);
            pr.setString(3, hoten);
            pr.setString(4, gt);
            pr.setString(5, qquan);
            pr.setString(6, quoctich);
            pr.setString(7,cmtnd );
            t=pr.executeUpdate();
        }catch (Exception e){
        e.printStackTrace();
        }
        
        return t;
    }
public int update(String masv, String malop ,String hoten  ,String gt, String qquan, 
        String quoctich, String ns, String cmtnd)
    {
         int t=0;
        try {
             pr= con.prepareStatement("update SINHVIEN set MALOP=?, "
                                                                                            + "HOTEN=?, GIOITINH=?, "
                                                                                            + "QUEQUAN=?, QUOCTICH=?,CMTND=?,"
                                                                                            + "NGAYSINH='"+ns+"' where MASV=?");
            pr.setString(1, malop);
            pr.setString(2, hoten);
            pr.setString(3, gt);
            pr.setString(4, qquan);
            pr.setString(5, quoctich);
            pr.setString(6,cmtnd );
            pr.setString(7, masv);            
            t=pr.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return t;
    }
    public int remove(String masv)throws Exception
    {
        int t=0;
         pr=con.prepareStatement("delete from SINHVIEN "
                                                    + "where MASV='"+masv+"'");
        t=pr.executeUpdate();
        return t;
    }
     public Vector<Vector<String>> findMasv(String masv)throws SQLException
    {
        Vector<Vector<String>> data = new Vector<>();
        ResultSet kq=null;
        stm=con.createStatement();
        kq=stm.executeQuery("select *  from SINHVIEN where MASV='"+masv+"'");
        while(kq.next())
            {
                Vector vt=new Vector();
                vt.add(kq.getString("MASV"));
                vt.add(kq.getString("MALOP"));
                vt.add(kq.getString("HOTEN"));
                vt.add(kq.getString("GIOITINH"));
                vt.add(kq.getString("QUEQUAN"));
                vt.add(kq.getString("QUOCTICH"));
                vt.add(kq.getString("CMTND"));
                vt.add(kq.getString("NGAYSINH"));
                data.add(vt);
            }
        return data;
    }
     public Vector<Vector<String>> Sap() throws SQLException
    {
        Vector<Vector<String>> data = new Vector<>();
        ResultSet rs=null;// khai báo
       stm=con.createStatement();//khởi tạo đối tượng stm
        rs=stm.executeQuery("select *  from SINHVIEN ORDER BY MASV ");
         while(rs.next())
            {
                Vector vt=new Vector();
                vt.add(rs.getString("MASV"));
                vt.add(rs.getString("MALOP"));
                vt.add(rs.getString("HOTEN"));
                vt.add(rs.getString("GIOITINH"));
                vt.add(rs.getString("QUEQUAN"));
                vt.add(rs.getString("QUOCTICH"));
                vt.add(rs.getString("CMTND"));
                vt.add(rs.getString("NGAYSINH"));
                data.add(vt);
            }
        return data;
    }

public Vector<Vector<String>> findLop(String MALOP)throws SQLException
    {
        Vector<Vector<String>> data = new Vector<>();
        ResultSet kq=null;
        stm=con.createStatement();
        kq=stm.executeQuery("select *  from SINHVIEN "
                                                       + "where MALOP='"+MALOP
                                                     +"' ORDER BY MALOP,MASV");
        while(kq.next())
            {
                Vector vt=new Vector();
                vt.add(kq.getString("MASV"));
                vt.add(kq.getString("MALOP"));
                vt.add(kq.getString("HOTEN"));
                vt.add(kq.getString("GIOITINH"));
                vt.add(kq.getString("QUEQUAN"));
                vt.add(kq.getString("QUOCTICH"));
                vt.add(kq.getString("CMTND"));
                vt.add(kq.getString("NGAYSINH"));
                data.add(vt);
            }
        return data;
    }
     public boolean checkMaSV(String masv) {
         try {
         String sql = "Select * from SINHVIEN where MASV = '" + masv + "'";
        stm = con.createStatement();
         rs = stm.executeQuery(sql);
        if (!rs.next()) {
            return false;
        }
         } catch (Exception e) {
         }
        return true;
    }
     public boolean checkCmtnd(String cmtnd) {
        try {
            stm= con.createStatement();
        rs = stm.executeQuery("Select * from SINHVIEN where CMTND = '" + cmtnd + "'");
        if (!rs.next()) {
            return false;
        }
        } catch (Exception e) {
        }
        return true;
    }
     public boolean checkCmtnd(String cmtnd, String maSV) {
        try {
         stm= con.createStatement();
        rs = stm.executeQuery("Select * from SINHVIEN where CMTND = '" + cmtnd + "'AND MASV !='"+maSV+"'");
        if (!rs.next()) {
            return false;
        }
        } catch (Exception e) {
        }
        return true;
    }
     public boolean checkMaSVDiem(String masv) throws SQLException,
         ClassNotFoundException {
         String sql = "Select * from DIEM where MASV = '" + masv + "'";
        stm = con.createStatement();
        rs = stm.executeQuery(sql);
        if (!rs.next()) {
            return false;
        }
        return true;
    }
     public boolean checkMaLop(String MALOP){
         try {
             String sql = "Select * from LOP where MALOP = '" + MALOP + "'";
        stm= con.createStatement();
        rs = stm.executeQuery(sql);
        if (!rs.next()) {
            return false;
        }
         } catch (Exception e) {
         }
         return true;
       }
}
