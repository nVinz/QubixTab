package ru.brainrtp.core.scoreboard;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import ru.brainrtp.core.Main;

import java.util.List;
import java.util.Map;

public class ScoreBoardTask extends BukkitRunnable{

    private AnimatedScoreBoard animatedScoreBoard;
    private Map<Integer, List<String>> scoreboardContentMap;
    private List<String> title;
    private int maxCycles;

    public ScoreBoardTask(AnimatedScoreBoard animatedScoreBoard, List<String> title, Map<Integer, List<String>> scoreboardContentMap, int maxCycles){
        this.animatedScoreBoard = animatedScoreBoard;
        this.scoreboardContentMap = scoreboardContentMap;
        this.title = title;
        this.maxCycles = maxCycles;
    }
    private String previousTitle = null;
    private int currentCycle = 0;

//    public ScoreBoardTask(AnimatedScoreBoard animatedScoreBoard, List<String> title, Map<Integer, List<String>> scoreboardData, int size) {
//    }

    @Override
    public void run(){
        Scoreboard scoreboard = Main.main.getServer().getScoreboardManager().getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("dummy", "dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        if (maxCycles == currentCycle){
            currentCycle = 0;
        }

        if(title.size() > currentCycle){
            objective.setDisplayName(ChatColor.translateAlternateColorCodes('&', title.get(currentCycle)));
            previousTitle = title.get(currentCycle);
        } else {
            if (previousTitle == null){
                objective.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&cNo title :("));
            } else {
                objective.setDisplayName(ChatColor.translateAlternateColorCodes('&', previousTitle));
            }
        }

        for (Map.Entry<Integer, List<String>> entry: scoreboardContentMap.entrySet()){
            if (!(entry.getValue().size() < currentCycle) && entry.getValue().size() != 0){
                String text = entry.getValue().get(currentCycle);
                objective.getScore(ChatColor.translateAlternateColorCodes('&', text)).setScore(entry.getKey());
            }
        }

        for (Player player : Main.main.getServer().getOnlinePlayers()){
            player.setScoreboard(scoreboard);
        }

        currentCycle++;
    }
}
