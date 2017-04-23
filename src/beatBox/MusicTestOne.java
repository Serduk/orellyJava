package beatBox;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;

/**
 * Test Class for Music Sequencer
 * Created by serdyuk on 4/23/17.
 */
public class MusicTestOne {
    public void play() {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            System.out.println("We Get Sequencer");
        } catch (MidiUnavailableException e) {
            System.out.println("Sequencer init Fail");
        } finally {
            System.out.println("Here is Finally block");
        }
    }

    public static void main(String[] args) {
        MusicTestOne musicTestOne = new MusicTestOne();
        musicTestOne.play();
    }
}
