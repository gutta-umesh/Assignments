package com.mopokens.battle;
import java.util.*;
public class Battle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String myInput = sc.nextLine();
        String opponentInput = sc.nextLine();
        Breeder myBreeder = InputParser.parseBreeder(myInput);
        Breeder opponentBreeder = InputParser.parseBreeder(opponentInput);
        BreederValidation breederValidation = new BreederValidation();
        breederValidation.validate(myBreeder);
        breederValidation.validate(opponentBreeder);
        List<Mopoken> result =
                BattleLogic.findWinningOrder(
                        myBreeder.mopokens,
                        opponentBreeder.mopokens
                );
        if (result == null) {
            System.out.println("There are no chance of winning");
        } else {
            System.out.println(formatOutput(result));
        }
        sc.close();
    }
    private static String formatOutput(List<Mopoken> list) {
        return String.join(";", list.toString()
                                   .replace("[","")
                                   .replace("]","")
                                   .split(","));
    }

}
