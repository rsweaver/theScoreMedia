package Library;

public class Utilities {

  public enum LeagueOptions {
    NFL_FOOTBALL("NFL Football"),
    NBA_BASKETBALL("NBA Baskedball"),
    MLB_BASEBALL("MLB Baseball"),
    NHL_HOCKEY("NHL Hockey"),
    NCAA_FOOTBALL("NCAA Football"),
    NCAA_MENS_BASKETBALL("NCAA Men's Baskedball"),
    PGA_TOUR("PGA Tour"),
    NFL_FANTASY_NEWS("NFL Fantasy News");

    private final String text;

    LeagueOptions(final String text) {
      this.text = text;
    }

    @Override
    public String toString() {
      return text;
    }

  }


  public enum NFLTeams {
    SEAHAWKS("Seattle Seahawks", "Pete Carroll", "Lumen Field", "Seattle"),
    PATRIOTS("New England Patriots", "Bill Belichick", "Gillette Stadium", "Foxborough"),
    PACKERS("Green Bay Packers", "Matt LaFleur", "Lambeau Field", "Green Bay"),
    COWBOYS("Dallas Cowboys", "Mike McCarthy", "AT&T Stadium", "Arlington"),
    CHIEFS("Kansas City Chiefs", "Andy Reid", "Arrowhead Stadium", "Kansas City"),
    STEELERS("Pittsburgh Steelers", "Mike Tomlin", "Heinz Field", "Pittsburgh"),
    RAMS("Los Angeles Rams", "Sean McVay", "SoFi Stadium", "Inglewood"),
    _49ERS("San Francisco 49ers", "Kyle Shanahan", "Levi's Stadium", "San Francisco");
    //todo add all teams

    private final String name;
    private final String headCoach;
    private final String stadium;
    private final String location;

    NFLTeams(String name, String headCoach, String stadium, String location) {
      this.name = name;
      this.headCoach = headCoach;
      this.stadium = stadium;
      this.location = location;
    }

    public String getName() {
      return name;
    }

    public String getHeadCoach() {
      return headCoach;
    }

    public String getStadium() {
      return stadium;
    }

    public String getLocation() {
      return location;
    }

    @Override
    public String toString() {
      return name;
    }
  }

  public enum InfoTabLables {
    HEAD_COACH("Head Coach"),
    STADIUM("Stadium"),
    LOCATION("Location");
    //todo add other detail page info details

    private final String text;

    InfoTabLables(final String text) {
      this.text = text;
    }

    @Override
    public String toString() {
      return text;
    }
  }

}
