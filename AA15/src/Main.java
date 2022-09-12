import java.nio.file.Path;
import java.util.Iterator;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Scanner;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.io.IOException;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.util.List;


public class Main
{
    public void generarArchivo(final Usuario usuario, final String nombreArchivo, final List<Provincia> listaProvincias) throws IOException {
        final File doc = new File(nombreArchivo);
        doc.createNewFile();
        final FileWriter fw = new FileWriter(doc);
        final BufferedWriter bw = new BufferedWriter(fw);
        bw.write("ID: " + usuario.getId() + " Nombre: " + usuario.getNombre() + " Fecha: " + usuario.getFecha().toString() + "\n");
        for (int i = 0; i < listaProvincias.size(); ++i) {
            bw.write(String.valueOf(listaProvincias.get(i).toString()) + "\n");
        }
        bw.close();
        System.out.println("Archivo de texto generado con \u00e9xito.");
    }
    
    public static void main(final String[] args) {
        final Usuario usuario = new Usuario(4, "\u00c1lvaro Bulnes", LocalDate.now());
        final Main m = new Main();
        try {
            final URL url = new URL("https://public.opendatasoft.com/api/records/1.0/search/?dataset=provincias-espanolas&q=&rows=0&sort=-provincia&facet=ccaa&facet=provincia");
            final HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.connect();
            final int tiempoRespuesta = conn.getResponseCode();
            if (tiempoRespuesta != 200) {
                throw new RuntimeException("HttpResponse" + tiempoRespuesta);
            }
            final Scanner sc = new Scanner(url.openStream());
            String json = "";
            while (sc.hasNextLine()) {
                json = String.valueOf(json) + sc.nextLine();
            }
            sc.close();
            JSONObject objetoJSON = new JSONObject(json);
            JSONArray arrayJSON = (JSONArray)objetoJSON.get("facet_groups");
            objetoJSON = (JSONObject)arrayJSON.get(1);
            arrayJSON = (JSONArray)objetoJSON.get("facets");
            final List<Provincia> listaProvincia = new ArrayList<Provincia>();
            for (final Object iter : arrayJSON) {
                listaProvincia.add(new Provincia(((JSONObject)iter).getString("name"), ((JSONObject)iter).getString("path")));
            }
            m.generarArchivo(usuario, "salida_provincias_1209.txt", listaProvincia);
            final List<String> jenk = new ArrayList<String>();
            jenk.add("import java.time.LocalDate");
            jenk.add("pipeline{");
            jenk.add("    agent any");
            jenk.add("    stages{");
            jenk.add("        stage(\"holaMundo\"){");
            jenk.add("            steps{");
            jenk.add("                script{");
            jenk.add("                    println \"¡Hola, hoy es un dia espectacular para producir chocolate! Mira lo que se ha producido: \"");
            for (int i = 0; i < listaProvincia.size(); ++i) {
                jenk.add("                    println \"" + listaProvincia.get(i).nombre + " " + listaProvincia.get(i).nombreCapital + "\"");
            }
            jenk.add("                }");
            jenk.add("            }");
            jenk.add("        }");
            jenk.add("    }");
            jenk.add("}");
            final Path file = Paths.get("Jenkinsfile", new String[0]);
            try {
                Files.write(file, jenk, StandardCharsets.UTF_8, new OpenOption[0]);
                System.out.println("Jenkins generado correctamente.");
            }
            catch (IOException e) {
                System.out.println("Error.");
                e.printStackTrace();
            }
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}