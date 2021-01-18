package com.example.concurrency.assignment.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.concurrency.assignment.entitymodel.AssignmentMaster;
import com.example.concurrency.assignment.repository.AssignmentMasterRepository;
import com.example.concurrency.assignment.service.IncrementService;

@Service
public class IncrementServiceImpl implements IncrementService {

	@Autowired
	private AssignmentMasterRepository assignmentMasterRepository;

	@Override
	@Transactional
	public void incrementNumber(Long seqId) {

		AssignmentMaster assignmentMaster = null;
		assignmentMaster = assignmentMasterRepository.findBySeqId(seqId);
		assignmentMasterRepository.incrementNumber(assignmentMaster.getValue() + 1, seqId);

	}

}
