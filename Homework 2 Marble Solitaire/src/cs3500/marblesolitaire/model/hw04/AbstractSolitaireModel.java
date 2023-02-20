package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;


/**
 * This class represents an abstract Solitaire model, with fields of arm thickness, an
 * empty x position, an empty y position, and the board.
 */
public abstract class AbstractSolitaireModel implements MarbleSolitaireModel {
  protected SlotState[][] board;


  protected int armThickness;

  protected int emptyX;

  protected int emptyY;



  /**
   * This constructor creates the default board with an arm thickness of three and the empty slot
   * in the middle.
   */
  public AbstractSolitaireModel() {
    this.armThickness = 3;
    this.emptyX = 3;
    this.emptyY = 3;
  }

  /**
   * This constructor has two parameters, sRow and sCol, which determine the empty slot on
   * the board.
   *
   * @param sRow an int that determines the row, or x position, of the empty slot.
   * @param sCol an int that determines the column, or y position, of the empty slot.
   */

  public AbstractSolitaireModel(int sRow, int sCol) {
    this.armThickness = 3;
    if (invalidBoundaries(armThickness, sRow, sCol)) {
      throw new IllegalArgumentException(String.format("Invalid empty cell position (%d,%d)",
              sRow, sCol));
    }
    this.emptyX = sRow;
    this.emptyY = sCol;
    this.board = new SlotState[getBoardSize()][getBoardSize()];
    this.makeBoard(this.armThickness);
  }

  /**
   * This constructor has three parameters, the arm thickness, sRow, and sCol, and produces a
   * board based on the provided information.
   *
   * @param armThickness integer that represents the arm size of the board.
   * @param sRow         an int that determines the row, or x position, of the empty slot.
   * @param sCol         an int that determines the column, or y position, of the empty slot.
   */

  public AbstractSolitaireModel(int armThickness, int sRow, int sCol) {
    this.armThickness = armThickness;
    this.emptyX = sRow;
    this.emptyY = sCol;
    if (armThickness <= 1 || armThickness % 2 == 0) {
      throw new IllegalArgumentException("Invalid arm thickness");
    }
    if (this.invalidBoundaries(armThickness, sRow, sCol)) {
      throw new IllegalArgumentException(String.format("Invalid empty cell position (%d,%d)",
              sRow, sCol));
    } else {
      this.board = new SlotState[getBoardSize()][getBoardSize()];
      this.makeBoard(armThickness);
    }
  }

  /**
   * This constructor takes in the arm thickness with is the size of the arms of the board.
   *
   * @param armThickness integer that represents the arm size of the board.
   */
  public AbstractSolitaireModel(int armThickness) {
    this.emptyX = armThickness + (armThickness - 3) / 2;
    this.emptyY = armThickness + (armThickness - 3) / 2;
    if (armThickness <= 1 || armThickness % 2 == 0) {
      throw new IllegalArgumentException("Invalid arm thickness; must be a positive, odd integer");
    } else {
      this.armThickness = armThickness;
      this.board = new SlotState[getBoardSize()][getBoardSize()];
      this.makeBoard(armThickness);
    }
  }





