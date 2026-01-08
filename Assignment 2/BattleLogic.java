package com.mopokens.battle;
import java.util.*;
public class BattleLogic {
    static List<Mopoken> findWinningOrder(
            List<Mopoken> Mine,
            List<Mopoken> opponent) {
        List<Mopoken> mine = new ArrayList<>(Mine);
        List<Mopoken> chosenOrder = new ArrayList<>();
        int advantageCount = 0;
        for (Mopoken opp : opponent) {
            Mopoken best = chooseBestAgainst(mine, opp);
            if (best == null) {
                return null;
            }
            if (hasAdvantage(best, opp)) {
                advantageCount++;
            }
            chosenOrder.add(best);
            mine.remove(best);
        }
        return advantageCount >= 3 ? chosenOrder : null;
    }

    private static Mopoken chooseBestAgainst(List<Mopoken> mine,   Mopoken opponent) {
        Mopoken best = null;
        for (Mopoken m : mine) {
            if (best == null) {
                best = m;
                continue;
            }
            if (hasTypeAdvantage(m.getMopokenType(), opponent.getMopokenType())
                    && !hasTypeAdvantage(best.getMopokenType(), opponent.getMopokenType())) {
                best = m;
                continue;
            }
            if (m.getMopokenLevel() > best.getMopokenLevel()) {
                best = m;
            }
        }
        return best;
    }
    private static boolean hasAdvantage(Mopoken mine,Mopoken opponent) {
        boolean mineAdv = hasTypeAdvantage(mine.getMopokenType(), opponent.getMopokenType());
        boolean oppAdv = hasTypeAdvantage(opponent.getMopokenType(), mine.getMopokenType());
        if (mineAdv && !oppAdv) {
            return opponent.getMopokenLevel() < mine.getMopokenLevel() * 2;
        }
        if (oppAdv && !mineAdv) {
            return mine.getMopokenLevel() >= opponent.getMopokenLevel() * 2;
        }
        return mine.getMopokenLevel() > opponent.getMopokenLevel();
    }
    private static boolean hasTypeAdvantage(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        return (a.equals("fire") && (b.equals("grass") || b.equals("ghost"))) ||
               (a.equals("water") && b.equals("fire")) ||
               (a.equals("grass") && (b.equals("electric") || b.equals("fighting"))) ||
               (a.equals("electric") && b.equals("water")) ||
               (a.equals("psychic") && b.equals("ghost")) ||
               (a.equals("ghost") && (b.equals("fighting") || b.equals("fire") || b.equals("electric"))) ||
               (a.equals("fighting") && b.equals("electric"));
    }
}
