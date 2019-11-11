package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.TipsDao;
import vo.Plot1;
import vo.Tips;


@WebServlet("/GetMaleTipsList")
public class GetMaleTipsList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TipsDao td = new TipsDao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		System.out.println("서블릿 실행 남자 ");
		
		List<Tips> list = td.getTipsMale();
		
		Gson gson = new Gson(); 
		String json = gson.toJson(list);
		
		System.out.println(list);
		System.out.println("돌아갑니다.");
		
		response.getWriter().write(json);
	}

}
