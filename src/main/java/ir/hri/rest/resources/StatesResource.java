package ir.hri.rest.resources;

import ir.hri.core.entities.State;

import java.util.ArrayList;
import java.util.List;

public class StatesResource {
    List<State> stateList = new ArrayList<>();

    public StatesResource() {
    }

    public StatesResource(List<State> stateList) {
        this.stateList = stateList;
    }

    public List<State> getStateList() {
        return stateList;
    }

    public void setStateList(List<State> stateList) {
        this.stateList = stateList;
    }
}
