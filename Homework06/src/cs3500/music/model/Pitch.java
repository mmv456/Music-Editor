package cs3500.music.model;


/**
 * Represents the pitch of a note as denoted by a letter as per musical standard, some of which
 * may have "sharp" accidentals tacked on them as well.
 * contains methods the return relevant values from Pitches.
 */
public enum Pitch {
  C("C", 0), Csharp("C#", 1), D("D", 2), Dsharp("D#", 3), E("E", 4), F("F", 5), Fsharp("F#", 6),
  G("G", 7), Gsharp("G#", 8), A("A", 9), Asharp("A#", 10), B("B", 11);

  final String stringPitch;
  final int valuePitch;

  /**
   * a pitch is a string value and an int value.
   *
   * @param stringPitch the pitch value in string form
   * @param valuePitch the pitch value in int form
   */
  Pitch(String stringPitch, int valuePitch) {
    this.stringPitch = stringPitch;
    this.valuePitch = valuePitch;
  }

  /**
   * getter for stringPitch.
   *
   * @return the stringPitch
   */
  public String getStringPitch() {
    return stringPitch;
  }

  /**
   * getter for valuePitch.
   *
   * @return valuePitch
   */
  public int getValuePitch() {
    return valuePitch;
  }

}