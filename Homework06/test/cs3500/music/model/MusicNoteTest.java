package cs3500.music.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


import org.junit.Test;

/**
 * Tests for the MusicNote class.
 */
public class MusicNoteTest {

  // examples of MusicNotes
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

  // initializes the MusicNotes created above
  private void initialize() {
    this.note = new MusicNote(Pitch.Csharp, 4, 4, true);
    this.note1 = new MusicNote(Pitch.G, 7, 3, true);
    this.note2 = new MusicNote(Pitch.E, 2, 4, true);
    this.note3 = new MusicNote(Pitch.D, 2, 4, true);
    this.note4 = new MusicNote(Pitch.C, 2, 4, true);
    this.note5 = new MusicNote(Pitch.E, 8, 3, true);
    this.note6 = new MusicNote(Pitch.G, 8, 3, true);
    this.note7 = new MusicNote(Pitch.G, 2, 3, true);
    this.note8 = new MusicNote(Pitch.C, 8, 4, true);
    this.note9 = new MusicNote(Pitch.D, 4, 4, true);
    this.note10 = new MusicNote(Pitch.E, 3, 4, true);
    this.note11 = new MusicNote(Pitch.G, 2, 4, true);
    this.note12 = new MusicNote(Pitch.G, 4, 4, true);
  }

  // tests the getDuration() method
  @Test
  public void testGetDuration() {
    initialize();
    assertEquals(4, note.getDuration());
    assertEquals(7, note1.getDuration());
    assertEquals(2, note2.getDuration());
    assertEquals(2, note3.getDuration());
    assertEquals(2, note4.getDuration());
    assertEquals(8, note5.getDuration());
    assertEquals(8, note6.getDuration());
    assertEquals(2, note7.getDuration());
    assertEquals(8, note8.getDuration());
    assertEquals(4, note9.getDuration());
    assertEquals(3, note10.getDuration());
    assertEquals(2, note11.getDuration());
    assertEquals(4, note12.getDuration());
  }

  // tests the getOctaveValue() method
  @Test
  public void testGetOctaveValue() {
    initialize();
    assertEquals(48, note.getOctaveValue());
    assertEquals(36, note1.getOctaveValue());
    assertEquals(48, note2.getOctaveValue());
    assertEquals(48, note3.getOctaveValue());
    assertEquals(48, note4.getOctaveValue());
    assertEquals(36, note5.getOctaveValue());
    assertEquals(36, note6.getOctaveValue());
    assertEquals(36, note7.getOctaveValue());
    assertEquals(48, note8.getOctaveValue());
    assertEquals(48, note9.getOctaveValue());
    assertEquals(48, note10.getOctaveValue());
    assertEquals(48, note11.getOctaveValue());
    assertEquals(48, note12.getOctaveValue());
  }

  // tests the getPitch() method
  @Test
  public void testGetPitch() {
    initialize();
    assertEquals(1, note.getPitch());
    assertEquals(7, note1.getPitch());
    assertEquals(4, note2.getPitch());
    assertEquals(2, note3.getPitch());
    assertEquals(0, note4.getPitch());
    assertEquals(4, note5.getPitch());
    assertEquals(7, note6.getPitch());
    assertEquals(7, note7.getPitch());
    assertEquals(0, note8.getPitch());
    assertEquals(2, note9.getPitch());
    assertEquals(4, note10.getPitch());
    assertEquals(7, note11.getPitch());
    assertEquals(7, note12.getPitch());
  }

  // tests the getVolume() method
  @Test
  public void testGetVolume() {
    initialize();
    assertEquals(0, note.getVolume());
    assertEquals(0, note1.getVolume());
    assertEquals(0, note2.getVolume());
    assertEquals(0, note3.getVolume());
    assertEquals(0, note4.getVolume());
    assertEquals(0, note5.getVolume());
    assertEquals(0, note6.getVolume());
    assertEquals(0, note7.getVolume());
    assertEquals(0, note8.getVolume());
    assertEquals(0, note9.getVolume());
    assertEquals(0, note10.getVolume());
    assertEquals(0, note11.getVolume());
    assertEquals(0, note12.getVolume());
  }

  // tests the getInstrument() method
  @Test
  public void testGetInstrument() {
    initialize();
    assertEquals(0, note.getVolume());
    assertEquals(0, note1.getVolume());
    assertEquals(0, note2.getVolume());
    assertEquals(0, note3.getVolume());
    assertEquals(0, note4.getVolume());
    assertEquals(0, note5.getVolume());
    assertEquals(0, note6.getVolume());
    assertEquals(0, note7.getVolume());
    assertEquals(0, note8.getVolume());
    assertEquals(0, note9.getVolume());
    assertEquals(0, note10.getVolume());
    assertEquals(0, note11.getVolume());
    assertEquals(0, note12.getVolume());
  }

