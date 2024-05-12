package ParkingLotCaseStudy;

import ParkingLotCaseStudy.Strategies.SimpleParkingSpotAllotmentStrategy;
import ParkingLotCaseStudy.controllers.TicketController;
import ParkingLotCaseStudy.dtos.IssueTicketRequest;
import ParkingLotCaseStudy.dtos.IssueTicketResponse;
import ParkingLotCaseStudy.models.*;
import ParkingLotCaseStudy.repositories.GateRepository;
import ParkingLotCaseStudy.repositories.ParkingLotRepository;
import ParkingLotCaseStudy.repositories.TicketRepository;
import ParkingLotCaseStudy.repositories.VehicleRepository;
import ParkingLotCaseStudy.services.TicketService;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {

        Floor floor1 = new Floor(1);
        for(int i=1;i<=10;i++)
        {
            floor1.getParkingSpot().add(new ParkingSpot(VehicleType.TOW_WHEELER, ParkingSpotStatus.FILLED, i, floor1));
        }
        Gate gate = new Gate(GateType.ENTRY, 1l, GateStatus.WORKING);
        ArrayList<Floor> floors=new ArrayList<>();
        floors.add(floor1);
        ArrayList<Gate> gates=new ArrayList<>();
        gates.add(gate);
        ParkingLot parkingLot = new ParkingLot(1L, floors, gates, ParkingLotStatus.ACTIVE);
        GateRepository gateRepository = new GateRepository();
        gateRepository.getGates().put(1l,gate);
        VehicleRepository vehicleRepository = new VehicleRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        parkingLotRepository.getParkingLotMap().put(1l,parkingLot);
        TicketRepository ticketRepository = new TicketRepository();
        TicketService ticketService =
                new TicketService(gateRepository,vehicleRepository,parkingLotRepository,ticketRepository);
        TicketController ticketController = new TicketController(ticketService);
        IssueTicketRequest issueTicketRequest =
                new IssueTicketRequest("YA.02", 1l,
                        1l, new SimpleParkingSpotAllotmentStrategy());
        IssueTicketResponse issueTicketResponse = ticketController.issueTicket(issueTicketRequest);
        System.out.println(issueTicketResponse);


    }
}
