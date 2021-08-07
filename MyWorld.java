import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private counter score;
    private counter level;
    
    private int velocidad_coche;
    private int num_adelantamientos;
    private int num_adelantamientos_nivel;
    private mclaren candrhiz;
    private int num_rivales;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 700, 1); 
        
        num_adelantamientos = 0;
        num_adelantamientos_nivel = 4;
        velocidad_coche = 2;
        
        score = new counter("Score: " );
        level = new counter("Level: " );
        level.add(1);
        candrhiz = new mclaren(velocidad_coche);
        
        addObject(candrhiz, 300, 600);
        addObject(level, 205, 90);
        addObject(score, 205, 60);
    }
    
    public void act(){
        aumentar_dificultad();
        aniadir_rivales();
    }
    
     public int getRandomNumber(int start,int end){
       int normal = Greenfoot.getRandomNumber(end-start+1);
       return normal+start;
    }
    
    public void aumentar_puntuacion(int valor){
        score.add(valor);
    }
    
    public void aumentar_num_adelantamientos(){
        num_adelantamientos++;
    }
    
    public void disminuir_num_rivales(){
        num_rivales--;
    }
    
    public void aumentar_dificultad(){
        if(num_adelantamientos == num_adelantamientos_nivel){
            num_adelantamientos = 0;
            num_adelantamientos_nivel = num_adelantamientos_nivel + 2;
            velocidad_coche++;
            level.add(1);
            candrhiz.aumenta_velocidad();
        }
    }
    
    
    public void aniadir_rivales(){
        if(num_rivales == 0){
            
            int carril = getRandomNumber(0,3);
            
            if(carril == 0){
                addObject(new ferrari2(velocidad_coche),180, 80);
            }
            else if( carril == 1){
                addObject(new ferrari2(velocidad_coche),290, 80);
            }
            else{
                addObject(new ferrari2(velocidad_coche),410, 80);
            }
            
            carril++;
            carril = carril % 3;
            
            if(carril == 0){
                addObject(new ferrari2(velocidad_coche),180, 80);
            }
            else if( carril == 1){
                addObject(new ferrari2(velocidad_coche),290, 80);
            }
            else{
                addObject(new ferrari2(velocidad_coche),410, 80);
            }
            
            num_rivales = 2;
        }
    }
}
