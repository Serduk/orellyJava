package edu.mainRun.Music;

import javax.sound.midi.*;
import javax.swing.*;


/**
 * Main class for start play sound with GUI
 * Created by serdyuk on 5/22/17.
 */
public class MiniMusicPlayer3 {
    static JFrame jFrame = new JFrame("My First music Clip");
    static MyDrawPanel myDrawPanel;

    public static void main(String[] args) {
        MiniMusicPlayer3 miniMusicPlayer3 = new MiniMusicPlayer3();
        miniMusicPlayer3.go();
    }

    public void setUpGUI() {
        myDrawPanel = new MyDrawPanel();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setContentPane(myDrawPanel);
        jFrame.setBounds(30, 30, 300, 300);
        jFrame.setVisible(true);
    }

    public void go() {
        setUpGUI();
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.addControllerEventListener(myDrawPanel, new int[] {127});
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            int r = 0;
            for (int i = 0; i < 60; i+= 4) {
                r = (int) ((Math.random() * 50) +1);
                track.add(makeEvent(144, 1, r, 100, i));
                track.add(makeEvent(176, 1, 127, 0, i));
                track.add(makeEvent(128, 1, r, 100, i + 2));
            }

            sequencer.setSequence(seq);
            sequencer.start();
            sequencer.setTempoInBPM(120);

        } catch (Exception e) {
            System.out.println("Exception in MiniMusicPlayer3 class");
        }
    }

    public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
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