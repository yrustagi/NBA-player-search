public interface PlayerInterface {

  public String getID(); 
  
  public String getPlayerName();

  public String getTeam();

  public Double getAPG();

  public Double getRPG();

  public Double getPPG();

  int compareTo(PlayerInterface otherPlayer);
}
