/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;

import entity.TaiKhoan;
import java.util.ArrayList;

/**
 *
 * @author TranThuyNga
 */
public class ConnectTK  extends Connect{
    public ArrayList<TaiKhoan> getData()  {
        ArrayList<TaiKhoan> ds = new ArrayList<TaiKhoan>();
        try {
                stm = con.createStatement();
                rs = stm.executeQuery("select * from TAIKHOAN");
                while (rs.next()) {
                    TaiKhoan sv = new TaiKhoan(rs.getString(1), 
                            rs.getString(2));
                    ds.add(sv);                        
                }                                
        } catch (Exception ex) {           
            System.out.println("loi getData "+ ex.toString());
            return null;
        }
        return ds;
    }  
}
