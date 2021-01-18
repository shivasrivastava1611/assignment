package com.example.concurrency.assignment.entitymodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ASSIGNMENT_MASTER")
@Data
public class AssignmentMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INCREMENT_SEQ")
	@SequenceGenerator(sequenceName = "increment_seq", allocationSize = 1, name = "INCREMENT_SEQ")
	Long seqId;

	Long value;

}
