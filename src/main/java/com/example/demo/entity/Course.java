package com.example.demo.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * course
 * @author 
 */
@Data
public class Course implements Serializable {
    private String cnum;

    private String cname;

    private Double credit;

    private Integer chours;

    private String tnum;

    private static final long serialVersionUID = 1L;

    public Course(String cnum, String cname, Double credit, Integer chours, String tnum) {
        this.cnum = cnum;
        this.cname = cname;
        this.credit = credit;
        this.chours = chours;
        this.tnum = tnum;
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
        Course other = (Course) that;
        return (this.getCnum() == null ? other.getCnum() == null : this.getCnum().equals(other.getCnum()))
            && (this.getCname() == null ? other.getCname() == null : this.getCname().equals(other.getCname()))
            && (this.getCredit() == null ? other.getCredit() == null : this.getCredit().equals(other.getCredit()))
            && (this.getChours() == null ? other.getChours() == null : this.getChours().equals(other.getChours()))
            && (this.getTnum() == null ? other.getTnum() == null : this.getTnum().equals(other.getTnum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCnum() == null) ? 0 : getCnum().hashCode());
        result = prime * result + ((getCname() == null) ? 0 : getCname().hashCode());
        result = prime * result + ((getCredit() == null) ? 0 : getCredit().hashCode());
        result = prime * result + ((getChours() == null) ? 0 : getChours().hashCode());
        result = prime * result + ((getTnum() == null) ? 0 : getTnum().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cnum=").append(cnum);
        sb.append(", cname=").append(cname);
        sb.append(", credit=").append(credit);
        sb.append(", chours=").append(chours);
        sb.append(", tnum=").append(tnum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}