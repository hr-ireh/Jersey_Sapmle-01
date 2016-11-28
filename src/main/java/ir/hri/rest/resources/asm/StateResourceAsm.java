package ir.hri.rest.resources.asm;

import ir.hri.core.entities.State;
import ir.hri.rest.resources.StateResource;

public class StateResourceAsm {
    public StateResource toResource(State state) {
        StateResource stateResource = new StateResource();
        stateResource.setId(state.getId());
        stateResource.setName(state.getName());

        return stateResource;
    }
}
