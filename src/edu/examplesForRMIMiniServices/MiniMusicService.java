package edu.examplesForRMIMiniServices;


import edu.mainRun.Music.animationMusic.MyDrawPanel;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Track;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static edu.mainRun.Music.miniMusicPlayers.MiniMusicPlayer1.makeEvent;

/**
 * Class for ServiceServerImpl
 *
 * Created by sserdiuk on 6/30/17.
 */
public class MiniMusicService implements Service {
    MyDrawPanel myPanel;

    @Override
    public JPanel getGUIPanel() {
        JPanel mainPanel = new JPanel();
        myPanel = new MyDrawPanel();
        JButton playItButton = new JButton("Play It");
        playItButton.addActionListener(new PlayItListener());

        mainPanel.add(myPanel);
        mainPanel.add(playItButton);

        return mainPanel;
    }

    private class PlayItListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Sequencer sequencer = MidiSystem.getSequencer();
                sequencer.open();

                sequencer.addControllerEventListener(myPanel, new int[] {127});
                Sequence seq = new Sequence(Sequence.PPQ, 4);
                Track track = seq.createTrack();

                for (int i = 0; i < 100; i+=4) {
                    int rNum = (int) ((Math.random() * 50) + 1);
                    if (rNum < 38) {
                        track.add(makeEvent(144, 1, rNum, 100, i));
                        track.add(makeEvent(176, 1, 127, 0, i));
                        track.add(makeEvent(128, 1, rNum, 100, i + 2));
                    }
                }
                sequencer.setSequence(seq);
                sequencer.start();
                sequencer.setTempoInBPM(220);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
