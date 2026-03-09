public class Rue {
  private long idOrigin;
  private long idDestination;
  private long distance;
  private String name;

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

  public long getDistance() {
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
