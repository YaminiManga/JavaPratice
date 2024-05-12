package ParkingLotCaseStudy.controllers;

import ParkingLotCaseStudy.dtos.IssueTicketRequest;
import ParkingLotCaseStudy.dtos.IssueTicketResponse;
import ParkingLotCaseStudy.exceptions.GateNotFoundException;
import ParkingLotCaseStudy.exceptions.ParkingLotFullException;
import ParkingLotCaseStudy.exceptions.ParkingLotNotFoundException;
import ParkingLotCaseStudy.models.Ticket;
import ParkingLotCaseStudy.services.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public IssueTicketResponse issueTicket(IssueTicketRequest request)
    {
        Ticket ticket= null;
        try {
            try {
                try {
                    ticket = ticketService.issueTicket(request);
                } catch (ParkingLotFullException e) {
                    System.out.println("parkingLot IS FULL");
                    return new IssueTicketResponse(null,"FAILURE","ParkingLot is Full");
                }
            } catch (ParkingLotNotFoundException e) {
                System.out.println("parkingLot Not Found");
                return new IssueTicketResponse(null,"FAILURE","Invalid ParkingLot");

            }
        } catch (GateNotFoundException e) {
            System.out.println("Gate Not Found");
            return new IssueTicketResponse(null,"FAILURE","Invalid Gate");
        }
        return new IssueTicketResponse(ticket,"SUCCESS","TICKET GENERATED");


    }
}
