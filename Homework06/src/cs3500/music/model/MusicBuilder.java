package cs3500.music.model;

import java.util.ArrayList;

/**
 * Composition builder for MusicMakerModel.
 * Constructs a music builder for parametrized over the MusicMakerModel type.
 * Contains methods that build a music piece from input.
 */
public final class MusicBuilder implements CompositionBuilder<MusicMakerModel> {
  private ArrayList<ArrayList<MusicNote>> score = new ArrayList<>();
  private int tempo;

  @Override
  public MusicMakerModel build() {
    return new MusicMakerModel(score, tempo);
  }

  @Override
  public CompositionBuilder<MusicMakerModel> setTempo(int tempo) {
    this.tempo = tempo;
    return this;
  }

  @Override
  public CompositionBuilder<MusicMakerModel> addNote(int start, int end,
      int instrument, int pitch, int volume) {
    if (pitch > 127) {
      throw new IllegalArgumentException("Not a valid pitch");
    }
    if (start < 0) {
      throw new IllegalArgumentException("Not a valid beat");
    }
    if (score.size() < (start + (end - start))) {
      int x = start + (end - start);
      while (score.size() < x) {
        score.add(new ArrayList<MusicNote>());
      }
    }
    MusicNote temp = new MusicNote(pitch, (end - start), true, instrument, volume);
    score.get(start).add(temp);
    for (int ii = 1; ii < temp.getDuration(); ii++) {
      score.get(start + ii).add(temp.makeSustained().decrementDuration());
    }
    return this;
  }
}