package ir.hri.core.repositories;

import ir.hri.core.entities.State;

import java.util.List;

public interface StateRepository {
    State findById(int id) throws Exception;

    List<State> findAll() throws Exception;
}
