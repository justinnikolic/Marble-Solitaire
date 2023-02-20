package cs3500.marblesolitaire.model.hw02;

import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;


/**
 * This class is testing the EnglishSolitaireModel class.
 */
public class EnglishSolitaireModelTest {


  EnglishSolitaireModel b1;
  EnglishSolitaireModel b;
  EnglishSolitaireModel b2;
  EnglishSolitaireModel b3;
  EnglishSolitaireModel b4;
  EnglishSolitaireModel b5;
  EnglishSolitaireModel b6;
  EnglishSolitaireModel b7;
  EnglishSolitaireModel b8;
  EnglishSolitaireModel b9;
  MarbleSolitaireView v;
  MarbleSolitaireView v2;
  String loseGame;
  String winGame;


  @Before
  public void init() {
    this.b = new EnglishSolitaireModel();
    this.b1 = new EnglishSolitaireModel(3, 3, 3);
    this.b2 = new EnglishSolitaireModel(5, 6, 6);
    this.b3 = new EnglishSolitaireModel(7, 9, 9);
    this.b4 = new EnglishSolitaireModel(9, 12, 12);
    this.b5 = new EnglishSolitaireModel(27, 39, 39);
    this.b6 = new EnglishSolitaireModel(3, 0, 4);
    this.b7 = new EnglishSolitaireModel(0, 2);
    this.b8 = new EnglishSolitaireModel(3);
    this.b9 = new EnglishSolitaireModel(5);
    loseGame = new String("    O _ O\n" +
                                  "    O _ O\n" +
                                  "O O O O O O O\n" +
                                  "O _ O _ O _ _\n" +
                                  "O O O O O O O\n" +
                                  "    O _ O\n" +
                                  "    O O O");


    winGame = new String("    _ _ _    \n" +
                                "    _ _ _    \n" +
                                "_ _ _ _ _ _ _\n" +
                                "_ _ _ O _ _ _\n" +
                                "_ _ _ _ _ _ _\n" +
                                "    _ _ _    \n" +
                                "    _ _ _    ");
  }

  @Test
  public void testDefaultConstructor() {
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.b.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b.getSlotAt(0, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.b.getSlotAt(6, 5));
  }

  @Test
  public void testSecondConstructor() {
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.b7.getSlotAt(0, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b7.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.b7.getSlotAt(6, 5));
  }


