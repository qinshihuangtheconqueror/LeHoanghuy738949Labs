package AimsProject.hust.soict.ict.aims.screen.customer.controller;

import AimsProject.hust.soict.ict.aims.cart.Cart;
import AimsProject.hust.soict.ict.aims.exception.CartFullException;
import AimsProject.hust.soict.ict.aims.exception.PlayerException;
import AimsProject.hust.soict.ict.aims.media.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ItemController {
    private Media media;
    private Cart cart;
    @FXML
    private Button btnAddtoCart;
    @FXML
    private Button btnPlay;
    @FXML
    private Label lblTitle;
    @FXML
    private Label lblCost;
    @FXML
    void btnAddtoCartClicked(ActionEvent event) throws CartFullException {
        if(cart.getItemsOrdered().size() < cart.MAX_NUMBERS_ORDERS){
            if (cart != null && media != null) {
                cart.addMedia(media);
            }
        }
        else {
            String errorMessage = "ERROR: Cart is full";
            System.err.println(errorMessage);
            Platform.runLater(() -> {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Cart is full");
                alert.setHeaderText(null);
                alert.setContentText(errorMessage);
                alert.showAndWait();
            });
        }
    }

    @FXML
    void btnPlayClicked(ActionEvent event) throws PlayerException {
        if(media instanceof DigitalVideoDisc){
            showDVDInformation((DigitalVideoDisc) media);
        } else if (media instanceof CompactDisc) {
            showCDInformation((CompactDisc) media);
        }
    }
    private void showDVDInformation(DigitalVideoDisc dvd) throws PlayerException {
        if(dvd.getLength() > 0){
            String information = "DVD Information:\n" +
                    "Title: " + dvd.getTitle() + "\n" +
                    "Category: " + dvd.getCategory() + "\n" +
                    "Cost: $" + String.format("%.2f", dvd.getCost()) + "\n" +
                    "Length: " + dvd.getLength() + " minutes\n" +
                    "Director: " + dvd.getDirector();

            showMediaInformation(information);
        }
        else{
            String errorMessage = "ERROR: DigitalVideoDisc length is non-positive.";
            System.err.println(errorMessage);
            Platform.runLater(() -> {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Illegal DVD Length");
                alert.setHeaderText(null);
                alert.setContentText(errorMessage);
                alert.showAndWait();
            });
        }
    }

    private void showCDInformation(CompactDisc cd) {
        if (cd.getLength() > 0) {
            boolean hasZeroLengthTrack = false;
            StringBuilder tracksInformation = new StringBuilder();
            for (Track track : cd.getTracks()) {
                tracksInformation.append(track.getTitle()).append(" - ").append(track.getLength()).append(" minutes\n");
                if (track.getLength() == 0) {
                    hasZeroLengthTrack = true;
                }
            }

            if (hasZeroLengthTrack) {
                String errorMessage = "ERROR: CD contains a track with zero length.";
                System.err.println(errorMessage);
                Platform.runLater(() -> {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Illegal Track Length");
                    alert.setHeaderText(null);
                    alert.setContentText(errorMessage);
                    alert.showAndWait();
                });
            } else {
                String information = "CD Information:\n" +
                        "Title: " + cd.getTitle() + "\n" +
                        "Category: " + cd.getCategory() + "\n" +
                        "Cost: $" + String.format("%.2f", cd.getCost()) + "\n" +
                        "Artist: " + cd.getArtist() + "\n" +
                        "Tracks:\n" + tracksInformation.toString();

                showMediaInformation(information);
            }
        } else {
            String errorMessage = "ERROR: CD length is non-positive.";
            System.err.println(errorMessage);
            Platform.runLater(() -> {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Illegal CD Length");
                alert.setHeaderText(null);
                alert.setContentText(errorMessage);
                alert.showAndWait();
            });
        }
    }

    private void showMediaInformation(String information) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Media Information");
        alert.setHeaderText(null);
        alert.setContentText(information);

        alert.showAndWait();
    }
    public void setData(Media media, Cart cart){
        this.cart = cart;
        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost() + " $");
        if(media instanceof Playable){
            btnPlay.setVisible(true);
        }
        else {
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddtoCart, new Insets(0, 0, 0, 60));
        }
    }
    public ItemController(){

    }
}
