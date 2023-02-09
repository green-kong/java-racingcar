package domain;

import utils.constants.ErrorMessages;

public class Car {
    private final String name;
    private Long status = 0L;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void move(int randomNumber) {
        if (randomNumber > 3) {
            status++;
        }
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessages.NAME_LENGTH.getMessage());
        }
    }

    public Long getStatus() {
        return status;
    }

    public String getResult() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" : ");
        for (int i = 0; i < status; i++) {
            stringBuilder.append("-");
        }
        return name + stringBuilder;
    }
}
