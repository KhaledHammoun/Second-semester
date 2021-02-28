package S02_ObserverPattern.Ex3_4;

public class Start
{
  public static void main(String[] args)
  {
    SoccerMatch soccerMatch = new SoccerMatch();
    OldBoysFan oldBoys1=new OldBoysFan();
    soccerMatch.addPropertyChangeListener(oldBoys1);
    DreamTeamFan dreamTeam=new DreamTeamFan(soccerMatch);
    Referee referee=new Referee(soccerMatch);
    AngryCoach angryCoach=new AngryCoach(soccerMatch, soccerMatch.getTeam0());
    AngryCoach coach=new AngryCoach(soccerMatch, soccerMatch.getTeam1());
    ScoreBoard score=new ScoreBoard(soccerMatch);
    Medic medic1=new Medic(soccerMatch);
    soccerMatch.startMatch();
  }
}
