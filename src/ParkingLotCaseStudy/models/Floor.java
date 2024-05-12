package ParkingLotCaseStudy.models;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private List<ParkingSpot> parkingSpot;
    private int FloorNumber;

    public Floor(int floorNumber) {
        FloorNumber = floorNumber;
        this.parkingSpot=new ArrayList<>();
    }

    public List<ParkingSpot> getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(List<ParkingSpot> parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public int getFloorNumber() {
        return FloorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        FloorNumber = floorNumber;
    }
}
