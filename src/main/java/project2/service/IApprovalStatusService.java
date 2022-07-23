package project2.service;

import project2.model.ApprovalStatus;

import java.util.List;

public interface IApprovalStatusService {
    List<ApprovalStatus> findAllBy();

    ApprovalStatus getApprovalStatusById(Long id);
}
