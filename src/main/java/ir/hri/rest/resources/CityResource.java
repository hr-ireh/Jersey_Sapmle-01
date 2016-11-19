package ir.hri.rest.resources;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CityResource {
    @XmlElement(name = "Id")
    int id;

    @XmlElement(name = "StateId")
    int stateId;

    @XmlElement(name = "Name")
    String name;

    public CityResource() {
    }

    public CityResource(int id, int stateId, String name) {
        this.id = id;
        this.stateId = stateId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
