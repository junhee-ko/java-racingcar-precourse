package print;

import car.Car;
import referee.Referee;

import java.util.List;

public class Printer {

  private final Referee referee;

  public Printer(Referee referee) {
    this.referee = referee;
  }

  public void printResultOf(List<Car> cars, int tryCount, int totalTryCount) {
    if (tryCount == 1) {
      printNewline();
      printWithNewline(GuideMessage.RESULT);
    }

    printMidResultsOf(cars);

    if (tryCount == totalTryCount) {
      printFinalResultOf(cars);
    }
  }

  public void printMidResultsOf(List<Car> cars) {
    for (Car car : cars) {
      printWithNewline(car.getName() + ": " + car.getDistanceForPrint());
    }
    printNewline();
  }

  private void printFinalResultOf(List<Car> cars) {
    List<Car> winners = referee.getWinnersOf(cars);

    printWithoutNewline(winners.get(0).getName());
    for (int winnerIndex = 1; winnerIndex < winners.size(); winnerIndex++) {
      printWithoutNewline(", " + winners.get(winnerIndex));
    }
    printWithNewline(GuideMessage.WINNER);
  }

  private void printWithNewline(String message) {
    printWithoutNewline(message);
    printNewline();
  }

  public void printWithNewline(GuideMessage guideMessage) {
    printWithoutNewline(guideMessage);
    printNewline();
  }

  private void printWithoutNewline(String message) {
    System.out.print(message);
  }

  private void printWithoutNewline(GuideMessage guideMessage) {
    System.out.print(guideMessage.getMessage());
  }

  private void printNewline() {
    System.out.println();
  }
}
