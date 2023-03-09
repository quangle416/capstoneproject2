package org.perscholas.capstoneproject2.dao;

import jakarta.transaction.Transactional;
import org.perscholas.capstoneproject2.model.BlogPost;
import org.perscholas.capstoneproject2.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional(rollbackOn = Exception.class)
public interface ImageRepoI extends JpaRepository<Image, Integer> {

}
