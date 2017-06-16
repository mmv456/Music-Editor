package cs3500.music.view.artificialmidi;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import java.util.List;

import cs3500.music.model.Beat;
import cs3500.music.model.Note;
import cs3500.music.model.Repeats;
import cs3500.music.view.IMusicEditorView;

import javax.swing.JScrollPane;

/**
 * Mock SheetMusicView.
 */
public class SheetMusicView extends javax.swing.JFrame implements IMusicEditorView {

  private final SheetMusicPanel displayPanel;

  /**
   * Creates new SheetMusicView with a JScrollPane made from the display panel.
   */
  public SheetMusicView() {
    super("Music Editor");
    this.displayPanel = new SheetMusicPanel();
    JScrollPane scrollPane = new JScrollPane(displayPanel);

    this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    this.getContentPane().add(scrollPane);
    this.pack();

    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    this.setLocation(dim.width / 2 - this.getSize().width / 2,
        dim.height / 2 - this.getSize().height / 2);
  }

  @Override
  public void initializeView(int tempo) {
    this.setVisible(true);
  }

  /**
   * Accepts data from the controller to be rendered.
   *
   * @param beats the beat track
   * @param headings the note headings of every note column
   * @param numBeats the number of beats in the editor
   * @param measureLength the measure length
   */
  @Override
  public void acceptData(List<List<Beat>> beats, List<Note> notes, List<String> headings,
      int numBeats, int measureLength, List<Repeats> repeats) {
    displayPanel.acceptData(beats, headings, numBeats, measureLength);
  }

  @Override
  public void updateCurrentBeat(int currentBeat) {
    displayPanel.acceptCurrBeat(currentBeat);
  }

  @Override
  public void setListeners(ActionListener aListen, KeyListener keyListen,
      MouseListener mouseListen) {
    // Not needed
  }

  @Override
  public void goToStart() {
    // Not needed
  }

  @Override
  public void goToEnd() {
    // Not needed
  }

  @Override
  public void moveRight() {
    // Not needed
  }

  @Override
  public void moveLeft() {
    // Not needed
  }

  @Override
  public boolean isPlayed() {
    return false;
  }


  @Override
  public Dimension getPreferredSize() {
    return displayPanel.getPreferredSize();
  }

  /**
   * Returns the number of times repainted.
   * @return Number of paints.
   */
  public int numOfPaints() {
    return displayPanel.numOfPaints;
  }

}