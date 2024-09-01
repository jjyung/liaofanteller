package com.holumosa.liaofanteller.core.model;

import com.holumosa.liaofanteller.util.CommonUtils;
import com.holumosa.liaofanteller.constant.StarConst;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

// 天干
/**
 * The Enum Sky.
 *
 * @author Eric Yu
 */
public enum Sky {

  /** The SK y_0. */
  SKY_0(StarConst.SKY_0, 0), // 甲
  /** The SK y_1. */
  SKY_1(StarConst.SKY_1, 1), // 乙
  /** The SK y_2. */
  SKY_2(StarConst.SKY_2, 2), // 丙
  /** The SK y_3. */
  SKY_3(StarConst.SKY_3, 3), // 丁
  /** The SK y_4. */
  SKY_4(StarConst.SKY_4, 4), // 戊
  /** The SK y_5. */
  SKY_5(StarConst.SKY_5, 5), // 己
  /** The SK y_6. */
  SKY_6(StarConst.SKY_6, 6), // 庚
  /** The SK y_7. */
  SKY_7(StarConst.SKY_7, 7), // 辛
  /** The SK y_8. */
  SKY_8(StarConst.SKY_8, 8), // 壬
  /** The SK y_9. */
  SKY_9(StarConst.SKY_9, 9); // 癸

  /** The Constant COUNT. */
  public static final int COUNT = Sky.values().length;

  /** The display name to value map. */
  private static Map<String, Sky> displayNameToValueMap = new HashMap<String, Sky>();

  static {
    for (Sky sky : Sky.values()) {
      displayNameToValueMap.put(sky.displayName, sky);
    }
  }

  /** The display name. */
  private String displayName;

  /** The index. */
  private int index;

  /**
   * Instantiates a new sky.
   *
   * @param displayName the display name
   * @param index the index
   */
  private Sky(String displayName, int index) {
    this.displayName = displayName;
    this.index = index;
  }

  /**
   * Gets the by display name.
   *
   * @param name the name
   * @return the by display name
   */
  public static Optional<Sky> getByDisplayName(String name) {
    return Optional.<Sky>of(displayNameToValueMap.get(name));
  }

  /**
   * Contain.
   *
   * @param displayName the display name
   * @return true, if successful
   */
  public static boolean contain(String displayName) {
    return displayNameToValueMap.get(displayName) != null;
  }

  /**
   * Gets the by index.
   *
   * @param index the index
   * @return the by index
   */
  public static Sky getByIndex(int index) {
    return Sky.values()[CommonUtils.mod(index, Sky.values().length)];
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
  @JsonValue
  public int getIndex() {
    return index;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Enum#toString()
   */
  public String toString() {
    return this.displayName;
  }

  /**
   * Shift.
   *
   * @param i the i
   * @return the sky
   */
  public Sky shift(int i) {
    return getByIndex(this.index + i);
  }
}
