package ir.hri.core.services.impl;

import ir.hri.core.entities.State;
import ir.hri.core.repositories.StateRepository;
import ir.hri.core.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateServiceImpl implements StateService {
    @Autowired
    private StateRepository stateRepository;

    @Override
    public State findById(int id) throws Exception {
        return stateRepository.findById(id);
    }

    @Override
    public List<State> findAll() throws Exception {
        return stateRepository.findAll();
    }
}
