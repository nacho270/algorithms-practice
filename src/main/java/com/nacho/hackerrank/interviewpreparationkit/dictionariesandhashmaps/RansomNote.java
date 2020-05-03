package com.nacho.hackerrank.interviewpreparationkit.dictionariesandhashmaps;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RansomNote {

  static void checkMagazine(final String[] magazine, final String[] note) {
    final Map<String, Long> frecuencyNote = Stream.of(note) //
        .collect( //
            Collectors.groupingBy( //
                Function.identity(), //
                Collectors.counting()) //
        );

    for (final String word : magazine) {
      frecuencyNote.computeIfPresent(word, (w, count) -> count - 1);
    }

    boolean anyWordNotFoundInMagazine = frecuencyNote.values().stream().anyMatch(count -> count > 0);
    if (anyWordNotFoundInMagazine) {
      System.out.println("No");
    } else {
      System.out.println("Yes");
    }
  }

  static void checkMagazine2(final String[] magazine, final String[] note) {
    final Map<String, Long> frecuencyNote = Stream.of(note) //
        .collect( //
            Collectors.groupingBy( //
                Function.identity(), //
                Collectors.counting()) //
        );
    final Map<String, Integer> frecuencyMagazine = Stream.of(magazine) //
        .collect( //
            Collectors.toMap( //
                Function.identity(), //
                s -> 1, //
                Integer::sum) //
        );
    final boolean allFromNoteExistInMagazine = frecuencyNote.entrySet().stream() //
        .allMatch(e -> {
          Integer safeCount = Optional.ofNullable(frecuencyMagazine.get(e.getKey())).orElse(0);
          return safeCount >= e.getValue();
        });
    if (allFromNoteExistInMagazine) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }

  public static void main(final String[] args) {
    checkMagazine(new String[] { "give", "me", "one", "grand", "today", "night" }, new String[] { "give", "one", "grand", "today" });
    checkMagazine(new String[] { "two", "times", "three", "is", "not", "four" }, new String[] { "two", "times", "two", "is", "four" });
    System.out.println("--------------------------");
    checkMagazine2(new String[] { "give", "me", "one", "grand", "today", "night" }, new String[] { "give", "one", "grand", "today" });
    checkMagazine2(new String[] { "two", "times", "three", "is", "not", "four" }, new String[] { "two", "times", "two", "is", "four" });
  }
}
