package Guardados;

import Constructores.*;
import java.util.ArrayList;

public class ContenedorPrincipal {
	protected ArrayList<Escuderia> escuderias;
	
	
    public ContenedorPrincipal(int num) {
        // Crear una lista para almacenar las escuderías
        escuderias = new ArrayList<>();

        // Escudería 1
        ArrayList<Piloto> pilotos1 = new ArrayList<>();
        ArrayList<Tecnico> tecnicos1 = new ArrayList<>();
        ArrayList<Premio> premios1_1 = new ArrayList<>();
        ArrayList<Premio> premios1_2 = new ArrayList<>();
        String rutaCoche = "1aston.jpeg";
        CocheF1 coche1 = new CocheF1("Aston Martin", "AMR23", "Verde", 2023, 798.0, true, "Mercedes HPP", "Gasolina", "Aston Martin", rutaCoche );
        Piloto piloto1_1 = new Piloto("Fernando", "Alonso", 41, "España", "Piloto F1", 22, "Nuestro Padre", "Aston Martin", premios1_1,"Captura de pantalla 2023-05-17 a las 18.36.16.png");
        Piloto piloto1_2 = new Piloto("Lance", "Stroll", 24, "Canadá", "Piloto F1", 6, "Buen compi", "Aston Martin", premios1_2, "stroll.jpeg");
        pilotos1.add(piloto1_1);
        pilotos1.add(piloto1_2);
        Escuderia escuderia1 = new Escuderia("Aston Martin", "Reino Unido", "Mike Krack", "Silverstone", 1959, pilotos1, coche1, tecnicos1);
        escuderias.add(escuderia1);

        // Escudería 2
        ArrayList<Piloto> pilotos6 = new ArrayList<>();
        ArrayList<Tecnico> tecnicos6 = new ArrayList<>();
        ArrayList<Premio> premios6_1 = new ArrayList<>();
        ArrayList<Premio> premios6_2 = new ArrayList<>();
        String rutaCoche1 = "1alpine.jpeg";
        CocheF1 coche6 = new CocheF1("Alpine", "A523", "Rosa", 2023, 798.0, true, "Renault", "Gasolina", "Alpine", rutaCoche1);
        Piloto piloto6_1 = new Piloto("Esteban", "Ocon", 26, "Francia", "Piloto F1", 7, "Consistencia en carreras", "Alpine", premios6_1, "ocon.png");
        Piloto piloto6_2 = new Piloto("Pierre", "Gasly", 26, "Francia", "Piloto F1", 6, "Experiencia en carreras", "Alpine", premios6_2, "pierre.png");
        pilotos6.add(piloto6_1);
        pilotos6.add(piloto6_2);
        Escuderia escuderia6 = new Escuderia("Alpine", "Francia", "Laurent Rossi", "Enstone", 2021, pilotos6, coche6, tecnicos6);
        escuderias.add(escuderia6);
        
       
     // Escudería 3

        ArrayList<Piloto> pilotos7 = new ArrayList<>();
        ArrayList<Tecnico> tecnicos7 = new ArrayList<>();
        ArrayList<Premio> premios7_1 = new ArrayList<>();
        ArrayList<Premio> premios7_2 = new ArrayList<>();
        String rutaCoche2 = "1alphatauri.jpeg";
        CocheF1 coche7 = new CocheF1("AlphaTauri", "AT04", "Blanco", 2023, 798.0, true, "Honda", "Gasolina", "AlphaTauri", rutaCoche2);
        Piloto piloto7_1 = new Piloto("Yuki", "Tsunoda", 21, "Japón", "Piloto F1", 4, "Promesa joven (Lanzaruedas)", "AlphaTauri", premios7_1, "tsunoda.jpeg");
        Piloto piloto7_2 = new Piloto("Nick", "De Vries", 28, "Paises Bajos", "Piloto F1", 1, "Artista", "AlphaTauri", premios7_2, "nick.png");
        pilotos7.add(piloto7_1);
        pilotos7.add(piloto7_2);
        Escuderia escuderia7 = new Escuderia("AlphaTauri", "Italia", "Dietrich Matesthitz", "Faenza", 2020, pilotos7, coche7, tecnicos7);
        escuderias.add(escuderia7);
        
        

        // Escudería 4
        ArrayList<Piloto> pilotos8 = new ArrayList<>();
        ArrayList<Tecnico> tecnicos8 = new ArrayList<>();
        ArrayList<Premio> premios8_1 = new ArrayList<>();
        ArrayList<Premio> premios8_2 = new ArrayList<>();
        String rutaCoche3 = "f1-alfa-romeo-rear-view-iphone-cgxdzr0zfnf1fv05.jpg";
        CocheF1 coche8 = new CocheF1("Alfa Romeo", "C43", "Rojo", 2023, 798.0, true, "Ferrari", "Gasolina", "Alfa Romeo", rutaCoche3);
        Piloto piloto8_1 = new Piloto("Valtteri", "Bottas", 33, "Finlandia", "Piloto F1", 10, "Habilidad en clasificación", "Alfa Romeo", premios8_1, "bottas.jpeg");
        Piloto piloto8_2 = new Piloto("Zhou", "Guanyu", 23, "Chine", "Piloto F1", 1, "Experiencia en la categoría", "Alfa Romeo", premios8_2, "zou.png");
        pilotos8.add(piloto8_1);
        pilotos8.add(piloto8_2);
        Escuderia escuderia8 = new Escuderia("Alfa Romeo", "Suiza", "Alessandro Alunni Bravi", "Hinwil", 1950, pilotos8, coche8, tecnicos8);
        escuderias.add(escuderia8);

        // Escudería 5
        ArrayList<Piloto> pilotos2 = new ArrayList<>();
        ArrayList<Tecnico> tecnicos2 = new ArrayList<>();
        ArrayList<Premio> premios2_1 = new ArrayList<>();
        ArrayList<Premio> premios2_2 = new ArrayList<>();
        String rutaCoche4 = "2mercedes.jpeg";
        CocheF1 coche2 = new CocheF1("Mercedes", "W14", "Negro", 2023, 798.0, true, "Mercedes", "Gasolina", "Mercedes", rutaCoche4);
        Piloto piloto2_1 = new Piloto("Lewis", "Hamilton", 38, "Reino Unido", "Piloto F1", 16, "Velocidad", "Mercedes", premios2_1, "javi.jpeg");
        Piloto piloto2_2 = new Piloto("George", "Russell", 25, "Reino Unido", "Piloto F1", 4, "Parrillas de salida", "Mercedes", premios2_2, "russel.jpeg");
        pilotos2.add(piloto2_1);
        pilotos2.add(piloto2_2);
        Escuderia escuderia2 = new Escuderia("Mercedes", "Reino Unido", "Toto Wolff", "Brackley", 1954, pilotos2, coche2, tecnicos2);
        escuderias.add(escuderia2);
        
        //Escudería 6
        ArrayList<Piloto> pilotos3 = new ArrayList<>();
        ArrayList<Tecnico> tecnicos3 = new ArrayList<>();
        ArrayList<Premio> premios3_1 = new ArrayList<>();
        ArrayList<Premio> premios3_2 = new ArrayList<>();
        String rutaCoche5 = "Captura de pantalla 2023-05-18 a las 16.34.40.png";
        CocheF1 coche3 = new CocheF1("Red Bull Racing", "RB19", "Azul", 2023, 798.0, true, "Honda", "Gasolina", "Red Bull", rutaCoche5);
        Piloto piloto3_1 = new Piloto("Max", "Verstappen", 25, "Países Bajos", "Piloto F1", 8, "Agresividad", "Red Bull Racing", premios3_1, "verstappen.jpeg");
        Piloto piloto3_2 = new Piloto("Sergio (Checo)", "Pérez", 33, "México", "Piloto F1", 12, "Carreras tácticas", "Red Bull Racing", premios3_2, "perez.jpeg");
        pilotos3.add(piloto3_1);
        pilotos3.add(piloto3_2);
        Escuderia escuderia3 = new Escuderia("Red Bull Racing", "Reino Unido", "Christian Horner", "Milton Keynes", 1987, pilotos3, coche3, tecnicos3);
        escuderias.add(escuderia3);
        

        // Escudería 7
        ArrayList<Piloto> pilotos4 = new ArrayList<>();
        ArrayList<Tecnico> tecnicos4 = new ArrayList<>();
        ArrayList<Premio> premios4_1 = new ArrayList<>();
        ArrayList<Premio> premios4_2 = new ArrayList<>();
        String rutaCoche6 = "001a85715c68623bcf36650fcfe437a2.jpg";
        CocheF1 coche4 = new CocheF1("Ferrari", "SF-23", "Rojo", 2023, 798.0, true, "Ferrari", "Gasolina", "Ferrari", rutaCoche6);
        Piloto piloto4_1 = new Piloto("Charles", "Leclerc", 25, "Mónaco", "Piloto F1", 5, "Txiribueltas o salirse fuera", "Ferrari", premios4_1, "leclerc.jpeg");
        Piloto piloto4_2 = new Piloto("Carlos", "Sainz Jr. (Chili)", 28, "España", "Piloto F1", 8, "Stop Inventing", "Ferrari", premios4_2, "sainz.jpeg");
        pilotos4.add(piloto4_1);
        pilotos4.add(piloto4_2);
        Escuderia escuderia4 = new Escuderia("Ferrari", "Italia", "Mattia Binotto", "Maranello", 1950, pilotos4, coche4, tecnicos4);
        escuderias.add(escuderia4);
        
        
     // Escudería 8
        ArrayList<Piloto> pilotos5 = new ArrayList<>();
        ArrayList<Tecnico> tecnicos5 = new ArrayList<>();
        ArrayList<Premio> premios5_1 = new ArrayList<>();
        ArrayList<Premio> premios5_2 = new ArrayList<>();
        String rutaCoche7 = "wp11759070.png";
        CocheF1 coche5 = new CocheF1("McLaren", "MCL60", "Naranja", 2023, 798.0, true, "Mercedes", "Gasolina", "McLaren", rutaCoche7);
        Piloto piloto5_1 = new Piloto("Lando", "Norris", 23, "Reino Unido", "Piloto F1", 5, "Habilidades en clasificación", "McLaren", premios5_1, "norris.png");
        Piloto piloto5_2 = new Piloto("Oscar", "Piastri", 22, "Australia", "Piloto F1", 1, "Habilidades en carrera", "McLaren", premios5_2, "piastri.png");
        pilotos5.add(piloto5_1);
        pilotos5.add(piloto5_2);
        Escuderia escuderia5 = new Escuderia("McLaren", "Reino Unido", "Zak Brown", "Woking", 1992, pilotos5, coche5, tecnicos5);
        escuderias.add(escuderia5);
        
        

        // Escudería 9
        ArrayList<Piloto> pilotos9 = new ArrayList<>();
        ArrayList<Tecnico> tecnicos9 = new ArrayList<>();
        ArrayList<Premio> premios9_1 = new ArrayList<>();
        ArrayList<Premio> premios9_2 = new ArrayList<>();
        String rutaCoche8 = "OHILLJOLVNFKNIUNV3RX55XF3E.jpg";
        CocheF1 coche9 = new CocheF1("Haas", "VF-23", "Blanco", 2023, 798.0, true, "Ferrari", "Gasolina", "Haas", rutaCoche8);
        Piloto piloto9_1 = new Piloto("Kevin", "Mangnussen", 35, "Alemania", "Piloto F1", 13, "Ez dauka", "Haas", premios9_1, "magnusen.png");
        Piloto piloto9_2 = new Piloto("Nico", "Hulkenberg", 30, "Dinamarca", "Piloto F1", 7, "Legado Familiar", "Haas", premios9_2, "hulk.png");
        pilotos9.add(piloto9_1);
        pilotos9.add(piloto9_2);
        Escuderia escuderia9 = new Escuderia("Haas", "Estados Unidos", "Guenther Steiner", "Kannapolis", 2016, pilotos9, coche9, tecnicos9);
        escuderias.add(escuderia9);

        // Escudería 10
        ArrayList<Piloto> pilotos10 = new ArrayList<>();
        ArrayList<Tecnico> tecnicos10 = new ArrayList<>();
        ArrayList<Premio> premios10_1 = new ArrayList<>();
        ArrayList<Premio> premios10_2 = new ArrayList<>();
        String rutaCoche9 = "40e67e83f78a82f8e192ec0cd1cafcf6777718c2-3712x5568.jpg";
        CocheF1 coche10 = new CocheF1("Williams", "FW45", "Azul", 2023, 798.0, true, "Mercedes", "Gasolina", "Williams", rutaCoche9 );
        Piloto piloto10_1 = new Piloto("Alexander", "Albon", 27, "London", "Piloto F1", 4, "Talento emergente", "Williams", premios10_1, "albon.png");
        Piloto piloto10_2 = new Piloto("Logan", "Sargeant", 22, "EEUU", "Piloto F1", 1, "Reserva y desarrollo", "Williams", premios10_2, "manolo.jpeg");
        pilotos10.add(piloto10_1);
        pilotos10.add(piloto10_2);
        Escuderia escuderia10 = new Escuderia("Williams", "Reino Unido", "Simon Roberts", "Grove", 1975, pilotos10, coche10, tecnicos10);
        escuderias.add(escuderia10);
        
     // Escudería 11
       

        
        
    }
    
    public ArrayList<Escuderia> obtenerEscuderias() {
        return escuderias;
    }
    
    public void actualizarEscuderia(Escuderia escuderia) {
        // Buscar la escudería en la lista por su nombre o algún otro identificador único
        for (int i = 0; i < escuderias.size(); i++) {
            Escuderia e = escuderias.get(i);
            if (e.getNombre().equals(escuderia.getNombre())) {
                // Reemplazar la escudería existente con la nueva escudería
                escuderias.set(i, escuderia);
                break;
            }
        }
    }
    
    public ContenedorPrincipal() {
        escuderias = new ArrayList<>();
    }

    public void agregarEscuderia(Escuderia escuderia) {
        escuderias.add(escuderia);
    }
    public void eliminarEscuderia(String nombreEscuderia) {
        // Buscar la escudería en la lista por su nombre
        for (int i = 0; i < escuderias.size(); i++) {
            Escuderia escuderia = escuderias.get(i);
            if (escuderia.getNombre().equals(nombreEscuderia)) {
                // Eliminar la escudería de la lista
                escuderias.remove(i);
                break;
            }
        }
    }

}
