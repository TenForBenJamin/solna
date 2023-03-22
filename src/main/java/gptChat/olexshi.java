package gptChat;

public class olexshi {



        public static final double R = 6371; // Radius of the earth in km

        public static double distance(double lat1, double lon1, double lat2, double lon2) {
            double dLat = Math.toRadians(lat2 - lat1);
            double dLon = Math.toRadians(lon2 - lon1);
            double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                    Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                            Math.sin(dLon / 2) * Math.sin(dLon / 2);
            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
            double distance = R * c;
            return distance;
        }

        public static void main(String[] args) {
            double lat1 = 52.520008;
            double lon1 = 13.404954;
            double lat2 = 50.856614;
            double lon2 = 0.352222;

            double distance = distance(lat1, lon1, lat2, lon2);
            System.out.println("Distance between Berlin and Paris is: " + distance + " km");
        }


}
