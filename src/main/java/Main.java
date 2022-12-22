import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Interval[] intervals = new Interval[]{new Interval(23, 35), new Interval(5, 12), new Interval(7, 15),new Interval(100,200), new Interval(110, 210)};

        List<Interval> calculatedIntervals = calculateInteval(intervals);
        calculatedIntervals.stream().forEach(System.out::println);
    }

    public static List<Interval> calculateInteval(Interval[] intervals) {
        int[] intervalSequences = getSequencesFromInterval(intervals);
        return checkIntegerMatchAndReturnInterval(intervalSequences);
    }

    private static int[] getSequencesFromInterval(Interval[] intervals){
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            Interval interval = intervals[i];
            integers.add(interval.getStart());
            integers.add(interval.getFinish());
        }
        return integers.stream().mapToInt(i -> i).toArray();
    }

    public static List<Interval> checkIntegerMatchAndReturnInterval(int[] values) {
        List<Interval> intervals = new ArrayList<>();
        List<Integer> sortedRange = getRangesBetweenValues(values)
                .stream()
                .sorted(Integer::compareTo)
                .distinct()
                .collect(Collectors.toList());

        int start = sortedRange.get(0);
        for (int i = 0; i < sortedRange.size(); i++) {
            int currentVal = sortedRange.get(i);
            int nextVal = sortedRange.size() == i + 1 ? 0 : sortedRange.get(i + 1);

            if (currentVal + 1 != nextVal) {
                int finish = sortedRange.get(i);
                intervals.add(new Interval(start, finish));
                start = nextVal;
            }
        }

        return intervals;
    }

    private static List<Integer> getRangesBetweenValues(int[] values){
        List<Integer> range = new ArrayList<>();
        for (int i = 0; i < values.length; i = i + 2) {
            for (int j = values[i]; j <= values[i + 1]; j++) {
                range.add(j);
            }
        }

        return range;
    }
}


class Interval {
    public int start;
    public int finish;

    public Interval(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }

    public Interval() {
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getFinish() {
        return finish;
    }

    public void setFinish(int finish) {
        this.finish = finish;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", finish=" + finish +
                '}';
    }
}

