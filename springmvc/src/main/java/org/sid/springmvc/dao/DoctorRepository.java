package org.sid.springmvc.dao;

import org.sid.springmvc.entities.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository  extends JpaRepository<Doctor,Long>{
	public Page<Doctor> findByNameContains(String mc,Pageable pageable);

}
