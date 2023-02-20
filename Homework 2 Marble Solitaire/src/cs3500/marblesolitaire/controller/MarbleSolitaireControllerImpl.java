package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireGuiView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * This class represents the MarbleSolitaireController implementation.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {

  private MarbleSolitaireModel model;
  private MarbleSolitaireView view;
  private Readable in;


  /**
   * This constructor represents the implementation of controller and takes in three parameters.
   *
   * @param model represents the model of the board.
   * @param view  represents the view or display of the game board.
   * @param in    represents the input from the user.
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel model,
                                       MarbleSolitaireView view, Readable in) {
    if (model == null || view == null || in == null) {
      throw new IllegalArgumentException("Model and view cannot be null");
    }
    this.model = model;
    this.view = view;
    this.in = in;


  }




  @Override
  public void playGame() {
    Scanner scanner = new Scanner(in);
    while (!this.model.isGameOver()) {
      try {
        this.view.renderBoard();
      } catch (IOException e) {
        throw new IllegalStateException("Cannot render board");
      }
      try {
        this.view.renderMessage("\nScore: " + this.model.getScore() + "\n");
      } catch (IOException e) {
        throw new IllegalStateException("Cannot render score");
      }
      ArrayList<Integer> movePosn = new ArrayList<>();
      while (movePosn.size() < 4) {
        if (scanner.hasNext()) { //throw illegal state exception if false
          String input = scanner.next();
          if (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("Q")) {
            try {
              this.view.renderMessage("Game quit!\n" + "State of game when quit:\n"
                      + this.view.toString()
                      + "\n" + "Score: " + this.model.getScore());
              //reprint board
              return;
            } catch (IOException ex) {
              throw new IllegalStateException();
            }
          } else {
            try {
              movePosn.add(Integer.parseInt(input) - 1);
            } catch (NumberFormatException ignored) {
            }
          }
        } else {
          throw new IllegalStateException();
        }
      }

      int fromRow = movePosn.get(0);
      int fromCol = movePosn.get(1);
      int toRow = movePosn.get(2);
      int toCol = movePosn.get(3);

      try {
        this.model.move(fromRow, fromCol, toRow, toCol);
      } catch (IllegalArgumentException e) {
        try {
          this.view.renderMessage("Invalid move. Play again.\n");
        } catch (IOException exception) {
          throw new IllegalStateException();
        }
      }
    }
    if (this.model.isGameOver()) {
      try {
        this.view.renderMessage("Game over!\n" +
                this.view + "\n" +
                "Score: " + this.model.getScore());
      } catch (IOException e) {
        throw new IllegalStateException();
      }
    }
  }

  private void playGameQuitHelper() {
    ArrayList<Integer> movePosn = new ArrayList<>();
    Scanner scanner = new Scanner(in);
    while (movePosn.size() > 4) {
      if (scanner.hasNext()) {
        String input = scanner.next();
        if (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("Q")) {
          try {
            this.view.renderMessage("Game quit!\n" + "State of game when quit:\n"
                    + this.view.toString()
                    + "\n" + "Score: " + this.model.getScore());
            return;
          } catch (IOException e) {
            throw new RuntimeException(e);
          }
        } else {
          try {
            movePosn.add(Integer.parseInt(input) - 1);
          } catch (NumberFormatException ignored) {
          }
        }
      } else {
        throw new IllegalStateException();
      }
    }
  }
}


