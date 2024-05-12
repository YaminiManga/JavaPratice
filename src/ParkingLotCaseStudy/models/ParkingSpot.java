package ParkingLotCaseStudy.models;

public class ParkingSpot {
    private  VehicleType vehicleType;
    private ParkingSpotStatus parkingSpotStatus;
    private int Number;
    private Floor floor;

    public ParkingSpot(VehicleType vehicleType, ParkingSpotStatus parkingSpotStatus, int number, Floor floor) {
        this.vehicleType = vehicleType;
        this.parkingSpotStatus = parkingSpotStatus;
        Number = number;
        this.floor = floor;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }
}
