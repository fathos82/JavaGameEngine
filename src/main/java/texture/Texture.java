package texture;

import org.example.game.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
// import uuid:

/**
 * Classe utilitária para manipulação de texturas.
 */
public class Texture {

    private BufferedImage texture;

    /**
     * Construtor que carrega uma textura a partir do caminho do arquivo.
     *
     * @param path Caminho do arquivo da textura.
     */
    public Texture(String path) {
        loadTexture(path);
    }


    /**
     * Construtor que utiliza uma BufferedImage existente como textura.
     *
     * @param texture A BufferedImage representando a textura.
     */
    public Texture(BufferedImage texture) {
        this.texture = texture;
    }
    private void loadTexture(String path) {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("images/" + path)) {
            if (is != null) {
                texture = ImageIO.read(is);
            } else {
                throw new IOException("Arquivo não encontrado: " + path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Obtém a BufferedImage da textura.
     *
     * @return A BufferedImage da textura.
     */
    public BufferedImage getImage() {
        return texture;
    }

    /**
     * Obtém uma subimagem da textura.
     *
     * @param x      A coordenada x da subimagem.
     * @param y      A coordenada y da subimagem.
     * @param width  A largura da subimagem.
     * @param height A altura da subimagem.
     * @return A subimagem da textura.
     */

//    public BufferedImage getSubImage(int x, int y, int width, int height) {
//        return texture.getSubimage(x, y, width, height);
//    }

    public Texture getSubTexture(int x, int y, int width, int height) {
        return new Texture(texture.getSubimage(x, y, width, height));
    }

    public int getPixel(int x, int y) {
        return texture.getRGB(x, y);
    }
    public int getWidth() {
        return texture.getWidth();
    }

    public int getHeight() {
        return texture.getHeight();
    }

    public static void main(String[] args) {
    }
}
