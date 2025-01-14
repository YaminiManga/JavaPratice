package ParkingLotCaseStudy.repositories;

import ParkingLotCaseStudy.exceptions.ParkingLotNotFoundException;
import ParkingLotCaseStudy.models.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {
    private Map<Long, ParkingLot> parkingLotMap=new HashMap<>();

    public Map<Long, ParkingLot> getParkingLotMap() {
        return parkingLotMap;
    }

    public void setParkingLotMap(Map<Long, ParkingLot> parkingLotMap) {
        this.parkingLotMap = parkingLotMap;
    }

    public ParkingLot getparkingLotById(Long id) throws ParkingLotNotFoundException {
        if(parkingLotMap.containsKey(id))
        {
            return parkingLotMap.get(id);
        }
        throw new ParkingLotNotFoundException();
    }
}
