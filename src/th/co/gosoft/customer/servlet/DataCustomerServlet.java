package th.co.gosoft.customer.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import th.co.gosoft.customer.dao.CustomerDAO;
import th.co.gosoft.customer.dto.CustomerDTO;

@WebServlet("/DataCustomerServlet")
public class DataCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DataCustomerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerDAO CustomerDAO = new CustomerDAO();
		List<CustomerDTO> resultList = null;
		try {
			resultList = CustomerDAO.selectAllCustomer();
			Gson gson = new Gson();
			String result = gson.toJson(resultList);	
			response.setContentType("application/Json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
}
