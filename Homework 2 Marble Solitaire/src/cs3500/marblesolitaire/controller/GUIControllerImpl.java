package cs3500.marblesolitaire.controller;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.view.MarbleSolitaireGuiView;

public class GUIControllerImpl implements GUIController{

  private MarbleSolitaireModel model;
  private MarbleSolitaireGuiView view;

  public GUIControllerImpl(MarbleSolitaireModel model, MarbleSolitaireGuiView view) {
    this.model = model;
    this.view = view;
  }

  @Override
  public void makeMove(int x, int y) {

  }


//  @Override
//  public void makeMove(int x, int y) {
//    if (model.getSlotAt(x, y) == MarbleSolitaireModelState.SlotState.Marble) {
//
//    }
//  }
}
