package java17.records;

record VideoGame(String title, int yearPublished) {}

public class RecordExample {

    public static void main(String[] args) {
        // Creating an instance of the Person record
        VideoGame game = new VideoGame("Paper Mario", 2000);

        // Accessing fields using automatically generated methods
        System.out.println("Title: " + game.title());
        System.out.println("Year published: " + game.yearPublished());

        // Using the generated toString() method
        System.out.println("Game: " + game);

        // Create another instance for equality check
        VideoGame anotherGame = new VideoGame("Animal Crossing", 2001);

        // Check equality
        System.out.println("Is game equal to anotherGame? " + game.equals(anotherGame));

        // Check hashCode
        System.out.println("Hash code of game: " + game.hashCode());
        System.out.println("Hash code of anotherGame: " + anotherGame.hashCode());
    }

}
