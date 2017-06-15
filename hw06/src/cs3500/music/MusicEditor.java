package cs3500.music;

import cs3500.music.model.IMusicEditorModel;
import cs3500.music.model.MusicEditorCreater;
import cs3500.music.model.MusicEditorCreater.Builder;
import cs3500.music.util.MusicReader;

import cs3500.music.view.IMusicEditorView;
import cs3500.music.view.MidiGuiView;
import cs3500.music.view.MidiView;
import cs3500.music.view.SheetMusicTextView;
import cs3500.music.view.SheetMusicView;
import java.io.FileReader;
import java.io.IOException;
import javax.sound.midi.InvalidMidiDataException;


public class MusicEditor {
  /**
   * Main method running the music editor.
   *
   * @param args the arguments for the music editor
   * @throws IOException for an invalid file
   * @throws InvalidMidiDataException when midi input is invalid
   */
  public static void main(String[] args) throws IOException, InvalidMidiDataException {

    MusicEditorCreater.Builder builder = new Builder();

    IMusicEditorModel model = MusicReader.parseFile(new FileReader(args[0]), builder);
    IMusicEditorView view;
    switch (args[1]) {
      case "text":
        view = new SheetMusicTextView();
        break;
      case "gui":
        view = new SheetMusicView();
        break;
      case "midi":
        view = new MidiView();
        break;
      case "midigui":
        view = new MidiGuiView();
        break;
      default:
        throw new IllegalArgumentException("Not a valid view");
    }
  }
}