package referee;

import car.NumberGenerator;

import java.util.Random;

public class MockNumberLessThanFourGenerator implements NumberGenerator {

  private final Random random;

  public MockNumberLessThanFourGenerator(Random random) {
    this.random = random;
  }

  @Override
  public int getRandomNumber() {
    return random.nextInt(4);
  }
}
