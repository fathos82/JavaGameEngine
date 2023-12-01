package texture;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public final class SpriteTransformations {
    private SpriteTransformations() {}
    /**
     * Rotaciona a BufferedImage em um determinado ângulo.
     *
     * @param sprite   A Sprite a ser rotacionada.
     * @param degrees O ângulo de rotação em graus.
     */
    public static void rotate(Sprite sprite, double degrees) {
        BufferedImage image = sprite.getTexture().getImage();

        int width = image.getWidth();
        int height = image.getHeight();

        // Configura a matriz de transformação corretamente
        AffineTransform transform = new AffineTransform();
        transform.rotate(Math.toRadians(degrees), width / 2.0, height / 2.0);

        // Cria uma nova imagem com as dimensões originais
        BufferedImage rotatedImage = new BufferedImage(width, height, image.getType());
        AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);

        // Realiza a rotação
        op.filter(image, rotatedImage);
    }

    /**
     * Reflete horizontalmente a BufferedImage.
     *
     * @param sprite A Texture  original.
     */
    public static void flipHorizontal(Sprite sprite) {
        BufferedImage image = sprite.getTexture().getImage();
        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage flippedImage = new BufferedImage(width, height, image.getType());

        // Configura a matriz de transformação corretamente para reflexão horizontal
        AffineTransform transform = new AffineTransform(-1, 0, 0, 1, width, 0);
        AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);

        // Realiza a reflexão horizontal
        op.filter(image, flippedImage);

    }

}
