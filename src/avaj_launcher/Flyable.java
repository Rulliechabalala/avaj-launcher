package avaj_launcher;

public interface Flyable {
	void updateConditions();
	void registerTower(WeatherTower weatherTower);
	String getDescription();
}
