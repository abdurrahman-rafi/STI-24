import java.util.*;

public class GameTeam implements Team {
    private String teamName;
    
    // TODO: Gunakan List untuk menyimpan urutan anggota team
    private List<TeamMember> members;
    
    // TODO: Gunakan Map untuk quick lookup member berdasarkan nama
    private Map<String, TeamMember> memberMap;
    
    public GameTeam(String teamName) {
        this.teamName = teamName;
        this.members = new ArrayList<>();
        this.memberMap = new HashMap<>();
    }
    
    // TODO: Implement addMember
    // Tambahkan member ke List dan Map
    // Tambahkan role "Player" ke Set
    @Override
    public void addMember(TeamMember p){
        members.add(p);
        memberMap.put(p.getName(), p);
    }
    
    // TODO: Implement removeMember
    // Cari dan hapus member dari List menggunakan iterator
    // Hapus dari Map juga
    @Override
    public void removeMember(String name){
        Iterator<TeamMember> iterator = members.iterator();
        while(iterator.hasNext()){
            TeamMember p = iterator.next();
            if(p.getName().equalsIgnoreCase(name)){
                iterator.remove();
                break;
            }
        }

        memberMap.remove(name);
    }

    
    // TODO: Implement findMember
    // Gunakan Map untuk quick lookup
    @Override
    public TeamMember findMember(String name){
        return memberMap.get(name);
    }
    
    // TODO: Buat method getAllMembers() return List<TeamMember>
    public List<TeamMember> getAllMembers(){
        List<TeamMember> out = new ArrayList<>(members);
        return out;
    }
    
    // TODO: Buat method getTeamSize() return int
    public int getTeamSize(){
        return members.size();
    }
    
    // TODO: Buat method getTopSkillPlayer() return TeamMember
    // Loop melalui List dan cari player dengan skill tertinggi
    public TeamMember getTopSkillPlayer(){
        TeamMember out = members.get(0);
        for(TeamMember p : members){
            if(p.getSkillLevel() > out.getSkillLevel()){
                out = p;
            }
        }

        return out;
    }
    
    // TODO: Buat method getPlayersBySkillLevel(int minSkill) return List<TeamMember>
    // Filter players yang skill-nya >= minSkill
    public List<TeamMember> getPlayersBySkillLevel(int minSkill){
        List<TeamMember> filter = new ArrayList<>();

        for(TeamMember p : members){
            if(p.getSkillLevel() >= minSkill){
                filter.add(p);
            }
        }
        return filter;
    }
    
    // TODO: Buat method getTeamName() return String
    public String getTeamName(){
        return teamName;
    }
}