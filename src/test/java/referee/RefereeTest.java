package referee;

import car.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RefereeTest {

  @Test
  @DisplayName("우승자가 한 명")
  void givenCarsDrivedDifferentDistance_whenGetWinner_thenWinnerIsOneCar() {
    // Given
    List<Car> cars = Arrays.asList(
        new Car("jko", new MockNumberLessThanFourGenerator(new Random())),
        new Car("kojun", new MockNumberLessThanFourGenerator(new Random())),
        new Car("hee", new MockNumberMoreThanFourGenerator(new Random()))
    );

    for (Car car : cars) {
      car.drive();
    }

    // When
    Referee referee = new Referee();
    List<Car> winner = referee.getWinnersOf(cars);

    // Then
    assertEquals(1, winner.size());
  }

  @Test
  @DisplayName("우승자가 두 명 이상")
  void givenCarsDrivedDifferentDistance_whenGetWinner_thenWinnerIsThreeCars() {
    // Given
    List<Car> cars = Arrays.asList(
        new Car("jko", new MockNumberLessThanFourGenerator(new Random())),
        new Car("kojun", new MockNumberLessThanFourGenerator(new Random())),
        new Car("hee", new MockNumberMoreThanFourGenerator(new Random())),
        new Car("ko", new MockNumberMoreThanFourGenerator(new Random()))
    );

    for (Car car : cars) {
      car.drive();
    }

    // When
    Referee referee = new Referee();
    List<Car> winners = referee.getWinnersOf(cars);

    // Then
    assertEquals(2, winners.size());
  }
}