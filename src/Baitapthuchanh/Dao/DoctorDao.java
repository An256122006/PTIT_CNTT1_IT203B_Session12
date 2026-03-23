package Baitapthuchanh.Dao;
import Baitapthuchanh.Connect.Doctor;
import Baitapthuchanh.entity.Doctors;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDao {
    public List<Doctors> findDoctors(String specialty) {
        String sql="SELECT * FROM Doctors WHERE specialty = ?";
        List<Doctors> doctor=new ArrayList<>();
        try (Connection connection= Doctor.getConnection();
             PreparedStatement preparedStatement= connection.prepareStatement(sql);
        ){
            preparedStatement.setString(1,specialty);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Doctors doctors=new Doctors();
                doctors.setId(resultSet.getInt("doctor_id"));
                doctors.setFullName(resultSet.getString("full_Name"));
                doctors.setSpecialty(resultSet.getString("specialty"));
                doctors.setExperienceYears(resultSet.getInt("experience_Years"));
                doctors.setBaseSalary(resultSet.getDouble("base_Salary"));
                doctors.setPassword(resultSet.getString("password"));
                doctor.add(doctors);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return doctor;
    }
    public double calculateTotalSalary(int d_id){
        String sql="{CALL calculate_duty_fee(?, ?)}";
        try(Connection connection=Doctor.getConnection();
            CallableStatement callableStatement= connection.prepareCall(sql)) {
            callableStatement.setInt(1,d_id);
            callableStatement.registerOutParameter(2,Types.DOUBLE);
            callableStatement.execute();
            return callableStatement.getDouble(2);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean update(int id,String newpass){
        boolean bl=false;
        String sql="UPDATE Doctors SET password=? WHERE doctor_id=?";
        try(Connection connection=Doctor.getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(sql)) {
            preparedStatement.setString(1,newpass);
            preparedStatement.setInt(2,id);
            int row=preparedStatement.executeUpdate();
            if (row>0){
                bl=true;
            }
            return bl;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
