package cs3500.marblesolitaire.model.hw04;


/**
 * This class represents a Triangle Solitaire model, with fields of arm thickness, an
 * empty x position, an empty y position, and the board.
 */
public class TriangleSolitaireModel extends AbstractSolitaireModel {


  /**
   * This constructor creates the default board with an arm thickness of three and the empty slot
   * in the middle.
   */
  public TriangleSolitaireModel() {
    this(5, 0, 0);
    this.makeBoard(armThickness);

  }

  /**
   * This constructor takes in the arm thickness with is the size of the arms of the board.
   *
   * @param dimension integer that represents the arm size of the board.
   */
  public TriangleSolitaireModel(int dimension) {
    this(dimension, 0, 0);
    this.makeBoard(armThickness);
  }

  /**
   * This constructor has two parameters, sRow and sCol, which determine the empty slot on
   * the board.
   *
   * @param row an int that determines the row, or x position, of the empty slot.
   * @param col an int that determines the column, or y position, of the empty slot.
   */
  public TriangleSolitaireModel(int row, int col) {
    this(5, row, col);
    this.makeBoard(armThickness);
  }

  /**
   * This constructor has three parameters which determine the boards dimensions and empty slot.
   *
   * @param dimension and int that determines the dimensions of the board.
   * @param row       the row of the empty slot.
   * @param col       the column of the empty slot.
   */
  public TriangleSolitaireModel(int dimension, int row, int col) {
    if (dimension >= 0) {
      this.armThickness = dimension;
    } else {
      throw new IllegalArgumentException("Dimensions cannot be negative");
    }
    if ((col <= row) && (row >= 0) && (col >= 0) &&
            (row < armThickness && (col < armThickness))) {
      this.emptyX = row;
      this.emptyY = col;
    } else {
      throw new IllegalArgumentException("Invalid empty slot");
    }
    this.board = new SlotState[getBoardSize()][getBoardSize()];
    this.makeBoard(this.armThickness);
  }

  @Override
  public int getBoardSize() {
    return this.armThickness;
  }

  @Override
  public SlotState[][] makeBoard(int armThickness) {
    this.board = new SlotState[getBoardSize()][getBoardSize()];
    for (int i = 0; i < this.getBoardSize(); i++) {
      for (int j = 0; j <= i; j++) {
        this.board[i][j] = SlotState.Marble;
      }
    }
    this.board[this.emptyX][this.emptyY] = SlotState.Empty;
    return this.board;
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if (invalidBoundaries(this.armThickness, fromRow, toRow) &&
            (invalidBoundaries(this.armThickness, toRow, toCol))) {
      throw new IllegalArgumentException("This move is invalid.");
    }
    if (validMove(fromRow, fromCol, toRow, toCol)) {
      if (toRow > fromRow && toCol > fromCol) {
        this.board[toRow - 1][toCol - 1] = SlotState.Empty; //down right
      } else if (fromRow > toRow && fromCol > toCol) { //up left
        this.board[fromRow - 1][fromCol - 1] = SlotState.Empty;
      } else if (toRow > fromRow) { //down left
        this.board[toRow - 1][toCol] = SlotState.Empty;
      } else if (toRow < fromRow) { //up right
        this.board[fromRow - 1][fromCol] = SlotState.Empty;
      } else if (toCol > fromCol) { // horizontal right
        this.board[toRow][toCol - 1] = SlotState.Empty;
      } else if (toCol < fromCol) { //horizontal left
        this.board[fromRow][fromCol - 1] = SlotState.Empty;
      }
      this.board[fromRow][fromCol] = SlotState.Empty;
      this.board[toRow][toCol] = SlotState.Marble;
    } else {
      throw new IllegalArgumentException("Invalid move");
    }
  }

  @Override
  public boolean invalidBoundaries(int armThickness, int sRow, int sCol) {
    return ((sRow < 0 || sCol < 0) ||
            (sRow >= this.getBoardSize() || sCol >= this.getBoardSize()));
  }

  @Override
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
    } else if (!(((Math.abs(toRow - fromRow) == 2 || Math.abs(toRow - fromRow) == 0)
            && (Math.abs(toCol - fromCol) == 0 || Math.abs(toCol - fromCol) == 2))
            || ((Math.abs(toRow - fromRow) == 0 || Math.abs(toRow - fromRow) == 2)
            && (Math.abs(toCol - fromCol) == 2 || Math.abs(toCol - fromCol) == 0)))) {
      return false;
      // there is a marble between the to and from positions
    } else if (toRow > fromRow && toCol > fromCol &&
            (this.board[toRow - 1][toCol - 1] != SlotState.Marble)) { //down right
      return false;
    } else if (fromRow > toRow && fromCol > toCol &&
            (this.board[fromRow - 1][fromCol - 1] != SlotState.Marble)) { //up left
      return false;
    } else if (toRow > fromRow && fromCol == toCol &&
            (this.board[toRow - 1][toCol] != SlotState.Marble)) { // down left
      return false;
    } else if (toRow < fromRow && fromCol == toCol &&
            (this.board[fromRow - 1][fromCol] != SlotState.Marble)) { //up right
      return false;
    } else if (toCol > fromCol && fromRow == toRow &&
            (this.board[toRow][toCol - 1] != SlotState.Marble)) { //horizontal right
      return false;
    } else if (toCol < fromCol && fromRow == toRow &&
            (this.board[fromRow][fromCol - 1] != SlotState.Marble)) { //horizontal left
      return false;
    }
    return true;
  }

  @Override
  public boolean isGameOver() {
    for (int sRow = 0; sRow < getBoardSize(); sRow++) {
      for (int sCol = 0; sCol < getBoardSize(); sCol++) {
        // checking move down left
        if (sRow <= this.getBoardSize() - 2 && validMove(sRow, sCol, sRow + 2, sCol)) {
          return false;
        }
        //move down right
        if (sRow <= this.getBoardSize() - 2
                && validMove(sRow, sCol, sRow + 2, sCol + 2)) {
          return false;
        }
        // check right
        if (sCol <= this.getBoardSize() - 2 && validMove(sRow, sCol, sRow, sCol + 2)) {
          return false;
        }
        //check up left
        if (sRow >= 2 && validMove(sRow, sCol, sRow - 2, sCol - 2)) {
          return false;
        }
        //check up right
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
}


