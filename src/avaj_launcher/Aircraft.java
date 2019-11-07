package avaj_launcher;

public abstract class Aircraft {
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	protected String type;

	private static long idCounter = 0;

	protected Aircraft(String spName, Coordinates sp_coordinates)
	{
		this.name = spName;
		this.coordinates = sp_coordinates;
		this.id = this.nextId();
	}

	private long nextId()
	{
		Aircraft.idCounter++;
		return Aircraft.idCounter - 1;
	}

	protected void log(String message)
	{
		String toLog = getDescription() + ": " + message;
		Logger.log(toLog);
	}

	public String getDescription()
	{
		return this.type + '#' + this.name + '(' + this.id + ")";
	}

	protected void move(Coordinates coords)
	{
		int	changedLatitude;
		int	changedLongitude;
		int	changedHeight;

		if (coords.getHeight() > 100)
			changedHeight = 100;
		else if (coords.getHeight() <= 0)
		{
			this.coordinates = new Coordinates(coords.getLongitude(), coords.getLatitude(), 0);
			land();
			return ;
		}
		else
			changedHeight = coords.getHeight();

		if (coords.getLatitude() < 0)
			changedLatitude = 0;
		else
			changedLatitude = coords.getLatitude();

		if (coords.getLongitude() < 0)
			changedLongitude = 0;
		else
			changedLongitude = coords.getLongitude();

		this.coordinates = new Coordinates(changedLongitude, changedLatitude, changedHeight);
	}

	protected abstract void land();
}
