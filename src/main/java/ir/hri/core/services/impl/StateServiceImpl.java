package ir.hri.core.services.impl;

import ir.hri.core.entities.State;
import ir.hri.core.repositories.StateRepository;
import ir.hri.core.repositories.impl.StateRepositoryImpl;
import ir.hri.core.services.StateService;

import java.util.List;

public class StateServiceImpl implements StateService {
    StateRepository stateRepository = new StateRepositoryImpl();

    @Override
    public State findById(int id) throws Exception {
        return stateRepository.findById(id);
    }

    @Override
    public List<State> findAll() throws Exception {
        return stateRepository.findAll();
    }
}
