package headfirst.observer;

public class CurrentDisplay implements DisplayElement, Observer {
    private float temp;
    private float humi;
    private WeatherData WeatherData;

    public CurrentDisplay(WeatherData weatherData) {
        this.WeatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void display() {
        System.out.println("temp:" + temp + ";humi" + humi);
    }

    public void update(float temp, float humi, float press) {
        this.temp = temp;
        this.humi = humi;
        display();
    }
}
