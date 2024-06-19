package com.lgy.member_jdbc_oracle.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemDTO {
	String mem_uid;
	String mem_pwd;
	String mem_name;
}
