package cr.go.ucr.triangulo;

public class Triangulo {

   
   private int x=0,y=0,z=0;
   
   ///12312312

    public void setX(int x) {
        //dato 2
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setZ(int z) {
        this.z = z;
    }
    
    public String getTipo()
    {
        String retorno=TipoTriangulo.NO_TRIANGULO.getNombre();
        int tipo=0;
        if(x == y){tipo+=1;}
        if(x == z){tipo+=2;}
        if(y == z){tipo+=3;}
       
                
                
        if(x <= 0 || y <= 0 || z <= 0){
            retorno=TipoTriangulo.NO_TRIANGULO.getNombre();
            return retorno;
        }
        if(tipo == 0){
            if(x+y <= z || y+z <= x || x+z <= y){
                retorno=TipoTriangulo.NO_TRIANGULO.getNombre();
            }else{
                retorno=TipoTriangulo.ESCALENO.getNombre();
 
            }
        }else if(tipo > 3){
            retorno=TipoTriangulo.EQUILATERO.getNombre();        
        }else if(tipo == 1 && x+y > z ){
            retorno=TipoTriangulo.ISOCELES.getNombre();        
        }else  if(tipo == 2 &&  x+z > y ){
            retorno=TipoTriangulo.ISOCELES.getNombre();        
        }else if(tipo == 3 &&  z+y > x ){
            retorno=TipoTriangulo.ISOCELES.getNombre();        
        }else{
            retorno=TipoTriangulo.NO_TRIANGULO.getNombre();
        }
        return retorno;
    }
   
    public Triangulo(){}
    
    
}
