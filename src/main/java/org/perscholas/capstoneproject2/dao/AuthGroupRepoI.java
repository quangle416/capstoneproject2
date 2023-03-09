package org.perscholas.capstoneproject2.dao;

import jakarta.transaction.Transactional;
import org.perscholas.capstoneproject2.model.AuthGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional(rollbackOn = Exception.class)
public interface AuthGroupRepoI extends JpaRepository<AuthGroup,Integer> {
}
