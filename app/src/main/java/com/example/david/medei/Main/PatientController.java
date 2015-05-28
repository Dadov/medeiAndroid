package com.example.david.medei.Main;

import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;

/**
 * Created by David on 5/28/2015.
 * Controller class
 */
public class PatientController {

    public PatientController() {

    }

    /**
     * this method creates a http post request to backend
     * @param patient is an object of Patient
     */
    public void postData(final Patient patient) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // Create a new HttpClient and Post Header
                HostnameVerifier hostnameVerifier = org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;
                DefaultHttpClient client = new DefaultHttpClient();
                SchemeRegistry registry = new SchemeRegistry();
                SSLSocketFactory socketFactory = SSLSocketFactory.getSocketFactory();
                socketFactory.setHostnameVerifier((X509HostnameVerifier) hostnameVerifier);
                registry.register(new Scheme("https", socketFactory, 443));
                SingleClientConnManager mgr = new SingleClientConnManager(client.getParams(), registry);
                DefaultHttpClient httpClient = new DefaultHttpClient(mgr, client.getParams());

                // Set verifier
                HttpsURLConnection.setDefaultHostnameVerifier(hostnameVerifier);
                HttpPost httpPost = new HttpPost("https://test-api.smart-trial.dk/api/public/signup/5566e151817a62021b1ea809");
                httpPost.setHeader(HTTP.CONTENT_TYPE, "application/x-www-form-urlencoded;charset=UTF-8");
                try {
                    List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(3);
                    nameValuePair.add(new BasicNameValuePair("firstname", patient.getFirstName()));
                    nameValuePair.add(new BasicNameValuePair("lastname", patient.getLastName()));
                    nameValuePair.add(new BasicNameValuePair("email", patient.getEmail()));
                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair, "UTF-8"));

                    // Execute HTTP Post Request
                    HttpResponse response = httpClient.execute(httpPost);
                    String respStr = EntityUtils.toString(response.getEntity());

                } catch (ClientProtocolException e) {
                    e.getMessage();
                } catch (IOException e) {
                    e.getMessage();
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        });
        thread.start();

    }
}
