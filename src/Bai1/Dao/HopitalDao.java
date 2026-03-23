package Bai1.Dao;

import java.util.List;
import Bai1.entity.doctor;
import Bai1.Connect.HopspitalConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//Vì sao PreparedStatement là “tấm khiên”?
// Cách hoạt động:
//PreparedStatement ps = connection.prepareStatement(
//        "SELECT * FROM users WHERE username = ? AND password = ?"
//);
//
//ps.setString(1, user);
//ps.setString(2, pass);
//
//Quan trọng:
//
//SQL gửi lên DB là:
//SELECT * FROM users WHERE username = ? AND password = ?
//Dữ liệu (user, pass) được gửi riêng, KHÔNG ghép vào SQL
public class HopitalDao {
    public void getDoctors(String code, String pass) {
        String sql = "SELECT * FROM doctors where code=? and pass=?";
        try(Connection connection=HopspitalConnect.getConnection();
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        ) {
            preparedStatement.setString(1,code);
            preparedStatement.setString(2,pass);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                doctor newDoctor = new doctor();
                newDoctor.setId(resultSet.getInt("id"));
                newDoctor.setCode(resultSet.getString("code"));
                newDoctor.setPass(resultSet.getString("pass"));
                System.out.println(newDoctor);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
