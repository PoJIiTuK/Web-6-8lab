package ua.lviv.iot.controller;

import ua.lviv.iot.dao.PerformerDAO;
import ua.lviv.iot.model.Performer;

import java.sql.SQLException;
import java.util.List;

public class PerformerController implements GeneralController<Performer> {

    PerformerDAO dao = new PerformerDAO();

    @Override
    public List<Performer> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Performer findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Performer performer) throws SQLException {
        dao.create(performer);
    }

    @Override
    public void update(Integer id, Performer performer) throws SQLException {
        dao.update(id , performer);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
