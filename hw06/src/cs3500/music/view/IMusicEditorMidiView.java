package cs3500.music.view;

/**
 * Interface for the Midi that extends IMusicEditorView.
 */
public interface IMusicEditorMidiView extends IMusicEditorView {

  /**
   * Either plays or stops the music.
   */
  void togglePlay();

  /**
   * Gets the current playing beat.
   * @return current playing beat.
   */
  int getCurrentBeat();

  /**
   * Will the view repeat at the current beat?.
   */
  void willRepeat();

}