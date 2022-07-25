public class Thing implements Comparable<Thing>{

    private String name;
    private int elo;
    public Thing(String pname) {
        this.name = pname;
        this.elo = 1000;
    }
    public Thing(String pname, int pelo) {
        this.name = pname;
        this.elo = pelo;
    }

    public void increaseElo(){
        this.elo += 50;
    }
    public void decreaseElo(){
        this.elo -=50;
    }

    public String getName() {
        return name;
    }

    public int getElo() {
        return elo;
    }

    @Override
    public int compareTo(Thing o) {
        return this.elo - o.elo;
    }
}
