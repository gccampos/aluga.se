package builder;

import org.springframework.ui.ModelMap;

import java.util.HashMap;

public class ModelMapBuilder {
    public static void setTitulo(String titulo, ModelMap model) {
        model.addAttribute("titulo", titulo);
    }

    public static void setMensagem(HashMap<String, String> mensagens, ModelMap model) {
        model.addAttribute("messages", mensagens);
    }


}