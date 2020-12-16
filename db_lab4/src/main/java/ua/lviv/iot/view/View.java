package ua.lviv.iot.view;

import ua.lviv.iot.controller.*;
import ua.lviv.iot.model.*;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {

    private static final Scanner scanner = new Scanner(System.in);
    private final Map<String, Printable> menu = new LinkedHashMap<>();

    private final SingController singController = new SingController();
    private final InformationController informationController = new InformationController();
    private final MusicLableController musicLableController = new MusicLableController();
    private final AlbomController albomController = new AlbomController();
    private final UserProfileController userProfileController = new UserProfileController();
    private final PerformerController performerController = new PerformerController();

    public View() {

        menu.put("11", this::getAllSings);
        menu.put("12", this::getSingById);
        menu.put("13", this::createSing);
        menu.put("14", this::updateSing);
        menu.put("15", this::deleteSing);

        menu.put("21", this::getAllInformation);
        menu.put("22", this::getInformationById);
        menu.put("23", this::createInformation);
        menu.put("24", this::updateInformation);
        menu.put("25", this::deleteInformation);

        menu.put("31", this::getAllMusicLables);
        menu.put("32", this::getMusicLableById);
        menu.put("33", this::createMusicLable);
        menu.put("34", this::updateMusicLable);
        menu.put("35", this::deleteMusicLable);

        menu.put("41", this::getAllAlboms);
        menu.put("42", this::getAlbomById);
        menu.put("43", this::createAlbom);
        menu.put("44", this::updateAlbom);
        menu.put("45", this::deleteAlbom);

        menu.put("51", this::getAllUserProfiles);
        menu.put("52", this::getUserProfileById);
        menu.put("53", this::createUserProfile);
        menu.put("54", this::updateUserProfile);
        menu.put("55", this::deleteUserProfile);

        menu.put("61", this::getAllPerformers);
        menu.put("62", this::getPerformerById);
        menu.put("63", this::createPerformer);
        menu.put("64", this::updatePerformer);
        menu.put("65", this::deletePerformer);

    }

    private void getAllSings() throws SQLException {
        System.out.println("\nAll Sings: ");
        System.out.println(singController.findAll() + "\n");
    }

    private void getAllInformation() throws SQLException {
        System.out.println("\nAll information: ");
        System.out.println(informationController.findAll() + "\n");
    }

    private void getAllMusicLables() throws SQLException {
        System.out.println("\nAll Music Lable: ");
        System.out.println(musicLableController.findAll() + "\n");
    }

    private void getAllAlboms() throws SQLException {
        System.out.println("\nAll Alboms: ");
        System.out.println(albomController.findAll() + "\n");
    }

    private void getAllUserProfiles() throws SQLException {
        System.out.println("\nAll User Profiles: ");
        System.out.println(userProfileController.findAll() + "\n");
    }

    private void getAllPerformers() throws SQLException {
        System.out.println("\nAll info about performers: ");
        System.out.println(performerController.findAll() + "\n");
    }

    private void getSingById() throws SQLException {
        System.out.println("\nEnter id to find sing with this id ...: ");
        Integer id = scanner.nextInt();
        System.out.println(singController.findById(id) + "\n");
    }

    private void getInformationById() throws SQLException {
        System.out.println("\nEnter id to find information with this id ...: ");
        Integer id = scanner.nextInt();
        System.out.println(informationController.findById(id) + "\n");
    }

    private void getMusicLableById() throws SQLException {
        System.out.println("\nEnter id to find Music Lable with this id ...: ");
        Integer id = scanner.nextInt();
        System.out.println(musicLableController.findById(id) + "\n");
    }

    private void getAlbomById() throws SQLException {
        System.out.println("\nEnter id to find albom with this id ...: ");
        Integer id = scanner.nextInt();
        System.out.println(albomController.findById(id) + "\n");
    }

    private void getUserProfileById() throws SQLException {
        System.out.println("\nEnter id to find user with this id ...: ");
        Integer id = scanner.nextInt();
        System.out.println(userProfileController.findById(id) + "\n");
    }

    private Performer getPerformerById() throws SQLException {
        System.out.println("\nEnter id to find performer ...: ");
        Integer id = scanner.nextInt();
        System.out.println(performerController.findById(id) + "\n");
        return null;
    }

    private Sing getSingValues() throws SQLException {
        System.out.println("Input singname: ");
        String singName = scanner.next();
        return new Sing(singName);
    }

    private Information getInformationValues() throws SQLException {
        System.out.println("Input sing id: ");
        Integer singId = scanner.nextInt();
        System.out.println("Input year name: ");
        String year = scanner.next();
        System.out.println("Input time_code name: ");
        String time_code = scanner.next();
        return new Information(singId, year, time_code);
    }

    private MusicLable getMusicLableValues() throws SQLException {
        System.out.println("Input performer id: ");
        Integer performerId = scanner.nextInt();
        System.out.println("Input per: ");
        String director= scanner.next();
        System.out.println("Input director: ");
        Integer budget = scanner.nextInt();
        System.out.println("Input budget in UA: ");
        return new MusicLable(performerId, director, budget);
    }

    private Albom getAlbomValues() throws SQLException {
        System.out.println("Input number_sings id: ");
        Integer number_sings = scanner.nextInt();
        System.out.println("Input all_time_code: ");
        Integer all_time_code = scanner.nextInt();
        return new Albom(number_sings, all_time_code);
    }

    private UserProfile getUserProfileValues() throws SQLException {
        System.out.println("Input user name: ");
        String userName = scanner.next();
        System.out.println("Input surName: ");
        String surName = scanner.next();
        return new UserProfile(userName, surName);
    }

    private Performer getPerformerValues() throws SQLException {
        System.out.println("Input ticket id: ");
        String name = scanner.next();
        System.out.println("Input user id: ");
        String surname = scanner.next();
        return new Performer(name, surname);
    }

    private void createSing() throws SQLException {
        System.out.println("\nAdd new Sing...");
        Sing sing = getSingValues();
        singController.create(sing);
        System.out.println("added an Sing\n");
    }

    private void createInformation() throws SQLException {
        System.out.println("\nAdd new Information...");
        Information information = getInformationValues();
        informationController.create(information);
        System.out.println("added an Information\n");
    }

    private void createMusicLable() throws SQLException {
        System.out.println("\nAdd new MusicLable...");
        MusicLable flight = getMusicLableValues();
        musicLableController.create(flight);
        System.out.println("added new MusicLable\n");
    }

    private void createAlbom() throws SQLException {
        System.out.println("\nAdd new ticket...");
        Albom albom = getAlbomValues();
        albomController.create(albom);
        System.out.println("added new ticket\n");
    }

    private void createUserProfile() throws SQLException {
        System.out.println("\nAdd new user...");
        UserProfile userProfile = getUserProfileValues();
        userProfileController.create(userProfile);
        System.out.println("added an userProfile\n");
    }

    private void createPerformer() throws SQLException {
        System.out.println("\nAdd new sigs...");
        Performer performer = getPerformerById();
        performerController.create(performer);
        System.out.println("added user with ticket\n");
    }

    private void updateInformation() throws SQLException {
        System.out.println("\nEnter id of Information to update: ");
        Integer id = scanner.nextInt();
        Information information = getInformationValues();
        information.setId(id);
        informationController.update(information.getId(), information);
        System.out.println("Updated \n");
    }


    private void updateMusicLable() throws SQLException {
        System.out.println("\nEnter id of Music Lable to update: ");
        Integer id = scanner.nextInt();
        MusicLable flight = getMusicLableValues();


        musicLableController.update(id, flight);
        System.out.println("Updated \n");
    }

    private void updateAlbom() throws SQLException {
        System.out.println("\nEnter id of ticket to update: ");
        Integer id = scanner.nextInt();
        Albom albom = getAlbomValues();
        albom.setId(id);

        albomController.update(albom.getId(), albom);
        System.out.println("Updated \n");
    }

    private void updateUserProfile() throws SQLException {
        System.out.println("\nEnter id of user to update: ");
        Integer id = scanner.nextInt();
        UserProfile userProfile = getUserProfileValues();
        userProfile.setId(id);

        userProfileController.update(userProfile.getId(), userProfile);
        System.out.println("Updated \n");
    }

    private void updatePerformer() throws SQLException {
        System.out.println("\nEnter id of user with ticket to update: ");
        Integer id = scanner.nextInt();
        Performer performer = getPerformerValues();
        performer.setId(id);

        performerController.update(performer.getId(), performer);
        System.out.println("Updated \n");
    }

    private void updateSing() throws SQLException {
        System.out.println("\nEnter id of sing to update: ");
        Integer id = scanner.nextInt();
        Sing sing = getSingValues();
        sing.setId(id);

        singController.update(sing.getId(), sing);
        System.out.println("Updated \n");
    }

    private void deleteSing() throws SQLException {
        System.out.println("\nEnter ID of Sing to delete it: ");
        int id = scanner.nextInt();

        singController.delete(id);
        System.out.println("Deleted \n");
    }

    private void deleteInformation() throws SQLException {
        System.out.println("\nEnter ID of airport to delete it: ");
        int id = scanner.nextInt();
        informationController.delete(id);
        System.out.println("Deleted \n");
    }

    private void deleteMusicLable() throws SQLException {
        System.out.println("\nEnter ID of Music Lable to delete it: ");
        int id = scanner.nextInt();
        musicLableController.delete(id);
        System.out.println("Deleted \n");
    }

    private void deleteAlbom() throws SQLException {
        System.out.println("\nEnter ID of Albom to delete it: ");
        int id = scanner.nextInt();

        albomController.delete(id);
        System.out.println("Deleted \n");
    }

    private void deleteUserProfile() throws SQLException {
        System.out.println("\nEnter ID of user to delete him: ");
        int id = scanner.nextInt();

        userProfileController.delete(id);
        System.out.println("Deleted \n");
    }

    private void deletePerformer() throws SQLException {
        System.out.println("\nEnter ID of user to delete his link with ticket: ");
        int id = scanner.nextInt();
        performerController.delete(id);
        System.out.println("Deleted \n");
    }

    public final void view() {
        System.out.println("\nInput method key to deal with db:");
        String input;
        do {
            try {
                input = scanner.next();
                menu.get(input).print();
                System.out.println("\nInput method key to deal with db:");
            } catch (Exception e) {
                System.out.println("No operation for this key");
                System.out.println("\nInput method key to deal with db:");
            }
        } while (scanner.hasNext());
    }

}

