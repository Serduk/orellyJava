package beatBox;

import javax.sound.midi.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * BeatBox player
 * Created by serdyuk on 5/24/17.
 */
public class BeatBox implements Serializable {
    private static final int instrumentBeatSize = 256; //instrument size in MIDI class. more than 256 -> cant play

    private String pathToFile = "resources/serializableData/lastVersion";
    private String fileExtension = ".ser";
    private JPanel mainPanel;
    private List<JCheckBox> checkBoxList;
    private Sequencer sequencer;
    private Sequence seq;
    private Track track;
    private JFrame theFrame;

    //Instruments name
    private String[] instrumentName = {
            "Bass Drum",
            "Acoustic Snare",
            "Crash Cymbal",
            "Hand Clamp",
            "High Tom",
            "High Bongo",
            "Maracas",
            "Whistle",
            "Low Conga",
            "CowBell",
            "Vibraslap",
            "Low-mid Tom",
            "High Agogo",
            "Open High Conga",
            "Super Conga",
            "Super Super Conga"
    };
    //Different drums button
    int[] instruments = {35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63};

    public static void main(String[] args) {
        new BeatBox().buildGUI();
    }

    private void buildGUI() {
        theFrame = new JFrame("Cyber BitBox");
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout layout = new BorderLayout();
        JPanel background = new JPanel(layout);
        //Add delimiter between all elements on background
        background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        checkBoxList = new ArrayList<>();
        Box buttonBox = new Box(BoxLayout.Y_AXIS);

        JButton start = new JButton("Start");
        start.addActionListener(new MyStartListener());
        buttonBox.add(start);

        JButton stop = new JButton("Stop");
        stop.addActionListener(new MyStopListener());
        buttonBox.add(stop);

        JButton upTempo = new JButton("Temp Up");
        upTempo.addActionListener(new MyUpTempoListener());
        buttonBox.add(upTempo);

        JButton downTempo = new JButton("Temp Down");
        downTempo.addActionListener(new MyDownTempoListener());
        buttonBox.add(downTempo);

//        Save data for play on nex time
        JButton serializableBeats = new JButton("Save (Serializable)");
        serializableBeats.addActionListener(new MySavedSerializableDataBeatBox());
        buttonBox.add(serializableBeats);

        JButton saveAs = new JButton("Save As");
        saveAs.addActionListener(new SaveUsSerializable());
        buttonBox.add(saveAs);

//        upload data from ser file. last beatBox temp
        JButton restoreLastData = new JButton("Restore");
        restoreLastData.addActionListener(new MyRestoreLastDataFromSerializable());
        buttonBox.add(restoreLastData);

        JButton restoreFromFile = new JButton("Restore From File");
        restoreFromFile.addActionListener(new RestoreFromFileSerializable());
        buttonBox.add(restoreFromFile);


        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for (int i = 0; i < 16; i++) {
            nameBox.add(new Label(instrumentName[i]));
        }

        background.add(BorderLayout.EAST, buttonBox);
        background.add(BorderLayout.WEST, nameBox);

        theFrame.getContentPane().add(background);

        GridLayout gridLayout = new GridLayout(16, 16);
        gridLayout.setVgap(1);
        gridLayout.setHgap(2);
        mainPanel = new JPanel(gridLayout);
        background.add(BorderLayout.CENTER, mainPanel);

//      Create Checkbox, add "false" for each checkBox, then add each checkbox to arrayList, and on panel
        for (int i = 0; i < instrumentBeatSize; i++) {
            JCheckBox c = new JCheckBox();
            c.setSelected(false);
            checkBoxList.add(c);
            mainPanel.add(c);
        }

        setUpMidi();

        theFrame.setBounds(50, 50, 300, 300);
        theFrame.pack();
        theFrame.setVisible(true);
    }

