package ua.lviv.iot.dao;

import ua.lviv.iot.connection.DbConnector;
import ua.lviv.iot.model.Sing;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SingDAO implements GeneralDAO<Sing> {

    private static final String SELECT_ALL = "SELECT * FROM music.sing";
    private static final String SELECT_ONE = "SELECT * FROM music.sing WHERE id=?";
    private static final String CREATE = "INSERT music.sing "
            + "(sing_name) VALUES (?)";
    private static final String UPDATE = "UPDATE music.sing"
            + " SET sing_name=? WHERE id=?";
    private static final String DELETE = "DELETE FROM music.sing WHERE id=?";


    @Override
    public List<Sing> findAll() throws SQLException {
        List<Sing> sings = new ArrayList<Sing>();
        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(SELECT_ALL)) {
            System.out.println(ps);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Sing sing = new Sing(
                        resultSet.getInt("id"),
                        resultSet.getString("sing_name")
                );
                sings.add(sing);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return sings;
    }

    @Override
    public Sing findById(Integer id) throws SQLException {
        Sing sing = null;
        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(SELECT_ONE)) {
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                sing = new Sing(
                        result.getInt("id"),
                         result.getString("sing_name")
                );

            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return sing;
    }

    @Override
    public void create(Sing newSing) throws SQLException {
        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(CREATE)) {
            ps.setString(1, newSing.getSingName());
            ps.executeUpdate();
            System.out.println(ps);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    @Override
    public void update(Integer id, Sing updatedAirline) throws SQLException {
        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(UPDATE)) {
            ps.setString(1, updatedAirline.getSingName());
            ps.setInt(2, id);
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

