package ParkingLotCaseStudy.repositories;
import ParkingLotCaseStudy.exceptions.GateNotFoundException;
import ParkingLotCaseStudy.models.Gate;

import java.util.HashMap;
import java.util.Map;

public class GateRepository {
    //it should be able to do all CRUD operations on gate
    private Map<Long, Gate> gates=new HashMap<>();

    public Map<Long, Gate> getGates() {
        return gates;
    }

    public void setGates(Map<Long, Gate> gates) {
        this.gates = gates;
    }

    public Gate findGateById(Long id) throws GateNotFoundException {
        if (gates.containsKey(id))
        {
            return gates.get(id);
        }
        throw new GateNotFoundException();
    }
}
