package com.example.javafx;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class DeaMediaPlayer extends Application {

    private MediaPlayer mediaPlayer;
    private File selectedFile;

    @FXML
    private Button playButton = new Button();

    @FXML
    private Button pauseButton = new Button();

    @FXML
    private Button stopButton = new Button();
    @FXML
    private Slider volumeSlider = new Slider();
    @FXML
    private ProgressBar volumeProgressBar = new ProgressBar();
    @FXML
    private HBox controlBox = new HBox();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DeaMediaPlayer.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 500);
        scene.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());
        stage.setTitle("Dea MediaPlayer");
        stage.setScene(scene);
        stage.show();
        stage.setMinWidth(615);
        stage.setMaxWidth(650);
        stage.setMinHeight(200);
        stage.setMaxHeight(500);
    }

    public static void main(String[] args) {
        launch();
    }

    @FXML
    protected void onPlayButtonClick() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters()
                .add(new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"));
        selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            Media sound = new Media(selectedFile.toURI().toString());
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            pauseButton.setText("Pause");
            volumeSlider.setValue(1.0);
            controlBox.setVisible(true);
        }

        volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (mediaPlayer != null) {
                    mediaPlayer.setVolume(newValue.doubleValue());
                }
            }
        });
        playButton.setVisible(false);
        pauseButton.setVisible(true);
        stopButton.setVisible(true);
        volumeSlider.setVisible(true);
    }

    @FXML
    protected void onPauseButtonClick() {
        if (mediaPlayer != null) {
            if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
                mediaPlayer.pause();
                pauseButton.setText("Resume");
            } else if (mediaPlayer.getStatus() == MediaPlayer.Status.PAUSED) {
                mediaPlayer.play();
                pauseButton.setText("Pause");
            }
        }
    }

    @FXML
    protected void onStopButtonClick() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            selectedFile = null;
            playButton.setVisible(true);
            pauseButton.setVisible(false);
            stopButton.setVisible(false);
            volumeSlider.setVisible(false);
        }
    }
}