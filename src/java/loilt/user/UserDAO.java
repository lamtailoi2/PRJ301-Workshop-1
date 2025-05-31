package loilt.user;

import java.io.Serializable;
import java.sql.Connection;
import loilt.util.DBHelper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO implements Serializable {

    public boolean checkLogin(String userId, String password) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT password "
                        + "FROM tbl_Users "
                        + "WHERE userId = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, userId);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String _password = rs.getString("password");
                    return _password.equals(password);
                }
            }
            return false;
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
    }

    public UserDTO getUserById(String id) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        UserDTO user = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT userId, password, fullname, role "
                        + "FROM tbl_Users "
                        + "WHERE userId = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String userId = rs.getString("userId");
                    String password = rs.getString("password");
                    String fullName = rs.getString("fullName");
                    int role = rs.getInt("role");
                    user = new UserDTO(userId, password, fullName, role);
                }
            }
            return user;
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
    }

}
