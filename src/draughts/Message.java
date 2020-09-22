package draughts;

import utils.Console;

enum Message {
    NUMBER_PLAYERS("Enter the number of players"),
    NAME_PLAYERS("Enter the name of player"),
    ENTER_COORDINATE_TO_REMOVE("Enter a coordinate to remove a piece:"),
    ENTER_COORDINATE_TO_PUT("Enter a coordinate to put a piece:"),
    RESUME("Do you want to continue");


     private String message;

     private Message() {

     }
     private Message(String message) {
         this.message = message;
     }

     void write() {
         Console.instance().write(this.message);
     }

     void writeln() {
         Console.instance().writeln(this.message);
     }

     @Override
     public String toString() {
         return this.message;
     }

 }


