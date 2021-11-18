package com.chunkiechunks.service;

import com.chunkiechunks.domain.Family;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class FamilyService {

    public List<Family> getAllFamilies() {
        return Family.findAll().list();
    }
}
