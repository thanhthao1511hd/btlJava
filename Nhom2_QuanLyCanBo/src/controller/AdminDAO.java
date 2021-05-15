/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.CanBo;
import model.KySu;

/**
 *
 * @author HaQuocTuan
 */
public class AdminDAO {

    private Connection conn;

    public AdminDAO() {
        try {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"
                    + "databasename=BTLJava;"
                    + "username=sa;"
                    + "password=123456789");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    //sap xep theo ho ten
    public ArrayList<KySu> sortByName() {
        ArrayList<KySu> list = new ArrayList<>();
        String sql = "select HoTen, NamSinh, GioiTinh, DiaChi, ChiTiet\n"
                + "from CanBo inner join ChucVuCanBo on CanBo.IDCanBo = ChucVuCanBo.IDCanBo\n"
                + "			inner join ChucVu on ChucVu.IDChucVu = ChucVuCanBo.IDChucVu\n"
                + "order by CanBo.HoTen";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KySu s = new KySu();
                s.setHoten(rs.getString("HoTen"));
                s.setNamsinh(rs.getString("NamSinh"));
                s.setGioitinh(rs.getString("GioiTinh"));
                s.setDiachi(rs.getString("DiaChi"));
                s.setMota(rs.getString("ChiTiet"));
                list.add(s);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //sap xep theo nam sinh
    public ArrayList<KySu> sortByDate() {
        ArrayList<KySu> list = new ArrayList<>();
        String sql = "select HoTen, NamSinh, GioiTinh, DiaChi, ChiTiet\n"
                + "from CanBo inner join ChucVuCanBo on CanBo.IDCanBo = ChucVuCanBo.IDCanBo\n"
                + "			inner join ChucVu on ChucVu.IDChucVu = ChucVuCanBo.IDChucVu\n"
                + "order by CanBo.NamSinh";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KySu s = new KySu();
                s.setHoten(rs.getString("HoTen"));
                s.setNamsinh(rs.getString("NamSinh"));
                s.setGioitinh(rs.getString("GioiTinh"));
                s.setDiachi(rs.getString("DiaChi"));
                s.setMota(rs.getString("ChiTiet"));
                list.add(s);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    // Add cán bộ
     public int insertCB(CanBo cb)
    {
        String sql="insert into CanBo(HoTen,NamSinh,GioiTinh,DiaChi,Username,Password,isAdmin) values(?,?,?,?,?,?,?)";
         try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, cb.getHoten());
            ps.setString(2, cb.getNamsinh());
            ps.setString(3, cb.getGioitinh());
            ps.setString(4, cb.getDiachi());
            ps.setString(5, cb.getUserName());
            ps.setString(6, cb.getPassword());
            ps.setInt(7, cb.getIsAdmin());
            if(ps.executeUpdate()>0 )
            {
                System.out.println("Add is success");
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
     
     // Add chức vụ
      public int insertCv(KySu ks)
    {
        String sql2="insert into ChucVuCanBo  values(?,?,?) ";
        
        try { 
            PreparedStatement ps2=conn.prepareStatement(sql2);
            ps2.setInt(1, ks.getID());
            ps2.setInt(2, ks.getID());
            ps2.setString(3, ks.getChucVu());
            if(ps2.executeUpdate()>0 )
            {
                System.out.println("Add is success");
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    // delete cán bộ
    public int deleteCB(int id)
    {
        String sql="delete CanBo where IDCanBo=?";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1, id);
            if(ps.executeUpdate()>0)
            {
                System.out.println("Xóa thành công");
            }
        } catch (Exception e) {
        }
        return -1;
    }
    
        // Cập nhật thông tin Cán Bộ
    public int updateCv( KySu ks)
    {
        
       
        String sql2="update ChucVuCanBo set ChiTiet=? where IDChucVuCanBo=? ";
        try {
            
            PreparedStatement ps2=conn.prepareStatement(sql2);
            ps2.setString(1, ks.getMota());
            ps2.setInt(2, ks.getIDks());
            if(ps2.executeUpdate()>0 )
            {
                System.out.println("Update is success");
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    public int updateCanBo(CanBo cb)
    {
         String sql="update CanBo set HoTen=?, NamSinh=?, GioiTinh=?, DiaChi=?, Username=?"
                + " where IDCanBo=?";
         try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, cb.getHoten());
            ps.setString(2, cb.getNamsinh());
            ps.setString(3, cb.getGioitinh());
            ps.setString(4, cb.getDiachi());
            ps.setString(5, cb.getUserName());
            ps.setInt(6, cb.getID());
            if(ps.executeUpdate()>0 )
            {
                System.out.println("Update is success");
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    
    
    public static void main(String[] args) {
        new AdminDAO();
    }
}
