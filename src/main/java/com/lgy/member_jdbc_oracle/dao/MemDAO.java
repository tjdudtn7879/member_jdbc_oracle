package com.lgy.member_jdbc_oracle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.lgy.member_jdbc_oracle.dto.MemDTO;
import com.lgy.member_jdbc_oracle.util.Constant;


public class MemDAO {
	JdbcTemplate template=null;
	
	public MemDAO() {
		template=Constant.template;
	}
	
//	public int loginYn(final String id, String pw) {
	public ArrayList<MemDTO> loginYn(final String id, String pw) {
		
//		String sql = "select mem_pwd from mvc_member where mem_uid="+id;
		String sql = "select mem_pwd from mvc_member where mem_uid='"+id+"'";
		return (ArrayList<MemDTO>) template.query(sql, new BeanPropertyRowMapper(MemDTO.class));
		
	}
public void write(final String mem_uid, final String mem_pwd, final String mem_name) {
		
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql="insert into mvc_member(mem_uid, mem_pwd, mem_name) "
						+ "values(?,?,?)";
//				con : 메소드 매개변수 이름 일치
				PreparedStatement pstmt = con.prepareStatement(sql);
//				파라미터 등은 final로 구성
				pstmt.setString(1, mem_uid);
				pstmt.setString(2, mem_pwd);
				pstmt.setString(3, mem_name);
				return pstmt;
			}
		});
		
	}
	
}
