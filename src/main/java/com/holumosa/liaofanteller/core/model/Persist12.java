package com.holumosa.liaofanteller.core.model;

import com.fasterxml.jackson.annotation.JsonValue;
import com.holumosa.liaofanteller.util.CommonUtils;
import com.holumosa.liaofanteller.constant.StarConst;

/**
 * The Enum Persist12.
 *
 * @author Eric Yu
 */
public enum Persist12 {

  /** The PERSIS t12_0. */
  PERSIST12_0(StarConst.PERSIST12_0, 0),

  /** The PERSIS t12_1. */
  PERSIST12_1(StarConst.PERSIST12_1, 1),

  /** The PERSIS t12_2. */
  PERSIST12_2(StarConst.PERSIST12_2, 2),

  /** The PERSIS t12_3. */
  PERSIST12_3(StarConst.PERSIST12_3, 3),

  /** The PERSIS t12_4. */
  PERSIST12_4(StarConst.PERSIST12_4, 4),

  /** The PERSIS t12_5. */
  PERSIST12_5(StarConst.PERSIST12_5, 5),

  /** The PERSIS t12_6. */
  PERSIST12_6(StarConst.PERSIST12_6, 6),

  /** The PERSIS t12_7. */
  PERSIST12_7(StarConst.PERSIST12_7, 7),

  /** The PERSIS t12_8. */
  PERSIST12_8(StarConst.PERSIST12_8, 8),

  /** The PERSIS t12_9. */
  PERSIST12_9(StarConst.PERSIST12_9, 9),

  /** The PERSIS t12_10. */
  PERSIST12_10(StarConst.PERSIST12_10, 10),

  /** The PERSIS t12_11. */
  PERSIST12_11(StarConst.PERSIST12_11, 11);

  /** The display name. */
  private String displayName;

  /** The index. */
  private int index;

  /**
   * Instantiates a new persist12.
   *
   * @param displayName the display name
   * @param index the index
   */
  Persist12(String displayName, int index) {
    this.displayName = displayName;
    this.index = index;
  }

  /**
   * Gets the by index.
   *
   * @param index the index
   * @return the by index
   */
  public static Persist12 getByIndex(int index) {
    return Persist12.values()[CommonUtils.mod(index, Persist12.values().length)];
  }

  /**
   * Gets the display name.
   *
   * @return the display name
   */
  public String getDisplayName() {
    return this.displayName;
  }

  /**
   * Gets the index.
   *
   * @return the index
   */
  public int getIndex() {
    return index;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Enum#toString()
   */
  @JsonValue
  public String toString() {
    return this.displayName;
  }

  /**
   * Shift.
   *
   * @param i the i
   * @return the persist12
   */
  public Persist12 shift(int i) {
    return getByIndex(this.index + i);
  }
}
