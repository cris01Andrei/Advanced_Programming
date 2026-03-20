package repository;

import model.Resource;
import exception.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.awt.Desktop;
import java.io.File;
import java.net.URI;

public class Repository {
    private List<Resource> resources;

    public Repository() {
        resources = new ArrayList<>();
    }

    public void addResource(Resource r) {
        resources.add(r);
    }

    public Resource findById(String id) throws ResourceNotFoundException {
        for (Resource r : resources) {
            if (r.getId().equals(id))
                return r;
        }
        throw new ResourceNotFoundException("Resource with id " + id + " not found");
    }

    public void openResource(String id) throws Exception {
        Resource r = findById(id);
        String location = r.getLocation();

        Desktop desktop = Desktop.getDesktop();

        if (location.startsWith("http")) {
            desktop.browse(new URI(location));
        } else {
            File file = new File(location);
            desktop.open(file);
        }
    }

    public void showAll() {
        for (Resource r : resources) {
            System.out.println(r);
        }
    }
} 
