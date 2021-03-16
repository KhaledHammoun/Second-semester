package Ex3_4;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

public class SoccerMatch implements PropertyChangeSubject{

	private String team0 = "Dream Team";
	private String team1 = "Old Boys";
	private PropertyChangeSupport support = new PropertyChangeSupport(this);

	public String getTeam0()
	{
		return team0;
	}
	public String getTeam1()
	{
		return team1;
	}

	public void startMatch() {
		System.out.println("Match starting \n\n");
		Random random = new Random();
		for(int i = 0; i < 90; i++) {

			int rand = random.nextInt(100);
			int whichTeam = random.nextInt(2);

			if(rand < 8) {
				// score goal
				scoreGoal(whichTeam);
			} else if(rand < 12) {
				// penalty
				roughTackle(whichTeam);
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				break;
			}
		}
		
		System.out.println("\n\nMatch ended");
	}

	private void roughTackle(int whichTeam) {
		if(whichTeam == 0) {
			support.firePropertyChange("Dream Team gets penalty", 0, 1);
		} else {
			support.firePropertyChange("Old Boys get penalty", 0, 2);
		}
	}

	private void scoreGoal(int whichTeam) {
		if(whichTeam == 0) {
			support.firePropertyChange("Dream Team scored goal", 0, 1);
		} else {
			support.firePropertyChange("Old Boys scored goal", 0, 1);
		}
	}

	@Override public void addPropertyChangeListener(String name,
			PropertyChangeListener listener)
	{
			support.addPropertyChangeListener(name, listener);
	}

	@Override public void addPropertyChangeListener(
			PropertyChangeListener listener)
	{
			support.addPropertyChangeListener(listener);
	}

	@Override public void removePropertyChangeListener(String name,
			PropertyChangeListener listener)
	{
			support.removePropertyChangeListener(name, listener);
	}

	@Override public void removePropertyChangeListener(
			PropertyChangeListener listener)
	{
			support.removePropertyChangeListener(listener);
	}
}
