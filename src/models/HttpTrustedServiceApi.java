package models;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HttpTrustedServiceApi implements ITrustedServiceApi{
    @Override
    public List<Country> GetCountries(Filter filter) throws IOException {
        URL url = new URL("https://esignature.ec.europa.eu/efda/tl-browser/api/v1/search/countries_list");
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");
        int statusCode = connection.getResponseCode();
        if(statusCode == HttpURLConnection.HTTP_OK){
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }
            in.close();
            Gson gson = new Gson();

            Type collectionType = new TypeToken<ArrayList<Country>>(){}.getType();
            ArrayList<Country> countries = gson.fromJson(response.toString(), collectionType);
            //TODO: aggiungere filtro
            return countries;
        }
        return null;
    }

    @Override
    public List<ServiceProvider> GetServiceProviders(Filter filter) throws IOException {
        URL url = new URL("https://esignature.ec.europa.eu/efda/tl-browser/api/v1/search/tsp_list");
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");
        int statusCode = connection.getResponseCode();
        if(statusCode == HttpURLConnection.HTTP_OK){
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }
            in.close();
            Gson gson = new Gson();

            Type collectionType = new TypeToken<ArrayList<ServiceProvider>>(){}.getType();
            ArrayList<ServiceProvider> providers = gson.fromJson(response.toString(), collectionType);

            //TODO: aggiungere filtro
            return providers;
        }
        return null;
    }

    @Override
    public List<ServiceStatus> GetServiceStatuses(Filter filter) throws IOException {
        URL url = new URL("https://esignature.ec.europa.eu/efda/tl-browser/api/v1/search/tsp_list");
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");
        int statusCode = connection.getResponseCode();
        if(statusCode == HttpURLConnection.HTTP_OK){
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }
            in.close();
            Gson gson = new Gson();

            Type collectionType = new TypeToken<ArrayList<ServiceProvider>>(){}.getType();
            //Ottengo la lista dei providers la quale contiene tutti i servizi i quali contengono i possibili stati
            ArrayList<ServiceProvider> providers = gson.fromJson(response.toString(), collectionType);
            List<String> statusNames = new ArrayList<String>();
            for (ServiceProvider p: providers){
                //Ottengo gli stati contenuti nei servizi di ogni providers
                for(String status: p.getStatuses())
                    statusNames.add(status);
            }
            //Dopo aver ottenuto tutti gli stati di tutti i providers, elimino eventuali duplicati
            statusNames = statusNames.stream().distinct().collect(Collectors.toList());
            List<ServiceStatus> statuses = statusNames
                    .stream()
                    .map(x -> new ServiceStatus(x))
                    .collect(Collectors.toList());
            //TODO: aggiungere filtro
            return statuses;
        }
        return null;
    }

    @Override
    public List<ServiceType> GetServiceTypes(Filter filter) {
        return null;
    }

    @Override
    public List<Service> GetServices(Filter filter) {
        return null;
    }
}
