public class TimeSlot implements ITimeSlot {

    private final IDateTime start;
    private final IDateTime end;

    public TimeSlot(IDateTime start, IDateTime end) {

        if (start == null || end == null || start.compareTo(end) >= 0) {
            throw new IllegalArgumentException(
                    "Start time must be before end time."
            );
        }

        this.start = start;
        this.end = end;
    }

    @Override
    public IDateTime getStart() {
        return start;
    }

    @Override
    public IDateTime getEnd() {
        return end;
    }

    @Override
    public int compareTo(ITimeSlot other) {

        if (end.compareTo(other.getStart()) <= 0) {
            return -1;
        }

        if (start.compareTo(other.getEnd()) >= 0) {
            return 1;
        }

        return 0;
    }

    @Override
    public String toString() {
        return "[" + start.format() + " - " + end.format() + ")";
    }
}