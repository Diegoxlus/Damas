package utils;

public class ClosedInterval {
    private final int MIN;
    private final int MAX;

    ClosedInterval(int min, int max){
        this.MIN = min;
        this.MAX = max;
    }
    ClosedInterval(int max){this(0,max);}

    boolean include(int value){return this.MIN<= value && value <= this.MAX ;}
}
