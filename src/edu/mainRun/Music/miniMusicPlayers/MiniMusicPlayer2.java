package edu.mainRun.Music.miniMusicPlayers;

import javax.sound.midi.*;


/**
 * Add event listeners
 * Created by serdyuk on 5/22/17.
 */
public class MiniMusicPlayer2 implements ControllerEventListener {
    public static void main(String[] args) {
        MiniMusicPlayer2 player2 = new MiniMusicPlayer2();
        player2.go();
    }

    private void go() {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            int[] eventsIWant = {127};
            sequencer.addControllerEventListener(this, eventsIWant);

            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            for (int i = 5; i < 60; i += 4) {
                track.add(makeEvent(144, 1, i, 100, i));
                track.add(makeEvent(176, 1, 127, 0, i));
                track.add(makeEvent(128, 1, i, 100, i + 2));
            }

            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();

        } catch (Exception e) {
            System.out.println("Sequencer Exception");
        }
    }

    @Override
    public void controlChange(ShortMessage event) {
        System.out.println("Olololo");
    }

    private MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;

        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (Exception e) {
            System.out.println("Exception in makeEvent Method");
        }

        return event;
    }
}
