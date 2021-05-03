package manager;

import car.Car;
import car.CarFactory;
import input.InputManager;
import print.GuideMessage;
import print.Printer;

import java.util.List;

public class GamaManager {

  private final InputManager inputManager;
  private final CarFactory carFactory;
  private final Printer printer;

  public GamaManager(InputManager inputManager, CarFactory carFactory, Printer printer) {
    this.inputManager = inputManager;
    this.carFactory = carFactory;
    this.printer = printer;
  }

  public void start() {
    String inputCarNames = getInputCarNames();
    int inputTotalTryCount = getInputTotalTryCount();
    List<Car> cars = carFactory.getCarsFrom(inputCarNames);

    for (int tryCount = 1; tryCount <= inputTotalTryCount; tryCount++) {
      drive(cars);
      printer.printResultOf(cars, tryCount, inputTotalTryCount);
    }
  }

  private String getInputCarNames() {
    printer.printWithNewline(GuideMessage.INPUT_CAR_NAME);

    return inputManager.getInputCarNames();
  }

  private int getInputTotalTryCount() {
    printer.printWithNewline(GuideMessage.INPUT_TRY_COUNT);

    return inputManager.getInputTryCount();
  }

  private void drive(List<Car> cars) {
    for (Car car : cars) {
      car.drive();
    }
  }
}
