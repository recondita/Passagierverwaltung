
/**
 * Write a description of class MeilenKonto here.
 * 
 * @author Jan Hofmeier 
 * @version (a version number or a date)
 */
public class MeilenKonto
{
    // instance variables - replace the example below with your own
    
    private String aStatus="normal";
    private int aBonusMeilen=0;
    private int aStatusMeilen=0;
    private boolean aMitglied=false;

    
    /**
     * Constructor for objects of class MeilenKonto
     */
    public MeilenKonto()
    {
    }
    
    private void berechneStatusMeilen(int pEntfernung)
    {
    	/*
    	if(pEntfernung<0)
    	aStatusMeilen+=1100;
    	else
    	*/
        aStatusMeilen+=pEntfernung/50;
        if(aStatusMeilen<1000)
        {
        	aStatus="normal";
        }
        else
        {
        	if(aMitglied&&aStatusMeilen>=2000)
        	{
        		aStatus="vip";
        	}
        	else
        	{
        		aStatus="advanced";
        	}
        }
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
    
    /*
     * Was soll diese Methode genau tun?
     */
    public void verbraucheMeilen(int pEntfernung)
    {
    	berechneStatusMeilen(pEntfernung);
        //aStatusMeilen-=pEntfernung;
    }
    public int gibBonusMeilen()
    {
        return aBonusMeilen;
    }
    public String gibStatus()
    {
        return aStatus;
    }
    
    public void aendereMitgliedschaft(boolean pTF)
    {
    	aMitglied=pTF;
    	berechneStatusMeilen(0);//pTF?-1:0);
    }
    
    public boolean gibMitgliedschaft()
    {
    	return aMitglied;
    }
    
}
