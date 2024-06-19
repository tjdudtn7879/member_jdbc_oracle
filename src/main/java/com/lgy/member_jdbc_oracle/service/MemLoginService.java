package com.lgy.member_jdbc_oracle.service;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.lgy.member_jdbc_oracle.dao.MemDAO;
import com.lgy.member_jdbc_oracle.dto.MemDTO;


public class MemLoginService implements MemService{


	@Override
	public int execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String mId = request.getParameter("mem_uid");
		String mPw = request.getParameter("mem_pwd");
		int re;
		
		MemDAO dao = new MemDAO();
//		int re = dao.loginYn(mId, mPw);
		ArrayList<MemDTO> dtos = dao.loginYn(mId, mPw);
		
		if (dtos.isEmpty()) {
			re=-1;
		} else {
			if (mPw.equals(dtos.get(0).getMem_pwd())) {
				re=1;
			} else {
				re=0;
			}
		}
		
		return re;
	}


}
