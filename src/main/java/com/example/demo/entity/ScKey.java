package com.example.demo.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * sc
 * @author 
 */
@Data
public class ScKey implements Serializable {
    private String snum;

    private String cnum;

    private static final long serialVersionUID = 1L;

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
        ScKey other = (ScKey) that;
        return (this.getSnum() == null ? other.getSnum() == null : this.getSnum().equals(other.getSnum()))
            && (this.getCnum() == null ? other.getCnum() == null : this.getCnum().equals(other.getCnum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSnum() == null) ? 0 : getSnum().hashCode());
        result = prime * result + ((getCnum() == null) ? 0 : getCnum().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", snum=").append(snum);
        sb.append(", cnum=").append(cnum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}