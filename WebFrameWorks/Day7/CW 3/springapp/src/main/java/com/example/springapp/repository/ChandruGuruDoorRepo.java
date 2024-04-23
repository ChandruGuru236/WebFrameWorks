package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.springapp.model.ChandruGuruDoor;
import java.util.List;

@Repository
public interface ChandruGuruDoorRepo extends JpaRepository<ChandruGuruDoor,Integer>{

    List<ChandruGuruDoor> findByDoorId(int doorId);
    List<ChandruGuruDoor> findByAccessType(String accessType);
    
}
