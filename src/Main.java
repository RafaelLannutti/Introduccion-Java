class Arma {
    private final String marca;
    private int calibre;
    private String estado;
    private int municiones;
    private Policía policia;

    public Arma(String marca, int calibre, String estado, int municiones, Policía policia) {
        this.marca = marca;
        this.calibre = calibre;
        this.estado = estado;
        this.municiones = municiones;
        this.policia = policia;
    }


    public String getMarca() { return marca; }
    public int getCalibre() { return calibre; }
    public String getEstado() { return estado; }
    public int getMuniciones() { return municiones; }
    public Policía getPolicia() { return policia; }

    public boolean estaEnUso() {
        return "EN USO".equals(estado);
    }

    public boolean esMayorQue(Arma otraArma) {
        return false;
    }
}


class ArmaCorta extends Arma {
    private boolean esAutomatica;

    public ArmaCorta(String marca, int calibre, String estado, int municiones,
                     boolean esAutomatica, Policía policia) {
        super(marca, calibre, estado, municiones, policia);
        this.esAutomatica = esAutomatica;
    }


    public boolean isEsAutomatica() { return esAutomatica; }

    public boolean puedeDisparar200m() {
        return true;
    }
}


class ArmaLarga extends Arma {
    private int nivel;
    private boolean tieneSelloRENAR;
    private String descripcionJustificativa;

    public ArmaLarga(String marca, int calibre, String estado, int municiones,
                     int nivel, boolean tieneSelloRENAR, String descripcionJustificativa, Policía policia) {
        super(marca, calibre, estado, municiones, policia);
        this.nivel = nivel;
        this.tieneSelloRENAR = tieneSelloRENAR;
        this.descripcionJustificativa = descripcionJustificativa;
    }

    // Getters y setters
    public int getNivel() { return nivel; }
    public boolean isTieneSelloRENAR() { return tieneSelloRENAR; }
    public String getDescripcionJustificativa() { return descripcionJustificativa; }

    @Override
    public boolean esMayorQue(Arma otraArma) {
        if (otraArma instanceof ArmaLarga) {
            return this.getNivel() > ((ArmaLarga) otraArma).getNivel();
        }
        return false;
    }
}


class Policía {
    private String nombre;
    private String apellido;
    private int legajo;

    public Policía(String nombre, String apellido, int legajo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
    }


    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public int getLegajo() { return legajo; }
}

public class Main {
    public static void main(String[] args) {
        Policía policía = new Policía("Juan", "García", 12345);


        ArmaCorta armaCorta = new ArmaCorta("Smith & Wesson", 9, "EN USO", 15, true, policía);
        System.out.println(policía.getNombre() + " está equipado con una " +
                armaCorta.getClass().getSimpleName() + ":");
        System.out.println("Marca: " + armaCorta.getMarca());
        System.out.println("Calibre: " + armaCorta.getCalibre());
        System.out.println("Estado: " + armaCorta.getEstado());
        System.out.println("Municiones: " + armaCorta.getMuniciones());
        System.out.println("Es automática: " + armaCorta.isEsAutomatica());
        System.out.println("Puede disparar a más de 200m: " + armaCorta.puedeDisparar200m());


        ArmaLarga armaLarga = new ArmaLarga("Ruger", 10, "EN USO", 20, 4,
                true, "Para proteger al público en situaciones de alto riesgo", policía);
        System.out.println("\n" + policía.getNombre() + " también está equipado con una " +
                armaLarga.getClass().getSimpleName() + ":");
        System.out.println("Marca: " + armaLarga.getMarca());
        System.out.println("Calibre: " + armaLarga.getCalibre());
        System.out.println("Estado: " + armaLarga.getEstado());
        System.out.println("Municiones: " + armaLarga.getMuniciones());
        System.out.println("Nivel: " + armaLarga.getNivel());
        System.out.println("Tiene sello RENAR: " + armaLarga.isTieneSelloRENAR());
        System.out.println("Descripción justificativa: " + armaLarga.getDescripcionJustificativa());
        System.out.println("Comparación con la primera arma: " +
                (armaLarga.esMayorQue(armaCorta) ? "Es mayor que" : "No es mayor que") +
                " la primera arma");

        if (armaCorta.estaEnUso() && armaCorta.getCalibre() >= 9 &&
                armaLarga.estaEnUso() && armaLarga.getCalibre() >= 9) {
            System.out.println("\nAmbas armas están en condiciones para su uso en un enfrentamiento.");
        } else {
            System.out.println("\nAlgunas armas no están en condiciones para su uso en un enfrentamiento.");
        }
    }
}

