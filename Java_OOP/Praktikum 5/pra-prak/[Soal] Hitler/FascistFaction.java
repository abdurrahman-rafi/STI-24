/**
 * POLYMORPHIC IMPLEMENTATION: FascistFaction extends Faction
 * 
 * This class demonstrates POLYMORPHISM by providing Fascist-specific
 * implementations of all abstract methods from the Faction class.
 * 
 * Fascist Faction Goals:
 * - Win by enacting 6 fascist policies OR by getting Hitler as chancellor with
 * 3+ fascist policies
 * - Coordinate secretly to achieve fascist control
 */
public class FascistFaction extends Faction {

  public FascistFaction() {
    super("Fascist");
  }

  @Override
  public Policy getPreferredDiscard(Policy[] policies) {
    // MAIN TODO: Implement fascist faction's policy preference
    // HINT: Fascists want to prevent liberal policies from being enacted, so they
    // should discard liberal policies if possible
    for(Policy p : policies){
      if(p == Policy.LIBERAL){
        return p;
      }
    }

    // TODO: Loop through policies to find the preferred discard type
    // TODO: Return a default option (first policy) if preferred type not found

    return policies[1];
  }

  @Override
  public Vote getVoteDecision(Player chancellor, Player president) {
    // MAIN TODO: Implement fascist faction's voting behavior
    // HINT: Fascists vote strategically to help other fascists gain power

    // TODO: Check if the chancellor or president belongs to the fascist faction
    // TODO: Vote to benefit fascist players and hinder liberal players
    if(chancellor.getFaction().getFactionName().equals("Fascist") || president.getFaction().getFactionName().equals("Fascists") ){
      return Vote.YAY;
    }else{
      return Vote.NAY;
    }
    

    // return null;
  }

  @Override
  public boolean checkWinCondition(int liberalPolicies, int fascistPolicies, boolean hitlerIsChancellor) {
    // MAIN TODO: Implement fascist win condition check
    // HINT: Fascists can win in two ways:
    // 1. By enacting enough fascist policies (6 fascists policies enacted)
    // 2. By getting Hitler as chancellor when certain conditions are met (3
    // fascists policies enacted)

    // TODO: Check for fascist policy victory condition
    if(fascistPolicies >= 6){
      return true;
    }
    
    return (fascistPolicies >= 3 && hitlerIsChancellor);
    // TODO: Check for Hitler-chancellor victory condition
    // TODO: Return true if any win condition is met

    // return false;
  }
}