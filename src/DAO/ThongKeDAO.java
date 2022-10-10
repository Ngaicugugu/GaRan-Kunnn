
package DAO;
import GiaoDien.FormQuanLi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Utils.jdbchelper;

public class ThongKeDAO {
    public List<Object[]> getHangHoa(){
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "select sanpham, soluong, gia, doanhthu from thongke";
                rs = jdbchelper.query(sql);
                while (rs.next()) {                    
                    Object[] model = {
                        rs.getString("sanpham"),
                        rs.getInt("soluong"),
                        rs.getFloat("gia"),
                        rs.getFloat("doanhthu")
                    };
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
     public List<Object[]> getTheoNam(int nam){
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "select sanpham, thongke.soluong, gia, doanhthu from thongke, daban where thongke.sott = daban.sott and YEAR(ngaymua) = '?' ";
                rs = jdbchelper.query(sql);
                while (rs.next()) {                    
                    Object[] model = {
                        rs.getString("sanpham"),
                        rs.getInt("soluong"),
                        rs.getFloat("gia"),
                        rs.getFloat("doanhthu")
                    };
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
     
 
}
