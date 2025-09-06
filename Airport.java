package assignment1;

public class Airport {
    private int xCoord;
    private int yCoord;
    private int fees;

    public Airport(int xPos, int yPos, int fees) {
        this.xCoord = xPos;
        this.yCoord = yPos;
        this.fees = fees;
    }

    public int getFees(){
        return this.fees;
    }

    public int[] getCoords(){
        int[] position = {this.xCoord, this.yCoord};
        return position;
    }
    public static int getDistance(Airport airport1, Airport airport2){
        int x1 = (airport1.getCoords())[0];
        int y1 = (airport1.getCoords())[1];
        int x2 = (airport2.getCoords())[0];
        int y2 = (airport2.getCoords())[1];

        double distance = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));

        if (distance > (int)distance){
            distance = (int)distance + 1;
        }
        return (int)distance;
    }
}

