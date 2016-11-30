package com.tr2016.hederkosher.utils;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ruslan on 29/11/16.
 */

public class Connection {
    public Map<String, Object> request(String url, Map<String, Object> parametersBody, Map<String, Object> parametersHeader){
        if (parametersBody==null) parametersBody = new HashMap<>();
        if (parametersHeader==null) parametersHeader = new HashMap<>();
        try {
            AsyncConnection connection= new AsyncConnection(url, parametersBody, parametersHeader);
            AsyncTask<String, Void, Map<String, Object>> responce = connection.execute();
//            Map<String,Object> mapRes = null;
            return responce.get();
        } catch (Exception e) {
        }
        return null;
    }


    class AsyncConnection extends AsyncTask<String, Void, Map<String, Object>> {
        private String urlString = "";
        private Map<String, Object> parametersHeader;
        private Map<String, Object> parametersBody;
        private int readTimeOut = 10000;
        private int connectTimeout = 15000;

        private String methodHeader = "GET";

        private Map<String, Object> mapRes;

        public AsyncConnection(String urlString, Map<String, Object> parametersBody, Map<String, Object> parametersHeader) {
            this.urlString = urlString;
            this.parametersBody = parametersBody;
            this.parametersHeader = parametersHeader;
        }

        public Map<String, Object> request() {
            mapRes = new HashMap<>();
            mapRes.put("requestStatus", Boolean.FALSE);
            mapRes.put("requestMessage", "");
            mapRes.put("status", 0);
            mapRes.put("responceString", "");

            if (urlString == null || urlString.isEmpty()) {
                mapRes.put("requestMessage", "Url is empty");
            }

            try {
                String responceString = getContentToString();
                mapRes.put("responceString", responceString);
            } catch (Exception e) {
                mapRes.put("requestMessage", e.getMessage());
            }
            return mapRes;
        }


        private String getContentToString() {
            BufferedReader reader = null;
            HttpURLConnection c = null;
            try {
                URL url = new URL(urlString);
                c = (HttpURLConnection) url.openConnection();

                c.setRequestProperty("Content-Type","application/json");
                c.setRequestProperty("Content-length", "0");
                c.setRequestProperty("Accept", "application/json");
                c.setRequestMethod(parametersHeader.containsKey("method")? (String) parametersHeader.get("method") : methodHeader);
                c.setReadTimeout(parametersHeader.containsKey("readTimeOut")? Integer.parseInt((String) parametersHeader.get("readTimeOut")) : readTimeOut);
                c.setConnectTimeout(parametersHeader.containsKey("connectTimeout")? Integer.parseInt((String) parametersHeader.get("connectTimeout")) : connectTimeout);
                c.setUseCaches(false);
                c.setAllowUserInteraction(false);

                if (!parametersBody.isEmpty()){
                    c.setDoInput(true);
                    c.setDoOutput(true);
                    c.setChunkedStreamingMode(0);
//                    JSONObject json = new JSONObject();
//                    for (Map.Entry<String, Object> entry : parametersBody.entrySet()) {
//                        try {
//                            json.put(entry.getKey(),entry.getValue());
//                        } catch (JSONException e) {
//                        }
//                    }
                    JSONObject json = getJsonFromMap(parametersBody);

                    OutputStream out = new BufferedOutputStream(c.getOutputStream());
                    OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
                    osw.write(json.toString());
                    osw.flush();
                    osw.close();
                }

                c.connect();

                int status = c.getResponseCode();
                mapRes.put("status", status);
//                if(status == HttpURLConnection.HTTP_OK)
                switch (status) {
                    case HttpURLConnection.HTTP_OK:  //HTTP Status-Code 200: OK
                    case HttpURLConnection.HTTP_CREATED: //HTTP Status-Code 201: Created.
//                        InputStream in = new BufferedInputStream(c.getInputStream());
                        reader = new BufferedReader(new InputStreamReader(c.getInputStream(),"UTF-8"));
                        StringBuilder buf = new StringBuilder();
                        String line = null;
                        while ((line = reader.readLine()) != null) {
                            buf.append(line + "\n");
                        }
                        reader.close();
                        mapRes.put("requestStatus", Boolean.TRUE);
                        return buf.toString();
                }
//            System.out.println();
            } catch (MalformedURLException ex) {
                mapRes.put("requestMessage", ex.getMessage());
            } catch (IOException ex) {
                mapRes.put("requestMessage", ex.getMessage());
            } catch (JSONException ex){
                mapRes.put("requestMessage", ex.getMessage());
            }
            finally {
                if (c != null) {
                    try {
                        c.disconnect();
                    } catch (Exception ex) {
                    }
                }
            }
            return "";
        }

        @Override
        protected Map<String, Object> doInBackground(String... path) {
            return request();
        }

        @Override
        protected void onProgressUpdate(Void... items) {
        }

        @Override
        protected void onPostExecute(Map<String, Object> content) {
//        mapRes.put("responceString",content);

//            super.onPostExecute(strJson);
//            // выводим целиком полученную json-строку
//            Log.d(LOG_TAG, strJson);
//
//            JSONObject dataJsonObj = null;
//            String secondName = "";
//
//            try {
//                dataJsonObj = new JSONObject(strJson);
//                JSONArray friends = dataJsonObj.getJSONArray("friends");
//
//                // 1. достаем инфо о втором друге - индекс 1
//                JSONObject secondFriend = friends.getJSONObject(1);
//                secondName = secondFriend.getString("name");
//                Log.d(LOG_TAG, "Второе имя: " + secondName);
//
//                // 2. перебираем и выводим контакты каждого друга
//                for (int i = 0; i < friends.length(); i++) {
//                    JSONObject friend = friends.getJSONObject(i);
//
//                    JSONObject contacts = friend.getJSONObject("contacts");
//
//                    String phone = contacts.getString("mobile");
//                    String email = contacts.getString("email");
//                    String skype = contacts.getString("skype");
//
//                    Log.d(LOG_TAG, "phone: " + phone);
//                    Log.d(LOG_TAG, "email: " + email);
//                    Log.d(LOG_TAG, "skype: " + skype);
//                }
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }
//    }
        }


    }



    private JSONObject getJsonFromMap(Map<String, Object> map) throws JSONException {
        JSONObject jsonData = new JSONObject();
        for (String key : map.keySet()) {
            Object value = map.get(key);
            if (value instanceof Map<?, ?>) {
                value = getJsonFromMap((Map<String, Object>) value);
            }
            jsonData.put(key, value);
        }
        return jsonData;
    }
}