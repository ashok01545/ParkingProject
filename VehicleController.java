package com.cg.psa.controller;

import com.cg.psa.entity.ParkingFloor;
import com.cg.psa.entity.ParkingPremise;
import com.cg.psa.entity.ParkingSlots;
import com.cg.psa.entity.Payment;
import com.cg.psa.exception.NoSuchParkingSlotException;
import com.cg.psa.exception.NoSuchPaymentFoundException;
import com.cg.psa.exception.ParkingSlotNotAvailableException;
import com.cg.psa.exception.PaymentFailureException;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.psa.entity.Login;
import com.cg.psa.entity.ParkingFloor;
import com.cg.psa.entity.ParkingPremise;
import com.cg.psa.entity.User;
import com.cg.psa.entity.Vehicle;
import com.cg.psa.exception.DuplicateParkingFloorException;
import com.cg.psa.exception.DuplicateParkingPremiseException;
import com.cg.psa.exception.DuplicateUserException;
import com.cg.psa.exception.DuplicateVehicleException;
import com.cg.psa.exception.InvalidLoginCredintialException;
import com.cg.psa.exception.NoSuchParkingFloorException;
import com.cg.psa.exception.NoSuchParkingPremiseException;
import com.cg.psa.exception.NoSuchUserException;
import com.cg.psa.exception.NoSuchVehicleException;
import com.cg.psa.service.AdminService;
import com.cg.psa.service.ParkingService;
import com.cg.psa.service.PaymentService;
import com.cg.psa.service.UserService;
import com.cg.psa.service.VehicleService;

@RestController
@RequestMapping("/psa-vehicle")
public class VehicleController {
	
	@Autowired
	VehicleService vehicleService;
	
	@PostMapping("/addusersvehicle")
	public boolean addUsersVehicle(@RequestBody Vehicle vehicle) throws DuplicateVehicleException{
		return vehicleService.addUsersVehicle(vehicle);
	}
	
	@GetMapping("/findvehiclebyvehiclenumber/{vehicleNumber}/{userId}")
	public Vehicle findVehicleByVehicleNumber(@PathVariable String vehicleNumber,@PathVariable int userId) throws NoSuchVehicleException{
		return vehicleService.findVehicleByVehicleNumber(vehicleNumber, userId);
	}
	
	@GetMapping("/findallvehiclesbyuserid/{ownerId}")
	public List<Vehicle> findAllVehiclesByUserId(@PathVariable int ownerId) throws NoSuchVehicleException{
		return vehicleService.findAllVehiclesByUserId(ownerId);
	}
	
	@GetMapping("/findallvehiclesbyuserid/{ownerId}/{userId}")
	public boolean removeVehicleByVehicleNumber(@PathVariable String vehicleNumber,@PathVariable int userId) throws NoSuchVehicleException{
		return vehicleService.removeVehicleByVehicleNumber(vehicleNumber, userId);
	}
	
	@GetMapping("/modifyVehicle")
	public Vehicle modifyVehicle(@RequestBody Vehicle vehicle)throws NoSuchVehicleException{
		return vehicleService.modifyVehicle(vehicle);
	}

}
