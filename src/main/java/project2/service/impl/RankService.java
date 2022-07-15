package project2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project2.model.Rank;
import project2.repository.IRankRepository;
import project2.service.IRankService;

import java.util.List;

@Service
public class RankService implements IRankService {
    @Autowired
    private IRankRepository rankRepository;

    @Override
    public List<Rank> findAllRank() {
        return rankRepository.findAll();
    }

    @Override
    public Rank findById(Long id) {
        return rankRepository.findById(id).orElse(null);
    }
}
