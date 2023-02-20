package cs3500.marblesolitaire.controller;


/**
 * This interface represents the controller aspect of the marble solitaire game.
 */
public interface MarbleSolitaireController {
  /**
   * This method initiates playing the MarbleSolitaire game.
   *
   * @throws IllegalStateException if controller is unable to successfully read input and
   *                               transmit output.
   */
  void playGame() throws IllegalStateException;
}
