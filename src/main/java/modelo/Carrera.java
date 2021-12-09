package modelo;
/**
 *
 * @author brandon
 */
public class Carrera {
    public final String nombreDeCarrera = "Ingenieria en Computacion";
    public final int clvDeCarrera = 110;
    public final int numDeCreditosTotales = 438;
    public final int SemestresDuracion = 10;
    public static final int[][] creditosPorSemestre ={
            { 8,12,10, 6,10, 0},
            { 8, 8,12, 6,10, 0},
            { 8, 8, 8, 2,10,10},
            { 8,10, 8, 8, 8, 0},
            { 8,10, 8, 8, 8, 0},
            { 8,10,14, 8, 8, 0}, 
            { 6, 8, 8, 8, 8, 8},
            { 6, 8,10, 6,14, 0},
            { 8, 8, 8, 8, 8, 0},
            { 8, 8, 8, 8, 8, 0}
            };
    /*
     * CreditosPorSemestre = [Semestre] [MateriasCretidos] [NumMaterias] [CreditosTotales]
    */
}