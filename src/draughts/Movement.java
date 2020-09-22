package draughts;

public abstract class Movement{
    DraughtCoordinate origin;
    DraughtCoordinate destination;

    public Movement(DraughtCoordinate origin, DraughtCoordinate destination) {
        this.origin = origin;
        this.destination = destination;
    }

    public DraughtCoordinate getOrigin() {
        return origin;
    }

    public void setOrigin(DraughtCoordinate origin) {
        this.origin = origin;
    }

    public DraughtCoordinate getDestination() {
        return destination;
    }

    public void setDestination(DraughtCoordinate destination) {
        this.destination = destination;
    }
}
