package Bai2.Dao;
import Bai2.connect.PatientConnect;
import Bai2.entity.patients;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PatientDao {
    public boolean update(Double temp,int id) {
        boolean bl=false;
        String sql="UPDATE patients SET temperature=? WHERE patient_id=?";
        try(Connection connection=PatientConnect.getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(sql)) {
            preparedStatement.setDouble(1,temp);
            preparedStatement.setInt(2,id);;
            if(preparedStatement.executeUpdate()>0){
                bl=true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bl;
    }
}
