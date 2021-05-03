import car.CarFactory;
import car.RandomNumberGenerator;
import input.InputManager;
import input.InputValidator;
import manager.GamaManager;
import print.Printer;
import referee.Referee;

import java.util.Random;
import java.util.Scanner;

public class GameClient {

  public static void main(String[] args) {
    GamaManager gamaManager = new GamaManager(
        new InputManager(new Scanner(System.in), new InputValidator()),
        new CarFactory(new RandomNumberGenerator(new Random())),
        new Printer(new Referee())
    );

    gamaManager.start();
  }
}
