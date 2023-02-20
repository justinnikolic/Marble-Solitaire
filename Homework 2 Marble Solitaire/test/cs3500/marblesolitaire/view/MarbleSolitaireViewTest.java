package cs3500.marblesolitaire.view;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import cs3500.marblesolitaire.controller.FakeTestAppendable;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

import static java.lang.System.out;
import static org.junit.Assert.assertEquals;

/**
 * This class represents testing for MarbleSolitaireView.
 */
public class MarbleSolitaireViewTest {

  MarbleSolitaireModel model1;

  MarbleSolitaireModel model2;
  MarbleSolitaireModel model3;
  MarbleSolitaireModel model4;
  MarbleSolitaireModel model5;
  MarbleSolitaireModel model6;
  MarbleSolitaireModel model7;
  EnglishSolitaireModel model8;
  EnglishSolitaireModel model9;
  EnglishSolitaireModel model10;
  String armThree;
  String armThreeEmptyCorner;

  MarbleSolitaireView view1;
  MarbleSolitaireView view2;
  MarbleSolitaireView view3;
  MarbleSolitaireView view4;


  @Before
  public void setup() {
    // const1
    model1 = new EnglishSolitaireModel();
    // const2 correct (sRow, sCol)
    model2 = new EnglishSolitaireModel(3, 3);
    // const2 incorrect
    model3 = new EnglishSolitaireModel(0, 2);
    // const3 correct (armThickness, sRow, sCol)
    model4 = new EnglishSolitaireModel(3, 3, 3);
    // const3 incorrect
    model5 = new EnglishSolitaireModel(3, 5, 3);
    // const4 correct (armThickness)
    model6 = new EnglishSolitaireModel(3);
    // const4 incorrect
    model7 = new EnglishSolitaireModel(5);
    model8 = new EnglishSolitaireModel(3, 0, 4);

    armThree = ("    O O O\n" +
                "    O O O\n" +
                                  "O O O O O O O\n" +
                                  "O O O _ O O O\n" +
                                  "O O O O O O O\n" +
                                  "    O O O\n" +
                                  "    O O O");
    armThreeEmptyCorner = ("    O O _\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O");

    this.view1 = new MarbleSolitaireTextView(model4, out);
    this.view2 = new MarbleSolitaireTextView(model8, out);

  }

  /**
   * This represents a test for the view, with an English Solitaire model object and
   * a marble solitaire text view object.
   */
  public MarbleSolitaireViewTest() {
    this.model1 = new EnglishSolitaireModel();
    this.model8 = new EnglishSolitaireModel(3, 0, 4);
    this.view1 = new MarbleSolitaireTextView(this.model1, out);
    this.view2 = new MarbleSolitaireTextView(this.model8, out);

  }

  @Test
  public void testToString() {
    MarbleSolitaireViewTest test = new MarbleSolitaireViewTest();
    assertEquals(armThree, this.view1.toString());
    assertEquals(armThreeEmptyCorner,this.view2.toString());
  }

  @Test
  public void testRenderBoard() throws IOException {
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model);
    Appendable out = new StringBuilder();
    String board = "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32\n";

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