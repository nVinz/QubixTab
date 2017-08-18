package ru.brainrtp.core.scoreboard;

import ru.brainrtp.core.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnimatedScoreBoard {

    public AnimatedScoreBoard(){
        this.startScoreBoardTask();
    }
    private void startScoreBoardTask(){
        Map<Integer, List<String>> scoreboardData = new HashMap<>();

        List<String> title = new ArrayList<>();
        title.add("Це мой сурвир");

        List<String> lineOne = new ArrayList<>();
        lineOne.add("Х");
        lineOne.add("Ху");
        lineOne.add("Хуй");
        lineOne.add("Хуй!");

        List<String> two = new ArrayList<>();
        two.add("01");
        two.add("02");
        two.add("03");
        two.add("04");
        two.add("05");

        List<String> lineT = new ArrayList<>();
        lineT.add("1");
        lineT.add("2");
        lineT.add("3");
        lineT.add("4");
        lineT.add("5");

        scoreboardData.put(0, lineOne);
        scoreboardData.put(1, two);
        scoreboardData.put(2, lineT);

        new ScoreBoardTask(this, title, scoreboardData, lineOne.size()).runTaskTimer(Main.main, 0, 5);
    }
}
