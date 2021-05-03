package referee;

import car.NumberGenerator;

import java.util.Random;

public class MockNumberMoreThanFourGenerator implements NumberGenerator {

  private final Random random;

  public MockNumberMoreThanFourGenerator(Random random) {
    this.random = random;
  }

  @Override
  public int getRandomNumber() {
    return random.nextInt(6) + 4;
  }
}
