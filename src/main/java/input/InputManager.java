package input;

import java.util.Scanner;

public class InputManager {

  private final InputValidator inputValidator;
  private final Scanner scanner;

  public InputManager(Scanner scanner, InputValidator inputValidator) {
    this.scanner = scanner;
    this.inputValidator = inputValidator;
  }

  public String getInputCarNames() {
    String carNames = scanner.nextLine();

    inputValidator.validate(carNames);

    return carNames;
  }

  public int getInputTryCount() {
    int tryCount = scanner.nextInt();

    inputValidator.validate(tryCount);

    return tryCount;
  }
}
