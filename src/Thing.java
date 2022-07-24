public class Thing {
    String name;
    int elo;
    public Thing(String pname) {
        this.name = pname;
        this.elo = 1000;
    }
    public Thing(String pname, int pelo) {
        this.name = pname;
        this.elo = pelo;
    }

}
