package racingcar.view;

import racingcar.domain.car.Car;
import racingcar.controller.dto.GameManagerResponseDto;
import racingcar.domain.result.Result;

import java.util.List;

public class OutputView {
    private static final String ONE_STEP = "-";
    private static final String WINNERS_DELIMITER = ", ";
    private static final String STATUS_FORMAT = "%s : %s\n";

    public static void printResults(GameManagerResponseDto responseDto) {
        System.out.println("실행 결과");
        List<Result> results = responseDto.getResults();
        results.forEach(OutputView::printResult);
        printWinners(responseDto.getWinners());
    }

    private static void printResult(Result result) {
        List<Car> cars = result.getResult();
        for (Car car : cars) {
            System.out.printf(STATUS_FORMAT, car.getName(), printCarSteps(car.getPosition()));
        }
        printEmptyLine();
    }

    private static StringBuilder printCarSteps(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append(ONE_STEP);
        }
        return sb;
    }

    private static void printWinners(List<String> winners) {
        String result = String.join(WINNERS_DELIMITER, winners);
        System.out.println(result + "가 최종 우승했습니다.");
    }

    private static void printEmptyLine() {
        System.out.println();
    }
}