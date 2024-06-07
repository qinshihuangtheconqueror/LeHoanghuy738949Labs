package AimsProject.hust.soict.ict.aims.screen.customer.controller;

import AimsProject.hust.soict.ict.aims.cart.Cart;
import AimsProject.hust.soict.ict.aims.media.*;
import AimsProject.hust.soict.ict.aims.store.Store;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class CartController {
    private Store store;
    private Cart cart;
    private FilteredList<Media> filteredMedia;

    public CartController(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }

    @FXML
    private Label lblTotalCost;
    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TextField tfFilter;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof DigitalVideoDisc) {
            showDVDInformation((DigitalVideoDisc) media);
        } else if (media instanceof CompactDisc) {
            showCDInformation((CompactDisc) media);
        }
    }

    private void showDVDInformation(DigitalVideoDisc dvd) {
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

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        lblTotalCost.setText(String.valueOf(cart.totalCost()) + "$");
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        try {
            final String STORE_FXML_FILE_PATH = "/AimsProject/hust/soict/ict/aims/screen/customer/view/Store.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
            fxmlLoader.setController(new ViewStoreController(store, cart));

            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(new Scene(root));
            stage.setTitle("Store");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        float totalCost = cart.totalCost();
        int numberOfItems = cart.getItemsOrdered().size();

        String notificationMessage = "Order placed successfully!\n" +
                "Total Cost: $" + String.format("%.2f", totalCost) + "\n" +
                "Number of Items: " + numberOfItems;

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order Confirmation");
        alert.setHeaderText(null);
        alert.setContentText(notificationMessage);

        alert.showAndWait();

        cart = new Cart();
    }

    @FXML
    public void initialize() {
        colMediaId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        if (cart.getItemsOrdered() != null) {
            tblMedia.setItems(cart.getItemsOrdered());
        }

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        filteredMedia = new FilteredList<>(tblMedia.getItems(), p -> true);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observableValue, Media oldValue, Media newValue) {
                updateButtonBar(newValue);
            }
        });

        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                if (newValue != null) {
                    showFilteredMedia(tfFilter.getText()); // Update filtered list when toggle changes
                }
            }
        });

        lblTotalCost.setText(String.valueOf(cart.totalCost()) + "$");
    }

    void updateButtonBar(Media media){
        if(media == null){
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        }
        else {
            btnRemove.setVisible(true);
            if(media instanceof Playable){
                btnPlay.setVisible(true);
            }
            else btnPlay.setVisible(false);
        }
    }

    void showFilteredMedia(String filterText) {
        filteredMedia.setPredicate(media -> {
            if (filterText == null || filterText.isEmpty()) {
                return true; // Show all items if filter text is empty
            }
            String lowerCaseFilter = filterText.toLowerCase();
            if (radioBtnFilterId.isSelected()) {
                // Check if filter text matches ID
                return String.valueOf(media.getId()).toLowerCase().contains(lowerCaseFilter);
            } else if (radioBtnFilterTitle.isSelected()) {
                // Check if filter text matches title
                return media.getTitle().toLowerCase().contains(lowerCaseFilter);
            }
            return true; // Return true by default
        });
        // Set the filtered list to the table view
        tblMedia.setItems(filteredMedia);
    }
}
