package util;

import pojo.Interval;

import java.util.*;
import java.util.stream.Collectors;

public class IntervalCalculationUtils {

    public static List<Interval> calculateIntervalIntersection(Interval[] intervals) {
        List<Integer> intervalValues = getIntervalsValue(intervals);
        return defineIntersectionAndReturnIntervals(intervalValues);
    }

    private static List<Integer> getIntervalsValue(Interval[] intervals){
        return Arrays.stream(intervals)
                .map(el->List.of(el.getStart(), el.getFinish()))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private static List<Interval> defineIntersectionAndReturnIntervals(List<Integer> values) {
        List<Integer> sortedRange = new ArrayList<>(getRangesBetweenValues(values));
        List<Interval> resultIntervals = new ArrayList<>();

        int start = sortedRange.get(0);
        for (int i = 0; i < sortedRange.size() - 1; i++) {
            int currentVal = sortedRange.get(i);
            int nextVal = sortedRange.get(i + 1);
            boolean isLastIteration = sortedRange.size() == i + 2;

            if (currentVal + 1 != nextVal || isLastIteration) {
                int finish = isLastIteration? nextVal: currentVal;
                resultIntervals.add(new Interval(start, finish));
                start = nextVal;
            }
        }

        return resultIntervals;
    }

    private static Set<Integer> getRangesBetweenValues(List<Integer> values){
        Set<Integer> range = new TreeSet<>(Integer::compareTo);

        for (int i = 0; i < values.size(); i = i + 2) {
            for (int j = values.get(i); j <= values.get(i+1); j++) {
                range.add(j);
            }
        }

        return range;
    }
}
