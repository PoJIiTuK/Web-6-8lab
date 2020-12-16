package ua.lviv.iot.dao;

import ua.lviv.iot.connection.DbConnector;
import ua.lviv.iot.model.MusicLable;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public  class MusicLableDAO implements GeneralDAO<MusicLable> {

    private static final String SELECT_ALL = "SELECT * FROM music.musicLable";
    private static final String SELECT_ONE = "SELECT * FROM music.musicLable WHERE id=?";
    private static final String CREATE = "INSERT music.musicLable"
            + "(performer_id, director,budget)" +
            "VALUES (?,?,?)";
    private static final String UPDATE = "UPDATE musicLable"
            + " SET director=?, budget=?, name=?, surname=?,  ";
    private static final String DELETE = "DELETE FROM music.musicLable WHERE id=?";


    @Override
    public List<MusicLable> findAll() throws SQLException {
        List<MusicLable> musicLables = new ArrayList<MusicLable>();
        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(SELECT_ALL)) {
            System.out.println(ps);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                MusicLable musicLable = new MusicLable(
                        resultSet.getInt("id"),
                        resultSet.getInt("performer_id"),
                        resultSet.getString("director"),
                        resultSet.getInt("budget"));
                        musicLables.add(musicLable);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return musicLables;
    }


    @Override
    public MusicLable findById(Integer id) throws SQLException {
        MusicLable musicLable = null;
        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(SELECT_ONE)) {
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                musicLable = new MusicLable(resultSet.getInt("id"),
                        resultSet.getInt("parformer_id"),
                        resultSet.getString("director"),
                        resultSet.getInt("budget"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return musicLable;
    }

    @Override
    public void create(MusicLable musicLable) throws SQLException {

        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(CREATE)) {
            ps.setInt(1, musicLable.getPerformerId());
            ps.setString(2, musicLable.getDirector());
            ps.setInt(3, musicLable.getBudget());
            ps.executeUpdate();
            System.out.println(ps);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    @Override
    public void update(Integer id, MusicLable musicLable) throws SQLException {
        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement("UPDATE music.musicLable"
                + " SET performer_id=?, director=?, budget=?")) {
            ps.setInt(4, id);
            ps.setInt(1, musicLable.getPerformerId());
            ps.setString(2, musicLable.getDirector());
            ps.setInt(3, musicLable.getBudget());

            ps.executeUpdate();
            System.out.println(ps);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(DELETE)) {
            ps.setInt(1, id);
            System.out.println(ps);
            ps.executeUpdate();

        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}
