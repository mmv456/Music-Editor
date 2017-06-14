package cs3500.music.model;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests the model.
 */
public class ModelTest {
  private IMusicMakerModel<MusicNote> model = new MusicMakerModel();
  private MusicNote note = new MusicNote(Pitch.Csharp, 4, 4, true);
  private MusicNote note1 = new MusicNote(Pitch.G, 7, 3, true);
  private MusicNote note2 = new MusicNote(Pitch.E, 2, 4, true);
  private MusicNote note3 = new MusicNote(Pitch.D, 2, 4, true);
  private MusicNote note4 = new MusicNote(Pitch.C, 2, 4, true);
  private MusicNote note5 = new MusicNote(Pitch.E, 8, 3, true);
  private MusicNote note6 = new MusicNote(Pitch.G, 8, 3, true);
  private MusicNote note7 = new MusicNote(Pitch.G, 2, 3, true);
  private MusicNote note8 = new MusicNote(Pitch.C, 8, 4, true);
  private MusicNote note9 = new MusicNote(Pitch.D, 4, 4, true);
  private MusicNote note10 = new MusicNote(Pitch.E, 3, 4, true);
  private MusicNote note11 = new MusicNote(Pitch.G, 2, 4, true);
  private MusicNote note12 = new MusicNote(Pitch.G, 4, 4, true);

  @Test
  public void testGetNotesAtBeat() {
    ArrayList<MusicNote> temp = new ArrayList<MusicNote>();
    temp.add(note1);
    temp.add(note2);
    model.addNote(note1, 0);
    model.addNote(note2, 0);
    model.addNote(note3, 2);
    model.addNote(note4, 4);
    model.addNote(note3, 6);
    model.addNote(note1, 8);
    model.addNote(note2, 8);
    model.addNote(note2, 10);
    model.addNote(note10, 12);
    model.addNote(note6, 16);
    model.addNote(note3, 16);
    model.addNote(note3, 18);
    model.addNote(note9, 20);
    model.addNote(note7, 24);
    model.addNote(note2, 24);
    model.addNote(note11, 26);
    model.addNote(note12, 28);
    model.addNote(note6, 32);
    model.addNote(note2, 32);
    model.addNote(note3, 34);
    model.addNote(note4, 36);
    model.addNote(note3, 38);
    model.addNote(note6, 40);
    model.addNote(note2, 40);
    for (MusicNote note : model.getNotesAtBeat(8)) {
      assertTrue(model.getNotesAtBeat(8).contains(note));
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetNotesAtBeat1() {
    model.getNotesAtBeat(1);
  }

  @Test
  public void testAdd() {
    model.addNote(note, 0);
    assertEquals(model.getScore().size(), 4);
  }

  @Test
  public void testAdd1() {
    model.addNote(note, 0);
    assertEquals(model.getScore().get(0).get(0), note);
  }

  @Test(expected = IllegalArgumentException.class)
  public void add2() {
    model.addNote(note, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void add3() {
    model.addNote(null, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveNote() {
    model.addNote(note, 0);
    model.removeNote(note.makeSustained().decrementDuration(), 1);
    assertEquals(model.getScore().get(2).size(), 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemove() {
    model.removeNote(null, 0);
    model.removeNote(note, 2);
    model.addNote(note, 1);
    model.removeNote(note, 0);
  }

  @Test

  public void testEquals() {
    model.addNote(note6, 48);
    assertEquals(model.getScore().get(48).get(0), note6);
  }

  @Test
  public void testEquals1() {
    MusicNote temp = note.makeSustained().decrementDuration();
    assertEquals(temp, new MusicNote(Pitch.Csharp, 3, 4, false));
  }

  @Test
  public void testGetTempo() {
    MusicMakerModel model = new MusicMakerModel();
    assertEquals(model.getTempo(), 0);
  }



}
