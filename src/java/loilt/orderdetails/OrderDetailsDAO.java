package loilt.orderdetails;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import loilt.util.DBHelper;

public class OrderDetailsDAO implements Serializable {

    public boolean insertOrderDetail(String userId, String mobileId, int quantity, float price)
            throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "INSERT INTO tbl_OrderDetails(userId, mobileId, quantity, price, total) "
                        + "VALUES(?, ?, ?, ?, ?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, userId);
                stm.setString(2, mobileId);
                stm.setInt(3, quantity);
                stm.setFloat(4, price);
                stm.setFloat(5, price * quantity);
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

    public List<OrderDetailsDTO> getAll() throws SQLException, ClassNotFoundException {
        List<OrderDetailsDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT orderDetailId, userId, mobileId, quantity, price, total "
                        + "FROM tbl_OrderDetails";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int orderDetailId = rs.getInt("orderDetailId");
                    String userId = rs.getString("userId");
                    String mobileId = rs.getString("mobileId");
                    int quantity = rs.getInt("quantity");
                    float price = rs.getFloat("price");
                    float total = rs.getFloat("total");
                    list.add(new OrderDetailsDTO(orderDetailId, userId, mobileId, quantity, price, total));
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
}
