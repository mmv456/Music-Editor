package cs3500.music.view;

import javax.sound.midi.InvalidMidiDataException;

/**
 * Interface used for all the views.
 */
public interface IView {

  /**
   * Displays/Runs the View.
   */
  void render() throws InvalidMidiDataException;
}