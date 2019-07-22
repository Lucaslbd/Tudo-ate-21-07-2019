package br.com.vendas.bean;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "MBFoto")
public class BeanFoto {

    private List<String> images;

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    @PostConstruct
    public void init() {
        images = new ArrayList<>();
        String foto1 = "7897395020217.jpg";
        images.add(foto1);
        String foto2 = "070330509078.jpg";
        images.add(foto2);
        String foto3 = "7891024131909.jpg";
        images.add(foto3);
    }

}
