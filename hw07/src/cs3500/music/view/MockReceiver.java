package cs3500.music.view;

import javax.sound.midi.MidiMessage;
import javax.sound.midi.Receiver;
import javax.sound.midi.ShortMessage;



/**
 * The Mock for the Receiver. Also used mainly in the tests.
 */
public class MockReceiver implements Receiver {

  StringBuilder log;

  /**
   * Constructors the Mock Receiver.
   */
  public MockReceiver(StringBuilder log) {
    this.log = log;
  }

  /**
   * Sends the message to the log.
   *
   * @param message the MidiMessage.
   * @param timeStamp the timestamp.
   */
  @Override
  public void send(MidiMessage message, long timeStamp) {
    ShortMessage m = (ShortMessage) message;
    int note = m.getData1();
    log.append("The current Note is: " + note + " " + "\n");
  }

  /**
   * When closing.
   */
  @Override
  public void close() {
    log.append("Closing...");
    System.out.println(log.toString());
  }
}