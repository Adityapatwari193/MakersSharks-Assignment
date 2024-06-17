package com.Makersshift.assignment.MakersShift.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Makersshift.assignment.MakersShift.database.Datab;

public interface DatabRepository extends JpaRepository<Datab, Long> {
    @Query("SELECT d FROM Datab d WHERE TRIM(UPPER(d.username)) = TRIM(UPPER(:username))")
    Datab findByUsername(@Param("username") String username);
}
