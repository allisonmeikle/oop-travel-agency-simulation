package assignment1;

public class Room {
    private String type;
    private int price;
    private boolean isAvailable;

    public Room (String type){
        if(type.equals("double") || type.equals("queen") || type.equals("king")) {
            this.type = type;
        } else {
            throw new IllegalArgumentException("A room of the specified type does not exist so it cannot be created.");
        }

        this.isAvailable = true;

        if (this.type.equals("double")){
            this.price = 90*100;
        } else if (this.type.equals("queen")) {
            this.price = 110*100;
        } else if (this.type.equals("king")){
            this.price = 150*100;
        }
    }
    public Room (Room inputRoom){
        this.price = inputRoom.price;
        this.isAvailable = inputRoom.isAvailable;
        this.type = inputRoom.type;
    }

    public String getType(){
        return this.type;
    }
    public int getPrice(){
        return this.price;
    }

    public void changeAvailability(){
        this.isAvailable = !this.isAvailable;
    }

    public static Room findAvailableRoom(Room[] rooms, String inputType){
        Room[] availableRooms;
        if (rooms.length == 0){
            return null;
        }

        for (Room currentRoom : rooms){
            if (currentRoom != null){
                if (currentRoom.isAvailable && currentRoom.type.equals(inputType)){
                    return currentRoom;
                }
            }
        }
        return null;
    }

    public static boolean makeRoomAvailable(Room[] rooms, String inputType){
        for (Room currentRoom : rooms){
            if (currentRoom != null) {
                if (!currentRoom.isAvailable && currentRoom.type.equals(inputType)) {
                    currentRoom.isAvailable = true;
                    return true;
                }
            }
        }
        return false;
    }
}
