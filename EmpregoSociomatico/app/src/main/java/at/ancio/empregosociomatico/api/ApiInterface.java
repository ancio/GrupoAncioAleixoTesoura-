package at.ancio.empregosociomatico.api;

import at.ancio.empregosociomatico.models.Vagas;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

@GET("top-headlines")
Call<Vagas> getVagas(

        @Query("country") String country ,
        @Query("apiKey") String apiKey
);



}
