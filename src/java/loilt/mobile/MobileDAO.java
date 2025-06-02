package loilt.mobile;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import loilt.util.DBHelper;
import java.sql.Connection;

public class MobileDAO {

    public List<MobileDTO> searchByIdOrName(String keyword) throws SQLException, ClassNotFoundException {
        List<MobileDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT mobileId, mobileName, price, description, quantity, notSale , yearOfProduction "
                        + "FROM tbl_Mobile "
                        + "WHERE mobileId LIKE ? OR mobileName LIKE ?";
                stm = con.prepareStatement(sql);
                String value = "%" + keyword + "%";
                stm.setString(1, value);
                stm.setString(2, value);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("mobileId");
                    String name = rs.getString("mobileName");
                    float price = rs.getFloat("price");
                    String description = rs.getString("description");
                    int yearOfProduction = rs.getInt("yearOfProduction");
                    int quantity = rs.getInt("quantity");
                    boolean notSale = rs.getBoolean("notSale");
                    list.add(new MobileDTO(id, name, price, description, quantity, yearOfProduction, notSale));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return list;
    }

    public List<MobileDTO> searchByValue(float minPrice, float maxPrice) throws SQLException, ClassNotFoundException {
        List<MobileDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT mobileId, mobileName, price, description, quantity, notSale , yearOfProduction "
                        + "FROM tbl_Mobile "
                        + "WHERE price >= ? AND price <= ? AND notSale = 0";
                stm = con.prepareStatement(sql);
                stm.setFloat(1, minPrice);
                stm.setFloat(2, maxPrice);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("mobileId");
                    String name = rs.getString("mobileName");
                    float price = rs.getFloat("price");
                    String description = rs.getString("description");
                    int yearOfProduction = rs.getInt("yearOfProduction");
                    int quantity = rs.getInt("quantity");
                    boolean notSale = rs.getBoolean("notSale");
                    list.add(new MobileDTO(id, name, price, description, quantity, yearOfProduction, notSale));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return list;
    }

    public boolean deleteById(String id) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "DELETE FROM tbl_Mobile "
                        + "WHERE mobileId = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                int row = stm.executeUpdate();
                return row > 0;
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;

    }

    public boolean updateMobile(MobileDTO mobile) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "UPDATE tbl_Mobile "
                        + "SET  price = ?, quantity = ?, description = ?, notSale = ? "
                        + "WHERE mobileId = ?";
                stm = con.prepareStatement(sql);
                stm.setFloat(1, mobile.getPrice());
                stm.setInt(2, mobile.getQuantity());
                stm.setString(3, mobile.getDescription());
                stm.setBoolean(4, mobile.isNotSale());
                stm.setString(5, mobile.getMobileId());
                int row = stm.executeUpdate();
                return row > 0;

            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;

    }

    public MobileDTO getMobileById(String id) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        MobileDTO dto = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT mobileId, mobileName, description, price, yearOfProduction, quantity, notSale FROM tbl_Mobile "
                        + "WHERE mobileId = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String _id = rs.getString("mobileId");
                    String name = rs.getString("mobileName");
                    float price = rs.getFloat("price");
                    String description = rs.getString("description");
                    int yearOfProduction = rs.getInt("yearOfProduction");
                    int quantity = rs.getInt("quantity");
                    boolean notSale = rs.getBoolean("notSale");
                    dto = new MobileDTO(_id, name, price, description, quantity, yearOfProduction, notSale);
                }
            }
        } finally {

            if (rs != null) {
                rs.close();
            }

            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return dto;
    }

    public boolean insertMobile(MobileDTO mobile) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "INSERT INTO tbl_Mobile(mobileId, mobileName, description, price, yearOfProduction, quantity, notSale) "
                        + "VALUES(?,?,?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, mobile.getMobileId());
                stm.setString(2, mobile.getMobileName());
                stm.setString(3, mobile.getDescription());
                stm.setFloat(4, mobile.getPrice());
                stm.setInt(5, mobile.getYearOfProduction());
                stm.setInt(6, mobile.getQuantity());
                stm.setBoolean(7, mobile.isNotSale());
                int row = stm.executeUpdate();
                return row > 0;
            }

        } finally {

            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

}
