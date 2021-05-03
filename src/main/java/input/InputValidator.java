package input;

public class InputValidator {

  private static final String INPUT_CAR_NAMES_DELIMITER = ",";

  private static final String CAR_NAME_EXCEPTION_MESSAGE = "car name size should be less than or equal to 5";
  private static final String TRY_COUNT_EXCEPTION_MESSAGE = "try count should be greater than or equal to 1";

  public void validate(String inputCarNames) {
    for (String carName : inputCarNames.split(INPUT_CAR_NAMES_DELIMITER)) {
      if (carName.length() > 5) {
        throw new RuntimeException(CAR_NAME_EXCEPTION_MESSAGE);
      }
    }
  }

  public void validate(int tryCount) {
    if (tryCount < 1) {
      throw new RuntimeException(TRY_COUNT_EXCEPTION_MESSAGE);
    }
  }
}
