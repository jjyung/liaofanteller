package com.holumosa.liaofanteller.core.model;

import com.fasterxml.jackson.annotation.JsonValue;
import com.holumosa.liaofanteller.constant.StarConst;
import java.util.Optional;

/**
 * The Enum StarReaction.
 *
 * @author Eric Yu
 */
public enum StarReaction implements StarElement {

  /** The star to treasure. */
  STAR_TO_TREASURE("祿"),
  /** The star to power. */
  STAR_TO_POWER("權"),
  /** The star to position. */
  STAR_TO_POSITION("科"),
  /** The star to problem. */
  STAR_TO_PROBLEM("忌");

  /** The display name. */
  private String displayName;

  /**
   * Instantiates a new star reaction.
   *
   * @param displayName the display name
   */
  private StarReaction(String displayName) {
    this.displayName = displayName;
  }

  /**
   * Gets the star reaction treasure star.
   *
   * @param sky the sky
   * @return the star reaction treasure star
   */
  public static Star getStarReactionTreasureStar(Sky sky) {
    return getStar(
            new String[] {
                  StarConst.MAJOR_STAR_HONEST,
                  StarConst.MAJOR_STAR_COUNSELLOR,
                  StarConst.MAJOR_STAR_RECREATION,
                  StarConst.MAJOR_STAR_MOON,
                  StarConst.MAJOR_STAR_GREED,
                  StarConst.MAJOR_STAR_MONEY,
                  StarConst.MAJOR_STAR_SUN,
                  StarConst.MAJOR_STAR_MOUTH,
                  StarConst.MAJOR_STAR_LAW,
                  StarConst.MAJOR_STAR_SOLDIER
                }
                [sky.getIndex()])
        .get();
  }

  /**
   * Gets the star reaction power star.
   *
   * @param sky the sky
   * @return the star reaction power star
   */
  public static Star getStarReactionPowerStar(Sky sky) {
    return getStar(
            new String[] {
                  StarConst.MAJOR_STAR_SOLDIER,
                  StarConst.MAJOR_STAR_LAW,
                  StarConst.MAJOR_STAR_COUNSELLOR,
                  StarConst.MAJOR_STAR_RECREATION,
                  StarConst.MAJOR_STAR_MOON,
                  StarConst.MAJOR_STAR_GREED,
                  StarConst.MAJOR_STAR_MONEY,
                  StarConst.MAJOR_STAR_SUN,
                  StarConst.MAJOR_STAR_EMPEROR,
                  StarConst.MAJOR_STAR_MOUTH
                }
                [sky.getIndex()])
        .get();
  }

  /**
   * Gets the star reaction position star.
   *
   * @param sky the sky
   * @return the star reaction position star
   */
  public static Star getStarReactionPositionStar(Sky sky) {
    return getStar(
            new String[] {
                  StarConst.MAJOR_STAR_MONEY,
                  StarConst.MAJOR_STAR_EMPEROR,
                  StarConst.MINOR_STAR_CLEVER,
                  StarConst.MAJOR_STAR_COUNSELLOR,
                  StarConst.MAJOR_STAR_SUN,
                  StarConst.MAJOR_STAR_LAW,
                  StarConst.MAJOR_STAR_TREASURY,
                  StarConst.MINOR_STAR_SKILL,
                  StarConst.MAJOR_STAR_TREASURY,
                  StarConst.MAJOR_STAR_MOON
                }
                [sky.getIndex()])
        .get();
  }

  /**
   * Gets the star reaction problem star.
   *
   * @param sky the sky
   * @return the star reaction problem star
   */
  public static Star getStarReactionProblemStar(Sky sky) {
    return getStar(
            new String[] {
                  StarConst.MAJOR_STAR_SUN,
                  StarConst.MAJOR_STAR_MOON,
                  StarConst.MAJOR_STAR_HONEST,
                  StarConst.MAJOR_STAR_MOUTH,
                  StarConst.MAJOR_STAR_COUNSELLOR,
                  StarConst.MINOR_STAR_SKILL,
                  StarConst.MAJOR_STAR_RECREATION,
                  StarConst.MINOR_STAR_CLEVER,
                  StarConst.MAJOR_STAR_MONEY,
                  StarConst.MAJOR_STAR_GREED
                }
                [sky.getIndex()])
        .get();
  }

  /**
   * Gets the star.
   *
   * @param displayName the display name
   * @return the star
   */
  public static Optional<Star> getStar(String displayName) {
    if (MajorStar.contain(displayName)) {
      return MajorStar.getByDisplayName(displayName).map(star -> (Star) star);
    } else if (MinorStar.contain(displayName)) {
      return MinorStar.getByDisplayName(displayName).map(star -> (Star) star);
    } else {
      return Optional.empty();
    }
  }

  /**
   * Gets the display name.
   *
   * @return the display name
   */
  @JsonValue
  public String getDisplayName() {
    return this.displayName;
  }
}
