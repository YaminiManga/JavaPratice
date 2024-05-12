package TicTacToe.Models;

public abstract class Player {
    private Character symbol;
    private  String name;
    private int id;
    private PlayerType playerType;
    public abstract Cell makeMove(Board board);

    public Player(Character symbol, String name, int id, PlayerType playerType) {
        this.symbol = symbol;
        this.name = name;
        this.id = id;
        this.playerType = playerType;
    }

    public Character getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setSymbol(Character symbol) {
        this.symbol = symbol;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }




}
