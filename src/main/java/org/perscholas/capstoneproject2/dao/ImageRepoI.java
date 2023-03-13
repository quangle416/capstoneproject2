package org.perscholas.capstoneproject2.dao;
import org.perscholas.capstoneproject2.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ImageRepoI extends JpaRepository<Image, Integer> {

}
