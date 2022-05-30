package models;

import java.util.List;

public class Filter {
    private List<Country> countries;
    private List<ServiceProvider> providers;
    private List<ServiceStatus> statuses;
    private List<ServiceType> types;


    public List<Country> getCountries() {
        return countries;
    }

    public List<ServiceProvider> getProviders() {
        return providers;
    }

    public List<ServiceStatus> getStatuses() {
        return statuses;
    }

    public List<ServiceType> getTypes() {
        return types;
    }

    public Filter(List<Country> countries,
                  List<ServiceProvider> providers,
                  List<ServiceStatus> statuses,
                  List<ServiceType> types){
        this.countries = countries;
        this.providers = providers;
        this.statuses = statuses;
        this.types = types;
    }
}
