package Bai5.Dao;
import Bai5.connect.PatientConnect;
import Bai5.entity.patients;

import java.sql.*;
import java.util.Optional;

public class PatientDao {
    public boolean update(patients patients) {
        boolean bl=false;
        String sql="UPDATE patients SET fullname = ? , age = ? , department = ? , priceofday = ? WHERE id=?";
        try(Connection connection= PatientConnect.getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(sql)) {
            preparedStatement.setString(1,patients.getFullname());
            preparedStatement.setInt(2,patients.getAge());
            preparedStatement.setString(3,patients.getDepartment());
            preparedStatement.setDouble(4,patients.getPriceofday());
            preparedStatement.setInt(5,patients.getId());
            if(preparedStatement.executeUpdate()>0){
                bl=true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bl;
    }
    public void getAll(){
        String sql="SELECT * FROM patients";
        try(Connection connection= PatientConnect.getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery()) {
            while (resultSet.next()){
                patients patients=new patients();
                patients.setId(resultSet.getInt("id"));
                patients.setFullname(resultSet.getString("fullname"));
                patients.setAge(resultSet.getInt("age"));
                patients.setDepartment(resultSet.getString("department"));
                patients.setCheckin(resultSet.getString("checkin"));
                patients.setCheckout(resultSet.getString("checkout"));
                patients.setPriceofday(resultSet.getDouble("priceofday"));
                System.out.println(patients);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void inserntPatient(patients patients){
        String sql="INSERT INTO patients (fullname, age, department, checkin, checkout, priceofday) VALUES (?, ?, ?, ?, ?, ?)";
        try(Connection connection= PatientConnect.getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(sql)) {
            preparedStatement.setString(1,patients.getFullname());
            preparedStatement.setInt(2,patients.getAge());
            preparedStatement.setString(3,patients.getDepartment());
            preparedStatement.setString(4,patients.getCheckin());
            preparedStatement.setString(5,patients.getCheckout());
            preparedStatement.setDouble(6,patients.getPriceofday());
            if(preparedStatement.executeUpdate()>0){
                System.out.println("Insert thanh cong");
            }else {
                System.out.println("Insert that bai");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void Delete(int id){
        String sql="DELETE FROM patients WHERE id = ?";
        try(Connection connection= PatientConnect.getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(sql)) {
            preparedStatement.setInt(1,id);
            if(preparedStatement.executeUpdate()>0){
                System.out.println("Delete thanh cong");
            }else {
                System.out.println("Delete that bai");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void calculate(int id,double total_fee){
        String sql="{call CALCULATE_DISCHARGE_FEE(?,?)}";
        try(Connection connection= PatientConnect.getConnection();
            CallableStatement callableStatement= connection.prepareCall(sql)) {
            callableStatement.setInt(1,id);
            callableStatement.registerOutParameter(2,Types.DOUBLE);
            callableStatement.execute();
            total_fee = callableStatement.getDouble(2);
            System.out.println("Tong tien: "+total_fee);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Optional<patients> find(int id){
        String sql="select * from patients where id=?";
        try(Connection connection= PatientConnect.getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(sql)) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();

            if (resultSet.next()) {
                patients p = new patients();

                p.setId(resultSet.getInt("id"));
                p.setFullname(resultSet.getString("fullname"));
                p.setAge(resultSet.getInt("age"));
                p.setDepartment(resultSet.getString("department"));
                p.setCheckin(resultSet.getString("checkin"));
                p.setCheckout(resultSet.getString("checkout"));
                p.setPriceofday(resultSet.getDouble("priceofday"));
                return Optional.of(p);
            } else {
                System.out.println("Không tìm thấy!");
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
