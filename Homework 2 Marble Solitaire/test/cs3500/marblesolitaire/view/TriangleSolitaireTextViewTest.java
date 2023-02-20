package cs3500.marblesolitaire.view;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import cs3500.marblesolitaire.controller.FakeTestAppendable;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;

import static java.lang.System.out;
import static org.junit.Assert.assertEquals;

/**
 * This class represents the testing for TriangleSolitaireTextView.
 */
public class TriangleSolitaireTextViewTest {
  MarbleSolitaireModel model1;

  MarbleSolitaireModel model2;
  MarbleSolitaireModel model3;
  MarbleSolitaireModel model4;
  MarbleSolitaireModel model5;
  MarbleSolitaireModel model6;
  MarbleSolitaireModel model7;
  TriangleSolitaireModel model8;
  String triangleWinGame;

  String triangleDefault;
  String armThreeEmptyCorner;

  MarbleSolitaireView view1;
  MarbleSolitaireView view2;
  MarbleSolitaireView view3;
  MarbleSolitaireView view4;


  @Before
  public void setup() {
    // const1
    model1 = new TriangleSolitaireModel();
    // const2 correct (sRow, sCol)
    model2 = new TriangleSolitaireModel(3, 3);
    // const2 incorrect
    model3 = new TriangleSolitaireModel(2, 0);
    // const3 correct (armThickness, sRow, sCol)
    model4 = new TriangleSolitaireModel(5, 0, 0);
    // const4 correct (armThickness)
    model6 = new TriangleSolitaireModel(3);
    // const4 incorrect
    model7 = new TriangleSolitaireModel(5);


    armThreeEmptyCorner = ("    O O _\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O");

    this.view1 = new TriangleSolitaireTextView(model4, out);
    this.view2 = new TriangleSolitaireTextView(model1, out);

    triangleDefault = new String(" _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O");

  }

  /**
   * This represents a test for the view, with an English Solitaire model object and
   * a marble solitaire text view object.
   */
  public TriangleSolitaireTextViewTest() {
    this.model1 = new EnglishSolitaireModel();
    this.triangleWinGame = new String("     _\n" +
            "   _ _\n" +
            "  _ _ _\n" +
            " _ _ _ _\n" +
            "_ _ O _ _");

  }

  @Test
  public void testToString() {
    MarbleSolitaireViewTest test = new MarbleSolitaireViewTest();
    assertEquals(triangleDefault, this.view1.toString());
  }

  @Test
  public void testRenderBoard() throws IOException {
    MarbleSolitaireModel model = new TriangleSolitaireModel();
    MarbleSolitaireView view = new TriangleSolitaireTextView(model);
    Appendable out = new StringBuilder();
    String board = "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O";

    view.renderBoard();
    assertEquals(board, out.toString());
  }

  @Test
  public void testRenderMessage() throws IOException {
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model);
    Appendable out = new StringBuilder();
    String message = "Checking the message";

    assertEquals(message, out.toString());
  }

  @Test(expected = IOException.class)
  public void testRenderBoardException() {
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model);
    Appendable out = new FakeTestAppendable();
  }



}