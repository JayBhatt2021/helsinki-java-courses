public class Main {
    public static void main(String[] args) {
        Room room = new Room();
        room.add(new Person("Alice", 160));
        room.add(new Person("Bob", 175));
        room.add(new Person("Charlie", 150));

        System.out.println("Room is empty: " + room.isEmpty());
        System.out.println("\nPersons in the room:");
        for (Person person : room.getPersons()) {
            System.out.println(person);
        }

        Person shortestPerson = room.shortest();
        System.out.println("\nShortest person: " + shortestPerson);

        Person takenPerson = room.take();
        System.out.println("\nTaken person: " + takenPerson);
        System.out.println("Updated persons in the room:");
        for (Person person : room.getPersons()) {
            System.out.println(person);
        }
    }
}
