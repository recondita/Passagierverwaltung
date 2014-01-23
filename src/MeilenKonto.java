
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
    
    private int berechneStatusMeilen(int pEntfernung)
    {
    	/*
    	if(pEntfernung<0)
    	aStatusMeilen+=1100;
    	else
    	*/
    	int erhoehung=pEntfernung/50;
        int aStatusMeilen= this.aStatusMeilen+((erhoehung>0)?((erhoehung>500)?500:erhoehung):((erhoehung<-500)?-500:erhoehung));
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
        return aStatusMeilen;
    }
    private int berechneBonusMeilen(int pEntfernung)
    {
        return aBonusMeilen+pEntfernung/10;
    }
    public void gutschreibenMeilen(int pEntfernung)
    {
        aStatusMeilen=berechneStatusMeilen(pEntfernung);
        aBonusMeilen=berechneBonusMeilen(pEntfernung);
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
    	if(aMitglied!=pTF)
    	{
    	aMitglied=pTF;
    	aStatusMeilen+=(pTF?1100:-1100);
    	berechneStatusMeilen(0);
    	}
    }
    
    public boolean gibMitgliedschaft()
    {
    	return aMitglied;
    }
    
}
