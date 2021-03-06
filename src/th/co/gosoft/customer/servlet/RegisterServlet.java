package th.co.gosoft.customer.servlet;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import th.co.gosoft.customer.model.RegisterCustomerModel;
import th.co.gosoft.customer.service.CustomerService;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BufferedReader reader = request.getReader();
		Gson gson = new Gson();
		RegisterCustomerModel registerCustomerModel = gson.fromJson(reader, RegisterCustomerModel.class);
    		
    		CustomerService customerService = new CustomerService();
    		customerService.registerCustomer(registerCustomerModel);

    		RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
            dispatcher.forward(request, response);    		
	}
}
