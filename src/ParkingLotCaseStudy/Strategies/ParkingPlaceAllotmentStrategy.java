package ParkingLotCaseStudy.Strategies;

import ParkingLotCaseStudy.exceptions.ParkingLotFullException;
import ParkingLotCaseStudy.models.ParkingLot;
import ParkingLotCaseStudy.models.ParkingSpot;
import ParkingLotCaseStudy.models.VehicleType;

public interface ParkingPlaceAllotmentStrategy {
    ParkingSpot getParkingSpot(VehicleType vehicleType,ParkingLot parkingLot) throws ParkingLotFullException;
}
