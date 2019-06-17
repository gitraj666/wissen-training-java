class Nexwave {
    public void doLearn() {
        // auth
        System.out.println("Do Learning");
    }

    public void doLab() {
        //auth
        System.out.println("Do Labs");
    }
}

class Auth {
    public void logIn() {
        System.out.println("Logged In");
    }

    public void logOut() {
        System.out.println("Logged Out");
    }

}

class NexwaveProxy extends Nexwave {
    Auth auth = new Auth();

    @Override
    public void doLearn() {
        auth.logIn();
        super.doLearn();
        auth.logOut();
    }

    @Override
    public void doLab() {
        auth.logIn();
        super.doLab();
        auth.logOut();
    }
}

public class Ex2 {
    public static void main(String args[]) {
        NexwaveProxy nexWaveProxy = new NexwaveProxy();
        nexWaveProxy.doLab();
        nexWaveProxy.doLearn();
    }
}