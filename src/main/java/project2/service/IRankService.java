package project2.service;

import project2.model.Rank;

import java.util.List;

public interface IRankService {
    List<Rank> findAllRank();

    Rank findById(Long id);
}
