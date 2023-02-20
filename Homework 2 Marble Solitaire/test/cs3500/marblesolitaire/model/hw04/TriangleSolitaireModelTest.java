package cs3500.marblesolitaire.model.hw04;

import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

import static org.junit.Assert.assertEquals;

/**
 * This class is testing the TriangleSolitaireModel class.
 */
public class TriangleSolitaireModelTest {

  TriangleSolitaireModel m1;
  TriangleSolitaireModel m2;
  TriangleSolitaireModel m3;
  TriangleSolitaireModel m4;
  TriangleSolitaireModel m5;
  TriangleSolitaireModel m6;
  TriangleSolitaireModel m7;

  String triangleWinGame;

  TriangleSolitaireModel m8;

  @Before
  public void init() {
    this.m1 = new TriangleSolitaireModel();
    this.m2 = new TriangleSolitaireModel(5);
    this.m3 = new TriangleSolitaireModel(7);
    this.m4 = new TriangleSolitaireModel(3,1);
    this.m5 = new TriangleSolitaireModel(4,4);
    this.m6 = new TriangleSolitaireModel(5, 2, 2);
    this.m7 = new TriangleSolitaireModel(7, 6, 3);
    this.triangleWinGame = new String("     _\n" +
            "   _ _\n" +
            "  _ _ _\n" +
            " _ _ _ _\n" +
            "_ _ O _ _");



  }

  @Test
  public void testDefaultConstructor() {
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.m1.getSlotAt(0,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.m1.getSlotAt(2,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.m1.getSlotAt(4,0));

  }

  @Test
  public void testSecondConstructor() {
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.m2.getSlotAt(0,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.m2.getSlotAt(2,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.m2.getSlotAt(4,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.m3.getSlotAt(0,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.m3.getSlotAt(6,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.m3.getSlotAt(6,6));
  }

  @Test
  public void testThirdConstructor() {
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.m4.getSlotAt(3,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.m5.getSlotAt(4,4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.m4.getSlotAt(2,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.m4.getSlotAt(4, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.m5.getSlotAt(2,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.m5.getSlotAt(4, 0));
  }

  @Test
  public void testFourthConstructor() {
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.m6.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.m7.getSlotAt(6, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.m6.getSlotAt(2, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.m6.getSlotAt(4, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.m7.getSlotAt(6, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.m7.getSlotAt(5, 0));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSecondConstructorInvalidDimensionZero() {
    TriangleSolitaireModel b = new TriangleSolitaireModel(0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSecondConstructorInvalidDimensionNegative() {
    TriangleSolitaireModel b = new TriangleSolitaireModel(-2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testThirdConstructorInvalidEmptySlotRight() {
    TriangleSolitaireModel b = new TriangleSolitaireModel(1,0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testThirdConstructorInvalidEmptySlotDown() {
    TriangleSolitaireModel b = new TriangleSolitaireModel(5,2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFourthConstructorInvalidEmptySlotRight() {
    TriangleSolitaireModel b = new TriangleSolitaireModel(5,1,0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFourthConstructorInvalidEmptySlotDown() {
    TriangleSolitaireModel b = new TriangleSolitaireModel(7,8,3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFourthConstructorInvalidDimensionZero() {
    TriangleSolitaireModel b = new TriangleSolitaireModel(0,0,0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFourthConstructorInvalidDimensionNegative() {
    TriangleSolitaireModel b = new TriangleSolitaireModel(-3,2,2);
  }


  @Test
  public void testMove() {
    TriangleSolitaireModel m = new TriangleSolitaireModel(3, 1);
    m.move(1, 1, 3, 1);
    m.move(3, 3, 1, 1);
    String move = new String("O    \n" +
            "   O O   \n" +
            "  O O O  \n" +
            " O _ O O \n" +
            "O O O O O");
    MarbleSolitaireView v = new TriangleSolitaireTextView(m);
    assertEquals(move, v.toString());

  }

  @Test
  public void testGetScoreWorks() {
    assertEquals(14, this.m1.getScore());
    assertEquals(27, this.m3.getScore());
    TriangleSolitaireModel m = new TriangleSolitaireModel();
    m.move(2, 0, 0, 0);
    m.move(2, 2, 2, 0);
    m.move(0, 0, 2, 2);
    assertEquals(11, m.getScore());
  }

  @Test
  public void testGameOver() {
    MarbleSolitaireModel model1 = new TriangleSolitaireModel();
    model1.move(2, 0, 0, 0);
    model1.move(2, 2, 2, 0);
    model1.move(0, 0, 2, 2);
    model1.move(3, 0, 1, 0);
    model1.move(4, 2, 2, 0);
    model1.move(3, 3, 3, 1);
    assertEquals(false, model1.isGameOver());
    model1.move(1, 0, 3, 0);
    model1.move(3, 0, 3, 2);
    model1.move(4, 4, 4, 2);
    model1.move(4, 1, 4, 3);
    model1.move(2, 2, 4, 2);
    model1.move(4, 3, 4, 1);
    model1.move(4, 0, 4, 2);
    assertEquals(true, model1.isGameOver());
  }

  @Test
  public void testTriangleMove() {
    MarbleSolitaireModel model1 = new TriangleSolitaireModel();
    model1.move(2, 0, 0, 0);
    model1.move(2, 2, 2, 0);
    model1.move(0, 0, 2, 2);
    model1.move(3, 0, 1, 0);
    model1.move(4, 2, 2, 0);
    model1.move(3, 3, 3, 1);
    model1.move(1, 0, 3, 0);
    model1.move(3, 0, 3, 2);
    model1.move(4, 4, 4, 2);
    model1.move(4, 1, 4, 3);
    model1.move(2, 2, 4, 2);
    model1.move(4, 3, 4, 1);
    model1.move(4, 0, 4, 2);
    MarbleSolitaireView v = new TriangleSolitaireTextView(model1);
    assertEquals(triangleWinGame, v.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveInvalidFromBoundaries() {
    MarbleSolitaireModel m = new TriangleSolitaireModel();
    m.move(0,2, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveInvalidToBoundaries() {
    MarbleSolitaireModel m = new TriangleSolitaireModel();
    m.move(4,4, 6, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveNonEmptyTo() {
    MarbleSolitaireModel m = new TriangleSolitaireModel();
    m.move(1,1, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveEmptyFrom() {
    MarbleSolitaireModel m = new TriangleSolitaireModel();
    m.move(0, 0, 2, 2);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveEmptyMiddle() {
    MarbleSolitaireModel m = new TriangleSolitaireModel();
    m.move(2, 2, 0, 0);
    m.move(0, 0, 2, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveDiagonal() {
    MarbleSolitaireModel m = new TriangleSolitaireModel();
    m.move(2, 2, 0, 0);
    m.move(3, 1, 2, 2);
  }
}