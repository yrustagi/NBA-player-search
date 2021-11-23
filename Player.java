public class Player implements Comparable<Player> {

  String playerName;
  String teamName;
  Double RPG;
  Double PPG;
  Double APG;
  String ID;

  public Player(String ID, String playerName, String teamName, Double PPG, Double RPG, Double APG) {
    super();
    this.playerName = playerName;
    this.teamName = teamName;
    this.RPG = RPG;
    this.PPG = PPG;
    this.APG = APG;
    this.ID = ID;
  }

  public String getPlayerName() {
    // TODO Auto-generated method stub
    return this.playerName;
  }

  public String getTeam() {
    // TODO Auto-generated method stub
    return this.teamName;
  }

  public Double getAPG() {
    // TODO Auto-generated method stub
    return this.APG;
  }

  public Double getRPG() {
    // TODO Auto-generated method stub
    return this.RPG;
  }

  public Double getPPG() {
    // TODO Auto-generated method stub
    return this.PPG;
  }

  public String getID() {
    // TODO Auto-generated method stub
    return this.ID;
  }

  @Override
  public String toString() {
    String toReturn = "ID " + this.ID + " Player Name " + this.playerName + "\n" + " Team " + this.teamName + "\n"
        + " Points per game " + this.PPG + " Rebounds per game " + this.RPG + "\n" + " Assists per game " + this.APG;

    return toReturn;

  }

  @Override
  public int compareTo(Player otherPlayer) {
    // TODO Auto-generated method stub
    int compareTo = this.playerName.compareTo(otherPlayer.getPlayerName());
    if (compareTo < 0) {
      return -1;
    }
    if (compareTo == 0) {
      return 0;

    } else
      return 1;
  }

}
