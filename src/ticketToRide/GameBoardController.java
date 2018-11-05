import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/*
    Controller class for the GameBoard UI
 */
public class GameBoardController {

    private Player player1 = new Player(Color.AQUA);
    private Player player2 = new Player(Color.PINK);
    private Player currentPlayer = null;
    private GameBoard board = new GameBoard();
    private GameLogic gameLogic = new GameLogic();
    private String city1 = "";
    private String city2 = "";

    @FXML
    private Button SF;

    @FXML
    private Rectangle SFtoLA1;

    @FXML
    private Rectangle SFtoLA2;

    @FXML
    private Rectangle SFtoLA3;

    @FXML
    private Button LA;

    @FXML
    private Rectangle LAtoSD1;

    @FXML
    private Rectangle LAtoSD2;

    @FXML
    private Button SD;

    @FXML
    private Rectangle SDtoLV1;

    @FXML
    private Rectangle SDtoLV2;

    @FXML
    private Rectangle SDtoLV3;

    @FXML
    private Rectangle SDtoLV4;

    @FXML
    private Button LV;

    @FXML
    private Rectangle SFtoLV1;

    @FXML
    private Rectangle SFtoLV2;

    @FXML
    private Rectangle SFtoLV3;

    @FXML
    private Button route;

    @FXML
    private Button trainCard;

    @FXML
    private Button destinationCard;

    @FXML
    void buttonPressed(ActionEvent event) {
        Button pressed = (Button) event.getSource();
        /*
            Check if one of the city variables is still empty so the player can choose the second destination.
            Doing this to prevent the player from continually spamming the buttons and overriding the data stored already
            This is also is a fail safe so that in the even that the player "accidentally" presses a button after
            choosing two destinations already, nothing will happen.
         */
       if (city1.isEmpty() ||  city2.isEmpty()) {
           if (pressed.equals(SF)) {
               SF.setStyle("-fx-background-color: #7CFC00");
               if (city1.isEmpty()) {
                   city1 = SF.getText();
               } else {
                   city2 = SF.getText();
               }
           } else if (pressed.equals(LA)) {
               LA.setStyle("-fx-background-color: #7CFC00");
               if (city1.isEmpty()) {
                   city1 = LA.getText();
               } else {
                   city2 = LA.getText();
               }
           } else if (pressed.equals(SD)) {
               SD.setStyle("-fx-background-color: #7CFC00");
               if (city1.isEmpty()) {
                   city1 = SD.getText();
               } else {
                   city2 = SD.getText();
               }
           } else if (pressed.equals(LV)) {
               LV.setStyle("-fx-background-color: #7CFC00");
               if (city1.isEmpty()) {
                   city1 = LV.getText();
               } else {
                   city2 = LV.getText();
               }
           }
       }
       if (pressed.equals(route)) {
          if ( gameLogic.isValidMove(gameLogic.getCurrentPlayer(currentPlayer, player1, player2), board, city1, city2) ) {
              if ( (city1.equals("SF") && city2.equals("LA")) || ((city1.equals("LA") && city2.equals("SF"))) ) {
                  SFtoLA1.setFill(currentPlayer.getPlayerColor());
                  SFtoLA2.setFill(currentPlayer.getPlayerColor());
                  SFtoLA3.setFill(currentPlayer.getPlayerColor());
              } else if ( (city1.equals("SF") && city2.equals("LA")) || ((city1.equals("LA") && city2.equals("SF"))) ) {
                  SFtoLV1.setFill(currentPlayer.getPlayerColor());
                  SFtoLV2.setFill(currentPlayer.getPlayerColor());
                  SFtoLV3.setFill(currentPlayer.getPlayerColor());
              } else if ( (city1.equals("SD") && city2.equals("LA")) || ((city1.equals("LA") && city2.equals("SD"))) ) {
                  LAtoSD1.setFill(currentPlayer.getPlayerColor());
                  LAtoSD2.setFill(currentPlayer.getPlayerColor());
              } else if ( (city1.equals("SD") && city2.equals("LV")) || ((city1.equals("LV") && city2.equals("SD"))) ) {
                  SDtoLV1.setFill(currentPlayer.getPlayerColor());
                  SDtoLV2.setFill(currentPlayer.getPlayerColor());
                  SDtoLV3.setFill(currentPlayer.getPlayerColor());
                  SDtoLV4.setFill(currentPlayer.getPlayerColor());
              }

              city1 = "";
              city2 = "";
              SF.setStyle(null);
              LA.setStyle(null);
              SD.setStyle(null);
              LV.setStyle(null);
          }

          currentPlayer = gameLogic.getCurrentPlayer(currentPlayer, player1, player2);
           if ( (city1.equals("SF") && city2.equals("LA")) || ((city1.equals("LA") && city2.equals("SF"))) ) {
               SFtoLA1.setFill(currentPlayer.getPlayerColor());
               SFtoLA2.setFill(currentPlayer.getPlayerColor());
               SFtoLA3.setFill(currentPlayer.getPlayerColor());
           } else if ( (city1.equals("SF") && city2.equals("LV")) || ((city1.equals("LV") && city2.equals("SF"))) ) {
               SFtoLV1.setFill(currentPlayer.getPlayerColor());
               SFtoLV2.setFill(currentPlayer.getPlayerColor());
               SFtoLV3.setFill(currentPlayer.getPlayerColor());
           } else if ( (city1.equals("SD") && city2.equals("LA")) || ((city1.equals("LA") && city2.equals("SD"))) ) {
               LAtoSD1.setFill(currentPlayer.getPlayerColor());
               LAtoSD2.setFill(currentPlayer.getPlayerColor());
           }
           city1 = "";
           city2 = "";
           SF.setStyle(null);
           LA.setStyle(null);
           SD.setStyle(null);
           LV.setStyle(null);
       }
    }
}

