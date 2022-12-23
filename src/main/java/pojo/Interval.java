package pojo;

public class Interval {
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
        return "entity.Interval{" +
                "start=" + start +
                ", finish=" + finish +
                '}';
    }
}