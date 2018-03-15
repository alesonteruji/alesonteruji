package br.edu.ifpr.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.edu.ifpr.modelo.servico.ServicoCidade;

@ManagedBean
@RequestScoped
public class DropDownView implements Serializable {

	@Inject
	private ServicoCidade servicoCid;

	private Map<String, Map<String, String>> data = new HashMap<String, Map<String, String>>();
	private String country;
	private String city;
	private Map<String, String> countries;
	private Map<String, String> cities;

	@PostConstruct
	public void init() {
		countries = new HashMap<String, String>();
		countries.put("USA", "USA");
		countries.put("Germany", "Germany");
		countries.put("Brazil", "Brazil");

		Map<String, String> map = new HashMap<String, String>();
		map.put("New York", "New York");
		map.put("San Francisco", "San Francisco");
		map.put("Denver", "Denver");
		data.put("USA", map);

		map = new HashMap<String, String>();
		map.put("Berlin", "Berlin");
		map.put("Munich", "Munich");
		map.put("Frankfurt", "Frankfurt");
		data.put("Germany", map);

		map = new HashMap<String, String>();
		map.put("Sao Paolo", "Sao Paolo");
		map.put("Rio de Janerio", "Rio de Janerio");
		map.put("Salvador", "Salvador");
		data.put("Brazil", map);
	}

	public Map<String, Map<String, String>> getData() {
		System.out.println("1");
		return data;
	}

	public String getCountry() {
		System.out.println("2");
		return country;
	}

	public void setCountry(String country) {
		System.out.println("3");
		this.country = country;
	}

	public String getCity() {
		System.out.println("4");
		return city;
	}

	public void setCity(String city) {
		System.out.println("5");
		this.city = city;
	}

	public Map<String, String> getCountries() {
		System.out.println("6");
		return countries;
	}

	public Map<String, String> getCities() {
		System.out.println("7");
		return cities;
	}

	public void onCountryChange() {
		System.out.println("8");
		if (country != null && !country.equals(""))
			cities = data.get(country);
		else
			cities = new HashMap<String, String>();
	}

	public void displayLocation() {
		System.out.println("9");
		FacesMessage msg;
		if (city != null && country != null)
			msg = new FacesMessage("Selected", city + " of " + country);
		else
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "City is not selected.");

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}