  /**
   * Move a marble from a given slot into another given slot. A move is only
   * valid if the to position is empty, the from position is a marble, there
   * is a marble in between the two positions, and the move is two slots away,
   * excluding a diagonal move.
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   * @throws IllegalArgumentException if the move is invalid.
   */
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if (invalidBoundaries(this.armThickness, fromRow, toRow) &&
            (invalidBoundaries(this.armThickness, toRow, toCol))) {
      throw new IllegalArgumentException("This move is invalid.");
    }
    if (validMove(fromRow, fromCol, toRow, toCol)) {
      if (toRow > fromRow) {
        this.board[toRow - 1][toCol] = SlotState.Empty;
      }
      if (toRow < fromRow) {
        this.board[fromRow - 1][fromCol] = SlotState.Empty;
      }
      if (toCol > fromCol) {
        this.board[toRow][toCol - 1] = SlotState.Empty;
      }
      if (toCol < fromCol) {
        this.board[fromRow][fromCol - 1] = SlotState.Empty;
      }
      this.board[fromRow][fromCol] = SlotState.Empty;
      this.board[toRow][toCol] = SlotState.Marble;
    } else {
      throw new IllegalArgumentException("Invalid move");
    }
  }


  /**
   * This method determines if the there are no longer any moves available.
   * @return whether the game is over or not.
   */
  public boolean isGameOver() {
    for (int sRow = 0; sRow < getBoardSize(); sRow++) {
      for (int sCol = 0; sCol < getBoardSize(); sCol++) {
        // checking move down
        if (sRow <= this.getBoardSize() - 2 && validMove(sRow, sCol, sRow + 2, sCol)) {
          return false;
        }
        // check right
        if (sCol <= this.getBoardSize() - 2 && validMove(sRow, sCol, sRow, sCol + 2)) {
          return false;
          //check up
        }
        if (sRow >= 2 && validMove(sRow, sCol, sRow - 2, sCol)) {
          return false;
          //check left
        }
        if (sCol >= 2 && validMove(sRow, sCol, sRow, sCol - 2)) {
          return false;
        }
      }
    }

    return true;
  }




  @Override
  public SlotState getSlotAt(int row, int col) {
    if (row >= this.getBoardSize() || col >= this.getBoardSize()) {
      throw new IllegalArgumentException("Row or column dimensions are " +
              "beyond the dimensions of the board");
    }
    return this.board[row][col];
  }


  @Override
  public int getScore() {
    int score = 0;

    for (int sRow = 0; sRow < getBoardSize(); sRow++) {
      for (int sCol = 0; sCol < getBoardSize(); sCol++) {
        if (this.board[sRow][sCol] == MarbleSolitaireModelState.SlotState.Marble) {
          score += 1;
        }
      }
    }
    return score;
  }

  /**
   * Checks to see if a certain position has any valid moves. A move is only
   * valid if the to position is empty, the from position is a marble, there
   * is a marble in between the two positions, and the move is two slots away,
   * excluding a diagonal move.
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   * @return true if a move is valid, or false if there are no more valid moves.
   */
  public boolean validMove(int fromRow, int fromCol, int toRow, int toCol) {
    // check if the move it out of bounds
    if (invalidBoundaries(this.armThickness, fromRow, fromCol)
            || invalidBoundaries(this.armThickness, toRow, toCol)) {
      return false;
      //there is a marble at the from position
    } else if (this.board[fromRow][fromCol] != SlotState.Marble) {
      return false;
      // the to position is empty
    } else if (this.board[toRow][toCol] != SlotState.Empty) {
      return false;
      // the from and to positions are two slots away (horizontally and vertically)
    } else if (!(((Math.abs(toRow - fromRow) == 2) && (Math.abs(toCol - fromCol) == 0))
            || ((Math.abs(toRow - fromRow) == 0) && (Math.abs(toCol - fromCol) == 2)))) {
      return false;
      // there is a marble between the to and from positions
    } else if (toRow > fromRow &&
            (this.board[toRow - 1][toCol] != SlotState.Marble)) { //vertical down
      return false;
    } else if (toRow < fromRow &&
            (this.board[fromRow - 1][fromCol] != SlotState.Marble)) { //vertical up
      return false;
    } else if (toCol > fromCol &&
            (this.board[toRow][toCol - 1] != SlotState.Marble)) { //horizontal right
      return false;
    } else {
      return toCol >= fromCol ||
              (this.board[fromRow][fromCol - 1] == SlotState.Marble); // horizontal left
    }
  }


  /**
   * This method checks so see if a given row and column are within the valid boundaries.
   * @param armThickness is used to determine the size of the board.
   * @param sRow is the row we are checking to be within valid boundaries.
   * @param sCol is the column we are checking to be within valid boundaries.
   * @return a boolean whether or not coordinates are valid.
   */
  public boolean invalidBoundaries(int armThickness, int sRow, int sCol) {
    return ((sRow < armThickness - 1 && sCol < armThickness - 1) || // top left
            (sRow < armThickness - 1 && sCol > (armThickness * 2 - 2)) || // top right
            (sRow > (armThickness * 2 - 2) && sCol < (armThickness - 1)) || // bottom left
            (sRow > (armThickness * 2 - 2) && sCol > (armThickness * 2 - 2)) || // bottom right
            (sRow < 0 || sCol < 0) || (sRow >= this.getBoardSize() || sCol >= this.getBoardSize()));
  }


  public int getBoardSize() {
    return this.armThickness * 3 - 2;
  }

  /**
   * This method constructs the board based on given parameters.
   * @param armThickness is used to distinguish the size of the board.
   * @return returns the board.
   */
  public SlotState[][] makeBoard(int armThickness) {
    this.board = new SlotState[getBoardSize()][getBoardSize()];
    for (int i = 0; i < this.getBoardSize(); i++) {
      for (int j = 0; j < this.getBoardSize(); j++) {
        if (invalidBoundaries(armThickness, i, j)) {
          this.board[i][j] = SlotState.Invalid;
        } else {
          this.board[i][j] = SlotState.Marble;
        }
      }
    }
    this.board[this.emptyX][this.emptyY] = SlotState.Empty;
    return this.board;
  }
}
