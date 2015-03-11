/*
 * Copyright (C) 2013 The Android Open Source Project
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.customnotifications;

import android.app.Activity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.text.Html;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.client.methods.HttpGet;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;



    public class MainActivity extends Activity {
        /**
         * This sample demonstrates notifications with custom content views.
         * <p/>
         * <p>On API level 16 and above a big content view is also defined that is used for the
         * 'expanded' notification. The notification is created by the NotificationCompat.Builder.
         * The expanded content view is set directly on the {@link android.app.Notification} once it has been build.
         * (See {@link android.app.Notification#bigContentView}.) </p>
         * <p/>
         * <p>The content views are inflated as {@link android.widget.RemoteViews} directly from their XML layout
         * definitions using {@link android.widget.RemoteViews#RemoteViews(String, int)}.</p>
         */






        @Override
        public void onBackPressed() {
            // do nothing. We want to force user to stay in this activity and not drop out.
            setContentView(R.layout.sample_main);
        }

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            WebView webView = (WebView) findViewById(R.id.webView);



            setContentView(R.layout.main);
        }

        /**
         * Create and show a notification with a custom layout.
         * This callback is defined through the 'onClick' attribute of the
         * 'Show Notification' button in the XML layout.
         *
         * @param
         */


        public void schedule(View view) {
            setContentView(R.layout.schedule);
        }

        public void back(View view) {
            setContentView(R.layout.sample_main);
        }

        public void events(View view) {
            setContentView(R.layout.events);
        }

        public void doScale(View view){
            ImageView imageView = (ImageView) findViewById(R.id.imageView);
            imageView.setImageResource(R.drawable.bigman);


            Animation scaleAnimation = AnimationUtils.loadAnimation(
                    getApplicationContext(), R.anim.scale);

            imageView.startAnimation(scaleAnimation);



        }
        class RequestTask extends AsyncTask<String, String, String>{

            @Override
// username, password, message, mobile
            protected String doInBackground(String... url) {
                // constants
                int timeoutSocket = 5000;
                int timeoutConnection = 5000;

                HttpParams httpParameters = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
                HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);
                HttpClient client = new DefaultHttpClient(httpParameters);

                HttpGet httpget = new HttpGet(url[0]);

                try {
                    HttpResponse getResponse = client.execute(httpget);
                    final int statusCode = getResponse.getStatusLine().getStatusCode();

                    if(statusCode != HttpStatus.SC_OK) {
                        Log.w("MyApp", "Download Error: " + statusCode + "| for URL: " + url);
                        return null;
                    }

                    String line = "";
                    StringBuilder total = new StringBuilder();

                    HttpEntity getResponseEntity = getResponse.getEntity();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(getResponseEntity.getContent()));

                    while((line = reader.readLine()) != null) {
                        total.append(line);
                    }

                    line = total.toString();
                    return line;
                } catch (Exception e) {
                    Log.w("MyApp", "Download Exception : " + e.toString());
                }
                return null;
            }

            @Override
            protected void onPostExecute(String result) {
                // do something with result
            }
        }
    }
