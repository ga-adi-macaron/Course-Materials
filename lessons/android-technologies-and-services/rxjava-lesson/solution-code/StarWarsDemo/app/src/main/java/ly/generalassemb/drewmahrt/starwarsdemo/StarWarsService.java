package ly.generalassemb.drewmahrt.starwarsdemo;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by drewmahrt on 12/15/16.
 */

public interface StarWarsService {

    @GET("people/{characterID}/")
    Observable<SWCharacter> getCharacterInfo(@Path("characterID")int id);

}
