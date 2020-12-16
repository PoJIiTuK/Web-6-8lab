package ua.lviv.iot.controller;

import ua.lviv.iot.dao.MusicLableDAO;
import ua.lviv.iot.model.MusicLable;

import java.sql.SQLException;
import java.util.List;

public class MusicLableController implements GeneralController<MusicLable> {

    MusicLableDAO musicLableDAO = new MusicLableDAO();

    @Override
    public List<MusicLable> findAll() throws SQLException {
        return musicLableDAO.findAll();
    }

    @Override
    public MusicLable findById(Integer id) throws SQLException {
        return musicLableDAO.findById(id);
    }

    @Override
    public void create(MusicLable musicLable) throws SQLException {
        musicLableDAO.create(musicLable);
    }

    @Override
    public void update(Integer id, MusicLable musicLable) throws SQLException {
        musicLableDAO.update(id, musicLable);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        musicLableDAO.delete(id);
    }
}
