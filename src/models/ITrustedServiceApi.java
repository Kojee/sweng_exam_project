package models;

import java.io.IOException;
import java.net.MalformedURLException;
import java.security.Provider;
import java.util.List;

public interface ITrustedServiceApi {
    public List<Country> GetCountries(Filter filter) throws IOException;
    public List<ServiceProvider> GetServiceProviders(Filter filter) throws IOException;
    public List<ServiceStatus> GetServiceStatuses(Filter filter) throws IOException;
    public List<ServiceType> GetServiceTypes(Filter filter);
    public List<Service> GetServices(Filter filter);
}
