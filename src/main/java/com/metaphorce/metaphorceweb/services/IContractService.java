package com.metaphorce.metaphorceweb.services;

import org.springframework.http.ResponseEntity;

import com.metaphorce.metaphorceweb.response.ContractResponseRest;

public interface IContractService {

	public ResponseEntity <ContractResponseRest> ListContract();
}
