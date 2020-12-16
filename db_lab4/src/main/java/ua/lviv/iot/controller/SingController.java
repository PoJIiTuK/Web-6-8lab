package ua.lviv.iot.controller;

import ua.lviv.iot.dao.SingDAO;
import ua.lviv.iot.model.Sing;

import java.sql.SQLException;
import java.util.List;

public class SingController implements GeneralController<Sing> {

    SingDAO singDAO = new SingDAO();

    @Override
    public List<Sing> findAll() throws SQLException {
        return singDAO.findAll();
    }

    @Override
    public Sing findById(Integer id) throws SQLException {
        return singDAO.findById(id);
    }

    @Override
    public void create(Sing sing) throws SQLException {
        singDAO.create(sing);
    }

    @Override
    public void update(Integer id, Sing sing) throws SQLException {
        singDAO.update(id, sing);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        singDAO.delete(id);
    }
}
