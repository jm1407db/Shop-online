package Model;

public class cliente {
    private String name;
    private String id;

    public cliente(String name, String id){
        this.name=name;
        this.id=id;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setNombre(String name) {
        this.name = name;
    }
    
    public void MostrarInfo(){
        System.out.println("Client Information \n Name:"+name+"\n id:"+id);
    }
}