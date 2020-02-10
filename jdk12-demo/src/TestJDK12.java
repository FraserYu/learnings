import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * 测试JDK12 Collectors. teeing API
 *
 * @author fraser
 * @date 2019/11/5 2:26 PM
 */
public class TestJDK12 {

	public static void main(String[] args) {

		NumberFormat formatter = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);

		String formattedString = formatter.format(25000L);
		System.out.println(formattedString);

//		Path file1 = Paths.get("/Users/fraser/Documents/projects/personal/learning-demo-collection/jdk12-demo/src/file1.txt");
//		Path file2 = Paths.get("/Users/fraser/Documents/projects/personal/learning-demo-collection/jdk12-demo/src/file2.txt");
//
//
//		try {
//			long mismatch = Files.mismatch(file1, file2);
//			System.out.println(mismatch);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

//		List<String> names = List.of( "   Alex", "brian");
//
//		List<String> transformedNames = new ArrayList<>();
//
//		for (String name : names)
//		{
//			String transformedName = name.transform(String::strip)
//					.transform(StringUtils::toCamelCase);
//
//			transformedNames.add(transformedName);
//		}


//		String result = "foo\nbar\n\tbar2".indent(4);
//
//		System.out.println(result);
//		CountSum countsum = Stream.of(2, 11, 1, 5, 7, 8, 12)
//				.collect(Collectors.teeing(
//						counting(),
//						summingInt(e -> e),
//						CountSum::new));
//
//		System.out.println(countsum.toString());
//
//		//---------------------------------------------------------------------------------------
//
//		MinMax minmax = Stream.of(null, 2, 11, 1, 5, 7, 8, 12)
//				.collect(Collectors.teeing(
//						minBy(Comparator.nullsFirst(Comparator.naturalOrder())),
//						maxBy(Comparator.nullsLast(Comparator.naturalOrder())),
//						(Optional<Integer> a, Optional<Integer> b) -> new MinMax(a.orElse(Integer.MIN_VALUE), b.orElse(Integer.MAX_VALUE))));
//
//		System.out.println(minmax.toString());
//
//		//---------------------------------------------------------------------------------------
//
//		List<Melon> melons = Arrays.asList(new Melon("Crenshaw", 1200),
//				new Melon("Gac", 3000), new Melon("Hemi", 2600),
//				new Melon("Hemi", 1600), new Melon("Gac", 1200),
//				new Melon("Apollo", 2600), new Melon("Horned", 1700),
//				new Melon("Gac", 3000), new Melon("Hemi", 2600)
//		);
//
//
//		WeightsAndTotal weightsAndTotal = melons.stream()
//				.collect(Collectors.teeing(
//						summingInt(Melon::getWeight),
//						mapping(m -> m.getWeight(), toList()),
//						WeightsAndTotal::new));
//
//		System.out.println(weightsAndTotal.toString());
//
//		//---------------------------------------------------------------------------------------
//
//		var result = Stream.of(
//						new Guest("Marco", true, 3),
//						new Guest("David", false, 2),
//						new Guest("Roger",true, 6))
//						.collect(Collectors.teeing(
//								Collectors.filtering(Guest::isParticipating, Collectors.mapping(Guest::getName, Collectors.toList())),
//								Collectors.summingInt(Guest::getParticipantsNumber),
//								EventParticipation::new
//						));
//		System.out.println(result);
	}
}


class CountSum {
	private final Long count;
	private final Integer sum;
	public CountSum(Long count, Integer sum) {
		this.count = count;
		this.sum = sum;
	}

	@Override
	public String toString() {
		return "CountSum{" +
				"count=" + count +
				", sum=" + sum +
				'}';
	}
}


class MinMax {
	private final Integer min;
	private final Integer max;
	public MinMax(Integer min, Integer max) {
		this.min = min;
		this.max = max;
	}

	@Override
	public String toString() {
		return "MinMax{" +
				"min=" + min +
				", max=" + max +
				'}';
	}
}


class Melon {
	private final String type;
	private final int weight;
	public Melon(String type, int weight) {
		this.type = type;
		this.weight = weight;
	}

	public String getType() {
		return type;
	}

	public int getWeight() {
		return weight;
	}
}

class WeightsAndTotal {
	private final int totalWeight;
	private final List<Integer> weights;
	public WeightsAndTotal(int totalWeight, List<Integer> weights) {
		this.totalWeight = totalWeight;
		this.weights = weights;
	}

	@Override
	public String toString() {
		return "WeightsAndTotal{" +
				"totalWeight=" + totalWeight +
				", weights=" + weights +
				'}';
	}
}

class Guest {
	private String name;
	private boolean participating;
	private Integer participantsNumber;

	public Guest(String name, boolean participating, Integer participantsNumber) {
		this.name = name;
		this.participating = participating;
		this.participantsNumber = participantsNumber;
	}
	public boolean isParticipating() {
		return participating;
	}

	public Integer getParticipantsNumber() {
		return participantsNumber;
	}

	public String getName() {
		return name;
	}
}

class EventParticipation {
	private List<String> guestNameList;
	private Integer totalNumberOfParticipants;

	public EventParticipation(List<String> guestNameList, Integer totalNumberOfParticipants) {
		this.guestNameList = guestNameList;
		this.totalNumberOfParticipants = totalNumberOfParticipants;
	}

	@Override
	public String toString() {
		return "EventParticipation { " +
				"guests = " + guestNameList +
				", total number of participants = " + totalNumberOfParticipants +
				" }";
	}
}
