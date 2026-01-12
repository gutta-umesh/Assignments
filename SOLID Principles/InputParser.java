package com.mopokens.battle;
import java.util.ArrayList;
import java.util.List;
public class InputParser {
    static Breeder parseBreeder(String input) {
        String[] parts = input.split(";");
        List<Mopoken> mopokens = new ArrayList<>();
        for (String part : parts) {
            String[] data = part.split("#");
            String type = data[0].trim();
            int level = Integer.parseInt(data[1].trim());
            mopokens.add(new Mopoken(type, level));
        }
        return new Breeder(mopokens);
    }
}

