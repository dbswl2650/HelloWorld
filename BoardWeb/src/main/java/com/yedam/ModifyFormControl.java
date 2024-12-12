package com.yedam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.jdbc.BoardDAO;
import com.yedam.vo.BoardVO;

public class ModifyFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bno = req.getParameter("board_no"); // 9글
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		
		System.out.println(bno);
		BoardDAO bdao = new BoardDAO();
		BoardVO bvo = bdao.selectBoard(Integer.parseInt(bno)); // 글번호 상세정보 반환.
		
		// 조회한 board정보를 jsp페이지에 전달.
		req.setAttribute("board", bvo); // board의 속성에 조회된 결과를 전달.
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		req.setAttribute("page", page);
		
		req.setAttribute("board", bvo);
		req.getRequestDispatcher("WEB-INF/html/modifyForm.jsp").forward(req, resp);
	}

}
