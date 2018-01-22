package th.co.gosoft.customer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import th.co.gosoft.customer.dto.DepartmentDTO;

public class DepartmentDAO {

	public List<DepartmentDTO> selectAllDepartment() throws Exception {
		List<DepartmentDTO> resultList = new ArrayList<>();
		
		Connection connect=null;
		PreparedStatement preparedStatement = null;
		
	    try {
	    	Class.forName("com.mysql.jdbc.Driver");

    		connect =  DriverManager.getConnection("jdbc:mysql://localhost/gosoft" +
    				"?user=root&password=12345678");
    		
	        String sql = "SELECT department_id , department_name FROM department";
	        preparedStatement = connect.prepareStatement(sql);
	        ResultSet result = preparedStatement.executeQuery();

	        while (result.next()) {
	        	DepartmentDTO departmentDTO = new DepartmentDTO();
	        	departmentDTO.setDepartment_id(result.getInt("department_id"));
	        	departmentDTO.setDepartment_name(result.getString("department_name"));

	        	resultList.add(departmentDTO);
	        }
	        return resultList;
	    } catch (Exception e) {
	        throw e;
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
