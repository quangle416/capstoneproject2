package org.perscholas.quanglecapstoneproject.dao;
import org.perscholas.quanglecapstoneproject.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ImageRepoI extends JpaRepository<Image, Integer> {

}
