package cs3500.marblesolitaire.controller;

import org.junit.Before;
import org.junit.Test;

import java.io.Reader;
import java.io.StringReader;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MockModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;


/**
 * This is the testing class for the MarbleSolitaireController implementation.
 */
public class MarbleSolitaireControllerImplTest {

  StringBuilder out;
  StringBuilder outNull;
  MarbleSolitaireModel model;
  MarbleSolitaireModel modelNull;
  MarbleSolitaireView view;
  MarbleSolitaireView viewNull;
  Reader in;
  Reader inNull;


  @Before
  public void init() {
    this.out = new StringBuilder();
    this.model = new EnglishSolitaireModel();
    this.view = new MarbleSolitaireTextView(model, out);
    this.viewNull = null;
    this.modelNull = null;
    this.in = new StringReader("1");
    this.inNull = null;


  }


  @Test(expected = IllegalArgumentException.class)
  public void testControllerConsNullModel() {
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(modelNull, view, in);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testControllerConsNullView() {
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, viewNull, in);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testControllerConsNullIn() {
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, inNull);
  }

  @Test
  public void testTwoMoves() {
    StringBuilder out = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    Reader in = new StringReader("6 4 4 4 3 4 5 4 q");

    MarbleSolitaireController controlla = new MarbleSolitaireControllerImpl(model, view, in);
    controlla.playGame();

    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "    O _ O\n"
            + "    O O O\n"
            + "Score: 31\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O _ O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O _ O\n"
            + "    O O O\n"
            + "Score: 30\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O _ O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O _ O\n"
            + "    O O O\n"
            + "Score: 30", out.toString());
  }


  @Test
  public void testGameOverLost() {
    StringBuilder out = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    Reader in = new StringReader("6 4 4 4 3 4 5 4 1 4 3 4 4 2 4 4 4 5 4 3 4 7 4 5 q");

    MarbleSolitaireController controlla = new MarbleSolitaireControllerImpl(model, view, in);
    controlla.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O _ O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 30\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 29\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 28\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "O _ O _ _ O O\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 27\n" +
            "Game over!\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "O _ O _ O _ _\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 26", out.toString());
  }

  @Test
  public void testGameOverWon() {
    StringBuilder out = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    Reader in = new StringReader("2 4 4 4 3 2 3 4 1 3 3 3 4 3 2 3 1 5 1 3 1 3 3 3 6 3" +
            " 4 3 5 1 5 3 5 4 5 2 3 1 5 1 5 1 5 3 5 6 5 4 7 5 5 5 4 5 6 5 7 3 7 5 7 5 5 5 2 5 4" +
            " 5 3 7 3 5 3 4 3 6 5 7 3 7 3 7 3 5 5 4 5 2 5 2 3 2 3 2 3 4 3 4 3 6 3 6 5 6 5 6 5 4" +
            " 4 4 4 6 6 4 4 4 4 3 4 5 4 6 4 4 q");

    MarbleSolitaireController controlla = new MarbleSolitaireControllerImpl(model, view, in);
    controlla.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 30\n" +
            "    _ O O\n" +
            "    _ _ O\n" +
            "O _ O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 29\n" +
            "    _ O O\n" +
            "    O _ O\n" +
            "O _ _ O O O O\n" +
            "O O _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 28\n" +
            "    O _ _\n" +
            "    O _ O\n" +
            "O _ _ O O O O\n" +
            "O O _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 27\n" +
            "    _ _ _\n" +
            "    _ _ O\n" +
            "O _ O O O O O\n" +
            "O O _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 26\n" +
            "    _ _ _\n" +
            "    _ _ O\n" +
            "O _ O O O O O\n" +
            "O O O O O O O\n" +
            "O O _ O O O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 25\n" +
            "    _ _ _\n" +
            "    _ _ O\n" +
            "O _ O O O O O\n" +
            "O O O O O O O\n" +
            "_ _ O O O O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 24\n" +
            "    _ _ _\n" +
            "    _ _ O\n" +
            "O _ O O O O O\n" +
            "O O O O O O O\n" +
            "_ O _ _ O O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 23\n" +
            "    _ _ _\n" +
            "    _ _ O\n" +
            "_ _ O O O O O\n" +
            "_ O O O O O O\n" +
            "O O _ _ O O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 22\n" +
            "    _ _ _\n" +
            "    _ _ O\n" +
            "_ _ O O O O O\n" +
            "_ O O O O O O\n" +
            "_ _ O _ O O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 21\n" +
            "    _ _ _\n" +
            "    _ _ O\n" +
            "_ _ O O O O O\n" +
            "_ O O O O O O\n" +
            "_ _ O O _ _ O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 20\n" +
            "    _ _ _\n" +
            "    _ _ O\n" +
            "_ _ O O O O O\n" +
            "_ O O O O O O\n" +
            "_ _ O O O _ O\n" +
            "    _ O _\n" +
            "    O O _\n" +
            "Score: 19\n" +
            "    _ _ _\n" +
            "    _ _ O\n" +
            "_ _ O O O O O\n" +
            "_ O O O _ O O\n" +
            "_ _ O O _ _ O\n" +
            "    _ O O\n" +
            "    O O _\n" +
            "Score: 18\n" +
            "    _ _ _\n" +
            "    _ _ O\n" +
            "_ _ O O O O O\n" +
            "_ O O O _ O O\n" +
            "_ _ O O _ _ O\n" +
            "    _ O O\n" +
            "    _ _ O\n" +
            "Score: 17\n" +
            "    _ _ _\n" +
            "    _ _ O\n" +
            "_ _ O O O O O\n" +
            "_ O O O _ O O\n" +
            "_ _ O O O _ O\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 16\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ O O _ O O\n" +
            "_ O O O O O O\n" +
            "_ _ O O O _ O\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 15\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ O O O _ _\n" +
            "_ O O O O O O\n" +
            "_ _ O O O _ O\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 14\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ O _ _ O _\n" +
            "_ O O O O O O\n" +
            "_ _ O O O _ O\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 13\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ O _ _ O O\n" +
            "_ O O O O O _\n" +
            "_ _ O O O _ _\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 12\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ O _ O _ _\n" +
            "_ O O O O O _\n" +
            "_ _ O O O _ _\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 11\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ O _ O _ _\n" +
            "_ O O O O O _\n" +
            "_ O _ _ O _ _\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 10\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ O O _ O _ _\n" +
            "_ _ O O O O _\n" +
            "_ _ _ _ O _ _\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 9\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ O O _ _\n" +
            "_ _ O O O O _\n" +
            "_ _ _ _ O _ _\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 8\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ O _\n" +
            "_ _ O O O O _\n" +
            "_ _ _ _ O _ _\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 7\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ O O O _ _\n" +
            "_ _ _ _ O O _\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 6\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ O O O _ _\n" +
            "_ _ _ O _ _ _\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 5\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ O _ _ O _\n" +
            "_ _ _ O _ _ _\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 4\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ O O _ O _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 3\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ O O _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 2\n" +
            "Game over!\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 1", out.toString());
  }

  @Test
  public void testGameQuitAfter4Inputs() {
    StringBuilder out = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    Reader in = new StringReader("6 4 4 4 q");

    MarbleSolitaireController controlla = new MarbleSolitaireControllerImpl(model, view, in);
    controlla.playGame();
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "    O _ O\n"
            + "    O O O\n"
            + "Score: 31\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "    O _ O\n"
            + "    O O O\n"
            + "Score: 31", out.toString());
  }

  @Test
  public void testGameQuitAfter2Inputs() {
    StringBuilder out = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    Reader in = new StringReader("6 4 q 4 4");

    MarbleSolitaireController controlla = new MarbleSolitaireControllerImpl(model, view, in);
    controlla.playGame();
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32", out.toString());
  }

  @Test
  public void testGameQuitAfter1Input() {
    StringBuilder out = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    Reader in = new StringReader("5 q 3 3 3");

    MarbleSolitaireController controlla = new MarbleSolitaireControllerImpl(model, view, in);
    controlla.playGame();
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32", out.toString());
  }

  @Test
  public void testGameQuitAfter3Input() {
    StringBuilder out = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    Reader in = new StringReader("5 3 3 q 3");

    MarbleSolitaireController controlla = new MarbleSolitaireControllerImpl(model, view, in);
    controlla.playGame();
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32", out.toString());
  }

  @Test
  public void testGameQuitFirstInput() {
    StringBuilder out = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    Reader in = new StringReader("q 5 3 3 3");

    MarbleSolitaireController controlla = new MarbleSolitaireControllerImpl(model, view, in);
    controlla.playGame();
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32", out.toString());
  }

  @Test
  public void testBadInputs() {
    StringBuilder out = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    Reader in = new StringReader("6 yes 4 Z b 4 haha 4 q");

    MarbleSolitaireController controlla = new MarbleSolitaireControllerImpl(model, view, in);
    controlla.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31", out.toString());
  }

  @Test
  public void testNormalMoveThenInvalidMoveThenNormalMove() {
    StringBuilder out = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    Reader in = new StringReader("6 4 4 4 2 3 1 3 5 6 5 4 q");

    MarbleSolitaireController controlla = new MarbleSolitaireControllerImpl(model, view, in);
    controlla.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Invalid move. Play again.\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 30\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 30", out.toString());
  }

  @Test
  public void testInvalidMoveThenNormalMove() {
    StringBuilder out = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    Reader in = new StringReader("5 3 3 3 6 4 4 4 q");

    MarbleSolitaireController controlla = new MarbleSolitaireControllerImpl(model, view, in);
    controlla.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Invalid move. Play again.\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31", out.toString());
  }

  @Test
  public void testNormalMoveThenInvalidMove() {
    StringBuilder out = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    Reader in = new StringReader("6 4 4 4 1 2 3 4 q");

    MarbleSolitaireController controlla = new MarbleSolitaireControllerImpl(model, view, in);
    controlla.playGame();
    assertEquals("O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Invalid move. Play again.\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31", out.toString());
  }

  @Test
  public void testMockModel() {
    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel model = new MockModel(log);
    MarbleSolitaireView view = new MarbleSolitaireTextView(model);
    Reader in = new StringReader("5 3 3 3");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("fromRow = 5, fromCol = 3, toRow = 3, toCol = 3", log.toString());
  }
}