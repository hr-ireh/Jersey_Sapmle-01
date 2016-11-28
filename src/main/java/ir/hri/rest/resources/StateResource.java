package ir.hri.rest.resources;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StateResource {
    @XmlElement(name = "Id")
    int id;

    @XmlElement(name = "Name")
    String name;

    public StateResource() {
    }

    public StateResource(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
