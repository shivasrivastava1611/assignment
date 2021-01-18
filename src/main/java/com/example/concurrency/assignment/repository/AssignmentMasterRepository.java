package com.example.concurrency.assignment.repository;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.concurrency.assignment.entitymodel.AssignmentMaster;

@Repository
public interface AssignmentMasterRepository extends CrudRepository<AssignmentMaster, Long> {

	@Modifying
	@Query("Update AssignmentMaster set value=:value where seqId=:seqId")
	int incrementNumber(@Param("value") Long value, @Param("seqId") Long seqId);

	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@QueryHints({ @QueryHint(name = "javax.persistence.lock.timeout", value = "3000") })
	AssignmentMaster findBySeqId(Long seqId);

}
