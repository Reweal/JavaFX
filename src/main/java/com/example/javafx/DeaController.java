//package com.example.javafx;
//
//import javafx.fxml.FXML;
//import javafx.scene.control.Button;
//import javafx.scene.control.Slider;
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
//import javafx.stage.FileChooser;
//
//import java.io.File;
//
//public class DeaController {
//
//
//    private MediaPlayer mediaPlayer;
//    private File selectedFile;
//    @FXML
//    private Slider slider;
//
//    @FXML
//    private Button playButton;
//
//    @FXML
//    private Button pauseButton;
//
//    @FXML
//    private Button stopButton;
//
//    @FXML
//    protected void onPlayButtonClick() {
//        playButton.setStyle("-fx-background-color: #009f00; -fx-text-fill: #ffffff;");
//        if (mediaPlayer != null) {
//            mediaPlayer.stop();
//        }
//        FileChooser fileChooser = new FileChooser();
//        fileChooser.getExtensionFilters()
//                .add(new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"));
//        selectedFile = fileChooser.showOpenDialog(null);
//
//        if (selectedFile != null) {
//            Media sound = new Media(selectedFile.toURI().toString());
//            mediaPlayer = new MediaPlayer(sound);
//            mediaPlayer.play();
//            pauseButton.setText("Pause");
//        }
//    }
//
//    @FXML
//    protected void onPauseButtonClick() {
//        if (mediaPlayer != null) {
//            if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
//                pauseButton.setStyle("-fx-background-color: #009f00; -fx-text-fill: #ffffff;");
//                mediaPlayer.pause();
//                pauseButton.setText("Resume");
//            } else if (mediaPlayer.getStatus() == MediaPlayer.Status.PAUSED) {
//                pauseButton.setStyle("-fx-background-color: #9f0000; -fx-text-fill: #ffffff;");
//                mediaPlayer.play();
//                pauseButton.setText("Pause");
//            }
//        }
//    }
//
//    @FXML
//    protected void onStopButtonClick() {
//        if (mediaPlayer != null) {
//            stopButton.setStyle("-fx-background-color: #9f0000; -fx-text-fill: #ffffff;");
//            mediaPlayer.stop();
//            playButton.setStyle("-fx-background-color: #9f0000; -fx-text-fill: #ffffff;");
//            pauseButton.setStyle("-fx-background-color: #9f0000; -fx-text-fill: #ffffff;");
//        }
//    }
//}