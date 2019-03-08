package PrimeWrapper.Beans;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class DataListView implements Serializable {

    private List<Car> cars;

    private Car selectedCar;

    @PostConstruct
    public void init() {
        cars = Car.getCars();
    }

    public List<Car> getCars() {
        return cars;
    }

    public Car getSelectedCar() {
        return selectedCar;
    }

    public void setSelectedCar(Car selectedCar) {
        this.selectedCar = selectedCar;
    }
}

