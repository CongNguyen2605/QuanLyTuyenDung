package org.example.quanlytuyendung.repository;

import org.example.quanlytuyendung.entity.GroupReasonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupReasonRepository extends JpaRepository<GroupReasonEntity,Integer>, JpaSpecificationExecutor<GroupReasonEntity> {
    Boolean existsByName(String name);
}
