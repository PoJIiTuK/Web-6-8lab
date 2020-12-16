package ua.lviv.iot.controller;

import ua.lviv.iot.dao.AlbomDAO;
import ua.lviv.iot.model.Albom;


import java.sql.SQLException;
import java.util.List;

public class AlbomController implements GeneralController<Albom>{

    AlbomDAO albomDAO = new AlbomDAO();

    @Override
    public List<Albom> findAll() throws SQLException {
        return albomDAO.findAll();
    }

    @Override
    public Albom findById(Integer id) throws SQLException {
        return albomDAO.findById(id);
    }

    @Override
    public void create(Albom albom) throws SQLException {
        albomDAO.create(albom);
    }

    @Override
    public void update(Integer id, Albom albom) throws SQLException {
        albomDAO.update(id, albom);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        albomDAO.delete(id);
    }
}
