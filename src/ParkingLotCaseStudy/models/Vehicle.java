package ParkingLotCaseStudy.models;

public class Vehicle {
    private VehicleType vehicleType;
    private String number;
    private String nameOfOwner;

    public Vehicle(VehicleType vehicleType, String number, String nameOfOwner) {
        this.vehicleType = vehicleType;
        this.number = number;
        this.nameOfOwner = nameOfOwner;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNameOfOwner() {
        return nameOfOwner;
    }

    public void setNameOfOwner(String nameOfOwner) {
        this.nameOfOwner = nameOfOwner;
    }


}
