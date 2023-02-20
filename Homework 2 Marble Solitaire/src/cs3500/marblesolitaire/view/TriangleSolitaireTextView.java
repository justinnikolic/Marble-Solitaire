package cs3500.marblesolitaire.view;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * This class represents the TriangleSolitaireView as text.
 */
public class TriangleSolitaireTextView implements MarbleSolitaireView {
  private MarbleSolitaireModelState model;

  private Appendable out;


  /**
   * This constructor has one parameter which is the model.
   *
   * @param model is a MarbleSolitaireModelState, which represents the current state of the model.
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState model) {
    if (model == null) {
      throw new IllegalArgumentException("Model and appendable cannot be null.");
    }
    this.model = model;
    this.out = System.out;
  }

  /**
   * This constructor takes in two parameters, model and output.
   *
   * @param model is the current state of the game.
   * @param out   is the appendable output.
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState model, Appendable out) {

    if (model == null || out == null) {
      throw new IllegalArgumentException("Model and appendable cannot be null.");
    }
    this.model = model;
    this.out = out;
  }

  @Override
  public String toString() {
    StringBuilder gameBoard = new StringBuilder();
    for (int sRow = 0; sRow < this.model.getBoardSize(); sRow++) {
      for (int i = 0; i < model.getBoardSize() - 1 - sRow; i++) {
        gameBoard.append(" ");
      }
      for (int sCol = 0; sCol < this.model.getBoardSize(); sCol++) {
        if (this.model.getSlotAt(sRow, sCol) == MarbleSolitaireModelState.SlotState.Empty) {
          gameBoard.append("_");
        } else if (this.model.getSlotAt(sRow, sCol) ==
                MarbleSolitaireModelState.SlotState.Invalid) {
          // only make invalid spaces if its on the left half of the board
          if (sCol < (model.getBoardSize() / 2) + 1) {
            gameBoard.append(" ");
          }
        } else if (this.model.getSlotAt(sRow, sCol) ==
                MarbleSolitaireModelState.SlotState.Marble) {
          gameBoard.append("O");
        }

        if (sCol != model.getBoardSize() - 1
                && this.model.getSlotAt(sRow, sCol + 1) ==
                MarbleSolitaireModelState.SlotState.Invalid
                && sCol > this.model.getBoardSize() / 2) {
          break;
        }

        // only append spaces if not at the right edge
        if (sCol < sRow) {
          gameBoard.append(" ");
        }
      }

      if (sRow != model.getBoardSize() - 1) {
        gameBoard.append("\n");
      }
    }

    return gameBoard.toString();
  }


  @Override
  public void renderBoard() throws IOException {
    out.append(toString());
  }

  @Override
  public void renderMessage(String message) throws IOException {
    out.append(message);
  }
}
