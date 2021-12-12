package Main;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Sport implements Comparable{
    String name;
    Integer countries;
    Boolean isOlympic;
    private SimpleStringProperty nameData;
    private SimpleIntegerProperty countriesData;
    private SimpleBooleanProperty isOlympicData;
    public Sport(String name, String countries, String isOlympic){
        this.name = name;
        this.countries = Integer.parseInt(countries);
        this.isOlympic = Boolean.parseBoolean(isOlympic);
        this.nameData = new SimpleStringProperty(this.name);
        this.countriesData = new SimpleIntegerProperty(this.countries);
        this.isOlympicData = new SimpleBooleanProperty(this.isOlympic);
    }

    public String getNameData() {
        return nameData.get();
    }

    public SimpleStringProperty nameDataProperty() {
        return nameData;
    }

    public void setNameData(String nameData) {
        this.nameData.set(nameData);
    }

    public int getCountriesData() {
        return countriesData.get();
    }

    public SimpleIntegerProperty countriesDataProperty() {
        return countriesData;
    }

    public void setCountriesData(int countriesData) {
        this.countriesData.set(countriesData);
    }

    public boolean isIsOlympicData() {
        return isOlympicData.get();
    }

    public SimpleBooleanProperty isOlympicDataProperty() {
        return isOlympicData;
    }

    public void setIsOlympicData(boolean isOlympicData) {
        this.isOlympicData.set(isOlympicData);
    }

    @Override
    public String toString() {
        return "Sport{ " +
                "name = " + name + '\'' +
                ", countries = " + countries +
                ", isOlympic = " + isOlympic +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Sport sport = (Sport) o;
        if (this.name.compareTo(sport.name) != 0){
            return this.name.compareTo(sport.name);
        }else {
            if (this.countries.compareTo(sport.countries) != 0){
                return this.countries.compareTo(sport.countries);
            }else {
                return this.isOlympic.compareTo(sport.isOlympic);
            }
        }
    }
}
