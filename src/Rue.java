public class Rue {
  private long idOrigin;
  private long idDestination;
  private double distance;
  private String name;

  public Rue(long idOrigin, long idDestination, double distance, String name) {
    this.idOrigin = idOrigin;
    this.idDestination = idDestination;
    this.distance = distance;
    this.name = name;
  }

  public long getIdOrigin() {
    return idOrigin;
  }

  public void setIdOrigin(long idOrigin) {
    this.idOrigin = idOrigin;
  }

  public long getIdDestination() {
    return idDestination;
  }

  public void setIdDestination(long idDestination) {
    this.idDestination = idDestination;
  }

  public double getDistance() {
    return distance;
  }

  public void setDistance(long distance) {
    this.distance = distance;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
