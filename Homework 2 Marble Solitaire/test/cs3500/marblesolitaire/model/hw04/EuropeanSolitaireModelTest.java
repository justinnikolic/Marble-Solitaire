package cs3500.marblesolitaire.model.hw04;

import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;


/**
 * This class is testing the EuropeanSolitaireModel class.
 */
public class EuropeanSolitaireModelTest {

  EuropeanSolitaireModel b1;
  EuropeanSolitaireModel b;
  EuropeanSolitaireModel b2;
  EuropeanSolitaireModel b3;
  EuropeanSolitaireModel b4;
  EuropeanSolitaireModel b5;
  EuropeanSolitaireModel b6;
  EuropeanSolitaireModel b7;
  EuropeanSolitaireModel b8;
  EuropeanSolitaireModel b9;
  MarbleSolitaireView v;
  MarbleSolitaireView v2;
  String loseGame;
  String winGame;


  @Before
  public void init() {
    this.b = new EuropeanSolitaireModel();
    this.b1 = new EuropeanSolitaireModel(3, 3, 3);
    this.b2 = new EuropeanSolitaireModel(5, 6, 6);
    this.b3 = new EuropeanSolitaireModel(7, 9, 9);
    this.b4 = new EuropeanSolitaireModel(9, 12, 12);
    this.b5 = new EuropeanSolitaireModel(27, 39, 39);
    this.b6 = new EuropeanSolitaireModel(3, 0, 4);
    this.b7 = new EuropeanSolitaireModel(0, 2);
    this.b8 = new EuropeanSolitaireModel(3);
    this.b9 = new EuropeanSolitaireModel(5);


    winGame = new String(" _ _ _\n" +
            "  O _ _ _ O\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "  O _ _ _ O\n" +
            "    _ _ _");
  }

