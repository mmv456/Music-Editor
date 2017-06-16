package cs3500.music.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import cs3500.music.model.Beat;
import cs3500.music.model.IMusicEditorModel;
import cs3500.music.model.Note;
import cs3500.music.model.Repeats;
import cs3500.music.model.Segment;
import cs3500.music.view.IMusicEditorGuiView;
import cs3500.music.view.IMusicEditorMidiView;
import cs3500.music.view.IMusicEditorView;
import cs3500.music.view.running.JumpEnd;
import cs3500.music.view.running.JumpStart;
import cs3500.music.view.running.MoveLeft;
import cs3500.music.view.running.MoveRight;
import cs3500.music.view.running.Play;



/**
 * A controller for the music editor designed to take input from the user to do the
 * following actions:
 *
 * <p>
 * - Remove notes
 * - Add notes
 * - Edit notes
 * - Add a song simultaneously or consecutively
 *</p>
 */
public class ControllerTemp implements ActionListener, MouseListener {
  private IMusicEditorModel model;
  private IMusicEditorView view;
  private KeyListener keyListen;
  private int currentBeat;

  /**
   * Creates the controller, connects model and view and initializes commands.
   * @param model Music editor model.
   * @param view Music editor view.
   */
  public ControllerTemp(IMusicEditorModel model, IMusicEditorView view) {
    this.model = model;
    this.view = view;

    Map<Integer, Runnable> commands = new HashMap<>();


    Runnable jumpStart = new JumpStart(this.view);
    Runnable jumpEnd = new JumpEnd(this.view);
    Runnable moveLeft = new MoveLeft(this.view);
    Runnable moveRight = new MoveRight(this.view);

    commands.put(36, jumpStart);
    commands.put(35, jumpEnd);
    commands.put(37, moveLeft);
    commands.put(39, moveRight);

    if (view.isPlayed()) {
      IMusicEditorMidiView midiView = (IMusicEditorMidiView) this.view;
      Runnable togglePlay = new Play(midiView);
      commands.put(32, togglePlay);
    }

    this.keyListen = new KeyHandle(commands);
  }


  public void startEditor(int measureLength) {
    model.setMeasureLength(measureLength);
    view.setListeners(this, this.keyListen, this);
    view.initializeView(model.getTempo());
    sendDataToView();


    if (view.isPlayed()) {
      IMusicEditorMidiView midiView = (IMusicEditorMidiView) this.view;
      boolean songOver = midiView.getCurrentBeat() == model.getNumBeats();
      while (!songOver) {
        midiView = (IMusicEditorMidiView) this.view;
        this.currentBeat = midiView.getCurrentBeat();
        midiView.willRepeat();
        sendCurrentBeatToView();
      }
    }
    else {
      this.currentBeat = 0;
    }

  }

  /**
   * Send all the important data from the model to the view.
   */
  void sendDataToView() {
    List<List<Beat>> beats = model.getBeats();
    List<Note> notes = model.getNotes();
    List<String> headings = model.getHeadings();
    int numBeats = model.getLength();
    int measureLength = model.getMeasureLength();
    List<Repeats> repeats = model.getRepetitions();

    view.acceptData(beats, notes, headings, numBeats, measureLength, repeats);
  }

  void sendCurrentBeatToView() {
    int currBeat = this.currentBeat;

    view.updateCurrentBeat(currBeat);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    IMusicEditorGuiView guiView = (IMusicEditorGuiView) this.view;
    String inputText = guiView.getInputString();
    Scanner scan = new Scanner(inputText); //getinputstring should also clear input

    if (e.getActionCommand().equals("Set Repeat")) {
      int start = scan.nextInt();
      int end = scan.nextInt();
      boolean ending = Boolean.parseBoolean(scan.next());

      model.addRepetition(new Repeats(new Segment(start, end), ending));
    }
    else {
      String[] noteVals = scan.next().split("(?=\\d)");
      String notePitch = noteVals[0];
      int octave = Integer.parseInt(noteVals[1]);

      if (e.getActionCommand().equals("Add Note")) {
        int length = scan.nextInt();
        int startBeat = scan.nextInt();
        model.addNote(new Note(notePitch, octave, 0, startBeat, length, 90));
      } else {
        int beat = scan.nextInt();
        if (e.getActionCommand().equals("Remove Note")) {
          model.removeNote(notePitch, octave, beat);
        } else {
          String editVal = scan.next();
          model.editNote(notePitch, octave, beat, e.getActionCommand(), editVal);
        }
      }
    }
    sendDataToView();
    guiView.resetFocus();
  }

  /**
   * Invoked when the mouse button has been clicked (pressed
   * and released) on a component.
   */
  @Override
  public void mouseClicked(MouseEvent e) {
    System.out.println("Mouse Clicked");
    IMusicEditorGuiView guiView = (IMusicEditorGuiView) this.view;
    guiView.resetFocus();
  }

  /**
   * Invoked when a mouse button has been pressed on a component.
   */
  @Override
  public void mousePressed(MouseEvent e) {
    // Not needed
  }

  /**
   * Invoked when a mouse button has been released on a component.
   */
  @Override
  public void mouseReleased(MouseEvent e) {
    // Not needed
  }

  /**
   * Invoked when the mouse enters a component.
   */
  @Override
  public void mouseEntered(MouseEvent e) {
    // Not needed
  }

  /**
   * Invoked when the mouse exits a component.
   */
  @Override
  public void mouseExited(MouseEvent e) {
    // Not needed
  }
}