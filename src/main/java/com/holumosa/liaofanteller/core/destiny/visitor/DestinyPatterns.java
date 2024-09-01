package com.holumosa.liaofanteller.core.destiny.visitor;

import com.holumosa.liaofanteller.core.destiny.pattern.Pattern;
import com.holumosa.liaofanteller.core.destiny.pattern.PatternType;
import java.util.*;
import java.util.stream.Collectors;

/** The Class DestinyPatterns. */
public class DestinyPatterns {

  /** The patterns map. */
  private Map<String, List<Pattern>> patternsMap = new HashMap<String, List<Pattern>>();

  /**
   * Adds the patterns.
   *
   * @param patterns the patterns
   */
  public void addPatterns(List<Pattern> patterns) {
    patterns.stream()
        .forEach(
            pattern -> {
              PatternType patternType = pattern.getPatternType();
              List<Pattern> inMapPatterns = patternsMap.get(patternType.getPatternTypeName());
              if (inMapPatterns == null) {
                inMapPatterns = new ArrayList<Pattern>();
                patternsMap.put(patternType.getPatternTypeName(), inMapPatterns);
              }
              inMapPatterns.add(pattern);
            });
  }

  /**
   * Gets the patterns.
   *
   * @param type the type
   * @return the patterns
   */
  public List<Pattern> getPatterns(PatternType type) {
    return Optional.ofNullable(patternsMap.get(type.getPatternTypeName()))
        .orElse(Collections.emptyList());
  }

  /**
   * Gets the patterns.
   *
   * @return the patterns
   */
  public List<Pattern> getPatterns() {
    return Optional.ofNullable(
            patternsMap.values().stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toList()))
        .orElse(Collections.emptyList());
  }
}
