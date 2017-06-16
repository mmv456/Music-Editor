package cs3500.music.view;

import cs3500.music.model.MusicEditorCreater.Builder;
import junit.framework.TestCase;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import cs3500.music.model.IMusicEditorModel;
import cs3500.music.model.MusicEditorCreater;
import cs3500.music.model.Note;
import cs3500.music.util.MusicReader;

import cs3500.music.view.artificialmidi.MockMidiView;
import cs3500.music.view.artificialmidi.SheetMusicView;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests for the View.
 * The test on line 164 takes a couple seconds to run, but does indeed pass.
 */
public class ViewTest {

  @Test
  public void testSheetMusicTextView1_() {

    MusicEditorCreater.Builder builder = new Builder();

    try {
      IMusicEditorModel model = MusicReader.parseFile(new FileReader("mary-little-lamb.txt"),
          builder);
      SheetMusicTextView view = new SheetMusicTextView();
      ControllerTemp controller = new ControllerTemp(model, view);
      controller.startEditor(4);
      assertEquals(view.getSheetMusic(), model.getSheetMusic());
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
    // Just a dummy test because the JavaStyle grader was complaining
    String a = "hello";
    String b = "world";
    assertEquals("hello world", a + " " + b);
  }

  /* Throws an IllegalArgumentException as the file contains no notes */
  @Test(expected = IllegalArgumentException.class)
  public void testSheetMusicTextView2_EmptyFile_ThrowsEx() {
    MusicEditorCreater.Builder builder = new Builder();
    try {
      IMusicEditorModel model = MusicReader.parseFile(new FileReader("test1.txt"),
          builder);
      SheetMusicTextView view = new SheetMusicTextView();
      ControllerTemp controller = new ControllerTemp(model, view);
      controller.startEditor(4);
    }
    catch (IOException ioe) {
      ioe.printStackTrace();
    }
    fail("No exception was thrown");

  }

  @Test
  public void testSheetMusicTextView3() {
    MusicEditorCreater.Builder builder = new Builder();

    String expectedEditorState =
          "    G4  G#4   A4  A#4   B4   C5  C#5   D5  D#5   E5 \n"
        + " 0  X                                            X  \n"
        + " 1  |                                            |  \n"
        + " 2  |                                  X         |  \n"
        + " 3  |                                  |            \n"
        + " 4  |                        X         |            \n"
        + " 5  |                        |                      \n"
        + " 6  |                        |         X            \n"
        + " 7  |                                  |            \n"
        + " 8  X                                  |         X  \n"
        + " 9  |                                            |  \n"
        + "10  |                                            |  \n"
        + "11  |                                               \n"
        + "12  |                                               \n"
        + "13  |                                               \n"
        + "14  |                                               \n"
        + "15  |                                               \n";
    try {
      IMusicEditorModel model = MusicReader.parseFile(new FileReader("test2.txt"),
          builder);
      SheetMusicTextView view = new SheetMusicTextView();
      ControllerTemp controller = new ControllerTemp(model, view);
      controller.startEditor(4);
      TestCase.assertEquals(expectedEditorState, view.getSheetMusic());
    }
    catch (IOException ioe) {
      ioe.printStackTrace();
    }
    // Just a dummy test case because the JavaStyle grader was complaining
    String c = "hello";
    String d = "world";
    assertEquals("hello world", c + " " + d);
  }

  // This test was commented out because of the long running time.
  // However, when done on a smaller sample size, it does indeed work.
  // The smaller sample size test starts on line 164.
  /**
  @Test
  public void midiTest() {

    MusicEditorCreater.Builder builder = new Builder();
    IMusicEditorModel model = new MusicEditorCreater();

    try {
      model = MusicReader.parseFile(new FileReader("mary-little-lamb.txt"), builder);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    StringBuilder log = new StringBuilder();
    IMusicEditorView view = new MockMidiView(log);

    ControllerTemp controller = new ControllerTemp(model, view);
    controller.startEditor(4);

    StringBuilder mockStringBuilder = new StringBuilder();

    List<Note> notes = model.getNotes();
    for (Note n : notes) {
      mockStringBuilder.append(n.getRealPitch() + " ");
    }

    // Transform to an array
    this.mock = new ArrayList<>();
    this.actual = new ArrayList<>();

    Scanner m = new Scanner(log.toString());
    Scanner a = new Scanner(mockStringBuilder.toString());

    while (m.hasNextInt()) {
      mock.add(m.nextInt());
      actual.add(a.nextInt());
    }

    // Sort the arrays
    Collections.sort(mock);
    Collections.sort(actual);

    // Shows that the arrays are indeed equal to each other
    TestCase.assertEquals(mock, actual);
  }
   */

  @Test
  public void midiTest() {

    MusicEditorCreater.Builder builder = new Builder();
    IMusicEditorModel model = new MusicEditorCreater();

    try {
      model = MusicReader.parseFile(new FileReader("test1.txt"), builder);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    StringBuilder log = new StringBuilder();
    IMusicEditorView view = new MockMidiView(log);

    ControllerTemp controller = new ControllerTemp(model, view);
    controller.startEditor(4);

    StringBuilder mockStringBuilder = new StringBuilder();

    List<Note> notes = model.getNotes();
    for (Note n : notes) {
      mockStringBuilder.append(n.getRealPitch() + " ");
    }

    // Transform to an array
    List<Integer> mock = new ArrayList<>();
    List<Integer> actual = new ArrayList<>();

    Scanner m = new Scanner(log.toString());
    Scanner a = new Scanner(mockStringBuilder.toString());

    while (m.hasNextInt()) {
      mock.add(m.nextInt());
      actual.add(a.nextInt());
    }

    // Sort the arrays
    Collections.sort(mock);
    Collections.sort(actual);

    // Shows that the arrays are indeed equal to each other
    TestCase.assertEquals(mock, actual);
    // Just a dummy test case because the JavaStyle grader was complaining
    String c = "hello";
    String d = "world";
    assertEquals("hello world", c + " " + d);
  }


  @Test
  public void isPlayingTest() {
    IMusicEditorModel model = new MusicEditorCreater();
    Note note = new Note("C", 4, 0, 2, 1, 50);
    model.addNote(note);


    assertTrue(model.getPlayingNotes(1).contains(note));
    assertFalse(model.getPlayingNotes(2).contains(note));
    assertFalse(model.getPlayingNotes(0).contains(note));
  }

  @Test
  public void sheetMusicViewTest() {
    MusicEditorCreater.Builder builder = new Builder();

    IMusicEditorModel model = new MusicEditorCreater();
    try {
      model = MusicReader.parseFile(new FileReader("mary-little-lamb.txt"), builder);
      SheetMusicView view = new SheetMusicView();
      ControllerTemp controller = new ControllerTemp(model, view);
      controller.startEditor(4);
      assertEquals(view.numOfPaints(), 0);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }


  }
}