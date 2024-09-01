package com.holumosa.liaofanteller.core.model;

import com.fasterxml.jackson.annotation.JsonValue;
import com.holumosa.liaofanteller.core.model.Data.FiveElement;
import com.holumosa.liaofanteller.util.CommonUtils;
import com.holumosa.liaofanteller.constant.StarConst;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.WeakHashMap;

// 主星
/**
 * The Enum MajorStar.
 *
 * @author Eric Yu
 */
/**
 * @author Eric Yu
 */
/**
 * @author Eric Yu
 */
public enum MajorStar implements Star {
  // 紫微
  /** The major star emperor. */
  MAJOR_STAR_EMPEROR(StarConst.MAJOR_STAR_EMPEROR, 0) {
    public Ground getGround(Destiny destiny) {
      return Ground.getByDisplayName(
              groundEmperorMapping
                  .get(destiny.getFiveElement())[destiny.getConfig().getBornDay() - 1])
          .get();
    }

    public Integer getStarEnergy(Ground ground) {
      return new Integer[] {0, 2, 2, 1, -1, 1, 2, 2, 1, 0, 0, 1}[ground.getIndex()];
    }
  },
  // 天機
  /** The major star counsellor. */
  MAJOR_STAR_COUNSELLOR(StarConst.MAJOR_STAR_COUNSELLOR, 1) {
    public Ground getGround(Destiny destiny) {
      return MAJOR_STAR_EMPEROR.getGround(destiny).shift(-1);
    }

    public Integer getStarEnergy(Ground ground) {
      return new Integer[] {2, -1, 1, 1, 2, 0, 2, -1, 0, 1, 2, 0}[ground.getIndex()];
    }
  },
  // 太陽
  /** The major star sun. */
  MAJOR_STAR_SUN(StarConst.MAJOR_STAR_SUN, 2) {
    public Ground getGround(Destiny destiny) {
      return MAJOR_STAR_EMPEROR.getGround(destiny).shift(-3);
    }

    public Integer getStarEnergy(Ground ground) {
      return new Integer[] {-1, -1, 1, 2, 1, 1, 2, 0, 0, 0, -1, -1}[ground.getIndex()];
    }
  },
  // 武曲
  /** The major star money. */
  MAJOR_STAR_MONEY(StarConst.MAJOR_STAR_MONEY, 3) {
    public Ground getGround(Destiny destiny) {
      return MAJOR_STAR_EMPEROR.getGround(destiny).shift(-4);
    }

    public Integer getStarEnergy(Ground ground) {
      return new Integer[] {1, 2, 0, -1, 2, 0, 1, 2, 0, 1, 2, 0}[ground.getIndex()];
    }
  },
  // 天同
  /** The major star recreation. */
  MAJOR_STAR_RECREATION(StarConst.MAJOR_STAR_RECREATION, 4) {
    public Ground getGround(Destiny destiny) {
      return MAJOR_STAR_EMPEROR.getGround(destiny).shift(-5);
    }

    public Integer getStarEnergy(Ground ground) {
      return new Integer[] {1, -1, 0, 2, 0, 2, -1, -1, 1, 0, 0, 2}[ground.getIndex()];
    }
  },
  // 廉貞
  /** The major star honest. */
  MAJOR_STAR_HONEST(StarConst.MAJOR_STAR_HONEST, 5) {
    public Ground getGround(Destiny destiny) {
      return MAJOR_STAR_EMPEROR.getGround(destiny).shift(-8);
    }

    public Integer getStarEnergy(Ground ground) {
      return new Integer[] {0, 1, 2, 0, 1, -1, 0, 2, 2, 0, 1, -1}[ground.getIndex()];
    }
  },
  // 天府
  /** The major star treasury. */
  MAJOR_STAR_TREASURY(StarConst.MAJOR_STAR_TREASURY, 6) {
    public Ground getGround(Destiny destiny) {
      Cell emperorCell = destiny.getGroundCell(MAJOR_STAR_EMPEROR.getGround(destiny));
      int emperorCellOffset =
          emperorCell.countCellNextDist(
              destiny.getGroundCell(Ground.getByDisplayName(StarConst.GROUND_2).get()));
      return emperorCell.getNextICell(emperorCellOffset * 2).get().getGround();
    }

    public Integer getStarEnergy(Ground ground) {
      return new Integer[] {2, 2, 2, 0, 2, 0, 1, 2, 0, -1, 2, 1}[ground.getIndex()];
    }
  },
  // 太陰
  /** The major star moon. */
  MAJOR_STAR_MOON(StarConst.MAJOR_STAR_MOON, 7) {
    public Ground getGround(Destiny destiny) {
      return MAJOR_STAR_TREASURY.getGround(destiny).shift(1);
    }

    public Integer getStarEnergy(Ground ground) {
      return new Integer[] {2, 2, 0, -1, 0, -1, -1, 0, 0, 1, 1, 2}[ground.getIndex()];
    }
  },
  // 貪狼
  /** The major star greed. */
  MAJOR_STAR_GREED(StarConst.MAJOR_STAR_GREED, 8) {
    public Ground getGround(Destiny destiny) {
      return MAJOR_STAR_TREASURY.getGround(destiny).shift(2);
    }

    public Integer getStarEnergy(Ground ground) {
      return new Integer[] {1, 2, 0, 0, 2, -1, 1, 2, 0, 0, 2, -1}[ground.getIndex()];
    }
  },
  // 巨門
  /** The major star mouth. */
  MAJOR_STAR_MOUTH(StarConst.MAJOR_STAR_MOUTH, 9) {
    public Ground getGround(Destiny destiny) {
      return MAJOR_STAR_TREASURY.getGround(destiny).shift(3);
    }

    public Integer getStarEnergy(Ground ground) {
      return new Integer[] {1, 1, 2, 2, 0, 0, 1, -1, 2, 2, 1, 1}[ground.getIndex()];
    }
  },
  // 天相
  /** The major star handprint. */
  MAJOR_STAR_HANDPRINT(StarConst.MAJOR_STAR_HANDPRINT, 10) {
    public Ground getGround(Destiny destiny) {
      return MAJOR_STAR_TREASURY.getGround(destiny).shift(4);
    }

    public Integer getStarEnergy(Ground ground) {
      return new Integer[] {2, 2, 2, -1, 1, 0, 1, 0, 2, -1, 0, 0}[ground.getIndex()];
    }
  },
  // 天梁
  /** The major star law. */
  MAJOR_STAR_LAW(StarConst.MAJOR_STAR_LAW, 11) {
    public Ground getGround(Destiny destiny) {
      return MAJOR_STAR_TREASURY.getGround(destiny).shift(5);
    }

    public Integer getStarEnergy(Ground ground) {
      return new Integer[] {2, 1, 2, 2, 1, -1, 2, 1, -1, 0, 1, -1}[ground.getIndex()];
    }
  },
  // 七殺
  /** The major star general. */
  MAJOR_STAR_GENERAL(StarConst.MAJOR_STAR_GENERAL, 12) {
    public Ground getGround(Destiny destiny) {
      return MAJOR_STAR_TREASURY.getGround(destiny).shift(6);
    }

    public Integer getStarEnergy(Ground ground) {
      return new Integer[] {1, 2, 2, -1, 1, 0, 1, 1, 2, 0, 2, 0}[ground.getIndex()];
    }
  },
  // 破軍
  /** The major star soldier. */
  MAJOR_STAR_SOLDIER(StarConst.MAJOR_STAR_SOLDIER, 13) {
    public Ground getGround(Destiny destiny) {
      return MAJOR_STAR_TREASURY.getGround(destiny).shift(-2);
    }

    public Integer getStarEnergy(Ground ground) {
      return new Integer[] {2, 1, -1, 1, 1, 0, 2, 2, -1, -1, 1, 0}[ground.getIndex()];
    }
  };

