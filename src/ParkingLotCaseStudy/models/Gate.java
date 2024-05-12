package ParkingLotCaseStudy.models;

public class Gate {
    private GateType gateType;
    private Long number;
    private Operator operator;
    private GateStatus gateStatus;

    public Gate(GateType gateType, Long number, GateStatus gateStatus) {
        this.gateType = gateType;
        this.number = number;
        this.gateStatus = gateStatus;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }
}
