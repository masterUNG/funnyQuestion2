package thailand.soumbundit.jirawat.funnyquestion.utility;

import java.security.PrivateKey;

public class MyConstant {

//    #########################################################################
//    About Unit1
//    #########################################################################
//    Warm Up
    private int[] answer1TrueInts = new int[]{2, 8, 13, 24};
    private int[] answer2TrueInts = new int[]{2, 3};
    private int[] answer3TrueInts = new int[]{2, 4};

//    Practice
    private String[] practice1True = new String[]{"keyboard","touch screen","data collection", "aa"};
    private int [] practise3Ints = new int[]{1,1,2,2,3,3};

//    #########################################################################

    //    item
    private String[] chioceSpinnerItemStrings = new String[]{
            "????",
            "game consoles",
            "webcam",
            "CPU",
            "external drive",
            "headset",
            "joystick",
            "keyboard",
            "speaker",
            "microphone",
            "laptop",
            "Flash drive",
            "USB",
            "data collection device",
            "gamepad",
            "headset",
            "mobile phone",
            "mouse",
            "mp3",
            "PDA",
            "printer",
            "scanner",
            "Screen",
            "tablet (pad)"
            };

    //    Choice Spinner 1
    private String[] chioceSpinner1Strings = new String[]{
            "1)..........",
            "To listen to music",
            "xxx",
            "To listen music",
            "xxx",
            "Listen to music",
            "xxx",
            "Listen music",
            "xxx",
            "Listening to music",
            "xxx",
            "To watch movie",
            "xxx",
            "Watching movies",
            "xxx",
            "To watch movies",
            "xxx",
            "Watching a movie",
            "xxx",
            "To play games",
            "xxx",
            "To play a game",
            "xxx",
            "Playing games",
            "Playing a game",
            "xxx",
            "To play computer games",
            "Playing computer games",
            "To shop online",
            "Shopping online",
            "xxx",
            "xxx"};

    private String[] chioceSpinner2Strings = new String[]{
            "2)..........",
            "xxx",
            "xxx",
            "Buying things",
            "xxx",
            "xxx",
            "To buy things",
            "Buy things",
            "Buy a thing",
            "xxx",
            "xxx",
            "xxx",
            "xxx",
            "To search information",
            "Searching information",
            "To present projects",
            "xxx",
            "xxx",
            "xxx",
            "Projects presenting",
            "To present a project",
            "To download music",
            "xxx",
            "xxx",
            "To present projects",
            "Downloading music",
            "xxx",
            "xxx",
            "xxx",
            "To download songs",
            "xxx",
            "Downloading songs"};

    private String[] chioceSpinner3Strings = new String[]{
            "3)..........",
            "xxx",
            "xxx",
            "To make website",
            "xxx",
            "Making website",
            "Website making",
            "xxx",
            "xxx",
            "xxx",
            "xxx",
            "To do project",
            "xxx",
            "xxx",
            "Doing project",
            "xxx",
            "Doing a project",
            "To do projects",
            "xxx",
            "xxx",
            "Doing projects",
            "xxx",
            "xxx",
            "xxx",
            "To do homework",
            "Doing homework",
            "xxx",
            "xxx",
            "To sell things",
            "Selling things"
            };

    private String[] chioceSpinner4Strings = new String[]{
            "..........",
            "Input devices",
            "Input device",
            "Input Devices",
            "Input Device",
            "Output devices",
            "Output device",
            "Output Devices",
            "Output Device",
            "System unit",
            "System Unit",
            "Storage devices",
            "Storage device",
            "Storage Devices",
            "Storage Device",
            "Communication devices",
            "Communication device",
            "Communication Devices",
            "Communication Device"
    };


    private String[] unitTitleStrings = new String[]{
            "Unit1 Computer Users",
            "Unit2",
            "Unit3 Computer Applications",
            "Unit4 The Internet",
            "Unit5",
            "Unit6"
    };

    private String[] chioceSpinner5Strings = new String[]{
            "..........",
            "To add a sound track",
            "To write assignments",
            "To make CDs",
            "To start his own website to try to sell directly",
            "To make birthday cards",
            "To organize the paintings themes",
            "To email tutor if she has some problem with the course work",
            "To encourage young students, to tell stories",

    }; //Practice: Listening


    private String[] chioceSpinner6Strings = new String[]{
            "..",
            "you",
            "computer",
            "your",
            "use",
            "in",
            "do",
            "How",
            "freetime",
            "?",

    }; //Language work: Practice

    private String[] chioceSpinner7Strings = new String[]{
            "Answer:.........",
            "Edutainment",
            "Multimedia",
            "Expert system",
            "Telecommute",
            "Information Superhighway"
    }; //B: Re-read the text to find the answers to these question.


//    Getter


    public int[] getPractise3Ints() {
        return practise3Ints;
    }

    public String[] getPractice1TrueString() {
        return practice1True;
    }

    public int[] getAnswer1TrueInts() {
        return answer1TrueInts;
    }

    public int[] getAnswer2TrueInts() {
        return answer2TrueInts;
    }

    public int[] getAnswer3TrueInts() {
        return answer3TrueInts;
    }

    public String[] getChioceSpinner7Strings() {
        return chioceSpinner7Strings;
    }

    public String[] getChioceSpinner6Strings() {
        return chioceSpinner6Strings;
    }

    public String[] getChioceSpinner5Strings() {
        return chioceSpinner5Strings;
    }

    public String[] getChioceSpinnerItemStrings() {
        return chioceSpinnerItemStrings;
    }

    public String[] getChioceSpinner4Strings() {
        return chioceSpinner4Strings;
    }

    public String[] getChioceSpinner1Strings() {
        return chioceSpinner1Strings;
    }

    public String[] getChioceSpinner2Strings() {
        return chioceSpinner2Strings;
    }

    public String[] getChioceSpinner3Strings() {
        return chioceSpinner3Strings;
    }

    public String[] getUnitTitleStrings() {
        return unitTitleStrings;
    }
}
