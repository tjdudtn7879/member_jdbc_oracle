package com.lgy.member_jdbc_oracle.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.lgy.member_jdbc_oracle.dao.MemDAO;



//게시글 저장
public class MWriteService implements MemService{

	@Override
	public int execute(Model model) {
		Map<String, Object>map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String boardName = request.getParameter("mem_uid");
		String boardTitle = request.getParameter("mem_pwd");
		String boardContent = request.getParameter("mem_name");
		
		MemDAO dao=new MemDAO();
		dao.write(boardName, boardTitle, boardContent);
		
		return 0;
	}
	
}
