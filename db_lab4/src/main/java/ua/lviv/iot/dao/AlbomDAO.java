package ua.lviv.iot.dao;

import ua.lviv.iot.connection.DbConnector;
import ua.lviv.iot.model.Albom;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlbomDAO implements GeneralDAO<Albom> {

    private static final String SELECT_ALL = "SELECT * FROM music.albom";
    private static final String SELECT_ONE = "SELECT * FROM music.albom WHERE id=?";
    private static final String CREATE = "INSERT music.albom (number_sings, price_in_uah) VALUES (?,?)";
    private static final String UPDATE = "UPDATE music.albom SET number_sings=?, price_in_uah=? WHERE id=?";
    private static final String DELETE = "DELETE FROM music.albom WHERE id=?";

    @Override
    public List<Albom> findAll() throws SQLException {
        List<Albom> alboms = new ArrayList<Albom>();
        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(SELECT_ALL)) {
            System.out.println(ps);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Albom albom = new Albom(
                        resultSet.getInt("id"),
                        resultSet.getInt("number_sings"),
                        resultSet.getInt("number_sings"));
                alboms.add(albom);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return alboms;
    }

    @Override
    public Albom findById(Integer id) throws SQLException {
        Albom albom = null;
        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(SELECT_ONE)) {
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                albom = new Albom(resultSet.getInt("id"),
                        resultSet.getInt("number_sings"),
                        resultSet.getInt("number_sings"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return albom;
    }

    @Override
    public void create(Albom albom) throws SQLException {

        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(CREATE)) {
            ps.setInt(1, albom.getNumberSings());
            ps.setInt(2, albom.getAllTimeCode());
            ps.executeUpdate();
            System.out.println(ps);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Albom newAlbom) throws SQLException {
        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(UPDATE)) {
            ps.setInt(1, id);
            ps.setInt(2, newAlbom.getNumberSings());
            ps.setInt(3, newAlbom.getAllTimeCode());

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
