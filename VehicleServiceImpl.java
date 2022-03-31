package com.cg.psa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.psa.dao.VehicleDao;
import com.cg.psa.entity.ParkingFloor;
import com.cg.psa.entity.Vehicle;
import com.cg.psa.exception.DuplicateVehicleException;
import com.cg.psa.exception.NoSuchParkingFloorException;
import com.cg.psa.exception.NoSuchVehicleException;

@Service("VehicleService")
public class VehicleServiceImpl implements VehicleService {
	
	@Autowired
	VehicleDao vehicleDao;

	@Override
	public boolean addUsersVehicle(Vehicle vehicle) throws DuplicateVehicleException {
		vehicleDao.saveAndFlush(vehicle);
		return true;
	}

	@Override
	public Vehicle findVehicleByVehicleNumber(String vehicleNumber, int userId) throws NoSuchVehicleException {
		Vehicle bean = null;
		try {
			for(Vehicle i :vehicleDao.findAll()) {
				if(i.getVehicleNumber().equals(vehicleNumber) && i.getOwner().getUserId()==userId) {
					bean = i;
					break;
				}
			}
		}
		catch(Exception e) {
			throw new NoSuchVehicleException("Vehicle details not Found");
		}
		return bean;
	}

	@Override
	public List<Vehicle> findAllVehiclesByUserId(int ownerId) throws NoSuchVehicleException{
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		try {
			for(Vehicle i :vehicleDao.findAll()) {
				if(i.getOwner().getUserId()==ownerId) {
					vehicles.add(i);
				}
			}
		}
		catch(Exception e) {
			throw new NoSuchVehicleException("Vehicle details not Found");
		}
		return vehicles;
	}

	@Override
	public boolean removeVehicleByVehicleNumber(String vehicleNumber, int userId) throws NoSuchVehicleException {
		Vehicle bean = null;
		try {
			for(Vehicle i :vehicleDao.findAll()) {
				if(i.getVehicleNumber().equals(vehicleNumber) && i.getOwner().getUserId()==userId) {
					bean = i;
					vehicleDao.deleteById(i.getVehicleId());
					return true;
				}
			}
		}
		catch(Exception e) {
			throw new NoSuchVehicleException("Vehicle details not Found");
		}
		return true;
	}

	@Override
	public Vehicle modifyVehicle(Vehicle vehicle) throws NoSuchVehicleException {
		Vehicle bean = null;
		try {
			bean = vehicleDao.findById(vehicle.getVehicleId()).get();
		}
		catch(Exception e) {
			throw new NoSuchVehicleException("Vehicle details not found!");
		}
		vehicleDao.saveAndFlush(vehicle);
		return vehicle;
	}

}
