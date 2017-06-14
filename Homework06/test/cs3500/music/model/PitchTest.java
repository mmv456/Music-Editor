package cs3500.music.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests for the Pitch enum class.
 */
public class PitchTest {

  // Test that makes sure the getter for stringPitch works correctly
  @Test
  public void testGetString() {
    assertEquals("C", Pitch.C.getStringPitch());
    assertEquals("C#", Pitch.Csharp.getStringPitch());
    assertEquals("D", Pitch.D.getStringPitch());
    assertEquals("D#", Pitch.Dsharp.getStringPitch());
    assertEquals("E", Pitch.E.getStringPitch());
    assertEquals("F", Pitch.F.getStringPitch());
    assertEquals("F#", Pitch.Fsharp.getStringPitch());
    assertEquals("G", Pitch.G.getStringPitch());
    assertEquals("G#", Pitch.Gsharp.getStringPitch());
    assertEquals("A", Pitch.A.getStringPitch());
    assertEquals("A#", Pitch.Asharp.getStringPitch());
    assertEquals("B", Pitch.B.getStringPitch());
  }

  // Test that makes sure the getter for valuePitch works correctly
  @Test
  public void testGetValue() {
    assertEquals(0, Pitch.C.getValuePitch());
    assertEquals(1, Pitch.Csharp.getValuePitch());
    assertEquals(2, Pitch.D.getValuePitch());
    assertEquals(3, Pitch.Dsharp.getValuePitch());
    assertEquals(4, Pitch.E.getValuePitch());
    assertEquals(5, Pitch.F.getValuePitch());
    assertEquals(6, Pitch.Fsharp.getValuePitch());
    assertEquals(7, Pitch.G.getValuePitch());
    assertEquals(8, Pitch.Gsharp.getValuePitch());
    assertEquals(9, Pitch.A.getValuePitch());
    assertEquals(10, Pitch.Asharp.getValuePitch());
    assertEquals(11, Pitch.B.getValuePitch());
  }
}