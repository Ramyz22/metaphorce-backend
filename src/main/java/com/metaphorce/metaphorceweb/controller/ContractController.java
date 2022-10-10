package com.metaphorce.metaphorceweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metaphorce.metaphorceweb.response.ContractResponseRest;
import com.metaphorce.metaphorceweb.services.IContractService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("api/v1")
public class ContractController {

@Autowired
private IContractService service;

@GetMapping("/contract")
public ResponseEntity<ContractResponseRest> GetContract(){
	
	ResponseEntity<ContractResponseRest> response = service.ListContract();
	 return response;
	
}
	
}
