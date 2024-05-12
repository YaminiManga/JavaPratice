package ParkingLotCaseStudy.services;

import ParkingLotCaseStudy.Strategies.ParkingPlaceAllotmentStrategy;
import ParkingLotCaseStudy.dtos.IssueTicketRequest;
import ParkingLotCaseStudy.dtos.IssueTicketResponse;
import ParkingLotCaseStudy.exceptions.GateNotFoundException;
import ParkingLotCaseStudy.exceptions.ParkingLotFullException;
import ParkingLotCaseStudy.exceptions.ParkingLotNotFoundException;
import ParkingLotCaseStudy.models.*;
import ParkingLotCaseStudy.repositories.GateRepository;
import ParkingLotCaseStudy.repositories.ParkingLotRepository;
import ParkingLotCaseStudy.repositories.TicketRepository;
import ParkingLotCaseStudy.repositories.VehicleRepository;

import java.util.Date;
import java.util.UUID;

public class TicketService {
   private GateRepository gateRepository;
   private VehicleRepository vehicleRepository;
   private ParkingLotRepository parkingLotRepository;
   private TicketRepository ticketRepository;

    public TicketService(GateRepository gateRepository, VehicleRepository vehicleRepository, ParkingLotRepository parkingLotRepository, TicketRepository ticketRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }

    public Ticket issueTicket(IssueTicketRequest request) throws GateNotFoundException,
            ParkingLotNotFoundException, ParkingLotFullException {
        /*
        1. Set Time
        2.Get Vehicle and Gate Details
        3.Get Parking Lot
            Assign empty spot for this vehicle
        4.Generate Ticket
        5.Save and return Ticket*/
        Ticket ticket=new Ticket();
        ticket.setEntryTime(new Date());
        Gate gate=gateRepository.findGateById(request.getGateId());
        ticket.setGate(gate);
        Vehicle vehicle=vehicleRepository.findVehicleByNumber(request.getVehicleNumber());
        if(vehicle==null)
        {
            //we are not throwing exception in findVehicleByNumber() method because when we are getting vehicle by
            //vehicle number this is an expected behaviour we are expecting a new vehicle can also be given so this
            //is not really an exception, Whereas for gates , gates are created at the starting of the parkingLot
            //So if the gate is not present we should throw the exception.
            vehicle=new Vehicle(request.getVehicleType(), request.getVehicleNumber(), request.getOwner());
            vehicleRepository.save(vehicle);
        }
        ticket.setVehicle(vehicle);
        ParkingLot parkingLot= parkingLotRepository.getparkingLotById(request.getParkingLotid());
        /*Assign empty spot for this vehicle- For this we will be not writing coder here because that is parking
         allotment strategy and we will write code in strategies package*/
        ParkingPlaceAllotmentStrategy allotmentStrategy= request.getParkingPlaceAllotmentStrategy();
        ParkingSpot parkingSpot=
                allotmentStrategy.getParkingSpot(request.getVehicleType(), parkingLot);
        ticket.setParkingSpot(parkingSpot);
        ticket.setNumber(request.getVehicleNumber()+ UUID.randomUUID());
        ticketRepository.save(ticket);
        return ticket;
    }
}

