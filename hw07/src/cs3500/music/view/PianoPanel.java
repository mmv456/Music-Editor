package cs3500.music.view;

import java.awt.*;

import java.util.ArrayList;

import java.util.List;

import java.util.Map;

import java.util.TreeMap;
import javax.swing.*;

import cs3500.music.model.Note;
import cs3500.music.model.Pitch;


/**
 * Represents the region where the keys of the piano are drawn.
 */
public class PianoPanel extends JPanel {
  private final int WHITE_KEY_LENGTH = 300;
  private final int BLACK_KEY_LENGTH = 130;
  private final int WHITE_KEY_WIDTH = 20;
  private final int BLACK_KEY_WIDTH = (WHITE_KEY_WIDTH / 2);
  private final Color WHITE_KEY_DISPLAY_COLOR = Color.YELLOW;
  private final Color BLACK_KEY_DISPLAY_COLOR = Color.ORANGE;

  private List<Note> noteRange = new ArrayList<>();
  private Map<Integer, List<String>> noteMap = new TreeMap<>();
  private ArrayList<Integer> naturalNotes = new ArrayList<>();
  private ArrayList<Integer> sharpNotes = new ArrayList<>();
  private int currentBeat = 0;
  private int duration = 0;

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.BLACK);
    this.drawWhiteKeys(g2d);
    this.drawBlackKeys(g2d);
  }

  /**
   * Draws the black keys on the piano.
   *
   * @param g2d the image in which the key is going to be drawn
   */
  private void drawBlackKeys(Graphics2D g2d) {
    int blackKeyCounter = (int) (WHITE_KEY_WIDTH * 0.75);
    for (int i = 0; i < this.sharpNotes.size(); i++) {
      if (new Note(this.sharpNotes.get(i), 0).getPitch().equals(Pitch.DSharp) |
          new Note(this.sharpNotes.get(i), 0).getPitch().equals(Pitch.ASharp)) {
        if (this.noteMap.get(sharpNotes.get(i)).get(currentBeat).equals("start")
            || this.noteMap.get(sharpNotes.get(i)).get(currentBeat).equals("continue")) {
          g2d.setColor(BLACK_KEY_DISPLAY_COLOR);
          g2d.fillRect(blackKeyCounter, 0, BLACK_KEY_WIDTH, BLACK_KEY_LENGTH);
          g2d.setColor(Color.BLACK);
          g2d.drawRect(blackKeyCounter, 0, BLACK_KEY_WIDTH, BLACK_KEY_LENGTH);
          blackKeyCounter += 2 * WHITE_KEY_WIDTH;
        } else {
          g2d.setColor(Color.BLACK);
          g2d.fillRect(blackKeyCounter, 0, BLACK_KEY_WIDTH, BLACK_KEY_LENGTH);
          blackKeyCounter += 2 * WHITE_KEY_WIDTH;
        }
      } else {
        if (this.noteMap.get(sharpNotes.get(i)).get(currentBeat).equals("start")
            || this.noteMap.get(sharpNotes.get(i)).get(currentBeat).equals("continue")) {
          g2d.setColor(BLACK_KEY_DISPLAY_COLOR);
          g2d.fillRect(blackKeyCounter, 0, BLACK_KEY_WIDTH, BLACK_KEY_LENGTH);
          g2d.setColor(Color.BLACK);
          g2d.drawRect(blackKeyCounter, 0, BLACK_KEY_WIDTH, BLACK_KEY_LENGTH);
          blackKeyCounter += WHITE_KEY_WIDTH;
        } else {
          g2d.setColor(Color.BLACK);
          g2d.fillRect(blackKeyCounter, 0, BLACK_KEY_WIDTH, BLACK_KEY_LENGTH);
          blackKeyCounter += WHITE_KEY_WIDTH;
        }
      }
    }
  }

  /**
   * Draws the white kets on the piano
   *
   * @param g2d the image in which the key is going to be drawn
   */
  private void drawWhiteKeys(Graphics2D g2d) {
    for (int i = 0; i < this.naturalNotes.size(); i++) {
      if (this.noteMap.get(naturalNotes.get(i)).get(currentBeat).equals("start")
          || this.noteMap.get(naturalNotes.get(i)).get(currentBeat).equals("continue")) {
        g2d.setColor(WHITE_KEY_DISPLAY_COLOR);
        g2d.fillRect(i * WHITE_KEY_WIDTH, 0, WHITE_KEY_WIDTH, WHITE_KEY_LENGTH);
        g2d.setColor(Color.BLACK);
        g2d.drawRect(i * WHITE_KEY_WIDTH, 0, WHITE_KEY_WIDTH, WHITE_KEY_LENGTH);
      }
      g2d.setColor(Color.BLACK);
      g2d.drawRect(i * WHITE_KEY_WIDTH, 0, WHITE_KEY_WIDTH, WHITE_KEY_LENGTH);
    }
  }


  protected void setNoteRange(List<Note> noteRange) {
    this.noteRange = noteRange;
  }

  protected void setCombineNoteMap(Map<Integer, List<String>> notes) {
    this.noteMap = notes;

    for (Integer i : notes.keySet()) {
      if (new Note(i, 0).isSharp()) {
        this.sharpNotes.add(i);
      } else {
        this.naturalNotes.add(i);
      }
    }
  }

  protected void updateCurrentBeat(int beat) {
    if (!((this.currentBeat + beat < 0) || this.currentBeat + beat >= this.duration)) {
      this.currentBeat += beat;
      this.repaint();
    }
  }

  protected void setDuration(int duration) {
    this.duration = duration;
  }

}