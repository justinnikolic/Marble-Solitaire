package cs3500.marblesolitaire.controller;

import java.io.IOException;


/**
 * This class represents a fake appendable used for testing.
 */
public class FakeTestAppendable implements Appendable {
  @Override
  public Appendable append(CharSequence csq) throws IOException {
    throw new IOException("Cannot transmit.");
  }

  @Override
  public Appendable append(CharSequence csq, int start, int end) throws IOException {
    throw new IOException("Cannot transmit.");
  }

  @Override
  public Appendable append(char c) throws IOException {
    throw new IOException("Cannot transmit.");
  }
}
