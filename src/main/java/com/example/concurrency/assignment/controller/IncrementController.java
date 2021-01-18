package com.example.concurrency.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.concurrency.assignment.requestmodel.IncrementRequest;
import com.example.concurrency.assignment.responsemodel.IncrementResponseModel;
import com.example.concurrency.assignment.service.IncrementService;

@RestController
@RequestMapping("/")
public class IncrementController {

	@Autowired
	private IncrementService incrementService;

	@PostMapping(value = "incrementNumber", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<IncrementResponseModel> incrementNumber(@RequestBody IncrementRequest incRequest) {
		incrementService.incrementNumber(incRequest.getId());
		return new ResponseEntity<IncrementResponseModel>(
				IncrementResponseModel.builder().message("SUCCESS").status(HttpStatus.OK).build(), HttpStatus.OK);

	}

}