  /** The ground emperor mapping. */
  public static final Map<FiveElement, String[]> groundEmperorMapping = getGroundEmperorMapping();

  /** The Constant COUNT. */
  public static final int COUNT = Ground.values().length;

  /** The display name to value map. */
  private static Map<String, MajorStar> displayNameToValueMap = new HashMap<String, MajorStar>();

  static {
    for (MajorStar majorStar : MajorStar.values()) {
      displayNameToValueMap.put(majorStar.displayName, majorStar);
    }
  }

  /** The display name. */
  private String displayName;

  /** The index. */
  private int index;

  /**
   * Instantiates a new major star.
   *
   * @param displayName the display name
   * @param index the index
   */
  private MajorStar(String displayName, int index) {
    this.displayName = displayName;
    this.index = index;
  }

  /**
   * Gets the by index.
   *
   * @param index the index
   * @return the by index
   */
  public static MajorStar getByIndex(int index) {
    return MajorStar.values()[CommonUtils.mod(index, MajorStar.values().length)];
  }

  /**
   * Gets the by display name.
   *
   * @param name the name
   * @return the by display name
   */
  public static Optional<MajorStar> getByDisplayName(String name) {
    return Optional.<MajorStar>of(displayNameToValueMap.get(name));
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
   * Gets the ground emperor mapping.
   *
   * @return the ground emperor mapping
   */
  private static Map<FiveElement, String[]> getGroundEmperorMapping() {
    return new CommonUtils.MapWrapper<FiveElement, String[]>(
            new WeakHashMap<FiveElement, String[]>())
        .put(
            FiveElement.WATER,
            new String[] {
              StarConst.GROUND_1,
              StarConst.GROUND_2,
              StarConst.GROUND_2,
              StarConst.GROUND_3,
              StarConst.GROUND_3,
              StarConst.GROUND_4,
              StarConst.GROUND_4,
              StarConst.GROUND_5,
              StarConst.GROUND_5,
              StarConst.GROUND_6,
              StarConst.GROUND_6,
              StarConst.GROUND_7,
              StarConst.GROUND_7,
              StarConst.GROUND_8,
              StarConst.GROUND_8,
              StarConst.GROUND_9,
              StarConst.GROUND_9,
              StarConst.GROUND_10,
              StarConst.GROUND_10,
              StarConst.GROUND_11,
              StarConst.GROUND_11,
              StarConst.GROUND_0,
              StarConst.GROUND_0,
              StarConst.GROUND_1,
              StarConst.GROUND_1,
              StarConst.GROUND_2,
              StarConst.GROUND_2,
              StarConst.GROUND_3,
              StarConst.GROUND_3,
              StarConst.GROUND_4
            })
        .put(
            FiveElement.WOOD,
            new String[] {
              StarConst.GROUND_4,
              StarConst.GROUND_1,
              StarConst.GROUND_2,
              StarConst.GROUND_5,
              StarConst.GROUND_2,
              StarConst.GROUND_3,
              StarConst.GROUND_6,
              StarConst.GROUND_3,
              StarConst.GROUND_4,
              StarConst.GROUND_7,
              StarConst.GROUND_4,
              StarConst.GROUND_5,
              StarConst.GROUND_8,
              StarConst.GROUND_5,
              StarConst.GROUND_6,
              StarConst.GROUND_9,
              StarConst.GROUND_6,
              StarConst.GROUND_7,
              StarConst.GROUND_10,
              StarConst.GROUND_7,
              StarConst.GROUND_8,
              StarConst.GROUND_11,
              StarConst.GROUND_8,
              StarConst.GROUND_9,
              StarConst.GROUND_0,
              StarConst.GROUND_9,
              StarConst.GROUND_10,
              StarConst.GROUND_1,
              StarConst.GROUND_10,
              StarConst.GROUND_11
            })
        .put(
            FiveElement.GOLD,
            new String[] {
              StarConst.GROUND_11,
              StarConst.GROUND_4,
              StarConst.GROUND_1,
              StarConst.GROUND_2,
              StarConst.GROUND_0,
              StarConst.GROUND_5,
              StarConst.GROUND_2,
              StarConst.GROUND_3,
              StarConst.GROUND_1,
              StarConst.GROUND_6,
              StarConst.GROUND_3,
              StarConst.GROUND_4,
              StarConst.GROUND_2,
              StarConst.GROUND_7,
              StarConst.GROUND_4,
              StarConst.GROUND_5,
              StarConst.GROUND_3,
              StarConst.GROUND_8,
              StarConst.GROUND_5,
              StarConst.GROUND_6,
              StarConst.GROUND_4,
              StarConst.GROUND_9,
              StarConst.GROUND_6,
              StarConst.GROUND_7,
              StarConst.GROUND_5,
              StarConst.GROUND_10,
              StarConst.GROUND_7,
              StarConst.GROUND_8,
              StarConst.GROUND_6,
              StarConst.GROUND_11
            })
        .put(
            FiveElement.EARTH,
            new String[] {
              StarConst.GROUND_6,
              StarConst.GROUND_11,
              StarConst.GROUND_4,
              StarConst.GROUND_1,
              StarConst.GROUND_2,
              StarConst.GROUND_7,
              StarConst.GROUND_0,
              StarConst.GROUND_5,
              StarConst.GROUND_2,
              StarConst.GROUND_3,
              StarConst.GROUND_8,
              StarConst.GROUND_1,
              StarConst.GROUND_6,
              StarConst.GROUND_3,
              StarConst.GROUND_4,
              StarConst.GROUND_9,
              StarConst.GROUND_2,
              StarConst.GROUND_7,
              StarConst.GROUND_4,
              StarConst.GROUND_5,
              StarConst.GROUND_10,
              StarConst.GROUND_3,
              StarConst.GROUND_8,
              StarConst.GROUND_5,
              StarConst.GROUND_6,
              StarConst.GROUND_11,
              StarConst.GROUND_4,
              StarConst.GROUND_9,
              StarConst.GROUND_6,
              StarConst.GROUND_7
            })
        .put(
            FiveElement.FIRE,
            new String[] {
              StarConst.GROUND_9,
              StarConst.GROUND_6,
              StarConst.GROUND_11,
              StarConst.GROUND_4,
              StarConst.GROUND_1,
              StarConst.GROUND_2,
              StarConst.GROUND_10,
              StarConst.GROUND_7,
              StarConst.GROUND_0,
              StarConst.GROUND_5,
              StarConst.GROUND_2,
              StarConst.GROUND_3,
              StarConst.GROUND_11,
              StarConst.GROUND_8,
              StarConst.GROUND_1,
              StarConst.GROUND_6,
              StarConst.GROUND_3,
              StarConst.GROUND_4,
              StarConst.GROUND_0,
              StarConst.GROUND_9,
              StarConst.GROUND_2,
              StarConst.GROUND_7,
              StarConst.GROUND_4,
              StarConst.GROUND_5,
              StarConst.GROUND_1,
              StarConst.GROUND_10,
              StarConst.GROUND_3,
              StarConst.GROUND_8,
              StarConst.GROUND_5,
              StarConst.GROUND_6
            })
        .getMap();
  }

  /*
   * (non-Javadoc)
   *
   * @see com.holumosa.liaofanteller.model.Star#getDisplayName()
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

  /*
   * (non-Javadoc)
   *
   * @see com.holumosa.liaofanteller.model.Star#getGround(com.holumosa.liaofanteller.model.Destiny)
   */
  public Ground getGround(Destiny destiny) {
    return null;
  }

  /**
   * Gets the star energy.
   *
   * @param ground the ground
   * @return the star energy
   */
  public Integer getStarEnergy(Ground ground) {
    return null;
  }

  /**
   * Shift.
   *
   * @param i the i
   * @return the major star
   */
  public MajorStar shift(int i) {
    return getByIndex(this.index + i);
  }
}
