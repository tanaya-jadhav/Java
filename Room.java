public class Room {
    int numberInRoom;
    private static int totalNumber;

    public void addOneToRoom() {
        this.numberInRoom ++;
        totalNumber++;

    }

    public void removeOneFromRoom() {
        if (this.numberInRoom > 0) {
            this.numberInRoom --;
            totalNumber --;
        }
    }

    public int getNumber() {
        return this.numberInRoom;

    }

    public static int getTotal() {
        return totalNumber;
    }
}
