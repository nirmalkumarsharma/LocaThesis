package org.locationanalyzer.entities.json.in;

public class LocationAddress
{
    private String display_name;

    private String licence;

    private String place_id;

    private String lon;

    private String[] boundingbox;

    private String osm_id;

    private String osm_type;

    private String lat;

    public String getDisplay_name ()
    {
        return display_name;
    }

    public void setDisplay_name (String display_name)
    {
        this.display_name = display_name;
    }

    public String getLicence ()
    {
        return licence;
    }

    public void setLicence (String licence)
    {
        this.licence = licence;
    }

    public String getPlace_id ()
    {
        return place_id;
    }

    public void setPlace_id (String place_id)
    {
        this.place_id = place_id;
    }

    public String getLon ()
    {
        return lon;
    }

    public void setLon (String lon)
    {
        this.lon = lon;
    }

    public String[] getBoundingbox ()
    {
        return boundingbox;
    }

    public void setBoundingbox (String[] boundingbox)
    {
        this.boundingbox = boundingbox;
    }

    public String getOsm_id ()
    {
        return osm_id;
    }

    public void setOsm_id (String osm_id)
    {
        this.osm_id = osm_id;
    }

    public String getOsm_type ()
    {
        return osm_type;
    }

    public void setOsm_type (String osm_type)
    {
        this.osm_type = osm_type;
    }

    public String getLat ()
    {
        return lat;
    }

    public void setLat (String lat)
    {
        this.lat = lat;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [display_name = "+display_name+", licence = "+licence+", place_id = "+place_id+", lon = "+lon+", boundingbox = "+boundingbox+", osm_id = "+osm_id+", osm_type = "+osm_type+", lat = "+lat+"]";
    }
}