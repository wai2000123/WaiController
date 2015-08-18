package wai.waigoprocontroller;

/**
 * Created by Wai on 17/8/2015.
 */
public class VideoFPS {
    /**
     * For gopro Video Frame Rate Setting
     */
    public enum videoFPS {
        _240fps("240fps","0"),
        _120fps("120fps","1"),
        _90fps("90fps","3"),
        _80fps("80fps","4"),
        _60fps("60fps","5"),
        _50fps("50fps","6"),
        _48fps("48fps","7"),
        _30fps("30fps","8"),
        _25fps("25fps","9"),
        _24fps("24fps","10");

        /**
         * For Display name
         */
        private String label;
        /**
         * For request status
         */
        private String statusCode;

        /**
         * Constructor method
         */
        videoFPS(String name,String s) {
            label = name;
            statusCode = s;
        }

        /**
         *
         * @return String array for Display name
         */
        public static String[] getAllLabel(){
            String[] labels = new String[values().length];
            for (int i = 0; i < values().length; i++)
            {
                labels[i] = values()[i].label;
            }
            return labels;
        }

        /**
         *
         * @return String for specified value display name
         */
        public static String getLabel(int i){return values()[i].label;}

        /**
         *
         * @return String for specified value statuscode
         */
        @Override
        public String toString() {
            return "3/"+statusCode;
        }
    }
}
