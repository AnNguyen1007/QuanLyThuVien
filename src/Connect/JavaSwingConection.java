/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import DinhDang.Bao;
import DinhDang.Sach;
import DinhDang.TaiLieu;
import DinhDang.TapChi;

public class JavaSwingConection {
    public List<Bao> getAllBao() {
    List<Bao> baoAll = new ArrayList<>();
      Connection connection = SQLConection.getConnection();
          try {
              String sql = "SELECT idTL, tenNXB, soBanPhatHanh, ngayPhathanh FROM TaiLieu WHERE Loai=?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,"bao");
            ResultSet rs = pstmt.executeQuery();           
            while( rs.next()) {
                Bao bao = new Bao();
                
                bao.setIdTL(rs.getString(1));
                bao.setTenNXB(rs.getString(2));
                bao.setSoBanPhatHanh(rs.getInt(3));
                bao.setNgayPhatHanh(rs.getString(4));

               baoAll.add(bao);
            }
            return baoAll;
        } catch(SQLException e){
            System.out.println("Lấy dữ liệu Báo lỗi");
        }
        return null;
    }
    public List<TapChi> getAllTapChi() {
    List<TapChi> tapchiAll = new ArrayList<>();
      Connection connection = SQLConection.getConnection();
          try {
              String sql = "SELECT idTL, tenNXB, soBanPhatHanh, soPhatHanh, thangPhatHanh FROM TaiLieu WHERE Loai=?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,"tapchi");
            ResultSet rs = pstmt.executeQuery();           
            while( rs.next()) {
                TapChi tapchi = new TapChi();
                
                tapchi.setIdTL(rs.getString(1));
                tapchi.setTenNXB(rs.getString(2));
                tapchi.setSoBanPhatHanh(rs.getInt(3));
                tapchi.setSoPhatHanh(rs.getString(4));
                tapchi.setThangPhatHanh(rs.getString(5));

               tapchiAll.add(tapchi);
            }
            return tapchiAll;
        } catch(SQLException e){
            System.out.println("Lấy dữ liệu Báo lỗi");
        }
        return null;
    }
    public List<Sach> getAllSach() {
    List<Sach> sachAll = new ArrayList<>();
      Connection connection = SQLConection.getConnection();
          try {
              String sql = "SELECT idTL, tenNXB, soBanPhatHanh, tenTacGia, soTrang FROM TaiLieu WHERE Loai=?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,"Sach");
            ResultSet rs = pstmt.executeQuery();           
            while( rs.next()) {
                Sach sach = new Sach();
                
                sach.setIdTL(rs.getString(1));
                sach.setTenNXB(rs.getString(2));
                sach.setSoBanPhatHanh(rs.getInt(3));
                sach.setTenTacGia(rs.getString(4));
                sach.setSoTrang(rs.getString(5));

               sachAll.add(sach);
            }
            return sachAll;
        } catch(SQLException e){
            System.out.println("Lấy dữ liệu Báo lỗi");
        }
        return null;
    }
    
     public TaiLieu searchTaiLieu(String id)
    {
        TaiLieu tailieu= new TaiLieu();
        Connection connect = SQLConection.getConnection();
        
        try {
            String sql=  "select idTL, tenNXB, soBanPhatHanh\n" +
                                "from TaiLieu\n" +
                                "where idTL=?\n";
            PreparedStatement pstmt = connect.prepareStatement(sql);
            pstmt.setString(1,id);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            tailieu.setIdTL(rs.getString(1));
            tailieu.setTenNXB(rs.getString(2));
            tailieu.setSoBanPhatHanh(rs.getInt(3));
            
            return tailieu;
            
        }
        catch(SQLException e)
        {
            System.out.println("tim sach theo id khong thay");
            return null;
        }      
    }
     
        public void deteleTaiLieu(String id)
    {
        Connection connection = SQLConection.getConnection();
        String sql = "delete TaiLieu "
                + "where idTL=?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,id);        
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
                System.out.println("ham xoa loi");
        }
    }
    
    
}
