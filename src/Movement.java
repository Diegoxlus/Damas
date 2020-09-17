public abstract class Movement{
    Coordinate origin;
    Coordinate destination;

    public Movement(Coordinate origin, Coordinate destination) {
        this.origin = origin;
        this.destination = destination;
    }

    public Coordinate getOrigin() {
        return origin;
    }

    public void setOrigin(Coordinate origin) {
        this.origin = origin;
    }

    public Coordinate getDestination() {
        return destination;
    }

    public void setDestination(Coordinate destination) {
        this.destination = destination;
    }
}
