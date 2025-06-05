package wk2;

public class Sample {
    private int stuff;

    public Sample(int value) {
        stuff = value;
    }

    public String bigger() {
        Elpmas x = new Elpmas();
        Elpmas y = new Elpmas();
        x.doStuff();
        y.doStuff();
        return "" + stuff;
    }

    private class Elpmas {
        private int ffuts = 2;

        private void doStuff() {
            stuff += ffuts;
        }
    }

    public static void main(String[] args) {
        Sample sample = new Sample(4);
        sample.bigger();
        System.out.println(sample);
    }
}
