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
public class KySu extends CanBo{
    String mota;
    int IDks;
    public KySu() {
    }

    public KySu(String mota) {
        this.mota = mota;
    }

    public KySu(String mota, int IDks, int ID, int isAdmin, String hoten, String namsinh, String gioitinh, String diachi, String UserName, String Password) {
        super(ID, isAdmin, hoten, namsinh, gioitinh, diachi, UserName, Password);
        this.mota = mota;
        this.IDks = IDks;
    }

    

    public int getIDks() {
        return IDks;
    }

    public void setIDks(int IDks) {
        this.IDks = IDks;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
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
