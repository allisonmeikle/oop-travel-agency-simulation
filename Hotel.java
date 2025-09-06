package assignment1;

public class Hotel {
    private String name;
    private Room[] rooms;

    public Hotel(String name, Room[] rooms){
        this.name = name;

        Room [] deepCopy = new Room[rooms.length];

        for (int i=0;i<rooms.length;i++){
            deepCopy[i] = new Room(rooms[i]);
        }
        this.rooms = deepCopy;
    }

    public int reserveRoom(String roomType){
        Room chosenRoom = Room.findAvailableRoom(this.rooms, roomType);

        if (chosenRoom == null){
            throw new IllegalArgumentException("No room of this type is available to be reserved.");
        }
        chosenRoom.changeAvailability();
        return chosenRoom.getPrice();
    }

    public boolean cancelRoom(String type){
        return Room.makeRoomAvailable(this.rooms, type);
    }
}

