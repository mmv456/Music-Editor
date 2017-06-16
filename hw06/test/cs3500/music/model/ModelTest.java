package cs3500.music.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cs3500.music.model.IMusicEditorModel;
import cs3500.music.model.MusicEditorCreater;
import cs3500.music.model.Note;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertNotEquals;

/**
 * Tests the model.
 */
public class ModelTest {

  String baseEditorState =
        "    C2  C#2   D2  D#2   E2   F2  F#2   G2  G#2   A2 \n"
      + " 0                                     X            \n"
      + " 1            X                        |            \n"
      + " 2  X         |                        |            \n"
      + " 3  |         |                        |         X  \n"
      + " 4                                     |         |  \n"
      + " 5                                               |  \n"
      + " 6                                               |  \n";

  List<Note> noteList = new ArrayList<>(Arrays.asList(new Note("A", 2, 0, 4, 3, 50),
      new Note("G", 2, 0, 5, 0, 50),
      new Note("B#", 2, 0, 2, 2, 50),
      new Note("D", 2, 0, 3, 1, 50)));

  @Test
  public void testInitMusicWithValidInput() {
    IMusicEditorModel model = new MusicEditorCreater();
    model.initMusic(noteList, 4, 100);
    assertEquals(baseEditorState, model.getSheetMusic());
  }

  /* Throws IllegalArgument Exception for trying to print sheet music for an empty song */
  @Test(expected = IllegalArgumentException.class)
  public void testInitMusicWithEmptySong_GetSheetMusic_ThrowsEx() {
    IMusicEditorModel model = new MusicEditorCreater();
    model.initMusic(new ArrayList<>(), 4, 100);
    model.getSheetMusic();
    fail("No exception was thrown");
  }

  @Test
  public void testInitMusicRestartsEditor() {
    IMusicEditorModel model = new MusicEditorCreater();
    model.initMusic(noteList, 4, 100);
    List<Note> newList = new ArrayList<>(Arrays.asList(new Note("A", 2, 0, 2, 2, 50)));
    model.initMusic(newList, 4, 100);
    assertNotEquals(baseEditorState, model.getSheetMusic());
  }

  @Test
  public void testAddNote_ExistingColumnDoesNotIncreaseNumBeats() {
    IMusicEditorModel model = new MusicEditorCreater();
    model.initMusic(noteList, 4, 100);
    Note addNote = new Note("C", 2, 0, 2, 5, 50);
    model.addNote(addNote);
    String expectedEditorState =
          "    C2  C#2   D2  D#2   E2   F2  F#2   G2  G#2   A2 \n"
        + " 0                                     X            \n"
        + " 1            X                        |            \n"
        + " 2  X         |                        |            \n"
        + " 3  |         |                        |         X  \n"
        + " 4                                     |         |  \n"
        + " 5  X                                            |  \n"
        + " 6  |                                            |  \n";
    assertEquals(expectedEditorState, model.getSheetMusic());
  }

  @Test
  public void testAddNote_ExistingColumnIncreasesNumBeats() {
    IMusicEditorModel model = new MusicEditorCreater();
    model.initMusic(noteList, 4, 100);
    Note addNote = new Note("C", 2, 0, 4, 5, 50);
    model.addNote(addNote);
    String expectedEditorState =
          "    C2  C#2   D2  D#2   E2   F2  F#2   G2  G#2   A2 \n"
        + " 0                                     X            \n"
        + " 1            X                        |            \n"
        + " 2  X         |                        |            \n"
        + " 3  |         |                        |         X  \n"
        + " 4                                     |         |  \n"
        + " 5  X                                            |  \n"
        + " 6  |                                            |  \n"
        + " 7  |                                               \n"
        + " 8  |                                               \n";
    assertEquals(expectedEditorState, model.getSheetMusic());
  }

  @Test
  public void testAddNote_NewColumnDoesNotIncreaseNumBeats() {
    IMusicEditorModel model = new MusicEditorCreater();
    model.initMusic(noteList, 4, 100);
    Note addNote = new Note("C", 3, 0, 4, 3, 50);
    model.addNote(addNote);
    String expectedEditorState =
          "    C2  C#2   D2  D#2   E2   F2  F#2   G2  G#2   A2  A#2   B2   C3 \n"
        + " 0                                     X                           \n"
        + " 1            X                        |                           \n"
        + " 2  X         |                        |                           \n"
        + " 3  |         |                        |         X              X  \n"
        + " 4                                     |         |              |  \n"
        + " 5                                               |              |  \n"
        + " 6                                               |              |  \n";
    assertEquals(expectedEditorState, model.getSheetMusic());
  }

  @Test
  public void testAddNote_NewColumnIncreasesNumBeats() {
    IMusicEditorModel model = new MusicEditorCreater();
    model.initMusic(noteList, 4, 100);
    Note addNote = new Note("C", 3, 0, 4, 5, 50);
    model.addNote(addNote);
    String expectedEditorState =
          "    C2  C#2   D2  D#2   E2   F2  F#2   G2  G#2   A2  A#2   B2   C3 \n"
        + " 0                                     X                           \n"
        + " 1            X                        |                           \n"
        + " 2  X         |                        |                           \n"
        + " 3  |         |                        |         X                 \n"
        + " 4                                     |         |                 \n"
        + " 5                                               |              X  \n"
        + " 6                                               |              |  \n"
        + " 7                                                              |  \n"
        + " 8                                                              |  \n";
    assertEquals(expectedEditorState, model.getSheetMusic());
  }
}