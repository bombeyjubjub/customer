package th.co.gosoft.customer.service;

import java.time.LocalDate;
import java.time.Period;

import th.co.gosoft.customer.dao.CustomerDAO;
import th.co.gosoft.customer.dto.CustomerDTO;
import th.co.gosoft.customer.model.RegisterCustomerModel;

public class CustomerService {

	public boolean registerCustomer(RegisterCustomerModel registerCustomerModel) {
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setName(registerCustomerModel.getName());
		customerDTO.setLastname(registerCustomerModel.getLastname());
		customerDTO.setUsername(registerCustomerModel.getUsername());
		customerDTO.setPassword(registerCustomerModel.getPassword());
		customerDTO.setBirthday(registerCustomerModel.getBirthday());
		customerDTO.setDepartmentId(registerCustomerModel.getDepartmentId());
		try {
		    String startDateString = registerCustomerModel.getBirthday();;
		    String[] parts = startDateString.split("/");
		    int day = Integer.parseInt(parts[0]);
		    int month = Integer.parseInt(parts[1]);
		    int year = Integer.parseInt(parts[2]);

		    LocalDate birthDate = LocalDate.of(year, month, day);
		    int result = calculateAge(birthDate);
		    customerDTO.setAge(result);
		    CustomerDAO customerDAO = new CustomerDAO();
		    customerDAO.insert(customerDTO);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return true;
	}
	
	public int calculateAge(LocalDate birthDate) {
		LocalDate currentDate = LocalDate.now();
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }
	
}
