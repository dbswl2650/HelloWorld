package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.jdbc.ReplyDAO;

public class DeleteEventControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("a"); // 휴가
		
		ReplyDAO rdao = new ReplyDAO();
		Map<String, String> inputVal = new HashMap<>();
		inputVal.put("title", title); 
		
		if(rdao.deleteEvent(inputVal)) {
			// {"retCod": "Ok"}
			resp.getWriter().print("{\"retCode\": \"OK\"}");
		} else {
			// {"retCod": "Fail"}
			resp.getWriter().print("{\"retCode\": \"Fail\"}");
		}
	
	}
}
