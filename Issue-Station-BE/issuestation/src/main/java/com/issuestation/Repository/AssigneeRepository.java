package com.issuestation.Repository;

import com.issuestation.Entity.Assignee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssigneeRepository extends JpaRepository<Assignee, Integer> {
    Optional<Assignee> findDistinctFirstByIssueId(Long id);
void deleteAllByIssueId(Long id);
    List<Assignee> findByIssueProjectId(Long projectId);
}
