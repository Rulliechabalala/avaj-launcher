package avaj_launcher;


import java.util.ArrayList;

public abstract class Tower {
	private ArrayList<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable)
	{
		observers.add(flyable);
		Logger.log("Tower says: " + flyable.getDescription() + " registered to weather tower.");
	}

	public  void unregister(Flyable flyable)
	{
		observers.remove(flyable);
		Logger.log("Tower says: " + flyable.getDescription() + " unregistered from weather tower.");
	}

	protected void conditionsChanged()
	{
		for(int i = 0; i < observers.size(); i++)
		{
			observers.get(i).updateConditions();
		}
	}
}
