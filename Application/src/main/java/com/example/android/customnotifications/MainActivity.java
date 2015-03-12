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
import java.net.URL;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {







        @Override
        public void onBackPressed() {
            // do nothing. We want to force user to stay in this activity and not drop out.
            setContentView(R.layout.sample_main);
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

        public void doScale(View view) {
            ImageView imageView = (ImageView) findViewById(R.id.imageView);
            imageView.setImageResource(R.drawable.bigman);


            Animation scaleAnimation = AnimationUtils.loadAnimation(
                    getApplicationContext(), R.anim.scale);

            imageView.startAnimation(scaleAnimation);


        }

    }

