package zombie;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import static zombie.Constants.*;

public class PlayerContext {
    private final PlayerId id;
    private final int bullets;
    private final int gameClock;
    private final PlayerId[][] playField;
    private final int x;
    private final int y;
    private final int boardSize;
    

    public PlayerContext(PlayerId id, int bullets, int gameClock, PlayerId[][] playField, int x, int y, int boardSize) {
        this.id = id;
        this.bullets = bullets;
        this.gameClock = gameClock;
        this.playField = playField;
        this.x = x;
        this.y = y;
        this.boardSize = boardSize;
    }

    public PlayerId getId() {
        return id;
    }

    public int getBullets() {
        return bullets;
    }

    public PlayerId[][] getPlayField() {
        return playField;
    }
    
    public Set<PlayerId> shootablePlayers() {
        Set<PlayerId> players = new HashSet<>();
        for (int x = CENTRE_OF_VISION - SHOOT_RANGE; x <= CENTRE_OF_VISION + SHOOT_RANGE; x++) {
            for (int y = CENTRE_OF_VISION - SHOOT_RANGE; y <= CENTRE_OF_VISION + SHOOT_RANGE; y++) {
                if (playField[x][y] != null) players.add(playField[x][y]);
            }
        }
        return Collections.unmodifiableSet(players);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public int getBoardSize() {
        return boardSize;
    }

    public int getGameClock() {
        return gameClock;
    }
    
    public PlayerId lookAround(int xOffset, int yOffset) {
        try {
            return playField[CENTRE_OF_VISION + xOffset][CENTRE_OF_VISION + yOffset];
        } catch (ArrayIndexOutOfBoundsException ex) {
            return null;
        }
    }
    
}
