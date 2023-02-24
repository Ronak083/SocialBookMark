package Constants;
public enum bookGenre {
      ART("Art"),
      BIOGRAPHY("Biography"),
      CHILDREN ("Children" ),
      FICTION ("Fiction" ),
      HISTORY ("History" ),
      MYSTERY ("Mystery" ),
      PHILOSOPHY ("Philosophy" ),
      RELIGION ("Religion" ),
      ROMANCE ("Romance" ),
      SELFHELP ("SelfHelp" ),
      TECHNICAL ("Technical" );

       bookGenre(String name) {
        this.name = name;
    }
    private String name;
    public String getName(){
        return name;
    }
}
