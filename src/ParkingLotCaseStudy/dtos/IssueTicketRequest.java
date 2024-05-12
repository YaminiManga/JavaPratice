package ParkingLotCaseStudy.dtos;

import ParkingLotCaseStudy.Strategies.ParkingPlaceAllotmentStrategy;
import ParkingLotCaseStudy.models.VehicleType;

public class IssueTicketRequest {
    private VehicleType vehicleType;
    private  String vehicleNumber;
    private String owner;
    private Long  gateId;
    private Long parkingLotid;
    private ParkingPlaceAllotmentStrategy parkingPlaceAllotmentStrategy;

    public IssueTicketRequest(String vehicleNumber, Long gateId, Long parkingLotid, ParkingPlaceAllotmentStrategy parkingPlaceAllotmentStrategy) {
        this.vehicleNumber = vehicleNumber;
        this.gateId = gateId;
        this.parkingLotid = parkingLotid;
        this.parkingPlaceAllotmentStrategy = parkingPlaceAllotmentStrategy;
    }

    public IssueTicketRequest(VehicleType vehicleType, String vehicleNumber, String owner, Long gateId, Long parkingLotid, ParkingPlaceAllotmentStrategy parkingPlaceAllotmentStrategy) {
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
        this.owner = owner;
        this.gateId = gateId;
        this.parkingLotid = parkingLotid;
        this.parkingPlaceAllotmentStrategy = parkingPlaceAllotmentStrategy;
    }

    public ParkingPlaceAllotmentStrategy getParkingPlaceAllotmentStrategy() {
        return parkingPlaceAllotmentStrategy;
    }

    public void setParkingPlaceAllotmentStrategy(ParkingPlaceAllotmentStrategy parkingPlaceAllotmentStrategy) {
        this.parkingPlaceAllotmentStrategy = parkingPlaceAllotmentStrategy;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Long getGateId() {
        return gateId;
    }

    public void setGateId(Long gateId) {
        this.gateId = gateId;
    }

    public Long getParkingLotid() {
        return parkingLotid;
    }

    public void setParkingLotid(Long parkingLotid) {
        this.parkingLotid = parkingLotid;
    }
}
