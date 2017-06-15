package cs3500.music.model;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.sound.midi.InvalidMidiDataException;

import cs3500.music.util.CompositionBuilder;
import cs3500.music.util.MusicReader;
import cs3500.music.view.IMusicEditorView;
import cs3500.music.view.MidiView;
import cs3500.music.view.SheetMusicTextView;

/**
 * Test the midi view.
 */
public class MidiTest {

  Readable ln1;
  Readable mary;
  Readable mystery1;
  Readable mystery2;
  Readable mystery3;
  Readable zootlw;
  Readable zootzl;

  CompositionBuilder<IMusicEditorModel> build;
  MusicEditorCreater maryLittleLamb;
  MidiView view;
  IMusicEditorView textView;


  @Before
  public void init() throws InvalidMidiDataException, FileNotFoundException{
    ln1 = new FileReader("lnl.txt");
    mary = new FileReader("mary-little-lamb.txt");
    mystery1 = new FileReader("mystery-1.txt");
    build = new MusicEditorCreater.Builder();
    textView = new SheetMusicTextView();
  }

  @Test
  public void testMary() {
    maryLittleLamb = MusicReader.parseFile(mary, build));
    view = new MidiView();
    view.reloadView();
  }
}
