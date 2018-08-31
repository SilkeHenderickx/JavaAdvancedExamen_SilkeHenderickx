package edu.ap.spring;

import java.awt.Point;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

@Component
public class Exam {
	
	// Maak gebruik van lambdas en streams om een array met alle
	// getallen terug te geven die deelbaar zijn door twee
	// 2 punten
	public int[] getTimesTwo(int[] numbers) {
		int[] result = Arrays.stream(numbers)
				.filter(n -> n % 2 == 0)
				.toArray();

		/*for (int r:
			 result) {
			System.out.println(r);
		}
		*/
		return result;
	}
	
	// Maak gebruik van lambdas en streams om alle uppercase characters
	// te tellen in de gegeven string
	// 1 punt
	public int countUppercaseCharacters(String sentence) {
		int result = (int)sentence.chars()
				.map(i -> (char) i)
				.filter(Character::isUpperCase)
				.count();
		//System.out.println(result);
		return result;
	}
	
	// Maak gebruik van lambdas en streams om het aantal keren te tellen
	// dat string s voorkomt (zowel uppercase als lowercase) in de lijst names
	// 1 punt
	public int countChar(List<String> names, String s) {
		//int r = (int)names.stream()
		//		.map(n -> n.toUpperCase().contains(s.toUpperCase()));

		char x = Character.toUpperCase(s.charAt(0));

		String concatStrings = names.stream()
				.map(n -> n.toUpperCase())
				.reduce("", String::concat);
		//System.out.println(concatStrings);
		Integer result = (int)concatStrings.chars()
				.filter(c -> c == x )
				.count();

		//System.out.println(result);
		return result;
	}
	
	// Maak gebruik van lambdas en streams om het hoogste Y coordinaat
	// te vinden
	// 2 punten
	public int getMaxY(List<Point> points) {
		int result = points.stream()
				.mapToInt(p -> p.y)
				.max().orElseThrow(NoSuchElementException::new);
		//System.out.println(result);
		return result;
	}	
}