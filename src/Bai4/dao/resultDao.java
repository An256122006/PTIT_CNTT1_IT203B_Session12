package Bai4.dao;
import Bai4.connect.HopspitalConnect;
import Bai4.entity.result;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class resultDao {
    public void insert(result result){
        String sql="INSERT INTO result (fullname, depcripsion, date) VALUES (?, ?, ?)";
        try (Connection connection=HopspitalConnect.getConnection();
             PreparedStatement preparedStatement=connection.prepareStatement(sql)){
            preparedStatement.setString(1,result.getFullname());
            preparedStatement.setString(2,result.getDepcripsion());
            preparedStatement.setString(3,result.getDate());
            if(preparedStatement.executeUpdate()>0){
                System.out.println("Insert thanh cong");
            }else {
                System.out.println("Insert that bai");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void getall(){
        String sql="SELECT * FROM result";
        try (Connection connection=HopspitalConnect.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet=preparedStatement.executeQuery()){
            while (resultSet.next()){
                result result=new result();
                result.setId(resultSet.getInt("id"));
                result.setFullname(resultSet.getString("fullname"));
                result.setDepcripsion(resultSet.getString("depcripsion"));
                result.setDate(resultSet.getString("date"));
                System.out.println(result);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
