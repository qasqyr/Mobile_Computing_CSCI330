//#StayHome
package com.example.homework_2_maps_activity;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.FragmentActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private RequestQueue mQ;
    private TextView textView;
    private Map<String, String> countryLocation = new HashMap<String, String>() {{
        put("Andorra", "42.546245 1.601554");
        put("UAE", "23.424076 53.847818");
        put("Afghanistan", "33.93911 67.709953");
        put("Antigua and Barbuda", "17.060816 -61.796428");
        put("Anguilla", "18.220554 -63.068615");
        put("Albania", "41.153332 20.168331");
        put("Armenia", "40.069099 45.038189");
        put("Netherlands Antilles", "12.226079 -69.060087");
        put("Angola", "-11.202692 17.873887");
        put("Antarctica", "-75.250973 -0.071389");
        put("Argentina", "-38.416097 -63.616672");
        put("American Samoa", "-14.270972 -170.132217");
        put("Austria", "47.516231 14.550072");
        put("Australia", "-25.274398 133.775136");
        put("Aruba", "12.52111 -69.968338");
        put("Azerbaijan", "40.143105 47.576927");
        put("Bosnia and Herzegovina", "43.915886 17.679076");
        put("Barbados", "13.193887 -59.543198");
        put("Bangladesh", "23.684994 90.356331");
        put("Belgium", "50.503887 4.469936");
        put("Burkina Faso", "12.238333 -1.561593");
        put("Bulgaria", "42.733883 25.48583");
        put("Bahrain", "25.930414 50.637772");
        put("Burundi", "-3.373056 29.918886");
        put("Benin", "9.30769 2.315834");
        put("Bermuda", "32.321384 -64.75737");
        put("Brunei", "4.535277 114.727669");
        put("Bolivia", "-16.290154 -63.588653");
        put("Brazil", "-14.235004 -51.92528");
        put("Bahamas", "25.03428 -77.39628");
        put("Bhutan", "27.514162 90.433601");
        put("Bouvet Island", "-54.423199 3.413194");
        put("Botswana", "-22.328474 24.684866");
        put("Belarus", "53.709807 27.953389");
        put("Belize", "17.189877 -88.49765");
        put("Canada", "56.130366 -106.346771");
        put("Cocos [Keeling] Islands", "-12.164165 96.870956");
        put("Palestine", "-4.038333 21.758664");
        put("CAR", "6.611111 20.939444");
        put("Congo", "-0.228021 15.827659");
        put("Switzerland", "46.818188 8.227512");
        put("Ivory Coast", "7.539989 -5.54708");
        put("Cook Islands", "-21.236736 -159.777671");
        put("Chile", "-35.675147 -71.542969");
        put("Cameroon", "7.369722 12.354722");
        put("China", "35.86166 104.195397");
        put("Colombia", "4.570868 -74.297333");
        put("Costa Rica", "9.748917 -83.753428");
        put("Cuba", "21.521757 -77.781167");
        put("Cape Verde", "16.002082 -24.013197");
        put("Christmas Island", "-10.447525 105.690449");
        put("Cyprus", "35.126413 33.429859");
        put("Czechia", "49.817492 15.472962");
        put("Germany", "51.165691 10.451526");
        put("Djibouti", "11.825138 42.590275");
        put("Denmark", "56.26392 9.501785");
        put("Dominica", "15.414999 -61.370976");
        put("Dominican Republic", "18.735693 -70.162651");
        put("Algeria", "28.033886 1.659626");
        put("Ecuador", "-1.831239 -78.183406");
        put("Estonia", "58.595272 25.013607");
        put("Egypt", "26.820553 30.802498");
        put("Western Sahara", "24.215527 -12.885834");
        put("Eritrea", "15.179384 39.782334");
        put("Spain", "40.463667 -3.74922");
        put("Ethiopia", "9.145 40.489673");
        put("Finland", "61.92411 25.748151");
        put("Fiji", "-16.578193 179.414413");
        put("Falkland Islands", "-51.796253 -59.523613");
        put("Micronesia", "7.425554 150.550812");
        put("Faroe Islands", "61.892635 -6.911806");
        put("France", "46.227638 2.213749");
        put("Gabon", "-0.803689 11.609444");
        put("UK", "55.378051 -3.435973");
        put("Grenada", "12.262776 -61.604171");
        put("Georgia", "42.315407 43.356892");
        put("French Guiana", "3.933889 -53.125782");
        put("Guernsey", "49.465691 -2.585278");
        put("Ghana", "7.946527 -1.023194");
        put("Gibraltar", "36.137741 -5.345374");
        put("Greenland", "71.706936 -42.604303");
        put("Gambia", "13.443182 -15.310139");
        put("Guinea", "9.945587 -9.696645");
        put("Guadeloupe", "16.995971 -62.067641");
        put("Equatorial Guinea", "1.650801 10.267895");
        put("Greece", "39.074208 21.824312");
        put("South Georgia and the South Sandwich Islands", "-54.429579 -36.587909");
        put("Guatemala", "15.783471 -90.230759");
        put("Guam", "13.444304 144.793731");
        put("Guinea-Bissau", "11.803749 -15.180413");
        put("Guyana", "4.860416 -58.93018");
        put("Gaza Strip", "31.354676 34.308825");
        put("Hong Kong", "22.396428 114.109497");
        put("Heard Island and McDonald Islands", "-53.08181 73.504158");
        put("Honduras", "15.199999 -86.241905");
        put("Croatia", "45.1 15.2");
        put("Haiti", "18.971187 -72.285215");
        put("Hungary", "47.162494 19.503304");
        put("Indonesia", "-0.789275 113.921327");
        put("Ireland", "53.41291 -8.24389");
        put("Israel", "31.046051 34.851612");
        put("Isle of Man", "54.236107 -4.548056");
        put("India", "20.593684 78.96288");
        put("British Indian Ocean Territory", "-6.343194 71.876519");
        put("Iraq", "33.223191 43.679291");
        put("Iran", "32.427908 53.688046");
        put("Iceland", "64.963051 -19.020835");
        put("Italy", "41.87194 12.56738");
        put("Jersey", "49.214439 -2.13125");
        put("Jamaica", "18.109581 -77.297508");
        put("Jordan", "30.585164 36.238414");
        put("Japan", "36.204824 138.252924");
        put("Kenya", "-0.023559 37.906193");
        put("Kyrgyzstan", "41.20438 74.766098");
        put("Cambodia", "12.565679 104.990963");
        put("Kiribati", "-3.370417 -168.734039");
        put("Comoros", "-11.875001 43.872219");
        put("Saint Kitts and Nevis", "17.357822 -62.782998");
        put("North Korea", "40.339852 127.510093");
        put("S. Korea", "35.907757 127.766922");
        put("Kuwait", "29.31166 47.481766");
        put("Cayman Islands", "19.513469 -80.566956");
        put("Kazakhstan", "48.019573 66.923684");
        put("Laos", "19.85627 102.495496");
        put("Lebanon", "33.854721 35.862285");
        put("Saint Lucia", "13.909444 -60.978893");
        put("Liechtenstein", "47.166 9.555373");
        put("Sri Lanka", "7.873054 80.771797");
        put("Liberia", "6.428055 -9.429499");
        put("Lesotho", "-29.609988 28.233608");
        put("Lithuania", "55.169438 23.881275");
        put("Luxembourg", "49.815273 6.129583");
        put("Latvia", "56.879635 24.603189");
        put("Libya", "26.3351 17.228331");
        put("Morocco", "31.791702 -7.09262");
        put("Monaco", "43.750298 7.412841");
        put("Moldova", "47.411631 28.369885");
        put("Montenegro", "42.708678 19.37439");
        put("Madagascar", "-18.766947 46.869107");
        put("Marshall Islands", "7.131474 171.184478");
        put("Macedonia [FYROM]", "41.608635 21.745275");
        put("Mali", "17.570692 -3.996166");
        put("Myanmar", "21.913965 95.956223");
        put("Mongolia", "46.862496 103.846656");
        put("Macao", "22.198745 113.543873");
        put("Northern Mariana Islands", "17.33083 145.38469");
        put("Martinique", "14.641528 -61.024174");
        put("Mauritania", "21.00789 -10.940835");
        put("Montserrat", "16.742498 -62.187366");
        put("Malta", "35.937496 14.375416");
        put("Mauritius", "-20.348404 57.552152");
        put("Maldives", "3.202778 73.22068");
        put("Malawi", "-13.254308 34.301525");
        put("Mexico", "23.634501 -102.552784");
        put("Malaysia", "4.210484 101.975766");
        put("Mozambique", "-18.665695 35.529562");
        put("Namibia", "-22.95764 18.49041");
        put("New Caledonia", "-20.904305 165.618042");
        put("Niger", "17.607789 8.081666");
        put("Norfolk Island", "-29.040835 167.954712");
        put("Nigeria", "9.081999 8.675277");
        put("Nicaragua", "12.865416 -85.207229");
        put("Netherlands", "52.132633 5.291266");
        put("Norway", "60.472024 8.468946");
        put("Nepal", "28.394857 84.124008");
        put("Nauru", "-0.522778 166.931503");
        put("Niue", "-19.054445 -169.867233");
        put("New Zealand", "-40.900557 174.885971");
        put("Oman", "21.512583 55.923255");
        put("Panama", "8.537981 -80.782127");
        put("Peru", "-9.189967 -75.015152");
        put("French Polynesia", "-17.679742 -149.406843");
        put("Papua New Guinea", "-6.314993 143.95555");
        put("Philippines", "12.879721 121.774017");
        put("Pakistan", "30.375321 69.345116");
        put("Poland", "51.919438 19.145136");
        put("Saint Pierre Miquelon", "46.941936 -56.27111");
        put("Pitcairn Islands", "-24.703615 -127.439308");
        put("Puerto Rico", "18.220833 -66.590149");
        put("Palestine", "31.952162 35.233154");
        put("Portugal", "39.399872 -8.224454");
        put("Palau", "7.51498 134.58252");
        put("Paraguay", "-23.442503 -58.443832");
        put("Qatar", "25.354826 51.183884");
        put("Réunion", "-21.115141 55.536384");
        put("Romania", "45.943161 24.96676");
        put("Serbia", "44.016521 21.005859");
        put("Russia", "61.52401 105.318756");
        put("Rwanda", "-1.940278 29.873888");
        put("Saudi Arabia", "23.885942 45.079162");
        put("Solomon Islands", "-9.64571 160.156194");
        put("Seychelles", "-4.679574 55.491977");
        put("Sudan", "12.862807 30.217636");
        put("Sweden", "60.128161 18.643501");
        put("Singapore", "1.352083 103.819836");
        put("Saint Helena", "-24.143474 -10.030696");
        put("Slovenia", "46.151241 14.995463");
        put("Svalbard and Jan Mayen", "77.553604 23.670272");
        put("Slovakia", "48.669026 19.699024");
        put("Sierra Leone", "8.460555 -11.779889");
        put("San Marino", "43.94236 12.457777");
        put("Senegal", "14.497401 -14.452362");
        put("Somalia", "5.152149 46.199616");
        put("Suriname", "3.919305 -56.027783");
        put("Sao Tome and Principe", "0.18636 6.613081");
        put("El Salvador", "13.794185 -88.89653");
        put("Syria", "34.802075 38.996815");
        put("Swaziland", "-26.522503 31.465866");
        put("Turks and Caicos", "21.694025 -71.797928");
        put("Chad", "15.454166 18.732207");
        put("French Southern Territories", "-49.280366 69.348557");
        put("Togo", "8.619543 0.824782");
        put("Thailand", "15.870032 100.992541");
        put("Tajikistan", "38.861034 71.276093");
        put("Tokelau", "-8.967363 -171.855881");
        put("Timor-Leste", "-8.874217 125.727539");
        put("Turkmenistan", "38.969719 59.556278");
        put("Tunisia", "33.886917 9.537499");
        put("Tonga", "-21.178986 -175.198242");
        put("Turkey", "38.963745 35.243322");
        put("Trinidad and Tobago", "10.691803 -61.222503");
        put("Tuvalu", "-7.109535 177.64933");
        put("Taiwan", "23.69781 120.960515");
        put("Tanzania", "-6.369028 34.888822");
        put("Ukraine", "48.379433 31.16558");
        put("Uganda", "1.373333 32.290275");
        put("U.S. Minor Outlying Islands", " ");
        put("USA", "37.09024 -95.712891");
        put("Uruguay", "-32.522779 -55.765835");
        put("Uzbekistan", "41.377491 64.585262");
        put("Vatican City", "41.902916 12.453389");
        put("St. Vincent Grenadines", "12.984305 -61.287228");
        put("Venezuela", "6.42375 -66.58973");
        put("British Virgin Islands", "18.420695 -64.639968");
        put("U.S. Virgin Islands", "18.335765 -64.896335");
        put("Vietnam", "14.058324 108.277199");
        put("Vanuatu", "-15.376706 166.959158");
        put("Wallis and Futuna", "-13.768752 -177.156097");
        put("Samoa", "-13.759029 -172.104629");
        put("Kosovo", "42.602636 20.902977");
        put("Yemen", "15.552727 48.516388");
        put("Mayotte", "-12.8275 45.166244");
        put("South Africa", "-30.559482 22.937506");
        put("Zambia", "-13.133897 27.849332");
        put("Zimbabwe", "-19.015438 29.154857");
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(48.019573, 66.923684), 1));
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        textView = findViewById(R.id.text_info);

        String URL = "https://coronavirus-19-api.herokuapp.com/countries";
        mQ = Volley.newRequestQueue(this);

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    JSONArray jsonArray = response;
                    System.out.println(response.toString());
                    String total_cases = "";
                    String today_cases = "";
                    String total_deaths = "";
                    String today_deaths = "";
                    String total_recovered = "";
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String country =  jsonObject.get("country").toString();
                        if (country.equals("World")) {
                            total_cases = jsonObject.get("cases").toString();
                            today_cases = jsonObject.get("todayCases").toString();
                            total_deaths = jsonObject.get("deaths").toString();
                            today_deaths = jsonObject.get("todayDeaths").toString();
                            total_recovered = jsonObject.get("recovered").toString();
                        }
                        if (countryLocation.get(country) != null) {
                            String coords[] = countryLocation.get(country).toString().split(" ");
                            float lat = Float.parseFloat(coords[0]);
                            float lng = Float.parseFloat(coords[1]);
                            LatLng countryCoords = new LatLng(lat, lng);

                            String totalCases = jsonObject.get("cases").toString();
                            String todayCases = jsonObject.get("todayCases").toString();
                            String totalDeaths = jsonObject.get("deaths").toString();
                            String todayDeaths = jsonObject.get("todayDeaths").toString();
                            String recovered = jsonObject.get("recovered").toString();


                            mMap.addMarker(new MarkerOptions()
                                    .position(countryCoords)
                                    .title(country + ", Total Cases: " + totalCases + ", Total Deaths: " + totalDeaths)
                                    .snippet(" Today Cases: " + todayCases + " Today Deaths: " + todayDeaths + " Recovered: " + recovered))
                                    .showInfoWindow();
                        }
                    }
                    textView.setText("Worldwide, Total Cases: " + total_cases + ", Today Cases: " + today_cases + ", Total Deaths: " + total_deaths + ", Today Deaths: " + today_deaths + ", Recovered: " + total_recovered + ", #stayhome please!");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQ.add(request);
        displayNotification();
    }

    public void displayNotification() {
        PendingIntent pi = PendingIntent.getActivity(this, 0, new Intent(this, this.getClass()), 0);
        Resources r = getResources();
        Notification notification = new NotificationCompat.Builder(this)
                .setSmallIcon(android.R.drawable.ic_menu_report_image)
                .setContentTitle("Data update")
                .setContentText("Map update with new information about Covid-19 statistics")
                .setContentIntent(pi)
                .setAutoCancel(true)
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notificationManager.notify(0, notification);
    }
}
