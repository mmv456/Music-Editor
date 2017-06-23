package cs3500.music.view;

import cs3500.music.model.ReadOnlyMusicEditorModel;

/**
 * The class for the Console View.
 * Renders into the Console.
 */
public class ConsoleView implements IView {

  ReadOnlyMusicEditorModel model;

  public ConsoleView(ReadOnlyMusicEditorModel model) {
    this.model = model;
  }

  /**
   * draws the state of the console.
   */
  public void render() {
    System.out.println(model.getState());
  }
}