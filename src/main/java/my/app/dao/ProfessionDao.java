package my.app.dao;

import my.app.domain.Profession;

import java.util.List;

public interface ProfessionDao {
    Profession getById(long id);

    List<Profession> getAll();

    void insert(Profession profession);

    void update(Profession profession);

    void deleteById(long id);
}
