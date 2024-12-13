package com.yedam;

import java.util.List;

import com.yedam.jdbc.ReplyDAO;
import com.yedam.vo.ReplyVO;

public class AppTest {
	public static void main(String[] args) {
		ReplyVO rv = new ReplyVO();
		rv.setBoardNo(224);
		rv.setReply("댓글테스트1234");
		rv.setReplyer("user99");
		
		ReplyDAO rdao = new ReplyDAO();
		if(rdao.insertReply(rv)) {
			System.out.println("삭제됨");
		} else {
			System.out.println("삭제안됨");
		}
		
		List<ReplyVO> list = rdao.selectList(224);
		for(ReplyVO rvo : rdao.selectList(224)) {
			System.out.println(rvo.toString());
		}
	}
}