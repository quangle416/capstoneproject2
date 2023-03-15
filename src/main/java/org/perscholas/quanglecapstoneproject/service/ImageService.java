package org.perscholas.quanglecapstoneproject.service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.perscholas.quanglecapstoneproject.dao.ImageRepoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
public class ImageService {
    ImageRepoI imageRepoI;
    @Autowired
    public ImageService(ImageRepoI imageRepoI) {
        this.imageRepoI = imageRepoI;
    }
}