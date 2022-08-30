package climateChange;

public class meatearologist {

        private String city;
        private String temperature;
        private String desc;
        private String dayLength;

        public meatearologist() {
                super();
        }

        public String getCity() {
                return city;
        }

        public String getTemperature() {
                return temperature;
        }

        public String getDesc() {
                return desc;
        }

        public String getDayLength() {
                return dayLength;
        }

        public meatearologist(String city, String temperature, String desc, String dayLength){
                this.city=city;
                this.temperature=temperature;
                this.desc=desc;
                this.dayLength=dayLength;

        }

}
