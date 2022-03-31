
package com.cg.psa.service;

import java.util.List;

import com.cg.psa.entity.Vehicle;
import com.cg.psa.exception.DuplicateVehicleException;
import com.cg.psa.exception.NoSuchVehicleException;


public interface VehicleService {
	public boolean addUsersVehicle(Vehicle vehicle) throws DuplicateVehicleException;
	public Vehicle findVehicleByVehicleNumber(String vehicleNumber, int userId) throws NoSuchVehicleException;
	public List<Vehicle> findAllVehiclesByUserId(int ownerId) throws NoSuchVehicleException;
	public boolean removeVehicleByVehicleNumber(String vehicleNumber, int userId) throws NoSuchVehicleException;
	public Vehicle modifyVehicle(Vehicle vehicle)throws NoSuchVehicleException;
}
