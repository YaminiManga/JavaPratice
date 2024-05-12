package ParkingLotCaseStudy.Strategies;

import ParkingLotCaseStudy.exceptions.ParkingLotFullException;
import ParkingLotCaseStudy.models.*;

public class SimpleParkingSpotAllotmentStrategy implements ParkingPlaceAllotmentStrategy{
    @Override
    public ParkingSpot getParkingSpot(VehicleType vehicleType, ParkingLot parkingLot) throws ParkingLotFullException {
        /*1.Find the ParkingLot
          2.Get all the floors of ParkingLot
          3.For each floor get the s;ots with vehicle type and status being free then return it
        */
        for(Floor floor:parkingLot.getFloors())
        {
            for(ParkingSpot parkingSpot: floor.getParkingSpot())
            {
                if(parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE))
                {
                    if(parkingSpot.getVehicleType().equals(vehicleType))
                    {
                        return parkingSpot;
                    }
                }
            }
        }
        //Throw an exception saying parking LOT is full
      throw new ParkingLotFullException();
    }
}