  @Test
  public void testThirdConstructor() {
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.b1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b1.getSlotAt(0, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.b1.getSlotAt(6, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.b6.getSlotAt(0, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.b2.getSlotAt(6, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b2.getSlotAt(0, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.b2.getSlotAt(0, 2));
  }


  @Test
  public void testFourthConstructor() {
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.b8.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b8.getSlotAt(0, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.b8.getSlotAt(6, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.b9.getSlotAt(6, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b9.getSlotAt(9, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.b9.getSlotAt(12, 12));
  }



  @Test
  public void testGetBoardSize() {


    assertEquals(7, this.b1.getBoardSize(), 7);
    assertEquals(12, this.b2.getBoardSize(), 12);
    assertEquals(79, this.b5.getBoardSize(), 79);
  }


  @Test
  public void testGetSlotAt() {

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b1.getSlotAt(3, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.b1.getSlotAt(0, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.b1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b1.getSlotAt(5, 3));
  }


  @Test
  public void testIsGameOverFalse() {

    EnglishSolitaireModel m = new EnglishSolitaireModel();
    m.move(5,3,3,3);
    m.move(4,5,4,3);
    m.move(6,4,4,4);
    assertEquals(false, m.isGameOver());
  }


  @Test
  public void testIsGameOverTrue() {

    EnglishSolitaireModel m = new EnglishSolitaireModel();
    m.move(5,3,3,3);
    m.move(2,3,4,3);
    m.move(3,1,3,3);
    m.move(3,4,3,2);
    m.move(0,3,2,3);
    m.move(3,6,3,4);
    assertEquals(true, m.isGameOver());
  }

  @Test
  public void testMove() {
    EnglishSolitaireModel m2 = new EnglishSolitaireModel();
    EnglishSolitaireModel m = new EnglishSolitaireModel();
    m.move(5,3,3,3);
    m.move(4,5,4,3);
    m.move(6,4,4,4);
    m.move(6,2,6,4);
    m.move(3,4,5,4);
    m.move(6,4,4,4);
    m.move(1,4,3,4);
    m.move(2,6,2,4);
    m.move(4,6,2,6);
    m.move(2,3,2,5);
    m.move(2,6,2,4);
    m.move(2,1,2,3);
    m.move(0,2,2,2);
    m.move(0,4,0,2);
    m.move(3,2,1,2);
    m.move(0,2,2,2);
    m.move(5,2,3,2);
    m.move(4,0,4,2);
    m.move(2, 0, 4, 0);
    m.move(4, 3, 4, 1);
    m.move(4, 0, 4, 2);
    m.move(2, 3, 2, 1);
    m.move(2, 1, 4, 1);
    m.move(4, 1, 4, 3);
    m.move(4, 3, 4, 5);
    m.move(4, 5, 2, 5);
    m.move(2, 5, 2, 3);
    m.move(3, 3, 3, 5);
    m.move(1, 3, 3, 3);
    m.move(3, 2, 3, 4);
    m.move(3, 5, 3, 3);
    MarbleSolitaireView v = new MarbleSolitaireTextView(m);
    assertEquals(winGame, v.toString());
  }


  @Test
  public void testGameOverMove() {

    EnglishSolitaireModel m = new EnglishSolitaireModel();
    m.move(5, 3, 3, 3);
    m.move(2, 3, 4, 3);
    m.move(3, 1, 3, 3);
    m.move(3, 4, 3, 2);
    m.move(0, 3, 2, 3);
    m.move(3, 6, 3, 4);
    MarbleSolitaireView v = new MarbleSolitaireTextView(m);
    assertEquals(loseGame, v.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveInvalidBoundaries() {
    EnglishSolitaireModel m = new EnglishSolitaireModel();
    m.move(0,0, 0, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveNonEmptyTO() {
    EnglishSolitaireModel m = new EnglishSolitaireModel();
    m.move(0, 2, 2, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveEmptyFrom() {
    EnglishSolitaireModel m = new EnglishSolitaireModel();
    m.move(5,3,3,3);
    m.move(4,5,4,3);
    m.move(4, 5, 4, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveEmptyMiddle() {
    EnglishSolitaireModel m = new EnglishSolitaireModel();
    m.move(5, 3, 3, 3);
    m.move(4, 5, 4, 3);
    m.move(4, 6, 4, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveMoreThanTwoAway() {
    EnglishSolitaireModel m = new EnglishSolitaireModel();
    m.move(5, 3, 3, 3);
    m.move(4, 5, 4, 3);
    m.move(4, 6, 4, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveMoveDiagonallyDownLeft() {
    EnglishSolitaireModel m = new EnglishSolitaireModel();
    m.move(5, 3, 3, 3);
    m.move(4, 5, 4, 3);
    m.move(2, 6, 4, 4);
  }



  @Test(expected = IllegalArgumentException.class)
  public void testConstructorArmThickness1Exception() {
    EnglishSolitaireModel board = new EnglishSolitaireModel(1, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorNegativeArmThicknessException() {
    EnglishSolitaireModel board = new EnglishSolitaireModel(-1, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorNegativeRowException() {
    EnglishSolitaireModel board = new EnglishSolitaireModel(3, -1, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorNegativeColException() {
    EnglishSolitaireModel board = new EnglishSolitaireModel(3, 1, -3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorInvalidEmptyTopLeftException() {
    EnglishSolitaireModel board = new EnglishSolitaireModel(3, 1, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorInvalidEmptyTopRightException() {
    EnglishSolitaireModel board = new EnglishSolitaireModel(3, 6, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorInvalidEmptyBottomLeftException() {
    EnglishSolitaireModel board = new EnglishSolitaireModel(3, 6, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorInvalidEmptyBottomRightException() {
    EnglishSolitaireModel board = new EnglishSolitaireModel(3, 5, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFirstConstructorExceptionTopLeft() {
    EnglishSolitaireModel board = new EnglishSolitaireModel(0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSecondConstructorExceptionTopRight() {
    EnglishSolitaireModel board = new EnglishSolitaireModel(0, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSecondConstructorExceptionTopLeft() {
    EnglishSolitaireModel board = new EnglishSolitaireModel(0, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSecondConstructorExceptionBottomLeft() {
    EnglishSolitaireModel board = new EnglishSolitaireModel(5, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSecondConstructorExceptionBottomRight() {
    EnglishSolitaireModel board = new EnglishSolitaireModel(5, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testThirdConstructorExceptionZero() {
    EnglishSolitaireModel board = new EnglishSolitaireModel(0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testThirdConstructorExceptionNegative() {
    EnglishSolitaireModel board = new EnglishSolitaireModel(-1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testThirdConstructorExceptionEven() {
    EnglishSolitaireModel board = new EnglishSolitaireModel(2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testThirdConstructorExceptionEven1() {
    EnglishSolitaireModel board = new EnglishSolitaireModel(100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testThirdConstructorExceptionNeg() {
    EnglishSolitaireModel board = new EnglishSolitaireModel(-100);
  }

  @Test
  public void testGetScoreWorks() {
    assertEquals(32, this.b1.getScore());
    assertEquals(104, this.b2.getScore());
    assertEquals(216, this.b3.getScore());
    EnglishSolitaireModel m = new EnglishSolitaireModel();
    m.move(5, 3, 3, 3);
    m.move(2, 3, 4, 3);
    m.move(3, 1, 3, 3);
    m.move(3, 4, 3, 2);
    m.move(0, 3, 2, 3);
    m.move(3, 6, 3, 4);
    assertEquals(26, m.getScore());
  }
}
