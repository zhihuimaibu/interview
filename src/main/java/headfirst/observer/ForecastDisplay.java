/*
package headfirst.observer;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer,DisplayElement {
    private float temp ;
    private float humi;
    private  Observable observable;
    public ForecastDisplay(Observable observable ){
        this.observable = observable;
        observable.addObserver(this);
    }
    public void display() {
        System.out.println("temp"+temp+"humi:"+"humi");
    }

    public void update(Observable o, Object arg) {
        if(o instanceof  WeatherData2){
            WeatherData2 ob = (WeatherData2)o;
            temp = ob.getTemp();
            humi = ob.getHumi();
            display();
        }
    }
}
*/
