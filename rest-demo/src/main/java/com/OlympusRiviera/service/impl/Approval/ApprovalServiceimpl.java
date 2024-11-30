package com.OlympusRiviera.service.impl.Approval;


import com.OlympusRiviera.model.Approval.Approval;
import com.OlympusRiviera.repository.Approval.ApprovalRepository;
import com.OlympusRiviera.service.Approval.ApprovalService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovalServiceimpl implements ApprovalService {

    ApprovalRepository approvalRepository;



    public Approval getApproval(String approval_id) {

        return approvalRepository.findById(approval_id).get();
    }


    public List<Approval> getAllApprovals() {
        return approvalRepository.findAll();
    }

}
