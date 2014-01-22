
/**
 * Write a description of class MeilenKonto here.
 * 
 * @author Jan Hofmeier 
 * @version (a version number or a date)
 */
public class MeilenKonto
{
    // instance variables - replace the example below with your own
    
    private String aStatus;
    int aBonusMeilen;
    int aStatusMeilen;

    


    /**
     * Constructor for objects of class MeilenKonto
     */
    public MeilenKonto()
    {

    }
    
    private void berechneStatusMeilen(int pEntfernung)
    {
        aStatusMeilen+=pEntfernung/50;
    }
    private void berechneBonusMeilen(int pEntfernung)
    {
        aBonusMeilen+=pEntfernung/10;
    }
    public void gutschreibenMeilen(int pEntfernung)
    {
        berechneStatusMeilen(pEntfernung);
        berechneBonusMeilen(pEntfernung);
    }
    public void verbraucheMeilen(int pEntfernung)
    {
        
    }
    public int gibBonusMeilen()
    {
        return 0;
    }
    public String gibStatus()
    {
        return aStatus;
    }
    
}
