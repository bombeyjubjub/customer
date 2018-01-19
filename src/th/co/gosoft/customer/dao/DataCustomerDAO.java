package th.co.gosoft.customer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import th.co.gosoft.customer.dto.DataCustomerDTO;

public class DataCustomerDAO {
	public List<DataCustomerDTO> selectAllCustomer() throws Exception {
		List<DataCustomerDTO> resultList = new ArrayList<>();
		Connection connect=null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
	    try {
	    	Class.forName("com.mysql.jdbc.Driver");

    		connect =  DriverManager.getConnection("jdbc:mysql://localhost/gosoft" +
    				"?user=root&password=12345678");
    		
	        String sql = "SELECT cus_name,cus_lastname,cus_username,cus_birthday,cus_age,department_name " + 
	        		"FROM customer INNER JOIN department " + 
	        		"ON customer.department_id = department.department_id";
	        preparedStatement = connect.prepareStatement(sql);
	        result = preparedStatement.executeQuery();

	        while (result.next()) {
	        	DataCustomerDTO datacustomerDTO = new DataCustomerDTO();
	        	datacustomerDTO.setName(result.getString("cus_name"));
	        	datacustomerDTO.setLastname(result.getString("cus_lastname"));
	        	datacustomerDTO.setUsername(result.getString("cus_username"));
	        	datacustomerDTO.setBirthday(result.getString("cus_birthday"));
	        	datacustomerDTO.setAge(result.getInt("cus_age"));
	        	datacustomerDTO.setDepartmentName(result.getString("department_name"));

	        	resultList.add(datacustomerDTO);
	        }
	        return resultList;
	    } catch (Exception e) {
	        System.out.println(e);
	        throw e;
	    }finally {
	    	if(result != null){
	    		result.close();
	    	}
	    	if(preparedStatement != null) {
	    		
	    		preparedStatement.close();
	    	}
	    	if(connect != null) {
	    		connect.close();
	    	}
	    }
	}
	public static void main(String[] args) throws Exception {
		DataCustomerDAO dataCustomerDAO = new DataCustomerDAO();
		List<DataCustomerDTO> resultList = dataCustomerDAO.selectAllCustomer();
		System.out.println(resultList.size());
		System.out.println(resultList.get(1).getName());
		System.out.println(resultList.get(1).getLastname());
		System.out.println(resultList.get(1).getUsername());
		System.out.println(resultList.get(1).getBirthday());
		System.out.println(resultList.get(1).getAge());
		System.out.println(resultList.get(1).getDepartmentName());
	}
}
