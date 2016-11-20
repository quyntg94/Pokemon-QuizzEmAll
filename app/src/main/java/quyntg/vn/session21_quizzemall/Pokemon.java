package quyntg.vn.session21_quizzemall;

/**
 * Created by giaqu on 11/20/2016.
 */

public class Pokemon {

    private int id;
    private String name;
    private String tag;
    private int gen;
    private String img;
    private String color;

    public Pokemon(int id, String name, String tag, int gen, String img, String color) {
        this.id = id;
        this.name = name;
        this.tag = tag;
        this.gen = gen;
        this.img = img;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getGen() {
        return gen;
    }

    public void setGen(int gen) {
        this.gen = gen;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
