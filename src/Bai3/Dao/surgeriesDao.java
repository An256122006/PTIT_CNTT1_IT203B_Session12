package Bai3.Dao;
import Bai3.connect.surgeriesConnect;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class surgeriesDao {
    public double calculateInsuranceCost(int id, double insurance_percent) {
        String sql="{call GET_SURGERY_FEE(?,?)}";
        try (Connection connection=surgeriesConnect.getConnection();
             CallableStatement callableStatement=connection.prepareCall(sql)){
            callableStatement.setInt(1,id);
            callableStatement.registerOutParameter(2,java.sql.Types.DOUBLE);
            callableStatement.execute();
            return callableStatement.getDouble(2);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}