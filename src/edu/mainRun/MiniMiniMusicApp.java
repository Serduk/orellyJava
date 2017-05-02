package edu.mainRun;

import javax.sound.midi.*;

/**
 * first test music app
 * Created by serdyuk on 5/2/17.
 */
public class MiniMiniMusicApp {
    public static void main(String[] args) {
        MiniMiniMusicApp mini = new MiniMiniMusicApp();
        mini.play();
    }

    public void play() {
        System.out.println("Try execute Sequencer");
        try {
//            Get Sequencer, and open him. at firts - his closed
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            Sequence seq = new Sequence(Sequence.PPQ, 4);
//            Create track
            Track track = seq.createTrack();

//            add events to midi
            ShortMessage a = new ShortMessage();
            a.setMessage(144, 1, 80, 100);
            MidiEvent noteOn = new MidiEvent(a, 1);
            track.add(noteOn);

            ShortMessage b = new ShortMessage();
            a.setMessage(128, 1, 80, 100);
            MidiEvent noteOff = new MidiEvent(b, 2);
            track.add(noteOff);

//            move track to sequencer
            sequencer.setSequence(seq);
            sequencer.start();

            System.out.println("Finish execute sequence");

        } catch (MidiUnavailableException | InvalidMidiDataException e) {
            e.printStackTrace();
        }
    }
}
