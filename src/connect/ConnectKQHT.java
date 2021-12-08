/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class ConnectKQHT extends Connect{
    
    protected  Statement getStatement()throws Exception
    {
        if(this.stm==null || this.stm.isClosed())
        {
            //khoi tao statement moi
            this.stm=this.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
        }
        return this.stm;
    }
    
    public ResultSet executeQuery(String qr) throws Exception
    {
        try{
            //thuc thi cau lenh
            this.rs=getStatement().executeQuery(qr);
        }
        catch(Exception e)
        {
            throw new Exception("Cau lenh Query khong duoc thuc thi");
        }
        return this.rs;
        //van mo ket noi de lay thong tin
    }
   
     
    public int executeUpdate(String qr) throws Exception
    {
        int ketqua=0;
        try{
            // thuc thi cau lenh
            ketqua=getStatement().executeUpdate(qr);
        }
        catch(Exception e)
        {
            throw new Exception("Loi queryUpdate khong duoc thuc hien");
        }
        finally{
            this.con.close();
        }
        return ketqua;
    }
    
    public ResultSet GetData(String jtable) throws SQLException
    {
        ResultSet kq=null;
        Statement st=con.createStatement();
        kq=st.executeQuery("select *"
                                    + " from DIEM");
        return kq;
    }

    public int add(String maSV, String maMon, double diemTP,
            double diemThi, double diemTB, double diem4, String diemChu, String xepLoai ) throws Exception
    {
        int t=0;
        t=getStatement().executeUpdate("insert into DIEM values('"+ maSV +"','"+ maMon +"',"+ diemTP 
                +","+  diemThi + ","+ diemTB + ","+diem4+",'"+diemChu+"','"+xepLoai+"')");
        return t;
    }
    
    public int update(String maSV, String maMon, double diemTP, double diemThi, double diemTB,
            double diem4, String diemChu, String xepLoai) throws Exception
    {
        int t;
        t=getStatement().executeUpdate("update DIEM set DIEMTHANHPHAN="+ diemTP +",DIEMTHI="
                + diemThi + ",DIEMTB="+ diemTB + ",THANGDIEM4="+diem4+",THANGDIEMCHU='"+diemChu
                +"',XEPLOAI='"+xepLoai+"' "+"where MASV='"+ maSV +"'" + "and MAMON='"+ maMon +"'");
        return t;
    }
    
    public int remove(String maSV, String maMon) throws Exception
    {
        int t;
        t= getStatement().executeUpdate("delete from DIEM where MASV='"+maSV+"'" 
                + "and MAMON='"+ maMon +"'");
        return t;
    }
    
    public ResultSet sapDiem() throws SQLException
    {
        ResultSet kq=null;
        Statement st=con.createStatement();
        kq=st.executeQuery("Select *from DIEM ORDER BY MASV, MAMON");
        return kq;       
    }
    
    public ResultSet findDiemByMaSVMaMon(String maSV, String maMon) throws SQLException
    {
        ResultSet kq=null;
        Statement st=con.createStatement();
        kq=st.executeQuery("select * from DIEM where MASV='"+ maSV +"'" + "and MAMON='" + maMon + "'");
        return kq;
    }
    
    public ResultSet findDiemByMaSV(String maSV) throws SQLException
    {
        ResultSet kq=null;
        Statement st=con.createStatement();
        kq=st.executeQuery("select * FROM DIEM WHERE MASV='"+maSV+"'");
        return kq;
    }
    
    public ResultSet findDiemByMaMon(String maMon) throws SQLException
    {
        ResultSet kq=null;
        Statement st=con.createStatement();
        kq=st.executeQuery("select *from DIEM  where MAMON='" + maMon + "'");
        return kq;
    }

    public boolean checkMaSVMaMon(String maSV, String maMon) throws SQLException, 
            ClassNotFoundException {
        Statement stm1 = con.createStatement();
        ResultSet rs = stm1.executeQuery("Select *  from DIEM where MASV = '" + maSV + "' and MAMON='" + maMon + "'");
        if (!rs.next()) {
            return false;
        }
        return true;
    }
    
    public boolean checkMaSV(String maSV) throws SQLException, ClassNotFoundException {
        Statement stm1 = con.createStatement();
        ResultSet rs = stm1.executeQuery("Select * from DIEM where MASV = '" + maSV + "'");
        if (!rs.next()) {
            return false;
        }
        return true;
    }
    public boolean checkMaMon(String maMon) throws SQLException, ClassNotFoundException {
        Statement stm1 = con.createStatement();
        ResultSet rs = stm1.executeQuery("Select * from DIEM where MAMON='" + maMon + "'");
        if (!rs.next()) {
            return false;
        }
        return true;
    }
     public boolean checkMaMh(String maMon) throws SQLException, ClassNotFoundException {
             Statement stm1 = con.createStatement();
        ResultSet rs = stm1.executeQuery("Select * from MONHOC where MAMON='" + maMon + "'");
        if (!rs.next()) {
            return false;
        }
        return true;
    }

}
