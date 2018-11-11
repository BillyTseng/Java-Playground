package leet.topics.dynamicProgramming;

/* 837. New 21 Game - medium */

public class New21Game {
    // target : the goal of game, like 21. (original is N)
    // stopPoint : the point which stop drawing card. (original is K)
    // cardRange : card range.  (original is W)
    public double new21Game(int target, int stopPoint, int cardRange) {
        double[] WinChance = new double[target + cardRange + 1];
        // In area stopPoint to target, player always win the game.
        for (int k = stopPoint; k <= target; k++) {
            WinChance[k] = 1.0;
        }

        // if stopPoint is 16, we want to know the sum of k+1 to k+w. all is 1.0.
        double sum = Math.min(cardRange, target - stopPoint + 1);
        for (int k = stopPoint - 1; k >= 0; k--) {
            WinChance[k] = sum / cardRange;
            sum += WinChance[k] - WinChance[k + cardRange];
        }
        return WinChance[0];
    }
}
