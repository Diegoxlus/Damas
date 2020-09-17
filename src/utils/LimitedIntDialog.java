package utils;

public class LimitedIntDialog extends WithConsoleModel {
    private final int LIMIT;

    public LimitedIntDialog(int limit){
        this.LIMIT = limit;
    }

    public int read(String message){
        boolean error;
        int value;
        do{
         value = this.console.readInt(message + "[0-" + this.LIMIT +"]");
         error = new ClosedInterval(this.LIMIT).include(value);
         if(error){
             this.console.writeError("NOT IN RANGE");
         }
        } while (error);
        return value;
    }
}
