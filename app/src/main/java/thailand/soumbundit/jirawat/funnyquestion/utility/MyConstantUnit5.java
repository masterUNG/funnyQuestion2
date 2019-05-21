package thailand.soumbundit.jirawat.funnyquestion.utility;

public class MyConstantUnit5 {



    private String[] choiceSpinnerListening = new String[]{
            ".......",
            "First,",
            "Next,",
            "After that,",
            "Finally,"
    };


    //Answer correction

    private int[] answerListeningInts = new int[]{2, 1, 4, 3};


    private String[] answerLanguageStrings = new String[]{
            "people will vote in elections online.",
            "all school children in my country will have mobile phones.",
            "taxis will be robot controlled.",
            "most computers will be voice-controlled.",
            "email will be replaced by a voice-based system.",
            "computers will become more powerful.",
            "tv journalists will be able to transmit what they see by using sensors in their optic nerves.",
            "voip phones will be revolutionize the way we communicate.",
            "mobile phones will replace computers as the commonest way to access the Internet.",
            "many the older pupils will have mobile phones."
    };


    ///Getter
    public int[] getAnswerListeningInts() {
        return answerListeningInts;
    }
    public String[] getChoiceSpinnerListening() {
        return choiceSpinnerListening;
    }
    public String[] getAnswerLanguageStrings() {
        return answerLanguageStrings;
    }


}
