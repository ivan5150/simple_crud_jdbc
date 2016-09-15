package my.app.service;


import my.app.domain.Profession;

import java.util.List;

public interface ProfessionService {
    Profession getById(long id);

    List<Profession> getAll();

    void insert(Profession profession);

    void update(Profession profession);

    void deleteById(long id);
}
