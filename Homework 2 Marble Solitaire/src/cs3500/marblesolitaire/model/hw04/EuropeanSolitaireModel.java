package cs3500.marblesolitaire.model.hw04;


/**
 * This class represents an European Solitaire model, with fields of arm thickness, an
 * empty x position, an empty y position, and the board.
 */
public class EuropeanSolitaireModel extends AbstractSolitaireModel {

  /**
   * This constructor creates the default board with an arm thickness of three and the empty slot
   * in the middle.
   */
  public EuropeanSolitaireModel() {
    super();
    this.makeBoard(this.armThickness);


  }


  /**
   * This constructor has two parameters, sRow and sCol, which determine the empty slot on
   * the board.
   *
   * @param sRow an int that determines the row, or x position, of the empty slot.
   * @param sCol an int that determines the column, or y position, of the empty slot.
   */
  public EuropeanSolitaireModel(int sRow, int sCol) {
    super(sRow, sCol);
    this.makeBoard(this.armThickness);
  }

  /**
   * This constructor has three parameters, the arm thickness, sRow, and sCol, and produces a
   * board based on the provided information.
   *
   * @param sideLength integer that represents the arm size of the board.
   * @param sRow       an int that determines the row, or x position, of the empty slot.
   * @param sCol       an int that determines the column, or y position, of the empty slot.
   */
  public EuropeanSolitaireModel(int sideLength, int sRow, int sCol) {
    super(sideLength, sRow, sCol);
    this.makeBoard(sideLength);
  }


  /**
   * This constructor takes in the arm thickness with is the size of the arms of the board.
   *
   * @param sideLength integer that represents the arm size of the board.
   */
  public EuropeanSolitaireModel(int sideLength) {
    super(sideLength);
    this.makeBoard(sideLength);
  }


  /**
   * This method constructs the board based on given parameters.
   *
   * @param sideLength is used to distinguish the size of the board.
   * @return returns the board.
   */
  @Override
  public SlotState[][] makeBoard(int sideLength) {
    this.board = new SlotState[getBoardSize()][getBoardSize()];
    for (int i = 0; i < this.getBoardSize(); i++) {
      for (int j = 0; j < this.getBoardSize(); j++) {
        if (invalidBoundaries(sideLength, i, j)) {
          this.board[i][j] = SlotState.Invalid;
        } else {
          this.board[i][j] = SlotState.Marble;
        }
      }
    }
    this.board[this.emptyX][this.emptyY] = SlotState.Empty;
    return this.board;
  }


  @Override
  public boolean invalidBoundaries(int sideLength, int sRow, int sCol) {
    return ((sRow < sideLength - 1
            && sCol < sideLength - 1
            && (sRow + sCol < sideLength - 1)) || //top left
            (sRow > (sideLength * 2 - 2)
                    && sCol < sideLength - 1
                    && (sRow > sCol + (sideLength * 2 - 2))) || //bottom left
            (sRow < sideLength - 1
                    && sCol > (sideLength * 2 - 2)
                    && (sCol > sRow + (sideLength * 2 - 2))) || //top right
            (sRow > (sideLength * 2 - 2)
                    && sCol > (sideLength * 2 - 2)
                    && sRow + sCol >= sideLength * 5 - 4)) || //bottom right
            (sRow < 0 || sCol < 0) ||
            (sRow >= this.getBoardSize() || sCol >= this.getBoardSize());


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


  @Override
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

}
