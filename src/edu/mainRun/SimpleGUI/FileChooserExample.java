package edu.mainRun.SimpleGUI;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.io.File;

/**
 * Example how add file Chooser for any file
 * Created by sserdiuk on 5/31/17.
 */
public class FileChooserExample {

        public static void main(String[] args) {
            saveTo();
            uploadFrom();
        }

        /*
        * Source: https://www.mkyong.com/swing/java-swing-jfilechooser-example/
        * Example How can save file to selected path with selected name
        * */
        public static void saveTo() {
            JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            jfc.setDialogTitle("Choose a directory to save your file: ");
            jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            /*
            * Set filter for files in directories
            * */
            jfc.setDialogTitle("Select an image");
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
        }

        /*
        * Example how can upload from already existed file
        * */
        public static void uploadFrom() {
            JFileChooser uploadFrom = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

            int value = uploadFrom.showOpenDialog(null);
            // int returnValue = jfc.showSaveDialog(null);

            if (value == JFileChooser.APPROVE_OPTION) {
                File selectedFile = uploadFrom.getSelectedFile();
                System.out.println(selectedFile.getAbsolutePath());
            }
        }
}
