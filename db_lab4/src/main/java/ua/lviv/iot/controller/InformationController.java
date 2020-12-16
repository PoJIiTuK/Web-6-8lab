package ua.lviv.iot.controller;

import ua.lviv.iot.dao.InformationDAO;
import ua.lviv.iot.model.Information;


import java.sql.SQLException;
import java.util.List;

public class InformationController implements GeneralController<Information> {

    InformationDAO informationDAO = new InformationDAO();

    @Override
    public List<Information> findAll() throws SQLException {
        return informationDAO.findAll();
    }

    @Override
    public Information findById(Integer id) throws SQLException {
        return informationDAO.findById(id);
    }

    @Override
    public void create(Information information) throws SQLException {
        informationDAO.create(information);
    }

    @Override
    public void update(Integer id, Information information) throws SQLException {
        informationDAO.update(id, information);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        informationDAO.delete(id);
    }
}
