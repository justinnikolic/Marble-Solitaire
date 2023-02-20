package cs3500.marblesolitaire.model.hw02;

import cs3500.marblesolitaire.model.hw04.AbstractSolitaireModel;

/**
 * This class represents an English Solitaire model, with fields of arm thickness, an
 * empty x position, an empty y position, and the board.
 */
public class EnglishSolitaireModel extends AbstractSolitaireModel {

  /**
   * This constructor creates the default board with an arm thickness of three and the empty slot
   * in the middle.
   */
  public EnglishSolitaireModel() {
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
  public EnglishSolitaireModel(int sRow, int sCol) {
    super(sRow, sCol);
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
  public EnglishSolitaireModel(int armThickness, int sRow, int sCol) {
    super(armThickness, sRow, sCol);
    this.makeBoard(armThickness);
  }


  /**
   * This constructor takes in the arm thickness with is the size of the arms of the board.
   *
   * @param armThickness integer that represents the arm size of the board.
   */
  public EnglishSolitaireModel(int armThickness) {
    super(armThickness);
    this.makeBoard(armThickness);
  }
}
