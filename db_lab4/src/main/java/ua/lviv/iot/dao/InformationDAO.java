package ua.lviv.iot.dao;


import ua.lviv.iot.model.Information;
import ua.lviv.iot.connection.DbConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class InformationDAO implements GeneralDAO<Information> {

    private static final String SELECT_ALL = "SELECT * FROM music.information";
    private static final String SELECT_ONE = "SELECT * FROM music.information WHERE id=?";
    private static final String CREATE = "INSERT music.information(year, time_code, sing_id) VALUES (?,?,?)";
    private static final String UPDATE = "UPDATE music.information"
            + " SET year=?, time_code=?, sing_id=?  WHERE id=?";
    private static final String DELETE = "DELETE FROM music.information WHERE id=?";


    @Override
    public List<Information> findAll() throws SQLException {
        List<Information> informations = new ArrayList<Information>();
        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(SELECT_ALL)) {
            System.out.println(ps);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Information information = new Information(
                        resultSet.getInt("id"),
                        resultSet.getInt("sing_id"),
                        resultSet.getString("year"),
                        resultSet.getString("time_code")

                );
                informations.add(information);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return informations;
    }

    @Override
    public Information findById(Integer id) throws SQLException {
        Information information = null;
        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(SELECT_ONE)) {
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                information = new Information(result.getInt("id"), result.getInt("sing_id"),
                        result.getString("year"), result.getString("time_code"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return information;
    }


    @Override
    public void create(Information newInformation) throws SQLException {
        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(CREATE)) {
            ps.setString(1, newInformation.getYear());
            ps.setString(2, String.valueOf(newInformation.getTimeCode()));
            ps.setString(3, String.valueOf(newInformation.getSingId()));
            ps.executeUpdate();
            System.out.println(ps);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    @Override
    public void update(Integer id, Information updatedInformation) throws SQLException {
        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(UPDATE)) {
            ps.setString(1, updatedInformation.getYear());
            ps.setString(2, updatedInformation.getTimeCode());
            ps.setInt(3, updatedInformation.getSingId());
            ps.setInt(4, id);
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