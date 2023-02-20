package cs3500.marblesolitaire.controller;

import java.io.InputStreamReader;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

/**
 * This class represents the Marble Solitaire main method.
 */
public class MarbleSolitaireMain {
  /**
   * This method represents playing the game using the console.
   * @param args are the arguments, or inputs, that are taken in.
   */
  public static void main(String[] args) {

    if (args.length == 1) {
      switch (args[0]) {
        case "english":
          buildEnglish(3, 3, 3).playGame();
          break;
        case "european":
          buildEuropean(3,3,3).playGame();
          break;
        case "triangle":
          buildTriangle(5, 0, 0).playGame();
          break;
        default:
          break;
      }
    }
    if (args.length == 3) {
      switch (args[0]) {
        case "english":
          buildEnglish(Integer.parseInt(args[2]), 3, 3).playGame();
          break;
        case "european":
          buildEuropean(Integer.parseInt(args[2]), 3, 3).playGame();
          break;
        case "triangle":
          buildTriangle(Integer.parseInt(args[2]), 0, 0).playGame();
          break;
        default:
          break;
      }
    }

    if (args.length == 4) {
      switch (args[0]) {
        case "english":
          buildEnglish(3, Integer.parseInt(args[2]),
                  Integer.parseInt(args[3])).playGame();
          break;
        case "european":
          buildEuropean(3, Integer.parseInt(args[2]),
                  Integer.parseInt(args[3])).playGame();
          break;
        case "triangle":
          buildTriangle(5, Integer.parseInt(args[2]),
                  Integer.parseInt(args[3])).playGame();
          break;
        default:
          break;
      }
    }
    if (args.length == 6) {
      switch (args[0]) {
        case "english":
          buildEnglish(Integer.parseInt(args[0]), Integer.parseInt(args[2]),
                  Integer.parseInt(args[3])).playGame();
          break;
        case "european":
          buildEuropean(Integer.parseInt(args[0]), Integer.parseInt(args[2]),
                  Integer.parseInt(args[3])).playGame();
          break;
        case "triangle":
          buildTriangle(Integer.parseInt(args[0]), Integer.parseInt(args[2]),
                  Integer.parseInt(args[3])).playGame();
          break;
        default:
          break;
      }
    }
  }

  /**
   * This method builds a English solitaire board using the proper view and model.
   * @param armThickness is used to determine the size of the board.
   * @param sRow         is the row of the empty slot.
   * @param sCol         is the column of the empty slot.
   * @return             the English solitaire board controller.
   */
  public static MarbleSolitaireController buildEnglish(int armThickness, int sRow, int sCol) {
    MarbleSolitaireModel m = new EnglishSolitaireModel();
    MarbleSolitaireView v = new MarbleSolitaireTextView(m);
    return new MarbleSolitaireControllerImpl(m, v, new InputStreamReader(System.in));
  }

  /**
   * This method builds a European solitaire board using the proper view and model.
   * @param armThickness is used to determine the size of the board.
   * @param sRow         is the row of the empty slot.
   * @param sCol         is the column of the empty slot.
   * @return             the European solitaire board controller.
   */

  public static MarbleSolitaireController buildEuropean(int armThickness, int sRow, int sCol) {
    MarbleSolitaireModel m = new EuropeanSolitaireModel();
    MarbleSolitaireView v = new MarbleSolitaireTextView(m);
    return new MarbleSolitaireControllerImpl(m, v, new InputStreamReader(System.in));
  }

  /**
   * This method builds a Triangle solitaire board using the proper view and model.
   * @param armThickness is used to determine the size of the board.
   * @param sRow         is the row of the empty slot.
   * @param sCol         is the column of the empty slot.
   * @return             the Triangle solitaire board controller.
   */

  public static MarbleSolitaireController buildTriangle(int armThickness, int sRow, int sCol) {
    MarbleSolitaireModel m = new TriangleSolitaireModel();
    MarbleSolitaireView v = new TriangleSolitaireTextView(m);
    return new MarbleSolitaireControllerImpl(m, v, new InputStreamReader(System.in));
  }


}
