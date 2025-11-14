import java.util.*;

public class Tournament {
    private String tournamentName;
    
    // TODO: Gunakan List untuk urutan tim
    private List<GameTeam> teams;
    private Map<String, GameTeam> teamMap;
    private Set<GameTeam> playedTeams;
    
    // TODO: Gunakan Map untuk quick lookup tim berdasarkan nama
    
    // TODO: Gunakan Set untuk track nama-nama tim yang sudah bertanding
    
    public Tournament(String tournamentName) {
        this.tournamentName = tournamentName;
        this.teams = new ArrayList<>();
        this.teamMap = new HashMap<>();
        this.playedTeams = new HashSet<>();
    }
    
    // TODO: Buat method registerTeam(GameTeam team)
    // Tambahkan team ke List dan Map
    public void registerTeam(GameTeam team){
        teams.add(team);
        teamMap.put(team.getTeamName(), team);
    }
    
    // TODO: Buat method getTeam(String teamName) return GameTeam
    // Gunakan Map untuk lookup
    public GameTeam getTeam(String teamName){
        return teamMap.get(teamName);
    }
    
    // TODO: Buat method recordMatch(String team1Name, String team2Name)
    // Tambahkan kedua tim ke playedTeams Set
    public void recordMatch(String team1Name, String team2Name){
        playedTeams.add(getTeam(team1Name));
        playedTeams.add(getTeam(team2Name));
    }
    
    // TODO: Buat method getTotalTeams() return int
    public int getTotalTeams(){
        return teams.size();
    }
    
    // TODO: Buat method getTeamsNotPlayed() return List<String>
    // Return team yang belum bertanding (tidak ada di Set playedTeams)
    public List<String> getTeamsNotPlayed(){
        List<String> list = new ArrayList<>();
        for(GameTeam g : teams){
            if(!playedTeams.contains(g)){
                list.add(g.getTeamName());
            }
        }

        return list;
    }
    
    // TODO: Buat method getAllTeams() return List<GameTeam>
    public List<GameTeam> getAllTeams(){
        List<GameTeam> list = new ArrayList<>(teams);
        return list;
    }
}