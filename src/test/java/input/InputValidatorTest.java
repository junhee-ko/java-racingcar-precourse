package input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputValidatorTest {

  @ParameterizedTest
  @ValueSource(strings = {"jko,ko,kojun", "miki,mouse,pobi", "ak21,jko12,junhe"})
  @DisplayName("자동차 이름이 다섯자 이하이면 정상")
  void givenCarNamesLessThanOrEqualsToFive_whenValidate_thenSuccess(String carNames) {
    // Given

    // When
    InputValidator inputValidator = new InputValidator();

    // Then
    inputValidator.validate(carNames);
  }

  @ParameterizedTest
  @ValueSource(strings = {"jko,junhee,kojun", "junheeko,ko,kojunhee", "pobi,jko123,junhee3"})
  @DisplayName("자동차 이름이 여섯자 이상이면 예외")
  void givenCarNamesMoreThanOrEqualsToSix_whenValidate_thenThrowException(String carNames) {
    // Given

    // When
    InputValidator inputValidator = new InputValidator();

    // Then
    assertThrows(RuntimeException.class, () -> inputValidator.validate(carNames));
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 3, 5, 10, 15})
  @DisplayName("시도할 횟수는 1 이상의 양의 졍수")
  void givenTryCountMoreThanOrEqualToOne_whenValidate_thenSuccess(int tryCount) {
    // Given

    // When
    InputValidator inputValidator = new InputValidator();

    // Then
    inputValidator.validate(tryCount);
  }

  @ParameterizedTest
  @ValueSource(ints = {0, -1, -3, -10, -15})
  @DisplayName("시도할 횟수가 1보다 작으면 예외")
  void givenTryCountLessThanOrEqualToOne_whenValidate_thenThrowException(int tryCount) {
    // Given

    // When
    InputValidator inputValidator = new InputValidator();

    // Then
    assertThrows(RuntimeException.class, () -> inputValidator.validate(tryCount));
  }
}
