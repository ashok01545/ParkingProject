package com.cg.psa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.psa.entity.User;
import com.cg.psa.entity.Vehicle;
@Repository
public interface VehicleDao extends JpaRepository<Vehicle, Integer>{


}
