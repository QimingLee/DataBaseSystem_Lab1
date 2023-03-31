package com.example.demo.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * sc
 * @author 
 */
@Data
public class Sc extends ScKey implements Serializable {
    private Double score;

    private static final long serialVersionUID = 1L;

    public Sc(String snum, String cnum, double score) {
        this.setCnum(cnum);
        this.setSnum(snum);
        this.setScore(score);
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Sc other = (Sc) that;
        return (this.getSnum() == null ? other.getSnum() == null : this.getSnum().equals(other.getSnum()))
            && (this.getCnum() == null ? other.getCnum() == null : this.getCnum().equals(other.getCnum()))
            && (this.getScore() == null ? other.getScore() == null : this.getScore().equals(other.getScore()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSnum() == null) ? 0 : getSnum().hashCode());
        result = prime * result + ((getCnum() == null) ? 0 : getCnum().hashCode());
        result = prime * result + ((getScore() == null) ? 0 : getScore().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", score=").append(score);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}