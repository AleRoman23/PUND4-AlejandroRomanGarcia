/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pund4;


public class Apuesta {

   /**
    * Método para asginar al atributo goles
    * @return goles_local
    */
    public int getGoles_local() {
        return goles_local;
    }

    /**
     * Método que selecciona los goles locales
     * @param goles_local indica goles locales
     */
    public void setGoles_local(int goles_local) {
        this.goles_local = goles_local;
    }

   /**
    * Método que asigna goles_visitante
    * @return devuelve goles visitante
    */
    public int getGoles_visitante() {
        return goles_visitante;
    }

    /**
     * Método que selecciona goles_visitante
     * @param goles_visitante indica goles_visitante
     */
    public void setGoles_visitante(int goles_visitante) {
        this.goles_visitante = goles_visitante;
    }

    /**
     * Método que asigna lo apostado
     * @return devuelve lo apostado
     */
    public int getApostado() {
        return apostado;
    }

    /**
     * Método que selecciona lo apostado
     * @param apostado indica lo apostado
     */
    public void setApostado(int apostado) {
        this.apostado = apostado;
    }
/**
 * Atributo que indica el dinero disponible
 */
    protected int dinero_disp;
    /**
 * Atributo que indica los goles local
 */
    protected int goles_local;
    /**
 * Atributo que indica los goles visitante
 */
    protected int goles_visitante;
    /**
 * Atributo que indica lo apostado
 */
    protected int apostado;

    /**
     * Contructor por defecto
     */
    public Apuesta() {
    }

    /**
     * Contructor con parámetros
     * @param dinero_disp Indica el dinero disponible
     * @param goles_local Indica los goles del local
     * @param goles_visitante Indica los goles de los visitantes
     */
    public Apuesta(int dinero_disp, int goles_local, int goles_visitante) {
        this.dinero_disp = dinero_disp;
        this.goles_local = goles_local;
        this.goles_visitante = goles_visitante;
        this.apostado = 0;
    }
    /**
     * Método para obtener el valor del atributo dinero_disp
     * @return devuelve el dinero disponible 
     */

    public int getDinero_disp() {
        return dinero_disp;
    }
    /**
     * Método para modificar el valor del atributo dinero_disp
     * @param dinero_disp Indica el dinero disponible
     */

    public void setDinero_disp(int dinero_disp) {
        this.dinero_disp = dinero_disp;
    }

    /**
     * Método para apostar.
     * Permite elegir la cantidad a apostar, no pudiendo ser inferior a 1 ni superior a tu saldo disponible
     * Este método será probado con JUnit
     * @param dinero indica el dinero
     * @throws Exception 
     */
    public void apostar(int dinero) throws Exception {
        if (dinero <= 0) {
            throw new Exception("No se puede apostar menos de 1€");
        }

        if (dinero > getDinero_disp()) {
            throw new Exception("No se puede apostar mas de lo que tienes");
        }
        {
            setDinero_disp(dinero - getDinero_disp());
            setApostado(dinero);
        }
    }
    
    /**
     * Método que comprueba si se ha acertado el resultado del partid
     *En caso de que lo haya acertado devuelve true. Chequea que no se metan menos de 0 goles
     * @param local indica resultado local
     * @param visitante indica resultado visitante
     * @return 
     * @throws Exception 
     */

    public boolean comprobar_resultado(int local, int visitante) throws Exception {
        boolean acertado = false;
        if ((local < 0) || (visitante) < 0) {
            throw new Exception("Un equipo no puede meter menos de 0 goles, por malo que sea");
        }

        if (getGoles_local() == local && getGoles_visitante() == visitante) {
            acertado = true;
        }
        return acertado;
    }


    /**
     * Método para cobrar la apuesta.
     * Comprueba que se acertó el resultado y, en ese caso, añade el valor apostado multiplicado por 10
     * al saldo disponible
     * @param cantidad_goles_local indica la cantidad de goles de los locales
     * @param cantidad_goles_visit indica la cantidada de goles de los visitantes
     * @throws Exception 
     */
    void cobrar_apuesta(int cantidad_goles_local, int cantidad_goles_visit) throws Exception {

        if (comprobar_resultado(cantidad_goles_local, cantidad_goles_visit) == false) {
            throw new Exception("No se puede cobrar una apuesta no acertada");
        }
        setDinero_disp(getDinero_disp() * 10);

    }
}