package testing;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;

final class ResourceManager {

    public static OpenGLTexture loadTexture(String fileName) throws IOException {
        try(var in = ResourceManager.class.getResourceAsStream(fileName)) {
            if (in == null)
                throw new FileNotFoundException(fileName);
            BufferedImage image = ImageIO.read(in);

            int width = image.getWidth();
            int height = image.getHeight();
            byte[] rgbaPixels = new byte[width * height * 4];

            int index = 0;
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int argb = image.getRGB(x, y);

                    byte a = (byte) ((argb >> 24) & 0xFF);
                    byte r = (byte) ((argb >> 16) & 0xFF);
                    byte g = (byte) ((argb >> 8) & 0xFF);
                    byte b = (byte) (argb & 0xFF);

                    rgbaPixels[index++] = r;
                    rgbaPixels[index++] = g;
                    rgbaPixels[index++] = b;
                    rgbaPixels[index++] = a;
                }
            }

            return new OpenGLTexture(width, height, rgbaPixels);
        }
    }

}
