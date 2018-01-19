package th.co.gosoft.customer.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import th.co.gosoft.customer.dao.DepartmentDAO;
import th.co.gosoft.customer.dto.DepartmentDTO;

@WebServlet("/DepartmentServlet")
public class DepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DepartmentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DepartmentDAO departmentDAO = new DepartmentDAO();
		List<DepartmentDTO> resultList = null;
		try {
			resultList = departmentDAO.selectAllDepartment();
			Gson gson = new Gson();
			String result = gson.toJson(resultList);	
//			JsonElement element = gson.toJsonTree(resultList,new TypeToken<List<DepartmentDTO>>() {}.getType());
//			JsonArray jsonArray = element.getAsJsonArray();
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

	public static void main(String[] args) {
		DepartmentDAO departmentDAO = new DepartmentDAO();
		List<DepartmentDTO> resultList = null;
		try {
			resultList = departmentDAO.selectAllDepartment();
			Gson gson = new Gson();
			String result = gson.toJson(resultList);
			
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
