package sport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SportsMainClass {

    public static double getAverageWeight(List<SportsPlayer> players) {
        if (players.isEmpty()) {
            return 0;
        }

        int totalWeight = 0;
        for (SportsPlayer player : players) {
            totalWeight += player.getWeight();
        }

        return (double) totalWeight / players.size();
    }

    public static void main(String[] args) {

        ArrayList<SportsPlayer> players = new ArrayList<SportsPlayer>();

        players.add(new BasketBallPlayer(80, Gender.MALE, 190));
        players.add(new BasketBallPlayer(75, Gender.FEMALE, 185));
        players.add(new BaseballPlayer(85, Gender.MALE, 25));
        players.add(new BaseballPlayer(75, Gender.FEMALE, 15));
        players.add(new VolleyballPlayer(65, Gender.MALE, 25));
        players.add(new VolleyballPlayer(60, Gender.FEMALE, 30));
        players.add(new TrackPlayer(70, Gender.MALE, 1500));
        players.add(new TrackPlayer(65, Gender.FEMALE, 800));
        players.add(new CrossCountryPlayer(55, Gender.MALE, 4.2));
        players.add(new CrossCountryPlayer(50, Gender.FEMALE, 4.5));
        players.add(new ShotPutPlayer(90, Gender.MALE, 1800));
        players.add(new ShotPutPlayer(80, Gender.FEMALE, 1600));
        players.add(new PoleVaultPlayer(70, Gender.MALE, 550));
        players.add(new PoleVaultPlayer(65, Gender.FEMALE, 500));

        // sorting the players by weight in ascending order
        System.out.println("Sorted by weight in ascending order:");
        Collections.sort(players);
        for (SportsPlayer player : players) {
            System.out.println(player.toString());
        }

        // sorting the players by weight in descending order
        System.out.println("Sorted by weight in descending order:");
        Collections.sort(players, Collections.reverseOrder());
        for (SportsPlayer player : players) {
            System.out.println(player);
        }

        System.out.println("Average weight of all players: " + getAverageWeight(players) + "kgs");

        
    }

    
    
}
