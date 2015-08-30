package andres.dev.com.weatherapp.Uties.TAGs;

/**
 * Created by INNSO SAS on 29/08/2015.
 */
public enum ActivityTags {

    SPLASH(100);

    private int Code;

    private ActivityTags(int code){
        Code = code;
    }

    public int code(){
        return Code;
    }
}
