package ua.lviv.iot.dao;

import ua.lviv.iot.connection.DbConnector;
import ua.lviv.iot.model.Sing;
import ua.lviv.iot.model.Performer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PerformerDAO implements GeneralDAO<Performer>{

    private static final String SELECT_ALL = "SELECT * FROM music.performer";
    private static final String SELECT_ONE = "SELECT * FROM music.performer WHERE id=?";
    private static final String CREATE = "INSERT music.performer (name, surname, country)" +
            "VALUES (?,?,?)";
    private static final String UPDATE = "UPDATE music.performer SET user_profile_id=?," +
            "ticket_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM music.performer WHERE id=?";

    @Override
    public List<Performer> findAll() throws SQLException {
        List<Performer> performers = new ArrayList<Performer>();
        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(SELECT_ALL)) {
            System.out.println(ps);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Performer performer = new Performer(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("country"));
                performers.add(performer);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return performers;
    }

    @Override
    public Performer findById(Integer id) throws SQLException {
        Performer userSing = null;
        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(SELECT_ONE)) {
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                userSing = new Performer(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("country"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return userSing;
    }

    @Override
    public void create(Performer performer) throws SQLException {
        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(CREATE)) {
            ps.setInt(1, performer.getId());
            ps.executeUpdate();
            System.out.println(ps);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    @Override
    public void update(Integer id, Performer performer) throws SQLException {
        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(UPDATE)) {
            ps.setInt(1, id);

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
