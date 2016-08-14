package com.tel_ran.hederkosher.model.dao;

/**
 * Created by Ruslan on 13.08.2016.
 */

    import java.util.HashSet;
    import java.util.Set;

public class Stats  implements java.io.Serializable {

    private Long statsid;
    private String name;
    private String description;
    private Set announcmentses = new HashSet(0);

    public Stats() {
    }

    public Stats(Long statsid, String name) {
        this.statsid = statsid;
        this.name = name;
    }

    public Long getStatsid() {
        return this.statsid;
    }

    public void setStatsid(Long statsid) {
        this.statsid = statsid;
    }
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}