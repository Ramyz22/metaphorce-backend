package com.metaphorce.metaphorceweb.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metaphorce.metaphorceweb.dao.IContractDao;
import com.metaphorce.metaphorceweb.model.Contract;
import com.metaphorce.metaphorceweb.model.Employee;
import com.metaphorce.metaphorceweb.response.ContractResponseRest;

@Service
public class ContractServiceImp implements IContractService{

	@Autowired
	private IContractDao contractDao;
	
	@Override
	@Transactional
	public ResponseEntity<ContractResponseRest> ListContract() {
		ContractResponseRest response = new ContractResponseRest();
		//List <Contract> list = new ArrayList<>();
		List <Contract> listAux = new ArrayList<>();
		
		try {
			//listAux = contractDao.listEmployeeContract();
			response.getContract().setContract(listAux);
			response.setMetadata("Response ok", "00", "Contract list, response ok");
			
			
			
		} catch (Exception e) {
			e.getStackTrace();
			response.setMetadata("Response no ok", "-1", "Error to find List");
			return new ResponseEntity<ContractResponseRest> (response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<ContractResponseRest> (response, HttpStatus.OK);
		 
	}

}
