package net.ausiasmarch.model;

public class UsuarioBean {

    private Long id;
    private String username;
    private String nombre;
    private String apellido1;
    private String apellido2;

    public UsuarioBean() {
    }

    public UsuarioBean(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public UsuarioBean(String username2, String nombre2, String apellido12, String apellido22) {
        //TODO Auto-generated constructor stub
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

}