  // tests the makeSustained() method
  @Test
  public void testMakeSustained() {
    initialize();
    assertEquals(new MusicNote(Pitch.Csharp, 4, 4, false), note.makeSustained());
    assertEquals(new MusicNote(Pitch.G, 7, 3, false), note1.makeSustained());
    assertEquals(new MusicNote(Pitch.E, 2, 4, false), note2.makeSustained());
    assertEquals(new MusicNote(Pitch.D, 2, 4, false), note3.makeSustained());
    assertEquals(new MusicNote(Pitch.C, 2, 4, false), note4.makeSustained());
    assertEquals(new MusicNote(Pitch.E, 8, 3, false), note5.makeSustained());
    assertEquals(new MusicNote(Pitch.G, 8, 3, false), note6.makeSustained());
    assertEquals(new MusicNote(Pitch.G, 2, 3, false), note7.makeSustained());
    assertEquals(new MusicNote(Pitch.C, 8, 4, false), note8.makeSustained());
    assertEquals(new MusicNote(Pitch.D, 4, 4, false), note9.makeSustained());
    assertEquals(new MusicNote(Pitch.E, 3, 4, false), note10.makeSustained());
    assertEquals(new MusicNote(Pitch.G, 2, 4, false), note11.makeSustained());
    assertEquals(new MusicNote(Pitch.G, 4, 4, false), note12.makeSustained());
  }

  // tests the getHead() method
  @Test
  public void testGetHead() {
    initialize();
    assertTrue(note.getHead());
    assertTrue(note1.getHead());
    assertTrue(note2.getHead());
    assertTrue(note3.getHead());
    assertTrue(note4.getHead());
    assertTrue(note5.getHead());
    assertTrue(note6.getHead());
    assertTrue(note7.getHead());
    assertTrue(note8.getHead());
    assertTrue(note9.getHead());
    assertTrue(note10.getHead());
    assertTrue(note11.getHead());
    assertTrue(note12.getHead());

    // Make them all sustained notes
    note = note.makeSustained();
    note1 = note1.makeSustained();
    note2 = note2.makeSustained();
    note3 = note3.makeSustained();
    note4 = note4.makeSustained();
    note5 = note5.makeSustained();
    note6 = note6.makeSustained();
    note7 = note7.makeSustained();
    note8 = note8.makeSustained();
    note9 = note9.makeSustained();
    note10 = note10.makeSustained();
    note11 = note11.makeSustained();
    note12 = note12.makeSustained();

    // now check that getting the head for all of these MusicNotes equals false, now that you've
    // made them sustained MusicNotes
    assertFalse(note.getHead());
    assertFalse(note1.getHead());
    assertFalse(note2.getHead());
    assertFalse(note3.getHead());
    assertFalse(note4.getHead());
    assertFalse(note5.getHead());
    assertFalse(note6.getHead());
    assertFalse(note7.getHead());
    assertFalse(note8.getHead());
    assertFalse(note9.getHead());
    assertFalse(note10.getHead());
    assertFalse(note11.getHead());
    assertFalse(note12.getHead());
  }

  // tests the decrementDuration() method
  @Test
  public void testDecrementDuration() {
    initialize();

    assertEquals(4, note.getDuration());
    assertEquals(7, note1.getDuration());
    assertEquals(2, note2.getDuration());
    assertEquals(2, note3.getDuration());
    assertEquals(2, note4.getDuration());
    assertEquals(8, note5.getDuration());
    assertEquals(8, note6.getDuration());
    assertEquals(2, note7.getDuration());
    assertEquals(8, note8.getDuration());
    assertEquals(4, note9.getDuration());
    assertEquals(3, note10.getDuration());
    assertEquals(2, note11.getDuration());
    assertEquals(4, note12.getDuration());


    note = note.decrementDuration();
    note1 = note1.decrementDuration();
    note2 = note2.decrementDuration();
    note3 = note3.decrementDuration();
    note4 = note4.decrementDuration();
    note5 = note5.decrementDuration();
    note6 = note6.decrementDuration();
    note7 = note7.decrementDuration();
    note8 = note8.decrementDuration();
    note9 = note9.decrementDuration();
    note10 = note10.decrementDuration();
    note11 = note11.decrementDuration();
    note12 = note12.decrementDuration();


    assertEquals(3, note.getDuration());
    assertEquals(6, note1.getDuration());
    assertEquals(1, note2.getDuration());
    assertEquals(1, note3.getDuration());
    assertEquals(1, note4.getDuration());
    assertEquals(7, note5.getDuration());
    assertEquals(7, note6.getDuration());
    assertEquals(1, note7.getDuration());
    assertEquals(7, note8.getDuration());
    assertEquals(3, note9.getDuration());
    assertEquals(2, note10.getDuration());
    assertEquals(1, note11.getDuration());
    assertEquals(3, note12.getDuration());
  }
}