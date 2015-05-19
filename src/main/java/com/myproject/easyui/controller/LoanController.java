package com.myproject.easyui.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myproject.easyui.service.LoanService;
import com.myproject.model.Loan;


/**
 * 项目处理
 * 	shaql
 * @author Administrator
 *
 */
@Controller
public class LoanController extends BaseController{

	@Autowired
	LoanService loanService;
	
	/**
	 * 项目显示页面     shaql
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/admin/verify/loanList", method = RequestMethod.GET)
	public String loanListView(Model model){
		return "/verify/loanList";
	} 
	
	@RequestMapping(value = "/verify/loanList", method = RequestMethod.POST)
	public void getLoanList(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("-----------------1111111111111--------------------");
		List<Loan> loans =loanService.getAll();
		System.out.println(loans.size()+"-------------------------------------");
		writeJson(loanService.getAll(), response);
	}
	
//	@ResponseBody
//	@RequestMapping(value = "/user/roleList", method = RequestMethod.POST)
//	public String getRoleData(Model model, HttpServletRequest request,
//			HttpServletResponse response) throws IOException {
//		String rows = request.getParameter("rows");
//		String page = request.getParameter("page");
//		if (rows == null) {
//			rows = "20";
//		}
//		if (page == null) {
//			page = "1";
//		}
//		
//		PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
//		List<Role> roleList = roleService.getAll();
//		PageInfo<Role>  pageInfo = new PageInfo<Role>(roleList);
//		ResponseResult result = new ResponseResult();
//		result.setTotal(pageInfo.getTotal());
//		result.setRows(roleList);
//		ObjectMapper mapper = new ObjectMapper();
//		
//		return  mapper.writeValueAsString(result);
//	}
//	
//	
//	@RequestMapping(value = "/user/roleSave", method = RequestMethod.POST)
//	public String userAddResponse(@ModelAttribute("role") Role role,
//			HttpServletRequest request, HttpServletResponse response) {
//		role.setId(role.getName());
//		role.setDescription(role.getDescription());
//		String resource = "/mybatis-config-test.xml";
//		InputStream is = LoanController.class.getResourceAsStream(resource);
//		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
//		SqlSession session = factory.openSession();
//		String statement = "com.myproject.mybatis.role.roleMapper.saveUser";
//		session.insert(statement, role);
//		session.commit();
//		session.close();
//		return null;
//	} 
	
}
