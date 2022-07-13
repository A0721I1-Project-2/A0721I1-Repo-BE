package project2.service;

import project2.model.Rank;
import project2.model.Role;

import java.util.List;
import java.util.Optional;

public interface IRankService {
    List<Rank> findAll();

    Optional<Rank> findByName(String nameRank);
}
