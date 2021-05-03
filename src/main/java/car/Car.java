package car;

public class Car {

  private final String name;
  private final NumberGenerator randomNumberGenerator;
  private int distance;

  public Car(String carName, NumberGenerator numberGenerator) {
    this.name = carName;
    this.randomNumberGenerator = numberGenerator;
  }

  public void drive() {
    distance += randomNumberGenerator.getRandomNumber() >= 4 ? 1 : 0;
  }

  public String getName() {
    return name;
  }

  public int getDistance() {
    return distance;
  }

  public String getDistanceForPrint() {
    StringBuilder distance = new StringBuilder();
    for (int i = 0; i < this.getDistance(); i++) {
      distance.append("-");
    }

    return distance.toString();
  }
}
