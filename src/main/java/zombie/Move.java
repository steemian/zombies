
package zombie;

import java.util.concurrent.ThreadLocalRandom;

public enum Move implements Action {
    NORTHEAST(1, -1),
    NORTH(0, -1),
    NORTHWEST(-1, -1),
    EAST(1, 0),
    STAY(0, 0),
    WEST(-1, 0),
    SOUTHEAST(1, 1),
    SOUTH(0, 1),
    SOUTHWEST(-1, 1);
    
    public final int x;
    public final int y;

    private Move(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public static Move randomMove() {
        return values()[ThreadLocalRandom.current().nextInt(values().length)];
    }
    
    public static Move inDirection(int x, int y) {
        int realx = (int) Math.signum(x);
        int realy = (int) Math.signum(y);
        for (Move move: values()) {
            if (move.x == realx && move.y == realy) return move;
        }
        throw new IllegalStateException("There's no move towards (" + x + ", " + y + ")!?");
    }
}
