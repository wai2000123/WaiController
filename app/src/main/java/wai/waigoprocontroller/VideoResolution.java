package wai.waigoprocontroller;

/**
 * Created by Wai on 17/8/2015.
 */
public class VideoResolution {

    /**
     * For gopro Video Resolution Setting
     */
    public enum videoResolution {
        _4000p("4K","1"),
        _4000p_SuperView("4K SuperView","2"),
        _2700p("2.7K","4"),
        _2700p_SuperView("2.7K SuperView","5"),
        _2700p_4TO3("2.7K 4:3","6"),
        _1440p("1440p","7"),
        _1080p_SuperView("1080p SuperView","8"),
        _1080p("1080p","9"),
        _960p("960p","10"),
        _720p_SuperView("720p SuperView","11"),
        _720p("720p","12"),
        _WVGA("WVGA","13");

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
        videoResolution(String name,String s) {
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
            return "2/"+statusCode;
        }
    }
}
