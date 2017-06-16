Music Editor:
___________________________________________________________________________
  To run, go to the Command Prompt and navigate to the folder with the jar file. Type in:
    java -jar hw06.jar NAMEOFTXT.txt TYPE
  There are four different types: console, gui, midi, and visual.

  ------ CHANGES ----------------------------------------------------------------------------------
  Most of the changes were for making the data easier to handle. For example, we separated classes
  so that they represent Notes and Pitches separately. Also, we added a Repeats class so that it
  will be better to distinguish them from normal beats.
  Merged the two models and added accessor methods to preserve encapsulation of code.
  Added CombineSim and CombineCon to add proper simultaneous and consecutive song addition to the
  model.
  Created NoteColumns to properly add any columns between the lowest note and highest note
  Corrected update to respect the scopes of the classes and delegated some of the work to the
  NoteColumn class.
  Added getters and a setter method to allow most things to stay private in here
  Added a builder for the model to make it compatible for this assignment and to make it easier to
  make a desired model.
  Wrote more accurate tests.

  ------ DESIGN -----------------------------------------------------------------------------------
  MODEL:
    The model consists of a few classes - the model itself, Beat, Note, NoteColumn, a
    ColumnComparator, and an enum representing Pitch.
    Purposes of the Classes: Beat - To represent a played beat. This class is used for the
    "beat track" Has a boolean field isHead designating if it is the head of a note. Also has a
    field to associate it with the note that it is representing. If the object EXISTS, it is a
    played beat. A rest is represented with null, this is so that for-each loops are faster.

    Note - Represents a note with pitch, octave, length, starting beat, instrument, a volume.
    The constructor calculates a lastbeat field and updates whenever changes are made to the length
    of the note.

    NoteColumn - Stores all the notes of one pitch, so there's a separate NoteColumn for C#7, C#6,
    B3, etc. The NoteColumn has a heading that represents pitch, pitch and octave, a list of notes
    it contains, and a "beat track". A beat track is a list of beats in order of playing of when
    the note is played, making it easy to print the editor and represent it as a view. It looks
    like this:
        (It is an ArrayList)
        Beats[0]    Beats[1]    Beats[2]    Beats[3]    Beats[4]
                      X           -           -
          null       Beat        Beat        Beat        null
                   isHead T     isHead F    isHead F
    The NoteColumn also automatically merges any overlapping notes.

    ColumnComparator - Comparator that uses hashcodes to sort note columns according to pitch.

    Pitch - An enum representing actual pitches of notes and stores the symbol and the ordinal
    (the order that they're in, from C = 0 to B = 11). Has many methods to convert ordinals to
    pitch strings, strings to pitch objects, and many others that are needed in the model
    computations. Also handles enharmonic pitches (B# -> C, Db -> C#) so intermediate pitches are
    represented as sharps.


  VIEW:
    MidiView - Plays song using the midi library. Takes in beat tracks and based on the head of
    the note, it sends an on message to the midi receiver. If it reads a note but it is not the head
    it will not send any message, and if it reads a null it will sends an off message. The thread
    thread is slept between each beat in order to play in the right tempo.

    Some functionality:
    Space Bar: play/pause
    Home: play from beginning
    End: go to the end
    Left and Right Arrow Keys: skip through measures

    SheetMusicView - A horizontal GUI view of the sheet music. Takes in beats, note headings,
    number of beats, and measures the length from the model. Uses the beat track to generate which
    note is being played at each beat. A yellow block represents the head of a note, a blue block
    represents a non-head note, and the background color represents no note is being played. The
    track is separated into groups of beats decided by the measure length. It also numbers the
    beginning beat of every measure. Use the text field and buttons to edit the respective note
    values. Use the following formats in the text field:
    Add Note - Pitch Octave StartBeat Length
    Remove Note - Pitch Octave Beat
    Edit Note - Pitch Octave EditValue

    SheetMusicTextView - Same output as getSheetMusic in the model. Represents the beat track
    the same way as in SheetMusicView but represents a note head with an "X", a non-head note as
    "|", and no note as whitespace. The music is shown vertically and outputted into the console.
    All beats are numbered on the left.

    MidiGuiView - Combines the features of the MidiView and the SheetMusicView. Press Space Bar
    to pause or play music like in the MidiView. Use buttons and the text field to edit notes like
    in the SheetMusicView. All keyboard commands will work the same like in their respective views.
