package car;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

  private final NumberGenerator numberGenerator;

  public CarFactory(NumberGenerator numberGenerator) {
    this.numberGenerator = numberGenerator;
  }

  private static final String INPUT_CAR_NAMES_DELIMITER = ",";

  public List<Car> getCarsFrom(String inputCarNames) {
    List<Car> cars = new ArrayList<>();
    for (String carName : inputCarNames.split(INPUT_CAR_NAMES_DELIMITER)) {
      Car car = new Car(carName, numberGenerator);
      cars.add(car);
    }

    return cars;
  }
}
