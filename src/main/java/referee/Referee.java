package referee;

import car.Car;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Referee {

  public ArrayList<Car> getWinnersOf(List<Car> cars) {
    sortCarsByDescendingOfDistance(cars);

    ArrayList<Car> winners = new ArrayList<>();
    Car firstWinner = cars.get(0);
    winners.add(firstWinner);
    addOtherWinners(cars, winners, firstWinner);

    return winners;
  }

  private void addOtherWinners(List<Car> cars, ArrayList<Car> winners, Car firstWinner) {
    for (int carIndex = 1; carIndex < cars.size(); carIndex++) {
      Car car = cars.get(carIndex);
      if (car.getDistance() != firstWinner.getDistance()) {
        break;
      }

      winners.add(car);
    }
  }

  private void sortCarsByDescendingOfDistance(List<Car> cars) {
    cars.sort(Comparator.comparing(Car::getDistance).reversed());
  }
}
