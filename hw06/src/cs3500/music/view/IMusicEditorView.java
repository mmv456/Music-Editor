package cs3500.music.view;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.List;

import cs3500.music.model.Beat;
import cs3500.music.model.Note;
import cs3500.music.model.Repeats;

/**
 * Renders a representation of the Music Editor's data.
 */
public interface IMusicEditorView {

  /**
   * Initializes the view.
   *
   * @param tempo song's tempo.
   */
  void initializeView(int tempo);

  /**
   * Renders data from the controller.
   *
   * @param beats the beat track
   * @param headings the note headings of every note column
   * @param numBeats the number of beats in the editor
   * @param measureLength the measure length
   * @param repeats repetitions in the song
   */
  void acceptData(List<List<Beat>> beats, List<Note> notes, List<String> headings,
      int numBeats, int measureLength, List<Repeats> repeats);

  /**
   * Updates the current beat.
   *
   * @param currentBeat current beat.
   */
  void updateCurrentBeat(int currentBeat);

  /**
   * Sets the listeners for the view.
   *
   * @param aListen The action listener for the buttons.
   * @param keyListen The key listener for keyboard input.
   * @param mouseListen The mouse listener for mouse input.
   */
  void setListeners(ActionListener aListen, KeyListener keyListen, MouseListener mouseListen);


  /**
   * Goes straight to the start of the view.
   */
  void goToStart();

  /**
   * Goes straight to the end of the view.
   */
  void goToEnd();

  /**
   * Moves right one measure in the view.
   */
  void moveRight();

  /**
   * Moves left one measure on the view.
   */
  void moveLeft();

  /**
   * Does the representation of the editor play music?
   *
   * @return True if it plays, false otherwise.
   */
  boolean isPlayed();
}