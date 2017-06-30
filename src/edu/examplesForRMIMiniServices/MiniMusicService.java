package edu.examplesForRMIMiniServices;


import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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

    public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return event;
    }

    private class MyDrawPanel extends JPanel implements ControllerEventListener {
        boolean message = false;

        @Override
        public void controlChange(ShortMessage event) {
            message = true;
            repaint();
        }

        public Dimension getPreferredSize() {
            return new Dimension(300, 300);
        }

        public void paintComponent(Graphics g) {
            if (message) {
                Graphics2D g2D = (Graphics2D) g;

                int r = (int) (Math.random() * 250);
                int gr = (int) (Math.random() * 250);
                int b = (int) (Math.random() * 250);

                g.setColor(new Color(r, gr, b));
                int ht = (int) ((Math.random() * 120) + 10);
                int width = (int) ((Math.random() * 120) + 10);

                int x = (int) ((Math.random() * 40) + 10);
                int y = (int) ((Math.random() * 40) + 10);

                g.fillRect(x, y, ht, width);
                message = false;

            }
        }
    }
}
