import java.util.ArrayList;

    class Singleton {
        private static Singleton s = null;
        ArrayList<String> users = new ArrayList<String>();
        ArrayList<String> admins = new ArrayList<String>();
        ArrayList<String> hotels_list = new ArrayList<String>();
        ArrayList<String> reservations = new ArrayList<String>();
        ArrayList<String> receptionists = new ArrayList<String>();

        private Singleton() {
        }

        public static Singleton getInstance() {
            if (s==null) {
                s = new Singleton();
                return s;
            } else {
                return s;
            }
        }
    }
