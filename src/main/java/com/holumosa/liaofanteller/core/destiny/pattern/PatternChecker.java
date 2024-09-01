package com.holumosa.liaofanteller.core.destiny.pattern;

import com.holumosa.liaofanteller.core.model.Destiny;
import java.util.List;

/** The Interface PatternChecker. */
public interface PatternChecker {

  /**
   * Visit destiny.
   *
   * @param destiny the destiny
   * @return the list
   */
  List<Pattern> visitDestiny(Destiny destiny);
}
