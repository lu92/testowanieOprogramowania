package LoginServiceHomework;

public interface Encoder {
    /**
     * Koduje dany text
     * @param  text  tekst do zakodowania
     * @return String zakodowany tekst
     */
    public String encode(String text);
}