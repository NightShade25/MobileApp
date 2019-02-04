package com.example.a10011752.weatherprojectapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    //MY THEME IS AVATAR THE LAST AIRBENDER NORTHERN WATER TRIBE

    String zip = "";
    EditText zipCode;
    TextView currentTemp, low1, low2, low3, low4, high1, high2, high3, high4, funnyQuote, currentWeatherDescription, currentTime, time1, time2, time3, time4;
    ImageView mainCurrentWeatherImage, weatherImage1, weatherImage2, weatherImage3, weatherImage4;
    Button okZip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        zipCode = findViewById(R.id.id_editTextZipCodeInput);
        okZip = findViewById(R.id.id_okForZipCodeButton);
        currentTemp = findViewById(R.id.id_currentTemperature);
        currentWeatherDescription = findViewById(R.id.id_currrentWeatherDescription);
        funnyQuote = findViewById(R.id.id_tagLine);

        low1 = findViewById(R.id.id_lowTemperature1);
        low2 = findViewById(R.id.id_lowTemperature2);
        low3 = findViewById(R.id.id_lowTemperature3);
        low4 = findViewById(R.id.id_lowTemperature4);
        high1 = findViewById(R.id.id_highTemperature1);
        high2 = findViewById(R.id.id_highTemperature2);
        high3 = findViewById(R.id.id_highTemperature3);
        high4 = findViewById(R.id.id_highTemperature4);
        mainCurrentWeatherImage= findViewById(R.id.id_currentWeatherPictue) ;
        weatherImage1= findViewById(R.id.id_weatherPicture1);
        weatherImage2 = findViewById(R.id.id_weatherPicture2);
        weatherImage3= findViewById(R.id.id_weatherPicture3);
        weatherImage4= findViewById(R.id.id_weatherPicture4);

        currentTime= findViewById(R.id.id_currentTime);
        time1= findViewById(R.id.id_time1);
        time2= findViewById(R.id.id_time2);
        time3= findViewById(R.id.id_time3);
        time4= findViewById(R.id.id_time4);

        okZip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAGTAG", zipCode.getText().toString() +"");
                zip = zipCode.getText().toString();
                Log.d("TAGTAG", zip +" part 2");
                new AsyncThread().execute(zip);
            }
        });



    }


    public class AsyncThread extends AsyncTask<String, Void, JSONObject> {



        @Override
        protected JSONObject doInBackground(String... zips) {

            String result = "";
            try {
                URL url = new URL("http://api.openweathermap.org/data/2.5/forecast?zip="+zips[0]+"&units=imperial&appid=fe024b03af55cf7154e725cdda2ef8f9");

                URLConnection conn = url.openConnection();

                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                String s = "";


                while ((s = br.readLine())!= null) {
                        result += s;
                }
           //     Log.d("TAGTAG", result+"");

                JSONObject weather1 = new JSONObject(result);
                return weather1;

             //   Log.d("TAGTAG", weather1.toString()+"");
             //   Log.d("TAGTAG", weather1.getJSONArray("list").getJSONObject(0).getJSONObject("main").getString("temp")+"");

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }


            return  null;
        }

        public  String changeTime(long timestamp) {
            try{
                Calendar calendar = Calendar.getInstance();
                TimeZone tz = calendar.getTimeZone();
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm aa");
                sdf.setTimeZone(tz);
                return sdf.format(new Date(timestamp * 1000));
            }catch (Exception e) {
            }
            return "";
        }
        @Override
        protected void onPostExecute(JSONObject jsonObject) {
            super.onPostExecute(jsonObject);
            try {
                if(jsonObject!=null) {
                    currentTemp.setText(jsonObject.getJSONArray("list").getJSONObject(0).getJSONObject("main").getString("temp") + " F");
                    currentTime.setText(changeTime(jsonObject.getJSONArray("list").getJSONObject(0).getLong("dt")));

                    //want 1, 2, 3, 4 ,5
                    low1.setText(jsonObject.getJSONArray("list").getJSONObject(1).getJSONObject("main").getString("temp_min") + " F");
                    high1.setText(jsonObject.getJSONArray("list").getJSONObject(1).getJSONObject("main").getString("temp_max") + " F");
                    time1.setText(changeTime(jsonObject.getJSONArray("list").getJSONObject(1).getLong("dt")));

                    low2.setText(jsonObject.getJSONArray("list").getJSONObject(2).getJSONObject("main").getString("temp_min") + " F");
                    high2.setText(jsonObject.getJSONArray("list").getJSONObject(2).getJSONObject("main").getString("temp_max") + " F");
                    time2.setText(changeTime(jsonObject.getJSONArray("list").getJSONObject(2).getLong("dt")));

                    low3.setText(jsonObject.getJSONArray("list").getJSONObject(3).getJSONObject("main").getString("temp_min") + " F");
                    high3.setText(jsonObject.getJSONArray("list").getJSONObject(3).getJSONObject("main").getString("temp_max") + " F");
                    time3.setText(changeTime(jsonObject.getJSONArray("list").getJSONObject(3).getLong("dt")));

                    low4.setText(jsonObject.getJSONArray("list").getJSONObject(4).getJSONObject("main").getString("temp_min") + " F");
                    high4.setText(jsonObject.getJSONArray("list").getJSONObject(4).getJSONObject("main").getString("temp_max") + " F");
                    time4.setText(changeTime(jsonObject.getJSONArray("list").getJSONObject(4).getLong("dt")));

                    String a = jsonObject.getJSONArray("list").getJSONObject(0).getJSONArray("weather").getJSONObject(0).getString("main");
                    if (a.equals("Clear")) {
                        mainCurrentWeatherImage.setImageResource(R.drawable.clear);
                    } else if (a.equals("Clouds")) {
                        mainCurrentWeatherImage.setImageResource(R.drawable.cloud);
                    } else if (a.equals("Rain")) {
                        mainCurrentWeatherImage.setImageResource(R.drawable.rain);
                    }

                    String b = jsonObject.getJSONArray("list").getJSONObject(0).getJSONArray("weather").getJSONObject(0).getString("description");

                    if(b.equals("clear sky")){                                                          //10
                        funnyQuote.setText("clearly see princess yue");
                    }else if(b.equals("few clouds")){                                                   //1
                        funnyQuote.setText("a few clouds to shield you from the sun's rage!");
                    }else if(b.equals("light rain")){                                             //2
                        funnyQuote.setText("yue will be mildly seen, light rain will block her!");
                    }else if(b.equals("broken clouds")){                                                //3
                        funnyQuote.setText("broken clouds will obscure your vie-yue");
                    }else if(b.equals("shower rain")){                                                  //4
                        funnyQuote.setText("waterbend outside today!");
                    }else if(b.equals("rain")){                                                         //5
                        funnyQuote.setText("your white jade's will be watered!");
                    }else if(b.equals("thunderstorm")){                                                 //6
                        funnyQuote.setText("stay inside, the gods are angry!");
                    }else if(b.equals("snow")){                                                         //7
                        funnyQuote.setText("hopefully its not black-ashed!");
                    }else if(b.equals("mist")){                                                         //8
                        funnyQuote.setText("dont lose your pendants, you might be searching! ");
                    }else if(b.equals("volcanic ash")){                                                 //9
                        funnyQuote.setText("THE FIRE NATION HAS RETURNED");
                    }else if(b.equals("scattered clouds")) {                                            //11
                        funnyQuote.setText("yue will be mildly seen,clouds will block her!");
                    }

                    //clearly see princess yue
                    //yue will be mildly seen
                    //scattering clouds will obsure your view-yue


                    currentWeatherDescription.setText(jsonObject.getJSONArray("list").getJSONObject(0).getJSONArray("weather").getJSONObject(0).getString("description"));

                    for (int i = 1; i < 6; i++) {
                        a = "";
                            a = jsonObject.getJSONArray("list").getJSONObject(i).getJSONArray("weather").getJSONObject(0).getString("main");
                        if (a.equals("Clear")) {
                            if (i == 1) {
                                weatherImage1.setImageResource(R.drawable.clear);
                            } else if (i == 2) {
                                weatherImage2.setImageResource(R.drawable.clear);
                            } else if (i == 3) {
                                weatherImage3.setImageResource(R.drawable.clear);
                            } else if (i == 4) {
                                weatherImage4.setImageResource(R.drawable.clear);
                            }
                        } else if (a.equals("Clouds")) {
                            if (i == 1) {
                                weatherImage1.setImageResource(R.drawable.cloud);
                            } else if (i == 2) {
                                weatherImage2.setImageResource(R.drawable.cloud);
                            } else if (i == 3) {
                                weatherImage3.setImageResource(R.drawable.cloud);
                            } else if (i == 4) {
                                weatherImage4.setImageResource(R.drawable.cloud);
                            }
                        } else if (a.equals("Rain")) {
                            if (i == 1) {
                                weatherImage1.setImageResource(R.drawable.rain);
                            } else if (i == 2) {
                                weatherImage2.setImageResource(R.drawable.rain);
                            } else if (i == 3) {
                                weatherImage3.setImageResource(R.drawable.rain);
                            } else if (i == 4) {
                                weatherImage4.setImageResource(R.drawable.rain);
                            }
                        } else if (a.equals("Snow")) {
                            if (i == 1) {
                                weatherImage1.setImageResource(R.drawable.snow);
                            } else if (i == 2) {
                                weatherImage2.setImageResource(R.drawable.snow);
                            } else if (i == 3) {
                                weatherImage3.setImageResource(R.drawable.snow);
                            } else if (i == 4) {
                                weatherImage4.setImageResource(R.drawable.snow);
                            }
                        }
                    }

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }


    }

}

//currentTemp.setText(jsonObject.getJSONArray("list").getJSONObject(0).getJSONArray("weather").getJSONObject(0).getString("description"));
//http://api.openweathermap.org/data/2.5/forecast?zip=08852&units=imperial&appid=fe024b03af55cf7154e725cdda2ef8f9
//key: fe024b03af55cf7154e725cdda2ef8f9