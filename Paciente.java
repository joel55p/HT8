public class Paciente {
    private String nombre;
    private String enfermedad;
    private String codigo;

    public Paciente(String nombre, String enfermedad, String Codigo) {
        this.nombre = nombre;
        this.codigo = Codigo;
        this.enfermedad = enfermedad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getEnfermedad() {
        return enfermedad;
    }
}