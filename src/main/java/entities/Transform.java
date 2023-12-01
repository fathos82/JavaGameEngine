package entities;

import vectors.Vector2;

public class Transform {

    public Vector2 position;
    public Vector2 rotation;
    public Vector2 scale;

    public Transform(Vector2 position, Vector2 rotation, Vector2 scale){
        this.position = position;
        this.rotation = rotation;
        this.scale = scale;
    }

    public Transform(){
        this.position = Vector2.zero();
        this.rotation = Vector2.zero();
        this.scale = Vector2.zero();
    }
}