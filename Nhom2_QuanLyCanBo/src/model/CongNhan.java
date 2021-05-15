/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author HaQuocTuan
 */
public class CongNhan extends CanBo{
    String mota;

    public CongNhan() {
    }

    public CongNhan(String mota) {
        this.mota = mota;
    }

    public CongNhan(String mota, int ID, int isAdmin, String hoten, String namsinh, String gioitinh, String diachi, String UserName, String Password) {
        super(ID, isAdmin, hoten, namsinh, gioitinh, diachi, UserName, Password);
        this.mota = mota;
    }

    
   

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(String namsinh) {
        this.namsinh = namsinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
    
    
}
