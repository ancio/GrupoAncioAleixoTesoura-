package at.ancio.empregosociomatico.api;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class apiClient {
 public static final String  BASE_URL = "https://uuuudud.org.com";
 public static Retrofit retrofit;

 public  static Retrofit getApiClient() throws NoSuchAlgorithmException {
     if (retrofit == null){

         new Retrofit.Builder().baseUrl(BASE_URL)
                 .client(getUnsafeOkHttpClient().build())
                 .addConverterFactory(GsonConverterFactory.create())
                 .build();

     }
     return retrofit;
 }

 public static OkHttpClient.Builder getUnsafeOkHttpClient() throws NoSuchAlgorithmException {
     try {

         final TrustManager[] trustAllCerts = new TrustManager[]{

                 new X509TrustManager() {
                     @Override
                     public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

                     }

                     @Override
                     public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

                     }

                     @Override
                     public X509Certificate[] getAcceptedIssuers() {
                         return new X509Certificate[0];
                     }
                 }
         };
         final SSLContext sslContext = SSLContext.getInstance("SSL");
         sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

         final SSLSocketFactory sslSocketFactory =sslContext.getSocketFactory();
         OkHttpClient.Builder builder = new OkHttpClient.Builder();
         builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);
         builder.hostnameVerifier(new HostnameVerifier() {
             @Override
             public boolean verify(String hostname, SSLSession session) {
                 return true;
             }
         });
         return builder;

     } catch (Exception e) {
         throw new RuntimeException(e);
     }
 }}
