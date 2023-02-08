package service;

import java.util.List;

import domain.Car;
import domain.Cars;
import domain.Rule;
import utils.RandomNumberGenerator;
import utils.exception.AlreadyDefinedFieldException;

public class Service {
    private final Cars cars = new Cars(new RandomNumberGenerator());
    private Rule rule;

    public void setCars(List<String> carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void setTrial(Long trial) {
        if (rule != null) {
            rule = new Rule(trial);
            return;
        }

        throw new AlreadyDefinedFieldException();
    }

    public void move() {
        cars.move();
    }

    public Long getTrial() {
        return rule.getTrial();
    }

    public List<String> getMoveResult() {
        return cars.getResult();
    }
}