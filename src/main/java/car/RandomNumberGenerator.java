package car;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

  private final Random random;

  public RandomNumberGenerator(Random random) {
    this.random = random;
  }

  public int getRandomNumber() {
    return random.nextInt(10);
  }
}
