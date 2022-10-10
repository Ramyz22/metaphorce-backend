package com.metaphorce.metaphorceweb.response;

import java.util.List;

import com.metaphorce.metaphorceweb.model.Contract;

import lombok.Data;

@Data
public class ContractResponse {
	
	List<Contract> contract; 
}
