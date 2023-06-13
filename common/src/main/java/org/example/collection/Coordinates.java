package org.example.collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name="coordinates")
public class Coordinates implements Serializable {
    @XmlElement
    private Integer x;
    @XmlElement
    private Integer y; //Поле не может быть null

    public Coordinates(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }
    public Coordinates() {
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }
    @Override
    public String toString(){
        return "coordinates{" +
                "x = " + x +
                "y = " + y +
                "}";
    }

    public int compareTo(Coordinates o) {
        if (o.getX() - this.x != 0) return   this.x - o.getX();
        if (o.getY() - this.y != 0) return   this.y - o.getY();
        return 0;
    }
}
