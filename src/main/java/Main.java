import pojo.Interval;
import util.IntervalCalculationUtils;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Interval[] intervals = new Interval[]{new Interval(1, 3), new Interval(5, 12),
                new Interval(7, 15),new Interval(100,200),
                new Interval(110, 210), new Interval(50,500)};

        List<Interval> calculatedIntervals = IntervalCalculationUtils.calculateIntervalIntersection(intervals);
        calculatedIntervals.stream().forEach(System.out::println);
    }
}

