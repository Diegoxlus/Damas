package draughts;

import utils.Console;

enum Message {
    NAME_PLAYERS("Enter the name of player: "),
    ENTER_COORDINATE_TO_REMOVE("Enter the origin coordinate:"),
    ENTER_COORDINATE_TO_PUT("Enter the target coordinate:"),
    RESUME("Do you want to continue? ");

     private String message;

     private Message() {

     }
     Message(String message) {
         this.message = message;
     }

     void write() {
         Console.instance().write(this.message);
     }

     void writeln() {
         Console.instance().writeln(this.message);
     }

     public String concat(String name){
         return this.message+name;
     }

     @Override
     public String toString() {
         return this.message;
     }

 }


