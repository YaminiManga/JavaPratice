package ParkingLotCaseStudy.repositories;

import ParkingLotCaseStudy.models.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class VehicleRepository {
    private Map<String, Vehicle> vehicles=new HashMap<>();

    public Map<String, Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Map<String, Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Vehicle findVehicleByNumber(String vehicleNumber)
    {
        if (vehicles.containsKey(vehicleNumber))
        {
            return vehicles.get(vehicleNumber);


        }
        //Here we should not create vehicle if the vehicle does not exist, We will create vehicle if it is not present
        //but not in this method,this method should only do what it is supposed to do.
        return null;
    }

    public void save(Vehicle vehicle) {
        vehicles.put(vehicle.getNumber(),vehicle);
    }
}
