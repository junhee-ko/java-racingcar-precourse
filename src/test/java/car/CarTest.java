package car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import referee.MockNumberLessThanFourGenerator;
import referee.MockNumberMoreThanFourGenerator;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

  @Test
  @DisplayName("항상 직진하는 자동차가 움직인 거리는 시도 회수와 동일")
  void givenCarsAlwaysGo_whenDriveInTryCount_thenCarDistanceIsTryCount() {
    // Given
    CarFactory carFactory = new CarFactory(new MockNumberMoreThanFourGenerator(new Random()));
    List<Car> cars = carFactory.getCarsFrom("jko,kojun,hee");
    int tryCount = 5;

    // When
    for (int i = 0; i < tryCount; i++) {
      for (Car car : cars) {
        car.drive();
      }
    }

    // Then
    for (int i = 0; i < 3; i++) {
      assertEquals(tryCount, cars.get(i).getDistance());
    }
  }

  @Test
  @DisplayName("항상 머춰있는 자동차가 움직인 거리는 0")
  void givenCarsAlwaysStop_whenDriveInTryCount_thenCarDistanceIsZero() {
    // Given
    CarFactory carFactory = new CarFactory(new MockNumberLessThanFourGenerator(new Random()));
    List<Car> cars = carFactory.getCarsFrom("jko,kojun,hee");
    int tryCount = 5;

    // When
    for (int i = 0; i < tryCount; i++) {
      for (Car car : cars) {
        car.drive();
      }
    }

    // Then
    for (int i = 0; i < 3; i++) {
      assertEquals(0, cars.get(i).getDistance());
    }
  }
}