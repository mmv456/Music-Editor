package cs3500.music.view;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.List;

import cs3500.music.model.Beat;
import cs3500.music.model.Note;
import cs3500.music.model.Repeats;

/**
 * Shows the sheet music of the song and plays the output with midi.
 */
public class MidiGuiView implements IMusicEditorGuiView, IMusicEditorMidiView {

  IMusicEditorGuiView gui = new SheetMusicView();
  IMusicEditorMidiView midi = new MidiView();

  /**
   Initializes the view.
   */
  @Override
  public void initializeView(int tempo) {
    gui.initializeView(tempo);
    midi.initializeView(tempo);
  }


  /**
   * Accepts data from the controller to be rendered.
   *
   * @param beats         the beat track
   * @param headings      the note headings of every note column
   * @param numBeats      the number of beats in the editor
   * @param measureLength the measure length
   */
  @Override
  public void acceptData(List<List<Beat>> beats, List<Note> notes, List<String> headings,
      int numBeats, int measureLength, List<Repeats> repeats) {
    gui.acceptData(beats, notes, headings, numBeats, measureLength, repeats);
    midi.acceptData(beats, notes, headings, numBeats, measureLength, repeats);
  }

  /**
   * Updates the current beat.
   * @param currentBeat current beat
   */
  @Override
  public void updateCurrentBeat(int currentBeat) {
    gui.updateCurrentBeat(currentBeat);
  }

  @Override
  public void setListeners(ActionListener aListen, KeyListener keyListen,
      MouseListener mouseListen) {
    gui.setListeners(aListen, keyListen, mouseListen);
    midi.setListeners(aListen, keyListen, mouseListen);
  }

  @Override
  public boolean isPlayed() {
    return true;
  }

  /**
   * Either plays or stops the view.
   */
  @Override
  public void togglePlay() {
    midi.togglePlay();
  }

  /**
   * Goes straight to the start of the view.
   */
  @Override
  public void goToStart() {
    midi.goToStart();
    gui.goToStart();
  }

  /**
   * Goes straight to the end of the view.
   */
  @Override
  public void goToEnd() {
    midi.goToEnd();
    gui.goToEnd();
  }

  /**
   * Moves right in the view.
   */
  @Override
  public void moveRight() {
    midi.moveRight();
    gui.moveRight();
  }

  /**
   * Moves left on the view.
   */
  @Override
  public void moveLeft() {
    midi.moveLeft();
    gui.moveLeft();
  }

  @Override
  public int getCurrBeat() {
    return midi.getCurrBeat();
  }

  /**
   * Will the view repeat at the current beat?
   */
  @Override
  public void willRepeat() {
    this.midi.willRepeat();
  }

  @Override
  public String getInputString() {
    return gui.getInputString();
  }

  @Override
  public void resetFocus() {
    gui.resetFocus();
  }
}