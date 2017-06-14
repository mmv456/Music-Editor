package cs3500.music.model;

import java.util.Objects;


/**
 * Represents a note on a standard western musical scale.
 */
public class MusicNote {
  private Pitch pitch;
  private int duration;
  private int octave;
  private boolean head;
  private int instrument;
  private int volume;

  /**
   * Constructor for MusicNote.
   *
   * @param pitch    the pitch of the note.
   * @param duration the duration in beats of the note.
   * @param octave   the octave of the note.
   * @param head     if true the note is the start of a note being played, else the note is being
   *                 held down.
   */
  public MusicNote(Pitch pitch, int duration, int octave, boolean head) {
    if (duration < 1 || octave > 99 || octave < 0) {
      throw new IllegalArgumentException("In valid note parameters");
    } else {
      this.pitch = pitch;
      this.duration = duration;
      this.octave = octave;
      this.head = head;
    }
  }

  /**
   * Alternative constructor for MusicNotes to add compatibility with the composition builder.
   *
   * @param pitch      integer value of pitch and octave in the range [0, 127]
   * @param duration   the duration of the note in beats
   * @param head       whether or not the note is a head or sustain
   * @param instrument the instrument the note is to be played on.
   * @param volume     int value of velocity of the note in the range [0, 127]
   */
  public MusicNote(int pitch, int duration, boolean head, int instrument, int volume) {
    this.duration = duration;
    this.head = head;
    if (pitch < 0 || pitch > 127) {
      throw new IllegalArgumentException("Not a valid pitch");
    }
    this.octave = pitch / 12;
    int tempPitch = pitch % 12;
    switch (tempPitch) {
      case 0:
        this.pitch = Pitch.C;
        break;
      case 1:
        this.pitch = Pitch.Csharp;
        break;
      case 2:
        this.pitch = Pitch.D;
        break;
      case 3:
        this.pitch = Pitch.Dsharp;
        break;
      case 4:
        this.pitch = Pitch.E;
        break;
      case 5:
        this.pitch = Pitch.F;
        break;
      case 6:
        this.pitch = Pitch.Fsharp;
        break;
      case 7:
        this.pitch = Pitch.G;
        break;
      case 8:
        this.pitch = Pitch.Gsharp;
        break;
      case 9:
        this.pitch = Pitch.A;
        break;
      case 10:
        this.pitch = Pitch.Asharp;
        break;
      default: // case 11:
        this.pitch = Pitch.B;
        break;
    }
    if (instrument < 0) {
      throw new IllegalArgumentException("Not a valid instrument.");
    } else {
      this.instrument = instrument;
    }
    if (volume < 0 || volume > 127) {
      throw new IllegalArgumentException("Not a valid volume");
    }
    this.volume = volume;
  }

  /**
   * Getter for the duration of a MusicNote.
   *
   * @return duration in int.
   */
  public int getDuration() {
    int x = duration;
    return x;
  }

  /**
   * Gets the value of the octave multiplied by 12 (so no pitch values and octave values overlap).
   *
   * @return octave value * 12
   */
  public int getOctaveValue() {
    int x = octave;
    return x * 12;
  }

  /**
   * Gets the pitch's integer value.
   *
   * @return the value of the pitch as an integer
   */
  public int getPitch() {
    int x = pitch.getValuePitch();
    return x;
  }

  /**
   * Gets the volume of the note.
   *
   * @return the volume of the note.
   */
  public int getVolume() {
    int x = volume;
    return x;
  }

  /**
   * Gets the instrument value.
   *
   * @return the instrument value.
   */
  public int getInstrument() {
    int x = instrument;
    return x % 16;
  }

  /**
   * Creates a sustained note from a note.
   *
   * @return a new note with head == false.
   */
  public MusicNote makeSustained() {
    return new MusicNote(this.pitch, this.duration, this.octave, false);
  }

  /**
   * Getter for head field.
   *
   * @return true if head else false.
   */
  public boolean getHead() {
    boolean x = head;
    return x;
  }

  /**
   * Creates a new note with duration - 1 of this note.
   *
   * @return a new note with decreased duration.
   */
  public MusicNote decrementDuration() {
    return new MusicNote(this.pitch, this.duration - 1, this.octave, this.head);
  }

  /**
   * Tostring() method for notes.
   *
   * @return string.
   */
  @Override
  public String toString() {
    return this.pitch.getStringPitch();
  }

  /**
   * Overriding the equals() method.
   *
   * @param object an object to be compared
   * @return true if same object, else false.
   */
  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (!(object instanceof MusicNote)) {
      return false;
    }
    MusicNote that = (MusicNote) object;
    return this.pitch == that.pitch && this.duration == that.duration && this.octave == that.octave;
  }

  /**
   * Equals() method that ignores the duration of a note.
   *
   * @param object this object
   * @return true if same object, false otherwise.
   */
  public boolean equalsIgnoreDuration(Object object) {
    if (this == object) {
      return true;
    }
    if (!(object instanceof MusicNote)) {
      return false;
    }
    MusicNote that = (MusicNote) object;
    return this.pitch == that.pitch && this.octave == that.octave;
  }

  /**
   * Overriding hashcode.
   *
   * @return int
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.pitch, this.duration, this.octave);
  }

}