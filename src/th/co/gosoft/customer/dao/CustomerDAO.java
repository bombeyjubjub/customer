package th.co.gosoft.customer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import th.co.gosoft.customer.dto.CustomerDTO;

public class CustomerDAO {

	public void insert(CustomerDTO customerDTO) throws SQLException {
		Connection connect=null;
		PreparedStatement preparedStatement = null;
    	try {
    		Class.forName("com.mysql.jdbc.Driver");

    		connect =  DriverManager.getConnection("jdbc:mysql://localhost/gosoft" +
    				"?user=root&password=12345678");
    		String name = customerDTO.getName();
            String lastname = customerDTO.getLastname();
            String username = customerDTO.getUsername();
            String password = customerDTO.getPassword();
            String birthday = customerDTO.getBirthday();
            int age = customerDTO.getAge();
            int departmentId = customerDTO.getDepartmentId();
            
    		String sql = "INSERT INTO customer (cus_name, cus_lastname, cus_username, cus_password, cus_birthday,cus_age,department_id) "
    				+ "VALUES (?,?,?,?,?,?,?)";
    		
    		preparedStatement = connect.prepareStatement(sql);
    		
    		preparedStatement.setString(1,name);
			preparedStatement.setString(2,lastname);
			preparedStatement.setString(3,username);
			preparedStatement.setString(4,password);
			preparedStatement.setString(5,birthday);
			preparedStatement.setInt(6,age);
			preparedStatement.setInt(7,departmentId);
			
			preparedStatement.executeUpdate();

			System.out.println("Record Inserted Successfully");		
    		} catch (Exception e) {
    			e.printStackTrace();
    		}finally {
    			if(preparedStatement != null) {
    				preparedStatement.close();
    			}
    			if(connect != null) {
    				connect.close();
    			}
    		}
	}
}
