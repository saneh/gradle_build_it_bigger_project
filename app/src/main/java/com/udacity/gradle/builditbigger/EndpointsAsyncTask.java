package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;

import com.example.sanehyadav1.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

import in.lemonco.jokesandroidlib.DisplayJokeActivity;

/**
 * Created by sanehyadav1 on 12/15/16, AsyncTask to retrieve jokes
 */
public class EndpointsAsyncTask extends AsyncTask<Void,Void,String> {
    private static MyApi myApiService = null;
    private Context context;
    private GetJokeTaskListener mListener = null;
    private Exception mError = null;

    EndpointsAsyncTask(Context context){
        this.context = context;
    }
    @Override
    protected String doInBackground(Void... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
//            // end options for devappserver
//
//            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
//                    .setRootUrl("https://new-project-gae-udacity-1.appspot.com/_ah/api/");

            myApiService = builder.build();
        }

        try {
            return myApiService.sayJoke("name").execute().getData();
        } catch (IOException e) {
            mError = e;
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if(this.mListener!=null){
            this.mListener.onComplete(result,mError);
        }
        if(mListener==null) {
            Intent intent = new Intent(context, DisplayJokeActivity.class);
            if (intent != null) {
                intent.putExtra(DisplayJokeActivity.JOKE_TEXT, result);
                context.startActivity(intent);
                //joke is fetched, make the spinner invisible
                MainActivity.getSpinner().setVisibility(View.GONE);

            }
        }

    }

    public static interface GetJokeTaskListener{
        public void onComplete(String joke,Exception e);
    }

    public EndpointsAsyncTask setListener(GetJokeTaskListener listener){
        this.mListener = listener;
        return this;
    }
}

