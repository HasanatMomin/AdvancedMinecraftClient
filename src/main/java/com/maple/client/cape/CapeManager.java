package com.maple.client.cape;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CapeManager {
    private static final String CAPE_PATH = "C:\\Users\\lavas\\Downloads\\cape_texture.png";
    
    private BufferedImage capeImage;
    private boolean capeLoaded = false;
    private boolean capeEnabled = true;
    
    public CapeManager() {
        loadCape();
    }
    
    public void loadCape() {
        try {
            File capeFile = new File(CAPE_PATH);
            if (capeFile.exists()) {
                capeImage = ImageIO.read(capeFile);
                capeLoaded = true;
            }
        } catch (IOException e) {
            capeLoaded = false;
        }
    }
    
    public BufferedImage getCapeImage() {
        return capeImage;
    }
    
    public boolean isCapeLoaded() {
        return capeLoaded;
    }
    
    public boolean isCapeEnabled() {
        return capeEnabled && capeLoaded;
    }
    
    public void toggleCape() {
        capeEnabled = !capeEnabled;
    }
}