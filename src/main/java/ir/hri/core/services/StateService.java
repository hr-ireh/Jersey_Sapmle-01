package ir.hri.core.services;

import ir.hri.core.entities.State;

import java.util.List;

public interface StateService {
    State findById(int id) throws Exception;

    List<State> findAll() throws Exception;
}
