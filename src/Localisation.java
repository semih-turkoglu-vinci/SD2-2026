public class Localisation {
  private long id;
  private String nom;
  private double latitude;
  private double longitude;
  private double altitude;


  public Localisation(long id, String nom, double latitude, double longitude, double altitude) {
    this.id = id;
    this.nom = nom;
    this.latitude = latitude;
    this.longitude = longitude;
    this.altitude = altitude;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(long latitude) {
    this.latitude = latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(long longitude) {
    this.longitude = longitude;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public double getAltitude() {
    return altitude;
  }

  public void setAltitude(int altitude) {
    this.altitude = altitude;
  }
}
