package com.fantasy.backend.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.fantasy.backend.models.Athlete;
import com.fantasy.backend.models.Team;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Converter {

    private String fileName;
    private BufferedReader reader;

    public Converter(String fileName) {
        this.fileName = "backend/src/main/resources/assets/" + fileName + ".csv";
    }

    public void setFileName(String newFileName) {
        this.fileName = "backend/src/main/resources/assets/" + newFileName + ".csv";
    }

    public ArrayList<Team> getTeams() {
        ArrayList<Team> teamListJava = new ArrayList<Team>();
        JSONParser parser = new JSONParser();
        ArrayList<String> teamListString = (ArrayList<String>) convertTeamData();

        for (int i = 0; i < teamListString.size(); i++) {
            JSONObject json;
            try {
                json = (JSONObject) parser.parse(teamListString.get(i));
                Team newTeam = new Team();
                newTeam.setName((String) json.get("name"));
                newTeam.setFounded(Integer.parseInt((String) json.get("founded")));
                newTeam.setWins(Integer.parseInt((String) json.get("wins")));
                newTeam.setLosses(Integer.parseInt((String) json.get("losses")));
                newTeam.setChampionships(Integer.parseInt((String) json.get("championships")));
                newTeam.setCoach((String) json.get("coach"));
                teamListJava.add(newTeam);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return teamListJava;

    }

    public ArrayList<Athlete> convertPlayerData() {

        String line = "";
        ArrayList<Athlete> athletes = new ArrayList<Athlete>();

        try {
            reader = new BufferedReader(new FileReader(fileName));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                String rank = row[0];
                String name = row[1];
                String started = row[3];
                String passingYds = row[4];
                String passingTds = row[5];
                String rushingYds = row[6];
                String rushingTds = row[7];
                String recYds = row[8];
                String recTds = row[9];
                String fieldGoals = row[10];
                String tackles = row[11];
                String age = row[13];
                String team = row[14];
                String passCompleted = row[17];
                String passAttempted = row[18];
                String interceptions = row[23];
                String sacked = row[28];
                String sackedYdsLost = row[29];
                String pos = row[71];
                String[] cleanData = { rank, name, started, passingYds, passingTds, rushingYds, rushingTds, recYds,
                        recTds, fieldGoals, tackles, age, team, passCompleted, passAttempted, interceptions, sacked,
                        sackedYdsLost, pos };

                for (int i = 0; i < cleanData.length; i++) {
                    String test = cleanData[i];
                    if (test == "") {
                        cleanData[i] = "0";
                    }
                }

                Athlete newAthlete = new Athlete();
                newAthlete.setPlayerRank(Integer.parseInt(cleanData[0]));
                newAthlete.setName(cleanData[1]);
                newAthlete.setStarted(Integer.parseInt(cleanData[2]));
                newAthlete.setPassingYds(Integer.parseInt(cleanData[3]));
                newAthlete.setPassingTds(Integer.parseInt(cleanData[4]));
                newAthlete.setRushingYds(Integer.parseInt(cleanData[5]));
                newAthlete.setRushingTds(Integer.parseInt(cleanData[6]));
                newAthlete.setRecYds(Integer.parseInt(cleanData[7]));
                newAthlete.setRecTds(Integer.parseInt(cleanData[8]));
                newAthlete.setFieldGoals(Integer.parseInt(cleanData[9]));
                newAthlete.setTackles(Integer.parseInt(cleanData[10]));
                newAthlete.setAge(Integer.parseInt(cleanData[11]));
                newAthlete.setTeam(cleanData[12]);
                newAthlete.setPassCompleted(Integer.parseInt(cleanData[13]));
                newAthlete.setPassAttempted(Integer.parseInt(cleanData[14]));
                newAthlete.setInterceptions(Integer.parseInt(cleanData[15]));
                newAthlete.setSacked(Integer.parseInt(cleanData[16]));
                newAthlete.setSackedYdsLost(Double.parseDouble(cleanData[17]));
                newAthlete.setPos(cleanData[18]);

                athletes.add(newAthlete);
            }
            return athletes;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    protected ArrayList<String> convertTeamData() {

        String line = "";
        ArrayList<String> jsonData = new ArrayList<String>();

        try {

            reader = new BufferedReader(new FileReader(fileName));
            while ((line = reader.readLine()) != null) {

                String[] row = line.split(",");
                String name = row[0];
                String founded = row[1];
                String wins = row[3];
                String losses = row[4];
                String championships = row[18];
                String coach = row[11];

                jsonData.add(
                        String.format(
                                "{\"name\": \"%s\", \"founded\": \"%s\", \"wins\": \"%s\", \"losses\": \"%s\", \"championships\": \"%s\", \"coach\": \"%s\"}",
                                name, founded, wins, losses, championships, coach));

            }

            // jsonData = jsonData.substring(0, (jsonData.length() - 1));
            // jsonData += "]";

            return jsonData;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

}