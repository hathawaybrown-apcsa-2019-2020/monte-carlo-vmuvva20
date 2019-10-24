/**
 * Simulate the seats filled in an airplane
 *
 * @author (Vedha Muvva)
 * @version (2019-10-24)
 */
import java.util.Scanner;
public class AirlineMonteCarlo
{
    /**
     * 
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    private int numSold, numSeats;
    private double probability;
    private int seatsFilled, totalSeatsFilled;
    private final int NUM_SIMULATIONS = 100000;
    private int timesOverbooked = 0;
    /**
     * The constructor for the AirlineMonteCarlo class
     * 
     * @param numSold       the number of tickets sold
     * @param numSeats      the number of seats available on the plane
     * @param probability   the percentage of people that do not take the flight
     */
    public AirlineMonteCarlo (int numSold, int numSeats, double probability)
    {
        this.numSold = numSold;
        this.numSeats = numSeats;
        this.probability = probability;
    }
    
    /**
     * Simulates 100,000 flights and calculates 
     * the seats filled for each flight,
     * the times the flight is overbooked, and
     * the total seats filled in 100,000 simmulations
     */
    public void runSimulation()
    {
       for (int i = 0; i < NUM_SIMULATIONS; i++)
       {
          seatsFilled = 0;
          for (int n = 0; n < numSold; n++)
          {
             if (Math.random() > probability)
                 seatsFilled++;
          }
          if (seatsFilled > numSeats)
          {
             timesOverbooked++;
          }
          totalSeatsFilled += seatsFilled;
       }
    }
    
    /**
     * Prints a user-friendly string with the results of the simulation
     */
    public void reportResults()
    {
        System.out.println("Simulation: " + numSold + " tickets sold for " + numSeats + 
        " seats;");
        System.out.println("No show probability = " + probability);
        System.out.println("Based on " + NUM_SIMULATIONS + 
        " simulations: ");
        System.out.println("Average seats filled: " + (double)totalSeatsFilled / NUM_SIMULATIONS);
        System.out.println("Number of times overbooked: " + timesOverbooked + 
        " ( " + (double)timesOverbooked / NUM_SIMULATIONS * 100 + " )");
    }
    
    /**
     * Runs the simulations and reports the results
     */
    public static void main (String[] args)
    {
        AirlineMonteCarlo mySim = new AirlineMonteCarlo(140, 136, 0.04);
        mySim.runSimulation();
        mySim.reportResults();
    }
}
