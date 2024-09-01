package com.holumosa.liaofanteller.core.destiny.pattern;

import java.io.Serializable;

/** The Enum PatternType. */
public interface PatternType extends Serializable {

  /**
   * Gets the pattern type name.
   *
   * @return the pattern type name
   */
  public default String getPatternTypeName() {
    return this.getClass().getSimpleName();
  }
}
