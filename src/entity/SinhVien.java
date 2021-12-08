/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author TranThuyNga
 */
public class SinhVien {
    String masv,malop, hoten, gioitinh, qquan,qtich,cmtnd;
    Date ngaySinh;

    public SinhVien(String masv, String malop, String hoten, String gioitinh, String qquan, String qtich, String cmtnd, Date ngaySinh) {
        this.masv = masv;
        this.malop = malop;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.qquan = qquan;
        this.qtich = qtich;
        this.cmtnd = cmtnd;
        this.ngaySinh = ngaySinh;
    }

    public SinhVien() {
    }

    public String getMasv() {
        return masv;
    }

    public String getMalop() {
        return malop;
    }

    public String getHoten() {
        return hoten;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public String getQquan() {
        return qquan;
    }

    public String getQtich() {
        return qtich;
    }

    public String getCmtnd() {
        return cmtnd;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public void setQquan(String qquan) {
        this.qquan = qquan;
    }

    public void setQtich(String qtich) {
        this.qtich = qtich;
    }

    public void setCmtnd(String cmtnd) {
        this.cmtnd = cmtnd;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    
}