  @Test
  public void testDefaultConstructor() {
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.b.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b.getSlotAt(0, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.b.getSlotAt(6, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b.getSlotAt(1, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b.getSlotAt(1, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b.getSlotAt(5, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b.getSlotAt(5, 5));
  }

  @Test
  public void testSecondConstructor() {
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.b7.getSlotAt(0, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b7.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b7.getSlotAt(1, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b7.getSlotAt(1, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b7.getSlotAt(5, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b7.getSlotAt(5, 5));
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
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b2.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b2.getSlotAt(3, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b2.getSlotAt(2, 3));

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b2.getSlotAt(3, 11));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b2.getSlotAt(2, 10));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b2.getSlotAt(1, 9));

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b2.getSlotAt(11, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b2.getSlotAt(10, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b2.getSlotAt(9, 1));

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b2.getSlotAt(9, 11));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b2.getSlotAt(10, 10));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b2.getSlotAt(11, 9));
  }


  @Test
  public void testFourthConstructor() {
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.b8.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b8.getSlotAt(0, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.b8.getSlotAt(6, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.b9.getSlotAt(6, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b9.getSlotAt(9, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.b9.getSlotAt(12, 12));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b2.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b2.getSlotAt(3, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b2.getSlotAt(2, 3));

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b2.getSlotAt(3, 11));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b2.getSlotAt(2, 10));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b2.getSlotAt(1, 9));

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b2.getSlotAt(11, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b2.getSlotAt(10, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b2.getSlotAt(9, 1));

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b2.getSlotAt(9, 11));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b2.getSlotAt(10, 10));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b2.getSlotAt(11, 9));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorArmThickness1Exception() {
    EuropeanSolitaireModel board = new EuropeanSolitaireModel(1, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorNegativeArmThicknessException() {
    EuropeanSolitaireModel board = new EuropeanSolitaireModel(-1, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorNegativeRowException() {
    EuropeanSolitaireModel board = new EuropeanSolitaireModel(3, -1, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorNegativeColException() {
    EuropeanSolitaireModel board = new EuropeanSolitaireModel(3, 1, -3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorInvalidEmptyTopLeftException() {
    EuropeanSolitaireModel board = new EuropeanSolitaireModel(3, 1, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorInvalidEmptyTopRightException() {
    EuropeanSolitaireModel board = new EuropeanSolitaireModel(3, 6, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorInvalidEmptyBottomLeftException() {
    EuropeanSolitaireModel board = new EuropeanSolitaireModel(3, 6, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorInvalidEmptyBottomRightException() {
    EuropeanSolitaireModel board = new EuropeanSolitaireModel(3, 5, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFirstConstructorExceptionTopLeft() {
    EuropeanSolitaireModel board = new EuropeanSolitaireModel(0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSecondConstructorExceptionTopRight() {
    EuropeanSolitaireModel board = new EuropeanSolitaireModel(0, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSecondConstructorExceptionTopLeft() {
    EuropeanSolitaireModel board = new EuropeanSolitaireModel(0, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSecondConstructorExceptionBottomLeft() {
    EuropeanSolitaireModel board = new EuropeanSolitaireModel(5, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSecondConstructorExceptionBottomRight() {
    EuropeanSolitaireModel board = new EuropeanSolitaireModel(5, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testThirdConstructorExceptionZero() {
    EuropeanSolitaireModel board = new EuropeanSolitaireModel(0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testThirdConstructorExceptionNegative() {
    EuropeanSolitaireModel board = new EuropeanSolitaireModel(-1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testThirdConstructorExceptionEven() {
    EuropeanSolitaireModel board = new EuropeanSolitaireModel(2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testThirdConstructorExceptionEven1() {
    EuropeanSolitaireModel board = new EuropeanSolitaireModel(100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testThirdConstructorExceptionNeg() {
    EuropeanSolitaireModel board = new EuropeanSolitaireModel(-100);
  }


  @Test
  public void testGetScoreWorks() {
    assertEquals(32, this.b1.getScore());
    assertEquals(128, this.b2.getScore());
    assertEquals(276, this.b3.getScore());
    EnglishSolitaireModel m = new EnglishSolitaireModel();
    m.move(5, 3, 3, 3);
    m.move(2, 3, 4, 3);
    m.move(3, 1, 3, 3);
    m.move(3, 4, 3, 2);
    m.move(0, 3, 2, 3);
    m.move(3, 6, 3, 4);
    assertEquals(26, m.getScore());
  }

  @Test
  public void testGameOver() {
    MarbleSolitaireModel model1 = new EuropeanSolitaireModel();
    assertEquals(false, model1.isGameOver());
    model1.move(1, 3, 3, 3);
    model1.move(2, 1, 2, 3);
    model1.move(0, 2, 2, 2);
    assertEquals(false, model1.isGameOver());
    model1.move(3, 2, 1, 2);
    model1.move(0, 4, 0, 2);
    model1.move(0, 2, 2, 2);
    model1.move(5, 2, 3, 2);
    model1.move(4, 0, 4, 2);
    model1.move(4, 3, 4, 1);
    model1.move(2, 0, 4, 0);
    model1.move(4, 0, 4, 2);
    model1.move(4, 5, 4, 3);
    model1.move(6, 4, 4, 4);
    model1.move(3, 4, 5, 4);
    model1.move(6, 2, 6, 4);
    model1.move(6, 4, 4, 4);
    model1.move(1, 4, 3, 4);
    model1.move(2, 6, 2, 4);
    assertEquals(false, model1.isGameOver());
    model1.move(2, 3, 2, 5);
    model1.move(4, 6, 2, 6);
    model1.move(2, 6, 2, 4);
    model1.move(4, 3, 4, 1);
    model1.move(4, 1, 2, 1);
    model1.move(2, 1, 2, 3);
    model1.move(2, 3, 2, 5);
    model1.move(2, 5, 4, 5);
    model1.move(4, 5, 4, 3);
    model1.move(3, 3, 3, 5);
    model1.move(5, 3, 3, 3);
    model1.move(3, 2, 3, 4);
    model1.move(3, 5, 3, 3);
    assertEquals(true, model1.isGameOver());
  }

  @Test
  public void testMove() {
    MarbleSolitaireModel model1 = new EuropeanSolitaireModel();
    model1.move(1, 3, 3, 3);
    model1.move(2, 1, 2, 3);
    model1.move(0, 2, 2, 2);
    model1.move(3, 2, 1, 2);
    model1.move(0, 4, 0, 2);
    model1.move(0, 2, 2, 2);
    model1.move(5, 2, 3, 2);
    model1.move(4, 0, 4, 2);
    model1.move(4, 3, 4, 1);
    model1.move(2, 0, 4, 0);
    model1.move(4, 0, 4, 2);
    model1.move(4, 5, 4, 3);
    model1.move(6, 4, 4, 4);
    model1.move(3, 4, 5, 4);
    model1.move(6, 2, 6, 4);
    model1.move(6, 4, 4, 4);
    model1.move(1, 4, 3, 4);
    model1.move(2, 6, 2, 4);
    model1.move(2, 3, 2, 5);
    model1.move(4, 6, 2, 6);
    model1.move(2, 6, 2, 4);
    model1.move(4, 3, 4, 1);
    model1.move(4, 1, 2, 1);
    model1.move(2, 1, 2, 3);
    model1.move(2, 3, 2, 5);
    model1.move(2, 5, 4, 5);
    model1.move(4, 5, 4, 3);
    model1.move(3, 3, 3, 5);
    model1.move(5, 3, 3, 3);
    model1.move(3, 2, 3, 4);
    model1.move(3, 5, 3, 3);
    MarbleSolitaireView v = new MarbleSolitaireTextView(model1);
    assertEquals(winGame, v.toString());
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
}