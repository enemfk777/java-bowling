package bowling.domain.state;

import bowling.domain.DownedPinCount;

import java.util.Objects;

public class Open implements State {
	private static final String SPLITTER = "|";
	private final DownedPinCount first;
	private final DownedPinCount second;

	Open(DownedPinCount first, DownedPinCount second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public State roll(DownedPinCount downedPinCount) {
		return this;
	}

	@Override
	public boolean isDone() {
		return true;
	}

	@Override
	public String reportState() {
		return convertReportPattern(first) + SPLITTER + convertReportPattern(second);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Open open = (Open) o;
		return first == open.first &&
				second == open.second;
	}

	@Override
	public int hashCode() {
		return Objects.hash(first, second);
	}
}
