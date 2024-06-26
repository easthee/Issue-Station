package com.issuestation.Service.IssueService;

import com.issuestation.Entity.Issue;
import com.issuestation.Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class IssueDeleteServicelmpl implements IssueDeleteService {

    private final IssueRepository issueRepository;
    private final AssigneeRepository assigneeRepository;
    private final ReporterRepository reporterRepository;
    private final CommentRepository commentRepository;
    private final FixerRepository fixerRepository;

    @Override
    @Transactional
    public void deleteIssue(long issueId) {
        Issue issue = issueRepository.findById(issueId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid issue ID"));
        assigneeRepository.deleteAllByIssueId(issueId);
        reporterRepository.deleteAllByIssueId(issueId);
        fixerRepository.deleteAllByIssueId(issueId);
        commentRepository.deleteAllByIssueId(issueId);
        issueRepository.delete(issue);
    }
}
