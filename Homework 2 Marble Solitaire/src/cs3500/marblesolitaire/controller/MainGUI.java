package cs3500.marblesolitaire.controller;

import java.io.InputStreamReader;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.view.MarbleSolitaireGuiView;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.SwingGuiView;

public class MainGUI {
  public static void main(String[] args) {
    MarbleSolitaireModelState state = new EnglishSolitaireModel();
    Appendable out = System.out;
    MarbleSolitaireGuiView view = new SwingGuiView(state);
    Readable in = new InputStreamReader(System.in);


  }
}
