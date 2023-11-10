package commons;

import javax.swing.ImageIcon;

public class MyImageIcon extends ImageIcon {
    private String imagePath;

    public MyImageIcon(String path) {
        super(path);
        this.imagePath = path;
    }

    public String getImagePath() {
        return imagePath;
    }
    

}