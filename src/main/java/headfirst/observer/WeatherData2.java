/*
package headfirst.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class WeatherData2 extends Observable {
    private float temp;
    private float humi;

    public void measurementsChanged(){
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(float temp,float humi,float press){
        this.temp = temp;
        this.humi = humi;
        measurementsChanged();
    }

    public  float getTemp(){
        return temp;
    }

    public float getHumi(){
        return humi;
    }

}
*/
