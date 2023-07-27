package com.example.danceSchoolBackend.repository;

import com.example.danceSchoolBackend.model.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contacts,Long> {


}