    //    Simple code for setUp MIDI for get Sequencer and and track
    private void setUpMidi() {
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            seq = new Sequence(Sequence.PPQ, 4);
            track = seq.createTrack();
            sequencer.setTempoInBPM(120);
        } catch (Exception e) {
            System.out.println("Something wrong with setUpMidi");
        }
    }

    private void buildTrackAndStart() {
//        Create array for each instrument for all 16 takts;
        int[] trackList = null;

//        remove ald track, and create new
        seq.deleteTrack(track);
        track = seq.createTrack();

//        Do this for each row, its mean for bass, congo, etc
        for (int i = 0; i < 16; i++) {
            trackList = new int[16];

//            setUpBtn who show as instrumetn (bass, congo, etc). Array contain MIDI-int for each instrument
            int key = instruments[i];

//            do this for each tackts in current row
            for (int j = 0; j < 16; j++) {
                JCheckBox jc = checkBoxList.get(j + (16 * i));
//                if boolean is true -> set key in current array slot
                if (jc.isSelected()) {
                    trackList[j] = key;
                } else {
                    trackList[j] = 0;
                }
            }

//            For current instrument, and for each 16 tackts -> create event and add them on track;
            makeTracks(trackList);
            track.add(makeEvent(176, 1, 127, 0, 16));
        }

        track.add(makeEvent(192, 9, 1, 0, 15));
        try {
            sequencer.setSequence(seq);
//            can set count of loop, or neverending loop
            sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
            sequencer.start();
            sequencer.setTempoInBPM(120);
        } catch (Exception e) {
            System.out.println("Problem with play track");
        }


    }

    public class MyStartListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            buildTrackAndStart();
        }
    }

    public class MyStopListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            sequencer.stop();
        }
    }

    //    set temp more fast
    public class MyUpTempoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float) (tempoFactor * 1.03));
        }
    }

    //    set temp more slowly
    public class MyDownTempoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float) (tempoFactor * .97));
        }
    }

    //    for serializable. Add listener to button serializet. for save all data
    public class MySavedSerializableDataBeatBox implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
//            create boolean array for save all state
            makeSoundFile(new File(pathToFile));
        }
    }

    public class MyRestoreLastDataFromSerializable implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            uploadSoundFile(new File(pathToFile + fileExtension));
        }
    }

    /*
    * Choose place and name for file, and were you want save this file
    * In This Class we use JFileChooser -> his open another one window, were we select place for file and fileName
    * Extension for file will be added automatically in method makeSoundFile
    * */
    public class SaveUsSerializable implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("save as");

            JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            jfc.setDialogTitle("Choose a directory to save your file: ");
            jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            /*
            * Set filter for files in directories
            * */
            jfc.setDialogTitle("Save SER file");
            jfc.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("only SERIALIZABLE files", "ser", ".ser", "serializable");
            jfc.addChoosableFileFilter(filter);

            int returnValue = jfc.showSaveDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                System.out.println(jfc.getSelectedFile().getPath());
            }

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                if (jfc.getSelectedFile().isDirectory()) {
                    System.out.println("You selected the directory: " + jfc.getSelectedFile());
                }
                System.out.println(jfc.getSelectedFile());
            }

//SAVE FILE
            makeSoundFile(jfc.getSelectedFile());
        }
    }

    /*
    * Choose already existed file for restore already existed serializable file
    * Also was added filter for file choosing.
    * Only files with extension "ser", ".ser", "serializable" can be uploaded
    * */
    public class RestoreFromFileSerializable implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Restore From");
            JFileChooser uploadFrom = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

            uploadFrom.setDialogTitle("Select SER file for restore data");
            uploadFrom.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("only SERIALIZABLE files", "ser", ".ser", "serializable");
            uploadFrom.addChoosableFileFilter(filter);

            int value = uploadFrom.showOpenDialog(null);
            // int returnValue = jfc.showSaveDialog(null);

            if (value == JFileChooser.APPROVE_OPTION) {
                File selectedFile = uploadFrom.getSelectedFile();
                System.out.println(selectedFile.getAbsolutePath());
            }

            uploadSoundFile(uploadFrom.getSelectedFile());
        }
    }

    //    Method create events for one instrument per one loop run, for each 16 takts.
    private void makeTracks(int[] list) {
        for (int i = 0; i < 16; i++) {
            int key = list[i];

            if (key != 0) {
                track.add(makeEvent(144, 9, key, 100, i));
                track.add(makeEvent(128, 9, key, 100, i + 1));
            }
        }
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

    /*
    * TODO: add check condition: if user also add extension in JFileChooser -> split it, and delete
    * TODO: if user just close window -> add catch for this case
    *
    * Method create sound file (save file to selected path)
    * Take all selected checkBoxes and save all in Serializable file
    * Method automatically add extension for file like "ser"
    * */
    private void makeSoundFile(File path) {
//            create boolean array for save all state
        boolean[] checkboxState = new boolean[instrumentBeatSize];

//            check all checkBoxes in frame, if checkBox is selected -> put him to array
        for (int i = 0; i < instrumentBeatSize; i++) {
            JCheckBox checkBox = checkBoxList.get(i);

            checkboxState[i] = checkBox.isSelected();
        }

        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path + fileExtension));
            outputStream.writeObject(checkboxState);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /*
    * Upload ser to application from PC
    * */
    private void uploadSoundFile(File path) {
        boolean[] checkBoxState = null;
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path));
            checkBoxState = (boolean[]) inputStream.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        for (int i = 0; i < instrumentBeatSize; i++) {
            JCheckBox check = checkBoxList.get(i);
            if (checkBoxState != null && checkBoxState[i]) {
                check.setSelected(true);
            } else {
                check.setSelected(false);
            }
        }

        sequencer.stop();
        buildTrackAndStart();
    }
}